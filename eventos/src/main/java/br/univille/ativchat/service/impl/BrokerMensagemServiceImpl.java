package br.univille.ativchat.service.impl;

import java.util.List;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;

import br.univille.ativchat.model.Mensagem;
import br.univille.ativchat.service.BrokerMensagemService;

public class BrokerMensagemServiceImpl implements BrokerMensagemService {
    String topicName = "topic-chat";
    String serviceBus = "sb-das12025-test-brazilsouth.servicebus.windows.net";
    String subscription = "subscription-" + System.getenv("tucod");

    DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

    ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder().fullyQualifiedNamespace(serviceBus)
            .credential(credential).transportType(AmqpTransportType.AMQP_WEB_SOCKETS).processor().topicName(topicName)
            .subscriptionName(subscription).receiveMode(ServiceBusReceiveMode.PEEK_LOCK).processMessage(context -> {
                System.out.println("Mensagem recebida: " + context.getMessage().getBody().toString());
                context.complete();
            }).processError(context -> {
                System.out.println("Erro: " + context.getException().getMessage());
            }).buildProcessorClient();

    ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
            .fullyQualifiedNamespace("sb-das12025-test-brazilsouth.servicebus.windows.net").credential(credential)
            .transportType(AmqpTransportType.AMQP_WEB_SOCKETS).sender().topicName(topicName).buildClient();

    @Override
    public void enviarMensagem(Mensagem mensagem) {
        senderClient.sendMessage(new ServiceBusMessage(mensagem));
        System.out.println(mensagem);
    }

    @Override
    public void buscarMensagens(List<Mensagem> mensagens) {
        processorClient.start();
        System.out.println("Aguardando");
        mensagens.stream().forEach(m -> System.out.println(m));
    }

}
