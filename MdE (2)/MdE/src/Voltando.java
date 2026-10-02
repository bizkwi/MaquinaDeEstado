public class Voltando extends AbstractState<Entregador> {

    public Voltando(Entregador agente) {
        super(agente);
    }

    @Override
    public void enter() {
        System.out.println("Entregador: voltando para a base");
    }

    @Override
    public void execute() {

        getCharacter().adicionarDistancia(10);

        getCharacter().printStats("Voltando para a base.");

        if (getCharacter().getDistancia() >= 90) {

            System.out.println(
                    "Entregador: Cheguei à base pronto para uma nova entrega!"
            );



            getCharacter().setPedidoDisponivel(false);

            // Reinicia a distância para uma nova entrega
            // mantendo o contador de entregas.
            getCharacter().setState(
                    new EsperandoPedido(getCharacter())
            );
        }
    }

    @Override
    public void leave() {
        System.out.println("Entregador: entrega finalizada.");


    }
}
