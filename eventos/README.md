# Arquitetura baseada em Eventos

## Tópicos
![Topicos]

[Install Azure CLI](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli)

1. Realizar o login no Azure, com a conta da uni
```bash
az login
```


2. criar um grupo de recurso
```bash
az group create --name rg-das12025-test-brazilsouth --location brazilsouth
```

3. criar uma instancia do [Azure Service Bus](https://learn.microsoft.com/en-us/azure/service-bus-messaging/service-bus-messaging-overview)

```bash
az servicebus namespace create --resource-group rg-das12025-test-brazilsouth --name sb-das12025-test-brazilsouth --location brazilsouth --sku Standard
```
4. Criar o tópico
```bash
az servicebus topic create --resource-group rg-das12025-test-brazilsouth --namespace-name sb-das12025-test-brazilsouth --name topic-das1
```

5. Criar a Subscription
```bash
az servicebus topic subscription create --resource-group rg-das12025-test-brazilsouth --namespace-name sb-das12025-test-brazilsouth --topic-name topic-das1 --name subscription-artur
```

