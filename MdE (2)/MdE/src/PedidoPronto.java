public class PedidoPronto extends AbstractState<Estoquista> {

    public PedidoPronto(Estoquista estoquista) {
        super(estoquista);
    }

    @Override
    public void enter() {

        System.out.println(
                "Estoquista: pedido disponível!"
        );
    }

    @Override
    public void execute() {

        getCharacter().printStats(
                "Pedido pronto."
        );

        /*
         * O Estoquista continua trabalhando.
         * Depois de disponibilizar o pedido,
         * começa a preparar outro.
         */

        getCharacter().setState(
                new Estocando(getCharacter())
        );
    }

    /*@Override
    public void leave() {

        System.out.println(
                "Estoquista: vou cuidar do estoque e preparar mais pedidos."
        );
    }*/
}
