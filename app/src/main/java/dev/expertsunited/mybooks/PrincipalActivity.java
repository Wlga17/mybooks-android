package dev.expertsunited.mybooks;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import dev.expertsunited.mybooks.model.LidosFragment;

public class PrincipalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        getSupportActionBar().hide();

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_desejos:{
                getSupportActionBar().hide();
                Fragment musicasFragment = ListaDesejosFragment.newInstance();
                openFragment(musicasFragment);
                break;
            }

            case R.id.menu_biblioteca:{
                getSupportActionBar().hide();
                Fragment musicasFragment = BibliotecaFragment.newInstace();
                openFragment(musicasFragment);
                break;
            }

            case R.id.menu_lidos:{
                getSupportActionBar().hide();
                Fragment musicasFragment = LidosFragment.newInstance();
                openFragment(musicasFragment);
                break;
            }

            case R.id.menu_perfil:{
                break;
            }

        }

        return true;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
