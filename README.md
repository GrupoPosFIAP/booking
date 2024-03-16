# API Booking
## Bem-vindo à API Booking! Aqui você encontrará informações sobre como utilizar os endpoints para registar
reserva de quartos e hotéis e pousadas espalhadas pelo mundo.


## Sobre
```
-API Booking permite o gerenciamento de reservaem hotéis e pousadas em diferentes localidades.

-Disponibilizamos endpoints para cinco categorias: clientes, quartos, prédios, serviços opcionais e reservas
nos quais aplicamos a mesma abstração, onde os dados serão recebidos e a seguir validados. Com essa
premissa criamos uma interface Dto para ser implementada nas cinco requisições; Essa interface possui
um método toDomain() para obter a classe de domínio referente a cada requisição, onde poderemos aplicar
as regras de negócios específicas para cada fluxo. 
```


## Tecnologias adotadas
```
-Java 17: programação server-side
-SpringBoot: criação API Restfull e microsserviços
-Docker: Gerar container do SGBD PostgresSQL
-PostgresSQL: Instanciado o SGBD via Docker
-DBeaver: Front-End para o SGBD
-PostMan: Utilizado nos testes dos endpoints
-Swagger: Modelagem, documentação e teste dos endpoints
```


## Como executar a aplicação
```
- Clonar o repositório https://github.com/GrupoPosFIAP/booking
- Iniciar o SGBD PostgresSQL e criar database booking
  Obs: Atualizar no application.properties usuário e senha 
- Confirmar Entrar na pasta raiz do projeto e executar o comando "mvn spring-boot:run"
- Testar via Postman/Swagger
  http://localhost:8080/swagger-ui/index.html#/
```


## Arquitetura
<img  width="100%" height="100%"  src="src/arquitetura.jpg"  alt="Arquitetura"  title="Arquitetura"  />


## Endpoints
* [Quartos](#quartos)
* [Serviços e Opcionais](#servicos e opcionais)
* [Cliente](#cliente)
* [Reservas](#reservas)


## Quartos

* Descrição dos Campos

Campo   | Descrição
--------- | ------
tipo | O tipo de prédio.
totalPessoas | O total de clientes.
quantidadeCamas | A quantidade de camas.
moveis | Os móveis disponíveis.
value | O valor da diária.
quantidadeBanheiros | A quantidade de banheiros.
quantidadeQuartos | A quantidade de quartos.


* Rota POST http://localhost:8080/quartos

Essa rota faz cadastro de quartos.

* Rota GET http://localhost:8080/quartos/1

Essa rota faz a consulta de quarto pelo id.

* Rota GET http://localhost:8080/quartos

Essa rota faz uma lista de quartos.

* Rota PUT http://localhost:8080/quartos/1

Essa rota faz alteração no quartos.

* Rota DELETE http://localhost:8080/quartos/1

Essa rota apaga o quartos.


## Servicos e Opcionais

* Descrição dos Campos

Campo   | Descrição
--------- | ------
servicos | O tipo de serviço.
descricaoServico | Descrição do servico.
valorServico | Valor do serviço.
itens | O tipo de item..
descricaoItens | A descrição dos itens.
valorItens | Valor dos itens.


* Rota POST http://localhost:8080/servicos

Essa rota faz cadastro de servicos.

* Rota GET http://localhost:8080/servicos/1

Essa rota faz a consulta de servico pelo id.

* Rota GET http://localhost:8080/servicos

Essa rota faz uma lista de servicos.

* Rota PUT http://localhost:8080/servicos/1

Essa rota faz alteração no servicos.

* Rota DELETE http://localhost:8080/servicos/1

Essa rota apaga o servicos.


## Cliente

* Descrição dos Campos

Campo   | Descrição
--------- | ------
nome | O nome da cliente. Deve ser uma string.
paisOrigem  | País de origem do cliente. Deve ser uma string.
cpf | O número do CPF do cliente. Deve ser uma string.
passaporte | Número do passaporte do cliente. Deve ser uma string.
dataDeNascimento | Data de nascimento. Deve ser uma data válida.
enderecoPaisOrigem | Endereço do cliente. Deve ser uma string.
telefone | Telefone do cliente. Deve ser uma string.
email | E-mail válido do cliente. Deve ser uma string.


* Rota POST http://localhost:8080/clientes

Essa rota faz cadastro de clientes.

* Rota GET http://localhost:8080/clientes/1

Essa rota faz a consulta de cliente pelo id.

* Rota GET http://localhost:8080/clientes

Essa rota faz uma lista de clientes.

* Rota PUT http://localhost:8080/clientes/1

Essa rota faz alteração no cliente.

* Rota DELETE http://localhost:8080/clientes/1

Essa rota apaga o cliente.


## Reservas

* Descrição dos Campos

Campo   | Descrição
--------- | ------
predio | O nome do prédio.
tipo | O tipo de prédio.
totalPessoas | O total de clientes.
quantidadeCamas | A quantidade de camas.
moveis | Os móveis disponíveis.
value | O valor da diária.
quantidadeBanheiros | A quantidade de banheiros.
quantidadeQuartos | A quantidade de quartos.


* Rota POST http://localhost:8080/reservas

Essa rota faz cadastro de reservas.

* Rota GET http://localhost:8080/reservas/1

Essa rota faz a consulta de reserva pelo id.

* Rota GET http://localhost:8080/reservas

Essa rota faz uma lista de reservas.

* Rota PUT http://localhost:8080/reservas/1

Essa rota faz alteração na reserva.

* Rota DELETE http://localhost:8080/reservas/1

Essa rota apaga a reserva.


## Dificuldades e Aprendizados
```
RETIRAR* A não padronização dos ambientes da equipe gerou falhas no build do projeto.
* O grupo não alinhou a finalização dos módulos da pós-graduação para liberar tempo adequado para o
desenvolvimento do projeto.
* Horários de reunião do grupo divergiu entre alguns participantes.
* Certa dificuldade no entendimento do enunciado do projeto. Exemplo: O relacionamento de algumas entidades.
RETIRAR* A utilização de IDE (Integrated Developer Envoirement – Ambiente de Desenvolvimento Integrado) idênticas
por parte dos membros da equipe, evita problemas de incompatibilidade.
```