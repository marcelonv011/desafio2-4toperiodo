public class Produto {

    private String nome;
    private int quantidade;
    private double preco;
    private double total;

    public Produto() {
    }

    public Produto(String nome, int quantidade, double preco, double total) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}