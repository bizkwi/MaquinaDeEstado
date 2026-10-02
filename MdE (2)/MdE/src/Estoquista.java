public class Estoquista implements Character {

    private int progresso = 0;
    private int estoque = 0;

    private boolean pedidoFinalizado = false;

    private State<Estoquista> state = new SeparandoPedido(this);

    public int getProgresso() {
        return progresso;
    }

    public void adicionarProgresso(int valor) {
        progresso += valor;
    }

    public void resetarProgresso() {
        progresso = 0;
    }

    public int getEstoque() {
        return estoque;
    }

    public void adicionarEstoque() {
        estoque++;
    }

    public void retirarEstoque() {


    }

    public boolean isPedidoFinalizado() {
        return pedidoFinalizado;
    }

    public void setPedidoFinalizado(boolean pedidoFinalizado) {
        this.pedidoFinalizado = pedidoFinalizado;
    }

    @Override
    public void update() {
        state.execute();
    }

    @Override
    public void setState(State state) {
        this.state.leave();
        this.state = state;
        this.state.enter();
    }

    @Override
    public void printStats(String estado) {

        System.out.println("\n✴✴✴✴✴ ESTOQUISTA ✴✴✴✴✴");
        System.out.println("Estado: " + estado);
        System.out.println("Progresso: " + progresso + "%");
        System.out.println("Pedidos no estoque: " + estoque);
        System.out.println("Pedido finalizado: " + pedidoFinalizado);
    }
}
