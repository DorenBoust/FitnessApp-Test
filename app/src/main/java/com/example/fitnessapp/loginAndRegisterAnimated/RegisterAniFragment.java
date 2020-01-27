package com.example.fitnessapp.loginAndRegisterAnimated;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessapp.R;

public class RegisterAniFragment extends Fragment {

    private RegisterAniViewModel mViewModel;
    private TextView tvToLogin;


    public static RegisterAniFragment newInstance() {
        return new RegisterAniFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.register_ani_fragment, container, false);

        tvToLogin = v.findViewById(R.id.tv_register_click_to_login);

        tvToLogin.setOnClickListener(view->{
            getFragmentManager().beginTransaction().
                    setCustomAnimations(R.anim.enter_right_to_left,R.anim.exite_right_to_left,R.anim.enter_left_to_right,R.anim.exite_left_to_right).
                    replace(R.id.mFragment, new LoginAniFragment()).commit();
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegisterAniViewModel.class);
        // TODO: Use the ViewModel
    }

}
