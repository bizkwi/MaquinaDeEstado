public class EntregandoPedido extends AbstractState<Entregador> {

    public EntregandoPedido(Entregador agente) {
        super(agente);
    }

    @Override
    public void enter() {
        System.out.println("Entregador: iniciando entrega...");
    }

    @Override
    public void execute() {

        getCharacter().adicionarDistancia(10);

        getCharacter().printStats("Entregando pedido...");

        if (getCharacter().getDistancia() >= 60) {
            getCharacter().adicionarEntrega();

            getCharacter().setState(
                    new Voltando(getCharacter())
            );
        }
    }

    @Override
    public void leave() {
        System.out.println("Entregador: pedido entregue com sucesso!");
    }
}
