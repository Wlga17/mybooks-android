package dev.expertsunited.mybooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.expertsunited.mybooks.Adapter.RecyclerViewAdapterBiblioteca;
import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;


public class BibliotecaFragment extends Fragment {

    private List<Livro> lsLivro;
    private RecyclerView recyclerView;
    private TextView textoQtd;
    private int contador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_biblioteca, container, false);

        FloatingActionButton fab = view.findViewById(R.id.btn_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirOutraActivity = new Intent(getActivity(), CadastroLivroBibliotecaActivity.class);
                startActivity(abrirOutraActivity);
            }
        });
        recyclerView = view.findViewById(R.id.recycleId_biblioteca);
        textoQtd = view.findViewById(R.id.qtdLivrosBiblioteca);
        return view;
    }

    public static BibliotecaFragment newInstace() {

        return new BibliotecaFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        carregarLista();
        textoQtd.setText("Você tem " + contador + " livros em sua Biblioteca");
    }

    public void carregarLista(){

        LivroDAO livroDAO = new LivroDAO(getContext());

        lsLivro = livroDAO.listaDeBiblioteca();
        RecyclerViewAdapterBiblioteca adapter = new RecyclerViewAdapterBiblioteca(getContext(),lsLivro);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);
        contador = lsLivro.size();
    }

}
