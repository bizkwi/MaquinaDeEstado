public class BuscandoPedido extends AbstractState<Entregador> {

    public BuscandoPedido(Entregador agente) {
        super(agente);
    }

    @Override
    public void enter() {
        System.out.println("Entregador: indo buscar o pedido.");
    }

    @Override
    public void execute() {

        getCharacter().adicionarDistancia(10);

        getCharacter().printStats("Indo buscar o pedido...");

        if (getCharacter().getDistancia() >= 30) {
            getCharacter().setState(
                    new EntregandoPedido(getCharacter())
            );
        }
    }

    @Override
    public void leave() {
        System.out.println("Entregador: cheguei ao local e peguei o pedido!");
        System.out.println(">>> Entregador retirou um pedido do estoque!");
    }


}
