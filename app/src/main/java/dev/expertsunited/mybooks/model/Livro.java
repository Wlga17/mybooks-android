package dev.expertsunited.mybooks.model;

public class Livro {
    private Double id;
    private String titulo;
    private String autor;
    private String editora;
    private String edicao;
    private String indicacao;
    private Double valor;
    private byte[] capa;
    private boolean isBiblioteca;
    private boolean isDesejo;
    private boolean isLidos;

    public Livro(Double id, String titulo, String autor, String editora, String edicao, String indicacao, Double valor, byte[] capa, boolean isBiblioteca, boolean isDesejo, boolean isLidos) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.indicacao = indicacao;
        this.valor = valor;
        this.capa = capa;
        this.isBiblioteca = isBiblioteca;
        this.isDesejo = isDesejo;
        this.isLidos = isLidos;
    }


    public Livro() {

    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public byte[] getCapa() {
        return capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public boolean isBiblioteca() {
        return isBiblioteca;
    }

    public void setBiblioteca(boolean biblioteca) {
        isBiblioteca = biblioteca;
    }

    public boolean isDesejo() {
        return isDesejo;
    }

    public void setDesejo(boolean desejo) {
        isDesejo = desejo;
    }

    public boolean isLidos() {
        return isLidos;
    }

    public void setLidos(boolean lidos) {
        isLidos = lidos;
    }
}
