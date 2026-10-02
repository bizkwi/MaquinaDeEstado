import java.util.ArrayList;

public class StateMachine {

    private ArrayList<Character> characters = new ArrayList<>();

    private Entregador entregador;
    private Estoquista estoquista;

    public void run() {

        entregador = new Entregador();
        estoquista = new Estoquista();

        characters.add(estoquista);
        characters.add(entregador);

        while (true) {

            System.out.println("\n✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴");

            System.out.println("✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴✴");

            /*
             * Atualiza os dois agentes.
             *
             * O Estoquista continua trabalhando
             * mesmo quando o Entregador está entregando.
             */

            for (Character character : characters) {
                character.update();
            }

            /*
             * Comunicação:
             *
             * Se existe um pedido no estoque,
             * o Entregador pode buscá-lo.
             */

            if (estoquista.getEstoque() > 0) {

                entregador.setPedidoDisponivel(true);
            }

            /*
             * Quando o Entregador pega o pedido,
             * retiramos um pedido do estoque.
             */

            if (entregador.isPedidoDisponivel()
                    && estoquista.getEstoque() > 0) {

                estoquista.retirarEstoque();

                /*System.out.println(
                        ">>> Entregador retirou um pedido do estoque!"
                );*/
            }

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {

        new StateMachine().run();
    }
}
