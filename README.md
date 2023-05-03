# Projeto Java CRUD de Cadastro de Clientes

Este projeto é um CRUD (Create, Read, Update, Delete) para cadastro de clientes em Java. O projeto foi criado utilizando Java 17 e utiliza um banco de dados PostGreSQL com o nome "bd_aula_04".

## Configuração do Banco de Dados

Para executar o projeto corretamente, é necessário que você tenha um banco de dados PostGreSQL instalado e configurado. O banco de dados utilizado por este projeto deve se chamar "bd_aula_04".

### Criação da tabela "tb_cliente"

Para criar a tabela "tb_cliente" no banco de dados, execute o seguinte comando SQL:

```sql
create table tb_cliente(
    idcliente       serial          primary key,
    nome            varchar(100)    not null,
    email           varchar(50)     not null,
    cpf             varchar(14)     not null,
    telefone        varchar(20)     not null
);

## Configuração do Projeto

Para executar o projeto, você precisará baixar e adicionar a biblioteca do driver JDBC do PostGreSQL ao projeto. Você pode baixar a biblioteca do driver JDBC do PostGreSQL no [MVNRepository](https://mvnrepository.com/artifact/org.postgresql/postgresql).

### Adicionar o driver JDBC ao projeto

Após baixar o driver JDBC do PostGreSQL, adicione-o ao projeto seguindo os seguintes passos:

1. Copie o arquivo .jar do driver para a pasta lib do projeto.
2. Adicione o arquivo .jar ao classpath do projeto.
3. Reinicie o projeto.

## Funcionamento do Projeto

Ao executar o projeto, será possível realizar as operações de CRUD no cadastro de clientes.
