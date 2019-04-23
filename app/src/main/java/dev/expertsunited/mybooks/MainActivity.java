package dev.expertsunited.mybooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        this.mViewHolder.btnCadastrar = findViewById(R.id.btn_novaConta);
        this.mViewHolder.btnCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_novaConta){
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivity(intent);

        }
    }

    private static class ViewHolder{
        Button btnCadastrar;
    }



}
