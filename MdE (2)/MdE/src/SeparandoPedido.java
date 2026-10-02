public class SeparandoPedido extends AbstractState<Estoquista> {

    public SeparandoPedido(Estoquista estoquista) {
        super(estoquista);
    }

    /*@Override
    public void enter() {
        System.out.println(
                "Estoquista: começando a preparar um novo pedido."
        );
    }*/

    @Override
    public void execute() {

        getCharacter().adicionarProgresso(25);

        getCharacter().printStats(
                "Preparando pedido..."
        );

        if (getCharacter().getProgresso() >= 100) {


            getCharacter().resetarProgresso();

            getCharacter().setPedidoFinalizado(true);

            getCharacter().setState(
                    new PedidoPronto(getCharacter())
            );
        }
    }

    @Override
    public void leave() {

        System.out.println(

        );

    }
}
