import java.util.List;

public class Pedido {

    public Cliente cliente;
    public List<Produto> produtos;
    public boolean finalizado;
    public double total;

    public Pedido(){}

    public Pedido(Cliente cliente, List<Produto> produtos, boolean finalizado, double total) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.finalizado = finalizado;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
