package com.example.usuario.pr10_sheets.ui.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.usuario.pr10_sheets.R;
import com.example.usuario.pr10_sheets.data.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditUserActivity extends AppCompatActivity {


    private static final String EXTRA_USER_DATA = "EXTRA_USER_DATA";
    @BindView(R.id.activity_edit_txtNombreUser)
    EditText activityEditTxtNombreUser;
    @BindView(R.id.activity_edit_txtUserPhone)
    EditText activityEditTxtUserPhone;
    @BindView(R.id.activity_edit_btnOptions)
    Button activityEditBtnOptions;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.flSheetRoot)
    FrameLayout flSheetRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        initViews();
    }

    private void initViews() {
        ButterKnife.bind(this);
    }

    // Método estático para iniciar la actividad (esperando un resultado).
    public static void startForResult(Activity activity, int requestCode, User user) {
        Intent intent;
        intent = new Intent(activity, EditUserActivity.class);
        intent.putExtra(EXTRA_USER_DATA, user);
        activity.startActivityForResult(intent, requestCode);
    }

    @OnClick(R.id.activity_edit_btnOptions)
    public void onBtnOptionsClicked() {
    }
}
