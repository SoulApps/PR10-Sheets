package com.example.usuario.pr10_sheets.ui.image;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.pr10_sheets.R;
import com.example.usuario.pr10_sheets.data.model.User;
import com.example.usuario.pr10_sheets.ui.data.EditUserActivity;
import com.example.usuario.pr10_sheets.ui.main.MainActivityViewModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserImageFragment extends Fragment {


    Unbinder unbinder;

    private final int RC_USER_DATA = 1;
    private final String EXTRA_USER_DATA = "EXTRA_USER_DATA";
    @BindView(R.id.fragment_user_image_imgUser)
    ImageView fragmentUserImageImgUser;
    @BindView(R.id.lblPhone)
    TextView lblPhone;
    @BindView(R.id.lblWebSite)
    TextView lblWebSite;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private MainActivityViewModel viewModel;

    public UserImageFragment() {
    }

    public static UserImageFragment newInstance() {
        UserImageFragment fragment = new UserImageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        obtainArguments();

    }

    private void obtainArguments() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        final Observer<User> observer = new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                changeUserData(user);
            }
        };
        viewModel.getUser().observe(this, observer);
    }

    // set the new user data every time we have a data change
    private void changeUserData(User user) {
        lblWebSite.setText(user.getUrl());
        lblPhone.setText(user.getPhone());
        Picasso.with(getContext()).load(user.getImageURL()).into(fragmentUserImageImgUser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_image, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onFabClicked() {
        // show dialog
    }
}
