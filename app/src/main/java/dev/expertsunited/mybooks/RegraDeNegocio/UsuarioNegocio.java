package dev.expertsunited.mybooks.RegraDeNegocio;

import dev.expertsunited.mybooks.model.Usuario;

public class UsuarioNegocio {

    public UsuarioNegocio() { }

    public boolean validarLoginESenha(String login, String senha) throws Exception{
        if (login.equals("") || login.isEmpty()) {
            throw new Exception("Informe o seu login!");
        }
        if (senha.equals("") || senha.isEmpty()) {
            throw new Exception("Informe a sua senha!");
        }
        return true;
    }

    public boolean validarNuloCadastro(Usuario usuario) throws Exception{
        if (usuario == null) {
            throw new Exception("Null!");
        }
        if (usuario.getNome().equals("") || usuario.getNome() == null) {
            throw new Exception("Informe o seu nome!");
        }
        if (usuario.getEmail().equals("") || usuario.getEmail() == null) {
            throw new Exception("Informe o seu email!");
        }
        if (usuario.getLogin().equals("") || usuario.getLogin() == null) {
            throw new Exception("Informe o seu login!");
        }
        if (usuario.getSenha().equals("") || usuario.getSenha() == null) {
            throw new Exception("Informe a sua senha!");
        }
        return true;
    }

    public boolean validarEmailFormato(String email){
        String regex = "^[a-zA-Z]+[0-9+_.-]+@(.+)$";
        return email.matches(regex.trim());
    }

    public boolean validarEmailNulo(String email) {
        return !email.equals("") && !email.isEmpty();
    }

    public boolean validarNomeFormato(String nome) {
        String regex = "^[a-zA-Z]{4,200}$";
        return nome.matches(regex.trim());
    }

    public boolean validarNomeNulo(String nome) {
        return !nome.equals("") && !nome.isEmpty();
    }

    public boolean validarLoginFormato(String login) {
        String regex = "^[a-z]+[0-9]{6,12}$";
        return login.matches(regex.trim());
    }

    public boolean validarLoginNulo(String login) {
        return !login.equals("") && !login.isEmpty();
    }

    public boolean validarSenhaFormato(String senha) {
        String regex = "^((? =. * [az]) (? =. * d) (? =. * [@ # $%]) (? =. * [AZ]). {6,16})$";
        return senha.matches(regex.trim());
    }

    public boolean validarSenhaNulo(String senha) {
        return !senha.equals("") && !senha.isEmpty();
    }

    public boolean validarIgualdadeLoginSenha(String login, String senha){
        return !login.equals(senha);
    }
}
