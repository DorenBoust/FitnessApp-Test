package com.example.fitnessapp.loginAndRegisterAnimated;

import android.os.AsyncTask;
import android.text.TextUtils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.fitnessapp.models.AsynUserJSON;
import com.google.android.material.textfield.TextInputLayout;


public class RegisterAniViewModel extends ViewModel {

    private MutableLiveData<String> mLiveData;


    public RegisterAniViewModel() {

        mLiveData = new MutableLiveData<>();
        new AsynUserJSON(mLiveData).execute();

    }

    public void validationDetails(TextInputLayout etUserName, TextInputLayout etPass, TextInputLayout etPassValidation, TextInputLayout etIntegrationCode){
        String userName = etUserName.getEditText().getText().toString();
        String pass = etPass.getEditText().getText().toString();
        String passValidation = etPassValidation.getEditText().getText().toString();
        String intagrationCode = etIntegrationCode.getEditText().getText().toString();


        if (TextUtils.isEmpty(userName)){
            etUserName.setError("שדה חובה");
        } else{
            etUserName.setError(null);
        }

        if (TextUtils.isEmpty(pass)){
            etPass.setError("שדה חובה");
        }else{
            etPass.setError(null);
        }

        if (TextUtils.isEmpty(passValidation)){
            etPassValidation.setError("שדה חובה");
        }else{
            etPassValidation.setError(null);
        }

        if (TextUtils.isEmpty(intagrationCode)){
            etIntegrationCode.setError("שדה חובה");
        }else{
            etIntegrationCode.setError(null);
        }


    }

    public LiveData<String> getIntegrationCode() {
        return mLiveData;
    }



}
