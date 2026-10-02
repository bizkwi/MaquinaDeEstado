public class Estocando extends AbstractState<Estoquista> {

    private int tempoEstocando = 0;

    public Estocando(Estoquista estoquista) {
        super(estoquista);
    }

    @Override
    public void enter() {

        System.out.println(
                "Estoquista: organizando o estoque"
        );
    }

    @Override
    public void execute() {

        tempoEstocando++;

        getCharacter().printStats(
                "Organizando os produtos..."
        );

        /*
         * Depois de 2 ciclos, começa a preparar
         * outro pedido.
         */

        if (tempoEstocando >= 2) {

            tempoEstocando = 0;

            getCharacter().setPedidoFinalizado(false);

            getCharacter().setState(
                    new SeparandoPedido(getCharacter())
            );
            getCharacter().adicionarEstoque();

        }
    }

    @Override
    public void leave() {

        System.out.println(
                "Estoquista: Estoque organizado! Vou preparar outro pedido."
        );
    }
}
