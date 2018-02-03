package com.example.usuario.pr10_sheets.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.usuario.pr10_sheets.data.model.User;

/**
 * Created by Mc_Ra on 03/02/2018.
 */

public class MainActivityViewModel extends ViewModel {

    // LiveData para el user
    private MutableLiveData<User> user;

    public LiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<User>();
            user.setValue(new User("Baldomero Llégate ligero", "666666666",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Baldomero_Espartero.jpg/1200px-Baldomero_Espartero.jpg"));
        }
        return user;
    }
}
