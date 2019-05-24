package dev.expertsunited.mybooks.database;

import dev.expertsunited.mybooks.model.Usuario;

public interface IUsuarioDAO {

    boolean cadastrar (Usuario usuario) throws Exception;
    boolean atualizar (Usuario usuario) throws Exception;
    String validarLogin (String login, String senha) throws Exception;
    String pegarId(String login, String senha);

}
