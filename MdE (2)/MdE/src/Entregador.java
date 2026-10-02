public class Entregador implements Character {

    private int distancia = 0;
    private int entregas = 0;

    private boolean pedidoDisponivel = false;

    private State<Entregador> state = new EsperandoPedido(this);

    public int getDistancia() {
        return distancia;
    }

    public void adicionarDistancia(int valor) {
        distancia += valor;
    }

    public int getEntregas() {
        return entregas;
    }

    public void adicionarEntrega() {
        entregas++;
    }

    public boolean isPedidoDisponivel() {
        return pedidoDisponivel;
    }

    public void setPedidoDisponivel(boolean pedidoDisponivel) {
        this.pedidoDisponivel = pedidoDisponivel;
    }
    



    public void printStats(String estado) {
        System.out.println("\n✴✴✴✴✴ ENTREGADOR ✴✴✴✴✴");
        System.out.println("Estado: " + estado);
        System.out.println("Distância percorrida: " + distancia);
        System.out.println("Entregas realizadas: " + entregas);
        System.out.println("Pedido disponível: " + pedidoDisponivel);
    }

    @Override
    public void update() {
        state.execute();
    }

    @Override
    public void setState(State state) {
        this.state.leave();
        this.state = state;
        state.enter();
    }
    public void consumirPedido() {
        pedidoDisponivel = false;
    }
}
