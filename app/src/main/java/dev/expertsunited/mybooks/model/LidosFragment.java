package dev.expertsunited.mybooks.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.expertsunited.mybooks.R;

public class LidosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lidos, container, false);
    }

    public static LidosFragment newInstance() {
        // Required empty public constructor
        return new LidosFragment();
    }

}
