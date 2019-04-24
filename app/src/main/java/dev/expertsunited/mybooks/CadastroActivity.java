package dev.expertsunited.mybooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        this.mViewHolder.txtNome = findViewById(R.id.txt_Nome);
        this.mViewHolder.txtEmail = findViewById(R.id.txt_Email);
        this.mViewHolder.txtLogin = findViewById(R.id.txt_Login);
        this.mViewHolder.txtSenha = findViewById(R.id.txt_Senha);

    }

    public static class ViewHolder {
        EditText txtNome;
        EditText txtEmail;
        EditText txtLogin;
        EditText txtSenha;
    }
}
