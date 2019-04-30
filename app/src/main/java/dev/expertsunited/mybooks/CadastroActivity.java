package dev.expertsunited.mybooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.expertsunited.mybooks.database.DbHelper;
import dev.expertsunited.mybooks.database.UsuarioDAO;
import dev.expertsunited.mybooks.model.Usuario;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    //private ViewHolder mViewHolder = new ViewHolder();
    //private SQLiteDatabase db;
    private DbHelper dbHelper;
    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtLogin;
    private EditText txtSenha;
    private Button btnCriarConta;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        txtNome = findViewById(R.id.txt_Nome);
        txtEmail = findViewById(R.id.txt_Email);
        txtLogin = findViewById(R.id.txt_Login);
        txtSenha = findViewById(R.id.txt_Senha);
        btnCriarConta = findViewById(R.id.btn_criarConta);
        btnCancelar = findViewById(R.id.btn_cancelar);

        btnCriarConta.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        dbHelper = new DbHelper( getApplicationContext() );
    }

    @Override
    public void onClick(View view) {
       int id = view.getId();
       if (id == R.id.btn_criarConta) {
           UsuarioDAO dao = new UsuarioDAO( getApplicationContext() );
           Usuario usuario = new Usuario();

           usuario.setNome(txtNome.getText().toString());
           usuario.setEmail(txtEmail.getText().toString());
           usuario.setLogin(txtLogin.getText().toString());
           usuario.setSenha(txtSenha.getText().toString());

           if(usuario.getNome().equals("") || usuario.getEmail().equals("") || usuario.getLogin().equals("") || usuario.getSenha().equals("")){
               Toast.makeText(this, "Todos os campos precisam ser preenchidos", Toast.LENGTH_SHORT).show();
           }else{
               boolean result = dao.cadastrar(usuario);
               if (result == true) {
                   Toast.makeText(this, "Cadastrado com sucesso! ", Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(this, "Erro ao cadastrar! ", Toast.LENGTH_SHORT).show();
               }
           }
       }
       if (id == R.id.btn_cancelar) {
           Intent intent = new Intent(this, MainActivity.class);
           startActivity(intent);
       }
    }

//    public void salvarUsuario(Usuario usuario) {
//        db = dbHelper.getWritableDatabase();
//
//        ContentValues novoUsuario = new ContentValues();
//
//        novoUsuario.put("nome", usuario.getNome());
//        novoUsuario.put("email", usuario.getEmail());
//        novoUsuario.put("login", usuario.getLogin());
//        novoUsuario.put("senha", usuario.getSenha());
//
//        long resultado = db.insert("usuarios", null, novoUsuario);
//        if (resultado > 0)    {
//            Toast.makeText(this, "Cadastrado com sucesso! ", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "Erro ao cadastrar! ", Toast.LENGTH_SHORT).show();
//        }
//        dbHelper.close();
//    }

//    public static class ViewHolder {
//        EditText txtNome;
//        EditText txtEmail;
//        EditText txtLogin;
//        EditText txtSenha;
//        Button btnCriarConta;
//        Button btnCancelar;
//    }


    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

}