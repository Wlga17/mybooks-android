package dev.expertsunited.mybooks.RegraDeNegocio;

public class LivroNegocio {

    public LivroNegocio() {
    }

    public boolean validarTituloFormato(String titulo) {
        String regex = "^[a-zA-Z0-9]{4,20}$";
        return titulo.matches(regex.trim());
    }

    public boolean validarTituloNulo(String titulo) {
        return !titulo.trim().equals("") && !titulo.trim().isEmpty();
    }

    public boolean validarAutorFormato(String autor) {
        String regex = "^[a-zA-Z]{4,20}$";
        return autor.matches(regex.trim());
    }

    public boolean validarAutorNulo(String autor) {
        return !autor.trim().equals("") && !autor.trim().isEmpty();
    }

    public boolean validarEdicaoFormato(String edicao) {
        String regex = "^[a-z0-9]{2,10}$";
        return edicao.matches(regex.trim());
    }

    public boolean validarEdicaoNulo(String edicao) {
        return !edicao.trim().equals("") && !edicao.trim().isEmpty();
    }

    public boolean validarEditoraFormato(String editora) {
        String regex = "^[a-zA-Z]{4,50}$";
        return editora.matches(regex.trim());
    }

    public boolean validarEditoraNulo(String editora) {
        return !editora.trim().equals("") && !editora.trim().isEmpty();
    }

    public boolean validarIndicacaoFormato(String indicacao) {
        String regex = "^[a-zA-Z]{4,20}$";
        return indicacao.matches(regex.trim());
    }

    public boolean validarIndicacaoNulo(String indicacao) {
        return !indicacao.trim().equals("") && !indicacao.trim().isEmpty();
    }

    public boolean validarPrecoFormato(String preco) {
        String regex = "^[0-9]{1,7}$";
        return preco.matches(regex.trim());
    }

    public boolean validarPrecoNulo(String preco) {
        return !preco.trim().equals("") && !preco.trim().isEmpty();
    }

}
