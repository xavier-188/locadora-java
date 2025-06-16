package model;

public abstract class Item implements Locavel {

    protected String titulo;
    protected String codigo;
    protected boolean emprestado;

    public Item(String titulo, String codigo, boolean emprestado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.emprestado = emprestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "\nTitulo: " + titulo
                + "\nCódigo: " + codigo
                + "\nSituação: " + (emprestado ? "Indisponível" : "Disponível");
    }

    public abstract String toText();

    public static Item fromText(String text) {

        String[] partesItem = text.split(";");

        String tipoItem = partesItem[0];
        String titulo = partesItem[1];
        String codigo = partesItem[2];
        boolean emprestado = Boolean.parseBoolean(partesItem[3]);

        if (tipoItem.equalsIgnoreCase("LIVRO")) {
            String autor = partesItem[4];
            String genero = partesItem[5];
            String isbn = partesItem[6];
            return new Livro(titulo, codigo, emprestado, autor, genero, isbn);

        }

        if (tipoItem.equals("FILME")) {
            String diretor = partesItem[4];
            String genero = partesItem[5];
            float duracao = Float.parseFloat(partesItem[6]);
            return new Filme(titulo, codigo, emprestado, diretor, duracao, genero);
        }
        return null;

    }

}
