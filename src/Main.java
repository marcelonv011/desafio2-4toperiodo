import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            opcao = menuInicial();

            switch (opcao) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuPedido();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

        } while (opcao != 3);
    }

    private static int menuInicial() {
        System.out.println("Bem-vindo, presione 1 se quer adicionar um novo cliente - presione 2 se quer realizar um pedido");
        System.out.println();
        System.out.println("1- Cliente");
        System.out.println("2- Pedido");

        return sc.nextInt();
    }

    private static void menuCliente() {
        int opcao2;

        do {
            opcao2 = menuClienteOptions();

            switch (opcao2) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    pesquisarCliente();
                    break;
                case 3:
                    editarCliente();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

        } while (opcao2 != 4);
    }

    private static int menuClienteOptions() {
        System.out.println("Voce entrou no menu de cliente");
        System.out.println("1- Cadastrar cliente");
        System.out.println("2- Procurar cliente");
        System.out.println("3- Editar cliente");


        return sc.nextInt();
    }

    private static void cadastrarCliente() {
        System.out.println();
        System.out.println("Digite o nome do cliente");
        String nome = sc.next();
        List<Endereco> enderecos = new ArrayList<>();
        System.out.println("Digite a rua do endereco do cliente");
        String rua = sc.next();
        System.out.println("Digite o numero do endereco do cliente");
        int numero = sc.nextInt();
        enderecos.add(new Endereco(rua, numero));

        clientes.add(new Cliente(nome, enderecos));
    }

    private static void pesquisarCliente(){
            System.out.println("Digite o nome do cliente que deseja pesquisar:");
            String nomePesquisa = sc.next();

            boolean clienteEncontrado = false;
            for (Cliente cliente : clientes) {
                if (cliente.getNome().equalsIgnoreCase(nomePesquisa)) {
                    System.out.println("Cliente encontrado:");
                    System.out.println("Nome: " + cliente.getNome());
                    List<Endereco> enderecos = cliente.getEnderecos();
                    if (!enderecos.isEmpty()) {
                        Endereco endereco = enderecos.get(0);
                        System.out.println("Endereco: " + endereco.getRua() + ", " + endereco.getNumero());
                    } else {
                        System.out.println("Cliente sem endereco cadastrado.");
                    }
                    clienteEncontrado = true;
                    break;
                }
            }
            if (!clienteEncontrado) {
                System.out.println("Cliente nao encontrado.");
            }
        }

        private static void editarCliente(){

                System.out.println("Digite o nome do cliente que deseja editar:");
                String nomeEdicao = sc.next();
                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equalsIgnoreCase(nomeEdicao)) {
                        System.out.println("Cliente encontrado:");
                        System.out.println("Nome atual: " + cliente.getNome());
                        System.out.println("Deseja editar o nome do cliente? (S/N)");
                        String respostaEditarNome = sc.next();
                        if (respostaEditarNome.equalsIgnoreCase("S")) {
                            System.out.println("Digite o novo nome do cliente:");
                            String novoNome = sc.next();
                            cliente.setNome(novoNome);
                        }
                        System.out.println("Deseja editar o endereco do cliente? (S/N)");
                        String respostaEditarEndereco = sc.next();
                        if (respostaEditarEndereco.equalsIgnoreCase("S")) {
                            List<Endereco> enderecos = cliente.getEnderecos();
                            if (!enderecos.isEmpty()) {
                                System.out.println("Endereco atual: " + enderecos.get(0).getRua() + ", " + enderecos.get(0).getNumero());
                                System.out.println("Digite a nova rua do endereco:");
                                String novaRua = sc.next();
                                System.out.println("Digite o novo numero do endereco:");
                                int novoNumero = sc.nextInt();
                                Endereco enderecoAtualizado = new Endereco(novaRua, novoNumero);
                                enderecos.set(0, enderecoAtualizado);
                            } else {
                                System.out.println("Cliente sem endereco cadastrado.");
                            }
                        }
                        System.out.println("Cliente atualizado com sucesso!");
                        return;
                    }
                }
                System.out.println("Cliente nao encontrado.");
            }

            private static int menuPedidoOptions(){
                System.out.println("Voce entrou no menu de pedidos");
                System.out.println("1- Realizar pedido");
                System.out.println("2- Visualizar pedido");

                return sc.nextInt();
            }

    private static void menuPedido() {
        int opcao3;

        do {
            opcao3 = menuPedidoOptions();

            switch (opcao3) {
                case 1:
                    realizarPedido();
                    break;
                case 2:
                    visualizarPedido();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

        } while (opcao3 != 3);
    }

    private static void realizarPedido(){
        System.out.println("Digite o nome de o cliente que vai realizar o pedido");
        String nomeCliente = sc.next();
        Cliente clienteEncontrado = null;

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("Cliente nao encontrado. Pedido nao pode ser associado.");
            return;
        }
        double total = 0;
        List<Produto> produtos = new ArrayList<>();
        System.out.println("qual é o nome de o produto?");
        String nome = sc.next();
        System.out.println("qual é a quantidade de produtos que quer");
        int quantidade = sc.nextInt();
        System.out.println("qual é o preco de o produto?");
        double preco = sc.nextDouble();
        double totalProduto = quantidade * preco;
        total = total + totalProduto;
        produtos.add(new Produto(nome, quantidade, preco, totalProduto));
        System.out.println("O pedido foi finalizado?\n\t1 para sim\n\t2 para nao\n");
        boolean finalizado = sc.nextInt() == 1 ? true : false;
        pedidos.add(new Pedido(clienteEncontrado, produtos, finalizado, total));
        if (finalizado) {
            for (Pedido pedido : pedidos) {
                reciboTxt(pedido);
            }
        }
    }

    private static void visualizarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("nao tem pedidos encontrados.");
            return;
        }

        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("=======================");
            System.out.println("Nome do Cliente: " + pedido.getCliente().getNome());
            System.out.println("Enderecos:");
            for (Endereco endereco : pedido.getCliente().getEnderecos()) {
                System.out.println("- Rua: " + endereco.getRua() + ", Numero: " + endereco.getNumero());
            }
            System.out.println("\nProdutos:");
            for (Produto produto : pedido.getProdutos()) {
                System.out.println("- Nome do produto: " + produto.getNome() +
                        "\n  Quantidade: " + produto.getQuantidade() +
                        "\n  Preço: " + produto.getPreco() +
                        "\n  Total do produto: " + produto.getTotal() +
                        "\n  ========================");
            }
            System.out.println("Valor total dos produtos: " + pedido.getTotal());
            System.out.println("=======================");
        }
    }

    

    private static void reciboTxt(Pedido pedido) {
        if (pedido.isFinalizado()) {
            try {
                String nomeArq = "recibo_" + pedido.getCliente().getNome() + ".txt";
                FileWriter escreveArq = new FileWriter(nomeArq);
                LocalDateTime dataHoraAtual = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String dataHoraFormatada = dataHoraAtual.format(formatter);
                escreveArq.write("\t\t================\n");
                escreveArq.write("\t\tRecibo do Pedido\n");
                escreveArq.write("\t\t================\n\n");
                escreveArq.write("Nome do Cliente: " + pedido.getCliente().getNome() + "\n");
                escreveArq.write("Endereços:\n");
                for (Endereco endereco : pedido.getCliente().getEnderecos()) {
                    escreveArq.write("- Rua: " + endereco.getRua() + ", Número: " + endereco.getNumero() + "\n");
                }
                escreveArq.write("\nProdutos:\n");
                for (Produto produto : pedido.getProdutos()) {
                    escreveArq.write("- Nome do produto: " + produto.getNome() +
                            "\n  Quantidade: " + produto.getQuantidade() +
                            "\n  Preço: " + produto.getPreco() +
                            "\n  Total do produto: " + produto.getTotal() +
                            "\n  ========================\n");
                }

                double totalPedido = 0;
                for (Produto produto : pedido.getProdutos()) {
                    totalPedido += produto.getTotal();
                }

                escreveArq.write("\n-------------------------------------------------");
                escreveArq.write("\nValor total dos produtos: " + totalPedido);
                escreveArq.write("\nPedido finalizado em: " + dataHoraFormatada);

                escreveArq.close();
                System.out.println("Recibo gerado com sucesso!");
            } catch (IOException e) {
                System.out.println("Problema ao gerar o recibo: " + e.getMessage());
            }
        }
    }
}
