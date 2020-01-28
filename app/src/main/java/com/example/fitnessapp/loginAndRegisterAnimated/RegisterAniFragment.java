package com.example.fitnessapp.loginAndRegisterAnimated;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.models.AsynUserJSON;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class RegisterAniFragment extends Fragment {

    private RegisterAniViewModel mViewModel;
    private TextView tvToLogin;

    private TextInputLayout etUserName;
    private TextInputLayout etPass;
    private TextInputLayout etPassValidation;
    private TextInputLayout etIntegrationCode;
    private Button btnRegister;
    private ProgressBar progressBar;
    private FirebaseAuth fAuth;

    MutableLiveData<String> liveDataIntegrationCode = new MutableLiveData<>();
    private String intagrationCodeStatus = "";





    public static RegisterAniFragment newInstance() {
        return new RegisterAniFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.register_ani_fragment, container, false);



        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegisterAniViewModel.class);

        tvToLogin = getView().findViewById(R.id.tv_register_click_to_login);

        etUserName = getView().findViewById(R.id.username_login);
        etPass = getView().findViewById(R.id.password_register);
        etPassValidation = getView().findViewById(R.id.passwordvalidation_register);
        etIntegrationCode = getView().findViewById(R.id.validation_register);
        btnRegister = getView().findViewById(R.id.btn_login_create_account);
        progressBar = getView().findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();

        tvToLogin.setOnClickListener(view->{
            getFragmentManager().beginTransaction().
                    setCustomAnimations(R.anim.enter_top_to_bottom,R.anim.exite_bottom_to_top,R.anim.enter_bottom_to_top,R.anim.exite_top_to_bottom).
                    replace(R.id.mFragment, new LoginAniFragment()).commit();
        });


        System.out.println(intagrationCodeStatus);

        btnRegister.setOnClickListener(v->{

            mViewModel.getIntegrationCode().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    intagrationCodeStatus = s;
                }
            });
            System.out.println(intagrationCodeStatus);
        });

    }

}
