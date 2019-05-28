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
import android.widget.Toast;

import java.io.ByteArrayInputStream;

import dev.expertsunited.mybooks.R;
import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;

public class DetalheLivroDesejosActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivCapa;
    private TextView tvTitulo, tvAutor, tvEdicao, tvEditora, tvPreco;
    private Button btnVoltar, btnExcluir, btnAdicionarBiblioteca;
    private Livro livroAtual;

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
        btnVoltar = findViewById(R.id.btn_voltarDesejos_detalhe_id);
        btnExcluir = findViewById(R.id.btn_excluirDesejos_detalhe_id);
        btnAdicionarBiblioteca = findViewById(R.id.btn_addBiblioteca_id);

        btnVoltar.setOnClickListener(this);
        btnExcluir.setOnClickListener(this);
        btnAdicionarBiblioteca.setOnClickListener(this);

        livroAtual = (Livro) getIntent().getSerializableExtra("livroSelecionado");

        byte[] capa = livroAtual.getCapa();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(capa);
        Bitmap imagemBitmap = BitmapFactory.decodeStream(imageStream);

        ivCapa.setImageBitmap(imagemBitmap);
        tvTitulo.setText(livroAtual.getTitulo());
        tvAutor.setText(livroAtual.getAutor());
        tvEdicao.setText(livroAtual.getEdicao());
        tvEditora.setText(livroAtual.getEditora());
        tvPreco.setText(livroAtual.getValor().toString());

  /*    Intent intent = getIntent();
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
        tvPreco.setText("R$ "+ preco.toString());*/

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if(id == R.id.btn_voltarDesejos_detalhe_id){
            finish();
        }

        if(id == R.id.btn_excluirDesejos_detalhe_id){

        }

        if(id == R.id.btn_addBiblioteca_id){

            String titulo = tvTitulo.getText().toString().trim();
            String autor = tvAutor.getText().toString().trim();
            String edicao = tvEdicao.getText().toString().trim();
            String editora = tvEditora.getText().toString().trim();
            Double preco = Double.parseDouble(tvPreco.getText().toString().trim());

            LivroDAO dao = new LivroDAO(getApplicationContext());
            Livro l = new Livro();

            l.setId(livroAtual.getId());
            l.setTitulo( titulo );
            l.setAutor( autor );
            l.setEdicao( edicao );
            l.setEditora( editora );
            l.setValor( preco );
            l.setBiblioteca(true);
            l.setDesejo(false);

            if (dao.alterar(l)) {
                finish();
                Toast.makeText(this, "Atualizado com sucesso! ", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Erro ao atualizar! ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
