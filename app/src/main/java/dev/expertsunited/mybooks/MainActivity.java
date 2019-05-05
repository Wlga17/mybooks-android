package dev.expertsunited.mybooks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.expertsunited.mybooks.database.DbHelper;
import dev.expertsunited.mybooks.database.UsuarioDAO;
import dev.expertsunited.mybooks.model.Usuario;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //private ViewHolder mViewHolder = new ViewHolder();
    private DbHelper dbHelper;
    //private SQLiteDatabase db;
    private Button btnCadastrar;
    private Button btnEntrar;
    private EditText edtLogin;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edtLogin = findViewById(R.id.edt_login);
        edtSenha = findViewById(R.id.edt_senha);
        btnCadastrar = findViewById(R.id.btn_novaConta);
        btnEntrar = findViewById(R.id.btn_entrar);

        btnEntrar.setOnClickListener(this);
        btnCadastrar.setOnClickListener(this);

        dbHelper = new DbHelper( getApplicationContext() );
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_novaConta){
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivity(intent);

        }
        if (id == R.id.btn_entrar) {
            UsuarioDAO dao = new UsuarioDAO( getApplicationContext() );
            Usuario usuario = new Usuario();

            usuario.setLogin(edtLogin.getText().toString());
            usuario.setSenha(edtSenha.getText().toString());

            if (usuario.getLogin().equals("") || usuario.getSenha().equals("")) {
                Toast.makeText(this, "Login e senha não inserido! ", Toast.LENGTH_SHORT).show();
            }else {
                String login = usuario.getLogin();
                String senha = usuario.getSenha();
                String result = dao.validarLogin(login, senha);

                if (result.equals("OK")) {
                    Toast.makeText(this, "Login OK! ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, PrincipalActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Login invalido! ", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

//    private static class ViewHolder{
//        Button btnCadastrar;
//        Button btnEntrar;
//        EditText edtLogin;
//        EditText edtSenha;
//    }


    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

}
