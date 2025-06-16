package model;

public class Livro extends Item {

    private String autor;
    private String genero;
    private String isbn;

    public Livro(String titulo, String codigo, boolean emprestado, String autor, String genero, String isbn) {
        super(titulo, codigo, emprestado);
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
    }

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAutor: " + autor
                + "\nGênero: " + genero
                + "\nISBN: " + isbn;
    }

    @Override
    public String toText() {
        return "LIVRO;" + titulo + ";" + codigo + ";" + (emprestado ? "EMPRESTADO" : "DISPONIVEL") + ";" + autor + ";" + genero + ";" + isbn + ";";
    }

    @Override
    public boolean isEmprestado() {
        return super.isEmprestado();
    }

}
