package com.nasser.codingchallenge.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.nasser.codingchallenge.R;
import com.nasser.codingchallenge.pojo.RepoModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RepoViewModel repoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel.class);
        repoViewModel.getRepos();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        ReposAdapter adapter = new ReposAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        repoViewModel.repoMutableLiveData.observe(this, new Observer<List<RepoModel>>() {
            @Override
            public void onChanged(List<RepoModel> repoModels) {
                adapter.setList(repoModels);
            }
        });
    }
}