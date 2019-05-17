package dev.expertsunited.mybooks;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    private int idNumero;

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

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_excluir_livro){

            LivroDAO dao = new LivroDAO( getApplicationContext() );
            dao.deletar(tvTitulo.getText().toString());
            finish();
        }

        if(id == R.id.btn_voltarDetalhe_id){
            finish();
        }

        if(id == R.id.btn_editarDetalhe_id){
            LivroDAO dao = new LivroDAO(getApplicationContext());
            Livro l = new Livro();
            l.setId(idNumero);
            l.setTitulo(tvTitulo.getText().toString());
            l.setAutor(tvAutor.getText().toString());
            l.setEditora(tvEditora.getText().toString());
            l.setEdicao(tvEdicao.getText().toString());
            l.setValor(Double.parseDouble(tvPreco.getText().toString()));
            dao.alterar(l);
            finish();
        }

    }
}
