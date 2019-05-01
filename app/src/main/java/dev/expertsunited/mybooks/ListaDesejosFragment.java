package dev.expertsunited.mybooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ListaDesejosFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_lista_desejos, container, false);

        FloatingActionButton fab = view.findViewById(R.id.btn_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirOutraActivity = new Intent(getActivity(), CadastroLivroActivity.class);
                startActivity(abrirOutraActivity);
            }
        });

        return view;
    }

    public static ListaDesejosFragment newInstance() {
        // Required empty public constructor
        return new ListaDesejosFragment();
    }

}
