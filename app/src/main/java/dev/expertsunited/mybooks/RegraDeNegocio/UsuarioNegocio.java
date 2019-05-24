package dev.expertsunited.mybooks.RegraDeNegocio;

import dev.expertsunited.mybooks.model.Usuario;

public class UsuarioNegocio {

    public UsuarioNegocio() { }

    public void validarLoginESenha(String login, String senha) throws Exception{
        if (login.equals("") || login.isEmpty()) {
            throw new Exception("Informe o seu login!");
        }
        if (senha.equals("") || senha.isEmpty()) {
            throw new Exception("Informe a sua senha!");
        }
    }

    public void validarNuloCadastro(Usuario usuario) throws Exception{
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
    }

    public void validarEmailFormato(Usuario usuario) throws Exception{
        String regex = "^(.+)@(.+)$";
        if (!usuario.getEmail().matches(regex)) {
            throw new Exception("E-mail incorreto!");
        }
    }

}
