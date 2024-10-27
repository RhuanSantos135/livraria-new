import java.time.LocalDate;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Locadora locadora = new Locadora();
        Scanner sc = new Scanner(System.in);

        locadora.adicionarLivro(new Livro("J.R.R. Tolkien", "High fantasy", "O Hobbit"));
        locadora.adicionarUsuario(new Usuario("Rhuan", new Endereco("Joao Francisco Lopes", "Centro", 123), 1, "14430750602"));
        locadora.adicionarFuncionario(new Funcionario("Jose", "14450750602", "Gerente", 1200, new Endereco("Vilas Boas", "Serra", 345)));

        while (true) {
            System.out.println("1. Alugar Livro");
            System.out.println("2. Devolver Livro");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o nome do usuário: ");
                String nomeUsuario = sc.nextLine();
                Usuario usuario = locadora.buscaUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = sc.nextLine();
                    Livro livro = locadora.buscarLivro(tituloLivro);

                    if (livro != null) {
                        locadora.locarLivro(usuario, livro);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }
            } else if (opcao == 2) {
                System.out.print("Digite o nome do usuário: ");
                String nomeUsuario = sc.nextLine();
                Usuario usuario = locadora.buscaUsuario(nomeUsuario);

                if (usuario != null) {
                    locadora.devolverLivro(usuario);
                } else {
                    System.out.println("Usuário não encontrado.");
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
