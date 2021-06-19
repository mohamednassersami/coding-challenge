package com.nasser.codingchallenge.data;

import com.nasser.codingchallenge.pojo.RepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoInterface {

  @GET("repositories?q=created%3A>2017-10-22&sort=stars&order=desc&fbclid=IwAR3-hXxtK2PuTTTpTDmM1vtj3AxcPe9hk-OYbP8AP1kx65uzTdfV2SMdcQU")
 public Call<List<RepoModel>> getRepos();
 }
