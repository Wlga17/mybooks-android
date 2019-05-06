package dev.expertsunited.mybooks;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;

public class CadastroLivroActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imagem;
    private Button btnCapa;
    private Button btnAdd, btnCancelar;
    private EditText edtTitulo, edtAutor, edtEditora, edtEdicao, edtPreco, edtIndicacao;
    private final int galeriaImagens = 1;
    private final int PERMISSAO_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);
        getSupportActionBar().hide();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }

        imagem = findViewById(R.id.img_livro_cadastro);
        btnCapa = findViewById(R.id.btn_adicionar_capa);
        btnCapa.setOnClickListener(this);

        edtTitulo = findViewById(R.id.txt_titulo);
        edtAutor = findViewById(R.id.txt_autor);
        edtEditora = findViewById(R.id.txt_editora);
        edtEdicao = findViewById(R.id.txt_edicao);
        edtPreco = findViewById(R.id.txt_preco);
        edtIndicacao = findViewById(R.id.txt_indicacao);

        btnAdd = findViewById(R.id.btn_adicionarLivro);
        btnAdd.setOnClickListener(this);

        btnCancelar = findViewById(R.id.btn_cancelarLivro);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_adicionar_capa){

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,galeriaImagens);
        }
        if (id == R.id.btn_adicionarLivro) {
            Livro livro = new Livro();
            LivroDAO dao = new LivroDAO( getApplicationContext() );


            livro.setTitulo(edtTitulo.getText().toString());
            livro.setAutor(edtAutor.getText().toString());
            livro.setEditora(edtEditora.getText().toString());
            livro.setEdicao(edtEdicao.getText().toString());
            livro.setValor(Double.parseDouble(edtPreco.getText().toString()));
            livro.setIndicacao(edtIndicacao.getText().toString());

            if (livro.getTitulo().equals("") || livro.getAutor().equals("")) {
                Toast.makeText(this, "Preecher o Titulo e o Autor", Toast.LENGTH_SHORT).show();
            }else {
                boolean result = dao.cadastrar(livro);
                if (result == true) {
                    Toast.makeText(this, "Livro cadastrado! ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Erro no cadastro! ", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == galeriaImagens) {
            Uri selectedImage = data.getData();
            String[] filePath = {
                    MediaStore.Images.Media.DATA
            };
            Cursor ponteiro = getContentResolver().query(selectedImage,filePath, null, null, null);
            ponteiro.moveToFirst();
            int columnIndex = ponteiro.getColumnIndex(filePath[0]);
            String picturePath = ponteiro.getString(columnIndex);
            ponteiro.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            imagem.setImageBitmap(thumbnail);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // A permissão foi concedida. Pode continuar
            } else {
                // A permissão foi negada. Precisa ver o que deve ser desabilitado
            }
            return;
        }
    }
}
