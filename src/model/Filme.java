package model;

public class Filme extends Item {

    private String diretor;
    private String genero;
    private float duracao;

    public Filme(String titulo, String codigo, boolean emprestado, String diretor, float duracao, String genero) {
        super(titulo, codigo, emprestado);
        this.diretor = diretor;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "\nDiretor: " + diretor
                + "\nGênero: " + genero
                + "\nDuração: " + duracao + " horas";
    }

    @Override
    public String toText() {
        return "FILME;" + titulo + ";" + codigo + ";" + (emprestado ? "EMPRESTADO" : "DISPONIVEL") + ";" + diretor + ";" + genero + ";" + duracao;
    }

    @Override
    public boolean isEmprestado() {
        return super.isEmprestado();
    }

}
