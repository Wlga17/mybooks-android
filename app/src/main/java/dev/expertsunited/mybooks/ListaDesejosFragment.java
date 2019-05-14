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

import dev.expertsunited.mybooks.Adapter.RecyclerViewAdapter;
import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;


public class ListaDesejosFragment extends Fragment {

    private List<Livro> lsLivro;
    private RecyclerView recyclerView;
    private TextView textoQtd;
    private int contador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_lista_desejos, container, false);

        FloatingActionButton fab = view.findViewById(R.id.btn_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirOutraActivity = new Intent(getActivity(), CadastroLivroDesejosActivity.class);
                startActivity(abrirOutraActivity);
            }
        });
        recyclerView = view.findViewById(R.id.recycleId_desejos);
        textoQtd = view.findViewById(R.id.qtdLivrosDesejos);
        return view;
    }

    public static ListaDesejosFragment newInstance() {

        return new ListaDesejosFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        carregarLista();
        textoQtd.setText("Você tem " + contador + " livros em sua lista de desejos");
    }

    public void carregarLista(){

        LivroDAO livroDAO = new LivroDAO(getContext());

        lsLivro = livroDAO.listaDeDesejos();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),lsLivro);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);
        contador = lsLivro.size();
    }
}
