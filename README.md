# Design e Arquitetura de Software I

## Aula 26/02/25

[Livro Eng Soft Moderna - Cap 7](https://engsoftmoderna.info/cap7.html)

- No Java, pacote/package == pastas/diretórios (./controller, ./service, etc.)
- Arquiteto define essa estrutura independente da linguagem
- Componentes == bibliotecas
- Módulos são separações por funções (e.g. financeiro, logística, etc.)
- Arquitetura MVC, Arquitetura em Camadas, ambas separam responsabilidades
- Entidade = banco
- Modelo = o que vai ser mostrado na tela
- É feito um mapeamento de ent para model.
- Microsserviços
## Monolito
- Repositório unico de código
- Uso de uma unica tecnologia padrao
- Compilado, testado, unico pacote
- Deploy como unico sistema
- Executado como um unico processo no SO
- Unico Banco de dados


## Aula 05/03/25

- Pipes e filtros, big ball of mud, Arquitetura Orientada a Mensagens, Arquitetura Publish/Subscribe
- Padrões vs estilos arquiteturais
- Padrão arquitetural = solução para um problema específico
 - MVC - separa as responsabilidades (Model = dados, View = tela, Control = comportamento)
- Estilo arquitetural

- Monolitos podem ser bons, e.g. Linux e outros kernels

- Diferenças C (não-oo), C++ (OOP), Rust na modernização dos SOs, melhor gerenciamento de memória nativo

- Arquitetura em Camadas
  - Manutenção
  - Divisão de responsabilidades
  - Performance
  - Segurança
 - Camada de visualização 
   - Requisitos próprios
 - Camada de lógica de negócio
   - Backend
 - Camada de persistência
   - Banco de dados relacional já está consolidado
   - Conecta todos os clientes
  
## Aula 06/03/25
- [Who Needs an Architect?](https://martinfowler.com/ieeeSoftware/whoNeedsArchitect.pdf)
- O que é arquitetura?
   - É o conjunto de partes mais importantes de um projeto no entendimento interno dele, dos desenvolvedores.
- Qual o comportamento do arquiteto da "Matrix"?
   - Ele faz todas as decisões importantes sobre como o projeto será feito, as tecnologias que serão utilizadas e a estrutura dele para garantir a integridade conceitual do projeto, garantir que tudo faça sentido junto.
- Qual o comportamento do arquiteto ideal?
   - Ele trabalha juntamente com a equipe para entender as entranhas do projeto e orientá-los da melhor maneira, participando da programação, entrando em uma reunião com o time de requisitos, para ter certeza que tudo vai ficar nos trilhos
 
 ## Aula 28/05/25
 - [Arquitetura Baseada em Serviços](https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/46[%3Bvnd.vst.idref%3Dcap13.xhtml]!/4/2/2/1:0[%2CCAP])
 - Flexível, mais simples e barata
 - Normalmente os serviços compartilham um banco de dados único
 - A maior simplicidade pode não ser ideal em alguns casos comparando com microsserviços, como casos envolvendo pagamentos.
 - Alterações no banco de dados devem ser cuidadosas pois podem impactar o serviço inteiro
