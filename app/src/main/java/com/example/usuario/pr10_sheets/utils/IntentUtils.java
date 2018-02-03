package com.example.usuario.pr10_sheets.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.usuario.pr10_sheets.data.model.User;


public class IntentUtils {
    // Método estático para iniciar la actividad (esperando un resultado).
    public static void startForResult(Activity from, Class target, int requestCode, final String extra, User user) {
        Intent intent;
        intent = new Intent(from, target.getClass());
        intent.putExtra(extra, user);
        from.startActivityForResult(intent, requestCode);
    }
}
