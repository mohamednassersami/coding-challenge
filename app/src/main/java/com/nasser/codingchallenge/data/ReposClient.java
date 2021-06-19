package com.nasser.codingchallenge.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nasser.codingchallenge.pojo.RepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReposClient {
    private static String Base_URL = "https://api.github.com/search/";
    private RepoInterface repoInterface;
    private static ReposClient INSTANCE;

    public ReposClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        repoInterface = retrofit.create(RepoInterface.class);
    }

    public static ReposClient getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new ReposClient();
        }
        return INSTANCE;
    }

    public Call<List<RepoModel>> getRepos(){
        return repoInterface.getRepos();
    }
}

