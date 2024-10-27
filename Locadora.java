import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Locadora {
    private double valorLocacao;
    private double valorMulta;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;
    private ArrayList<Funcionario> funcionarios;
    private Map<Usuario, Livro> livrosLocados;

    public Locadora() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.livrosLocados = new HashMap<>();
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso: " + funcionario.getNome());
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Usuario buscaUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public void devolverLivro(Usuario usuario) {
        if (livrosLocados.containsKey(usuario)) {
            Livro livro = livrosLocados.get(usuario);
            livro.setStatus(false);
            livrosLocados.remove(usuario);
            this.valorLocacao = 10;

            LocalDate dataLocacao = LocalDate.of(2024,10,1);
            LocalDate dataDevolucao = LocalDate.of(2024,10,5);
            LocalDate dataAtraso = LocalDate.now();

            long diasAlocado = ChronoUnit.DAYS.between(dataLocacao, dataDevolucao);
            double diasematraso = ChronoUnit.DAYS.between(dataDevolucao, dataAtraso);
            double valorTota =  diasAlocado * valorLocacao ;

            System.out.println("O livro '" + livro.getTitulo() + "' foi devolvido com sucesso.");
            System.out.printf("Valor total da locação: R$ %.2f%n", valorTota);
        } else {
            System.out.println("Esse usuário não possui livros locados.");
        }
    }

    public void locarLivro(Usuario usuario, Livro livro) {
        if (!livro.isStatus()) {
            livro.setStatus(true);
            livrosLocados.put(usuario, livro);
            setDataLocacao(LocalDate.now());
            System.out.println(usuario.getNome() + " alugou o livro '" + livro.getTitulo() + "'.");
        } else {
            System.out.println("O livro '" + livro.getTitulo() + "' não está disponível.");
        }
    }
}
