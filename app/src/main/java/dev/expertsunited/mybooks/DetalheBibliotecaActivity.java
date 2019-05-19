package dev.expertsunited.mybooks;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;

public class DetalheBibliotecaActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivCapa;
    private EditText tvTitulo, tvAutor, tvEdicao, tvEditora, tvPreco;
    private Button btnExcluir, btnVoltar, btnEditar;
    private Integer idNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_biblioteca);
        getSupportActionBar().hide();

        ivCapa = findViewById(R.id.imagemDetalheBibliotecaId);
        tvTitulo = findViewById(R.id.tituloDetalheBibliotecaId);
        tvAutor = findViewById(R.id.autorDetalheBibliotecaId);
        tvEdicao = findViewById(R.id.edicaoDetalheBibliotecaId);
        tvEditora = findViewById(R.id.editoraDetalheBibliotecaId);
        tvPreco = findViewById(R.id.precoDetalheBibliotecaId);
        btnExcluir = findViewById(R.id.btn_excluir_livro);
        btnVoltar = findViewById(R.id.btn_voltarDetalhe_id);
        btnEditar = findViewById(R.id.btn_editarDetalhe_id);

        btnExcluir.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);


        Intent intent = getIntent();

        Integer id = intent.getExtras().getInt("id");
        byte[] capa = intent.getExtras().getByteArray("capa");
        String titulo = intent.getExtras().getString("titulo");
        String autor = intent.getExtras().getString("autor");
        String edicao = intent.getExtras().getString("edicao");
        String editora = intent.getExtras().getString("editora");
        Double preco = intent.getExtras().getDouble("preco");
        boolean biblioteca = intent.getExtras().getBoolean("biblioteca");
        boolean desejo = intent.getExtras().getBoolean("desejos");
        boolean lidos = intent.getExtras().getBoolean("lidos");

        ByteArrayInputStream imageStream = new ByteArrayInputStream(capa);
        Bitmap imagemBitmap = BitmapFactory.decodeStream(imageStream);

        idNumero = id;

        ivCapa.setImageBitmap(imagemBitmap);
        tvTitulo.setText(titulo);
        tvAutor.setText(autor);
        tvEdicao.setText(edicao);
        tvEditora.setText(editora);
        tvPreco.setText(preco.toString());

    }

    public void alertDialogCustomizado(){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.alert_dialog);
        dialog.setTitle("Excluir Livro");

        final Button btnCancelarDialog = dialog.findViewById(R.id.btn_cancelar_alert);
        final Button btnExcluirDialog = dialog.findViewById(R.id.btn_excluir_alert);

        btnCancelarDialog.setEnabled(true);
        btnExcluirDialog.setEnabled(true);

        btnCancelarDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnExcluirDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LivroDAO dao = new LivroDAO( getApplicationContext() );
                dao.deletar(tvTitulo.getText().toString());
                dialog.dismiss();
                Intent intent = new Intent(getApplicationContext() ,DetalheBibliotecaActivity.class);
                startActivity(intent);

            }
        });

        dialog.show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_excluir_livro){

            alertDialogCustomizado();

        }

        if(id == R.id.btn_voltarDetalhe_id){
            finish();
        }

        if(id == R.id.btn_editarDetalhe_id){

            EditText titulo = findViewById(R.id.tituloDetalheBibliotecaId);
            EditText autor = findViewById(R.id.autorDetalheBibliotecaId);
            EditText editora = findViewById(R.id.editoraDetalheBibliotecaId);
            EditText edicao = findViewById(R.id.edicaoDetalheBibliotecaId);
            EditText preco = findViewById(R.id.precoDetalheBibliotecaId);


            idNumero = 1;
            LivroDAO dao = new LivroDAO(getApplicationContext());
            Livro l = new Livro();
            l.setId(idNumero);
            l.setTitulo(titulo.getText().toString());
            l.setAutor(autor.getText().toString());
            l.setEditora(editora.getText().toString());
            l.setEdicao(edicao.getText().toString());
            l.setValor(Double.parseDouble(preco.getText().toString()));
            dao.alterar(l);
            finish();
        }
    }
}
