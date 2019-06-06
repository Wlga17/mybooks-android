package dev.expertsunited.mybooks.fachada;


import dev.expertsunited.mybooks.RegraDeNegocio.LivroNegocio;
import dev.expertsunited.mybooks.RegraDeNegocio.UsuarioNegocio;
import dev.expertsunited.mybooks.model.Livro;
import dev.expertsunited.mybooks.model.Usuario;

public class Fachada {
    private UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
    private LivroNegocio livroNegocio = new LivroNegocio();

    public boolean cadastrarUsuario(Usuario usuario) {
        String email, nome, login, senha;
        email = usuario.getEmail();
        nome = usuario.getNome();
        login = usuario.getLogin();
        senha = usuario.getSenha();
        if (usuario != null) {
            usuarioNegocio.validarEmailFormato(email);
            usuarioNegocio.validarEmailNulo(email);
            usuarioNegocio.validarNomeFormato(nome);
            usuarioNegocio.validarNomeNulo(nome);
            usuarioNegocio.validarLoginFormato(login);
            usuarioNegocio.validarLoginNulo(login);
            usuarioNegocio.validarSenhaFormato(senha);
            usuarioNegocio.validarSenhaNulo(senha);
            return true;
        } else return false;
    }

    public boolean cadatrarLivro(Livro livro) {
        String titulo, autor, edicso, editora, indicacao, preco;
        titulo = livro.getTitulo();
        autor = livro.getAutor();
        edicso = livro.getEdicao();
        editora = livro.getEditora();
        indicacao = livro.getIndicacao();
        preco = livro.getValor().toString();
        if (livro != null) {
            livroNegocio.validarTituloFormato(titulo);
            livroNegocio.validarTituloNulo(titulo);
            livroNegocio.validarAutorFormato(autor);
            livroNegocio.validarAutorNulo(autor);
            livroNegocio.validarEdicaoFormato(edicso);
            livroNegocio.validarEdicaoNulo(edicso);
            livroNegocio.validarEditoraFormato(editora);
            livroNegocio.validarEditoraNulo(editora);
            livroNegocio.validarIndicacaoFormato(indicacao);
            livroNegocio.validarIndicacaoNulo(indicacao);
            livroNegocio.validarPrecoFormato(preco);
            livroNegocio.validarPrecoNulo(preco);
            return true;
        }
        else return false;

    }
}
