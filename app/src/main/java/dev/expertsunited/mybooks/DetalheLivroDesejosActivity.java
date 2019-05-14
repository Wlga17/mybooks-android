package dev.expertsunited.mybooks;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

import dev.expertsunited.mybooks.R;

public class DetalheLivroDesejosActivity extends AppCompatActivity {

    private ImageView ivCapa;
    private TextView tvTitulo, tvAutor, tvEdicao, tvEditora, tvPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_livro_desejos);
        getSupportActionBar().hide();

        ivCapa = findViewById(R.id.imagemDetalheId);
        tvTitulo = findViewById(R.id.tituloDetalheId);
        tvAutor = findViewById(R.id.autorDetalheId);
        tvEdicao = findViewById(R.id.edicaoDetalheId);
        tvEditora = findViewById(R.id.editoraDetalheId);
        tvPreco = findViewById(R.id.precoDetalheId);

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
}
