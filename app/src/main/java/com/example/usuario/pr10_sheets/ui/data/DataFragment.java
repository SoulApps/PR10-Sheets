package com.example.usuario.pr10_sheets.ui.data;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.usuario.pr10_sheets.R;
import com.example.usuario.pr10_sheets.data.model.User;
import com.example.usuario.pr10_sheets.ui.main.MainActivityViewModel;
import com.example.usuario.pr10_sheets.utils.IntentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DataFragment extends Fragment {

    @BindView(R.id.fragment_data_lblUserName)
    TextView fragmentDataLblUserName;
    @BindView(R.id.fragment_data_lblUserPhone)
    TextView fragmentDataLblUserPhone;
    @BindView(R.id.fragment_data_btnEditUser)
    Button fragmentDataBtnEditUser;
    Unbinder unbinder;

    private final int RC_USER_DATA = 1;
    private final String EXTRA_USER_DATA = "EXTRA_USER_DATA";
    private MainActivityViewModel viewModel;

    public DataFragment() {
    }

    public static DataFragment newInstance() {
        DataFragment fragment = new DataFragment();
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
        viewModel.getUser().observe(this,observer);
    }
    // set the new user data every time we have a data change
    private void changeUserData(User user) {
        fragmentDataLblUserName.setText(user.getName());
        fragmentDataLblUserPhone.setText(user.getPhone());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
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

    @OnClick(R.id.fragment_data_btnEditUser)
    public void obBtnEditUserClicked() {
        // if we click on btnEdit, we call to EditUserActivity with the user data
        // send the new user
        //EditUserActivity.startForResult(getActivity(),RC_USER_DATA,viewModel.getUser().getValue());
        IntentUtils.startForResult(getActivity(),EditUserActivity.class,RC_USER_DATA,EXTRA_USER_DATA,viewModel.getUser().getValue());
    }
}
