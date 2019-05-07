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

import java.util.List;

import dev.expertsunited.mybooks.Adapter.RecyclerViewAdapter;
import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;


public class BibliotecaFragment extends Fragment {

    private List<Livro> lsLivro;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        return view;
    }

    public static BibliotecaFragment newInstace() {
        // Required empty public constructor
        return new BibliotecaFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        carregarLista();
    }

    public void carregarLista(){

        LivroDAO livroDAO = new LivroDAO(getContext());

        lsLivro = livroDAO.listaDeBiblioteca();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),lsLivro);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);
    }

}
