package dev.expertsunited.mybooks.RegraDeNegocio;

public class LivroNegocio {

    public LivroNegocio() {
    }

    public boolean validarTituloFormato(String titulo) {
        String regex = "^[a-zà-úA-ZÀ-Ú0-9 +(a-zà-úA-ZÀ-Ú0-9)]{4,40}$";
        return titulo.matches(regex.trim());
    }

    public boolean validarTituloNulo(String titulo) {
        return !titulo.trim().equals("") && !titulo.trim().isEmpty();
    }

    public boolean validarAutorFormato(String autor) {
        String regex = "^[a-zà-úA-ZÀ-Ú +(a-zà-úA-ZÀ-Ú)]{4,30}$";
        return autor.matches(regex.trim());
    }

    public boolean validarAutorNulo(String autor) {
        return !autor.trim().equals("") && !autor.trim().isEmpty();
    }

    public boolean validarEdicaoFormato(String edicao) {
        String regex = "^[a-zà-úA-ZÀ-Ú0-9 +(a-zà-úA-ZÀ-Ú0-9)]{2,10}$";
        return edicao.matches(regex.trim());
    }

    public boolean validarEdicaoNulo(String edicao) {
        return !edicao.trim().equals("") && !edicao.trim().isEmpty();
    }

    public boolean validarEditoraFormato(String editora) {
        String regex = "^[a-zà-úA-ZÀ-Ú +(a-zà-úA-ZÀ-Ú)]{4,30}$";
        return editora.matches(regex.trim());
    }

    public boolean validarEditoraNulo(String editora) {
        return !editora.trim().equals("") && !editora.trim().isEmpty();
    }

    public boolean validarIndicacaoFormato(String indicacao) {
        String regex = "^[a-zà-úA-ZÀ-Ú +(a-zà-úA-ZÀ-Ú)]{4,30}$";
        return indicacao.matches(regex.trim());
    }

    public boolean validarIndicacaoNulo(String indicacao) {
        return !indicacao.trim().equals("") && !indicacao.trim().isEmpty();
    }

    public boolean validarPrecoFormato(String preco) {
        String regex = "^\\d*(\\.\\d{1,2})?$";
        return preco.matches(regex.trim());
    }

    public boolean validarPrecoNulo(String preco) {
        return !preco.trim().equals("") && !preco.trim().isEmpty();
    }

}
