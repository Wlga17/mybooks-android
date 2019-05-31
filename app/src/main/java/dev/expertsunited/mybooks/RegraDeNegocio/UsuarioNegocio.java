package dev.expertsunited.mybooks.RegraDeNegocio;

import dev.expertsunited.mybooks.model.Usuario;

public class UsuarioNegocio {

    public UsuarioNegocio() { }

    public boolean validarEmailFormato(String email){
        String regex = "^[a-z0-9_.-]+@[a-z]+[.](.+)$";
        return email.matches(regex.trim());
    }

    public boolean validarEmailNulo(String email) {
        return !email.trim().equals("") && !email.trim().isEmpty();
    }

    public boolean validarNomeFormato(String nome) {
        String regex = "^[a-zà-úA-ZÀ-Ú +(a-zà-úA-ZÀ-Ú)]{4,30}$";
        return nome.matches(regex.trim());
    }

    public boolean validarNomeNulo(String nome) {
        return !nome.trim().equals("") && !nome.trim().isEmpty();
    }

    public boolean validarLoginFormato(String login) {
        String regex = "[a-zA-Z0-9@_-]{6,12}$";
        return login.matches(regex.trim());
    }

    public boolean validarLoginNulo(String login) {
        return !login.trim().equals("") && !login.trim().isEmpty();
    }

    public boolean validarSenhaFormato(String senha) {
        String regex = "^((?=.*[a-z])(?=.*\\d)(?=.*[@#$*&%])(?=.*[A-Z]).{6,12})$";
        return senha.matches(regex.trim());
    }

    public boolean validarSenhaNulo(String senha) {
        return !senha.trim().equals("") && !senha.trim().isEmpty();
    }

    public boolean validarIgualdadeLoginSenha(String login, String senha){
        return !login.trim().equals(senha.trim());
    }
}
