public class Usuario {

    private static int codigoAtual = 0;
    private String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private String cpf;
    private int codigo;
    Endereco endereco;

    public Usuario(String nome, Endereco endereco, int codigo, String cpf) {

        codigo++;
        this.nome = nome;
        this.endereco = endereco;
        this.codigo = codigoAtual;
        this.cpf = cpf;
    }


}
