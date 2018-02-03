package com.example.usuario.pr10_sheets.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.usuario.pr10_sheets.R;
import com.example.usuario.pr10_sheets.ui.about.AboutMeFragment;
import com.example.usuario.pr10_sheets.ui.data.DataFragment;
import com.example.usuario.pr10_sheets.utils.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    // TODO cargar todos los fragmentos
    // TODO ordernar codigo
    // TODO traducir
    // TODO poner strings
    // TODO parte imagen usuario
    // TODO parte acerca de
    private TextView mTextMessage;
    private static final String TAG_DATA_FRAGMENT = "TAG_DATA_FRAGMENT";
    private static final String TAG_DATA_ABOUTME = "TAG_DATA_ABOUTME";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_userData:
                    FragmentUtils.replaceFragment(getSupportFragmentManager(),
                            R.id.actity_main_frlSpace, DataFragment.newInstance(), TAG_DATA_FRAGMENT);
                    break;
                case R.id.navigation_aboutMe:
                    FragmentUtils.replaceFragment(getSupportFragmentManager(),
                            R.id.actity_main_frlSpace, AboutMeFragment.newInstance(), TAG_DATA_ABOUTME);
                    break;


            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
