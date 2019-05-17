package dev.expertsunited.mybooks.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.util.List;

import dev.expertsunited.mybooks.CadastroLivroBibliotecaActivity;
import dev.expertsunited.mybooks.DetalheBibliotecaActivity;
import dev.expertsunited.mybooks.DetalheLivroDesejosActivity;
import dev.expertsunited.mybooks.R;
import dev.expertsunited.mybooks.model.Livro;

public class RecyclerViewAdapterBiblioteca extends RecyclerView.Adapter<RecyclerViewAdapterBiblioteca.MyViewHolder>{

    private Context mContext;
    private List<Livro> mList;

    public RecyclerViewAdapterBiblioteca(Context mContext, List<Livro> mData) {
        this.mContext = mContext;
        this.mList = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterBiblioteca.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_book_biblioteca,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterBiblioteca.MyViewHolder myViewHolder, final int i) {

        byte[] saidaImagem = mList.get(i).getCapa();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(saidaImagem);
        Bitmap imagemBitmap = BitmapFactory.decodeStream(imageStream);
        myViewHolder.livro_capa.setImageBitmap(imagemBitmap);

        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetalheBibliotecaActivity.class);

                intent.putExtra("id", mList.get(i).getId());
                intent.putExtra("capa", mList.get(i).getCapa());
                intent.putExtra("titulo", mList.get(i).getTitulo());
                intent.putExtra("autor", mList.get(i).getAutor());
                intent.putExtra("edicao", mList.get(i).getEdicao());
                intent.putExtra("editora", mList.get(i).getEditora());
                intent.putExtra("preco", mList.get(i).getValor());
                intent.putExtra("biblioteca", mList.get(i).isBiblioteca());
                intent.putExtra("desejos", mList.get(i).isDesejo());
                intent.putExtra("lidos", mList.get(i).isLidos());

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { return mList.size(); }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView livro_capa;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            livro_capa = itemView.findViewById(R.id.imgLivroBibliotecaId);
            cardView = itemView.findViewById(R.id.cardViewBibliotecaId);
        }
    }


}
