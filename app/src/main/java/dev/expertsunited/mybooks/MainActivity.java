package dev.expertsunited.mybooks;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
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
import dev.expertsunited.mybooks.database.MySharedPreference;
import dev.expertsunited.mybooks.database.UsuarioDAO;
import dev.expertsunited.mybooks.model.Usuario;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DbHelper dbHelper;
    private Button btnCadastrar;
    private Button btnEntrar;
    private EditText edtLogin;
    private EditText edtSenha;
    private MySharedPreference preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

//      SharedPreferences preferencias = (SharedPreferences) MySharedPreference.getInstance(this);

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
                String result = null;
                try {
                    result = dao.validarLogin(login, senha);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (result.equals("OK")) {
                    Intent intent = new Intent(this, PrincipalActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Login invalido! ", Toast.LENGTH_SHORT).show();
                }
            }

            //Dados Preferencias
//            preferencias.setUserName(usuario.getLogin());
//            preferencias.setUserId(usuario.getId());
        }
    }


    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

}
