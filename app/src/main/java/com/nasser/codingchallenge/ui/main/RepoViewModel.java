package com.nasser.codingchallenge.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.afollestad.materialdialogs.MaterialDialog;
import com.nasser.codingchallenge.data.ReposClient;
import com.nasser.codingchallenge.pojo.RepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RepoViewModel extends ViewModel {

    MutableLiveData<List<RepoModel>> repoMutableLiveData = new MutableLiveData<>();
    public  void getRepos(){
        ReposClient.getINSTANCE().getRepos().enqueue(new Callback<List<RepoModel>>() {
            @Override
            public void onResponse(Call<List<RepoModel>> call, Response<List<RepoModel>> response) {
                    repoMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<RepoModel>> call, Throwable t) {

            }
        });
    }
}
