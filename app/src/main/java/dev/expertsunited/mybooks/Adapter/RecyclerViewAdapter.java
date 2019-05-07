package dev.expertsunited.mybooks.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.List;


import dev.expertsunited.mybooks.R;
import dev.expertsunited.mybooks.model.Livro;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Livro> mList;

    public RecyclerViewAdapter(Context mContext, List<Livro> mData) {
        this.mContext = mContext;
        this.mList = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_book,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        byte[] saidaImagem = mList.get(i).getCapa();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(saidaImagem);
        Bitmap imagemBitmap = BitmapFactory.decodeStream(imageStream);
        myViewHolder.livro_capa.setImageBitmap(imagemBitmap);
        myViewHolder.nome_livro.setText(mList.get(i).getTitulo());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView livro_capa;
        TextView nome_livro;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            livro_capa = itemView.findViewById(R.id.imgLivroId);
            nome_livro = itemView.findViewById(R.id.nomeLivroId);
        }
    }


}
