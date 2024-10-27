public class Livro {

    public Livro(String autor, String genero, String titulo) {
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
        this.status = false;
    }

    String titulo;
    String genero;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    String autor;
    boolean status;

    @Override
    public String toString(){
       return  "Livro{"+
                "autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", titulo='" + titulo + '\'' +
                ", status='" + status + '}';
    }


}
