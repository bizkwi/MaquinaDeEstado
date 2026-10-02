# MaquinaDeEstado
Este projeto implementa uma simulação de preparação, armazenamento e entrega de pedidos utilizando o padrão de projeto State (Máquina de Estados) em Java.
A simulação possui dois agentes principais:

Estoquista: prepara pedidos, disponibiliza os pedidos e organiza o estoque.
Entregador: aguarda pedidos, busca o pedido, realiza a entrega e retorna para a base.

Os agentes são atualizados continuamente pela classe StateMachine, que controla o ciclo principal da simulação.

Para executar o projeto, é necessário ter:
Java JDK instalado;
Java 8 ou superior;
Um terminal ou uma IDE Java, como IntelliJ IDEA, Eclipse ou VS Code.

É possível notar as transições entre cada ciclo através de mensagens como:
Estoquista: pedido disponível!
Entregador: voltando para a base

Interfaces e classes de suporte

Character
Define as operações básicas que os agentes precisam implementar, como atualização do estado e impressão das estatísticas.

State
Define a estrutura dos estados da máquina:
enter() — executado quando o agente entra em um estado;
execute() — executado durante a permanência no estado;
leave() — executado quando o agente sai do estado.

AbstractState
Implementa uma estrutura básica para os estados e mantém uma referência ao agente associado.

Agente Estoquista
O Estoquista é responsável por preparar os pedidos e controlar a quantidade de pedidos disponíveis no estoque.
Estados:
SeparandoPedido
Representa a preparação de um novo pedido.
A cada ciclo, o progresso aumenta em 25%:
Quando o progresso chega a 100%, o estado muda para:
PedidoPronto
Representa um pedido que terminou de ser preparado e está disponível.
Estocando
Representa o momento em que o estoquista organiza os produtos.

Agente Entregador
O Entregador é responsável por aguardar, buscar e entregar os pedidos.
Estados:
EsperandoPedido
O entregador permanece aguardando enquanto não existe pedido disponível.
BuscandoPedido
Representa o deslocamento do entregador até o local onde o pedido está disponível.
A distância aumenta em 10 unidades por ciclo.
EntregandoPedido
Representa o deslocamento necessário para realizar a entrega.
A distância continua aumentando em 10 unidades por ciclo.
Voltando
Representa o retorno do entregador para a base.
A distância continua aumentando em 10 unidades por ciclo.
