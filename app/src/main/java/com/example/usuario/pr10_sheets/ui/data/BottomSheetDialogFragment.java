package com.example.usuario.pr10_sheets.ui.data;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.usuario.pr10_sheets.R;
import com.example.usuario.pr10_sheets.data.model.User;


public class BottomSheetDialogFragment extends android.support.design.widget.BottomSheetDialogFragment
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final String ARG_STUDENT = "ARG_STUDENT";
    private static final int SHEET_PEAK_HEIGHT = 650;
    private User user;
    private NavigationView navigationView;

    static BottomSheetDialogFragment newInstance(User user) {
        BottomSheetDialogFragment frg = new BottomSheetDialogFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_STUDENT, user);
        frg.setArguments(arguments);
        return frg;
    }

    private final BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN
                    || newState == BottomSheetBehavior.STATE_SETTLING) {
                dismiss();
            }

        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        obtainArguments();
        initViews(getView());
    }

    private void initViews(View view) {
        navigationView = view.findViewById(R.id.navigationView);
        setupBottomSheet(view);
    }

    private void setupBottomSheet(View view) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) view
                .getParent())
                .getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();
        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) behavior;
            bottomSheetBehavior.setBottomSheetCallback(mBottomSheetCallback);
            // To assure sheet is completely shown.
            bottomSheetBehavior.setPeekHeight(SHEET_PEAK_HEIGHT);//get the height dynamically
        }
        setupNavigationView();
    }

    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
        if (user != null) {
            navigationView.getMenu().findItem(R.id.mnuTitle).setTitle(user.getName());
        }
    }

    private void obtainArguments() {
        if (getArguments() != null) {
            user = getArguments().getParcelable(ARG_STUDENT);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuCall:
                call();
                dismiss();
                return true;
            case R.id.mnuSave:
                save();
                dismiss();
                return true;
        }
        return false;
    }

    private void save() {

    }

    private void call() {
        Toast.makeText(getContext(), String.format("calling to: %s", user
                        .getName()),
                Toast.LENGTH_SHORT).show();
    }
}
