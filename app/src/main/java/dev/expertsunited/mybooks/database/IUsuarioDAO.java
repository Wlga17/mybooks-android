package dev.expertsunited.mybooks.database;

import dev.expertsunited.mybooks.model.Usuario;

public interface IUsuarioDAO {

    public boolean cadastrar (Usuario usuario);
    public boolean atualizar (Usuario usuario);
    public String validarLogin (String login, String senha);

}
