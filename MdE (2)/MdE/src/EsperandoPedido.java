public class EsperandoPedido extends AbstractState<Entregador> {

    public EsperandoPedido(Entregador agente) {
        super(agente);
    }

    @Override
    public void enter() {
        System.out.println("Entregador: aguardando pedido...");
    }

    @Override
    public void execute() {

        getCharacter().printStats("Esperando pedido...");

        if (getCharacter().isPedidoDisponivel()) {
            getCharacter().setState(
                    new BuscandoPedido(getCharacter())
            );
        }
    }

    /*@Override
    public void leave() {
        System.out.println("Entregador: pedido recebido! Vou buscá-lo.");
    }*/
}
