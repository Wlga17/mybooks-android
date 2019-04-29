package dev.expertsunited.mybooks;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import dev.expertsunited.mybooks.database.DbHelper;
import dev.expertsunited.mybooks.model.Usuario;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private DbHelper dbHelper = new DbHelper(this);
    private SQLiteDatabase db = dbHelper.getWritableDatabase();
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        this.mViewHolder.txtNome = findViewById(R.id.txt_Nome);
        this.mViewHolder.txtEmail = findViewById(R.id.txt_Email);
        this.mViewHolder.txtLogin = findViewById(R.id.txt_Login);
        this.mViewHolder.txtSenha = findViewById(R.id.txt_Senha);
        this.mViewHolder.btnCriarConta = findViewById(R.id.btn_criarConta);

        this.mViewHolder.btnCriarConta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       int id = view.getId();
       if (id == R.id.btn_criarConta) {
           usuario.setNome(this.mViewHolder.txtNome.getText().toString());
           usuario.setEmail(this.mViewHolder.txtEmail.getText().toString());
           usuario.setLogin(this.mViewHolder.txtLogin.getText().toString());
           usuario.setSenha(this.mViewHolder.txtSenha.getText().toString());

           this.salvarUsuario(usuario);
       }
    }

    public void salvarUsuario(Usuario usuario) {

        ContentValues novoUsuario = new ContentValues();

        novoUsuario.put("nome", usuario.getNome());
        novoUsuario.put("email", usuario.getEmail());
        novoUsuario.put("login", usuario.getLogin());
        novoUsuario.put("senha", usuario.getSenha());

        db.insert("usuarios", null, novoUsuario);
        db.close();
    }

    public ArrayList<Usuario> getUsuarios() {

        String [] colunas = {"id", "nome", "email", "login"};
        Cursor cursor = dbHelper.getWritableDatabase().query("usuarios", colunas, null, null, null, null, null, null);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getDouble(0));
            usuario.setNome(cursor.getString(1));
            usuario.setEmail(cursor.getString(2));
            usuario.setLogin(cursor.getString(3));

            usuarios.add(usuario);
        }

        return usuarios;
    }

    public static class ViewHolder {
        EditText txtNome;
        EditText txtEmail;
        EditText txtLogin;
        EditText txtSenha;
        Button btnCriarConta;
    }
}
