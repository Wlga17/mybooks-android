package dev.expertsunited.mybooks;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;

public class DetalheBibliotecaActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivCapa;
    private TextView tvTitulo, tvAutor, tvEdicao, tvEditora, tvPreco;
    private Button btnExcluir;

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

        btnExcluir.setOnClickListener(this);


        Intent intent = getIntent();

        byte[] capa = intent.getExtras().getByteArray("capa");
        String titulo = intent.getExtras().getString("titulo");
        String autor = intent.getExtras().getString("autor");
        String edicao = intent.getExtras().getString("edicao");
        String editora = intent.getExtras().getString("editora");
        Double preco = intent.getExtras().getDouble("preco");

        ByteArrayInputStream imageStream = new ByteArrayInputStream(capa);
        Bitmap imagemBitmap = BitmapFactory.decodeStream(imageStream);

        ivCapa.setImageBitmap(imagemBitmap);
        tvTitulo.setText(titulo);
        tvAutor.setText(autor);
        tvEdicao.setText(edicao);
        tvEditora.setText(editora);
        tvPreco.setText("R$ "+ preco.toString());

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_excluir_livro){

            LivroDAO dao = new LivroDAO( getApplicationContext() );
            dao.deletar(tvTitulo.getText().toString());
            finish();
        }

    }
}
