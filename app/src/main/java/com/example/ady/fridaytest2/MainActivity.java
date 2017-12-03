package com.example.ady.fridaytest2;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;
    private List<image> list;
    Activity getactivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
       // context = MainActivity.this;


        RetrofitHelper.responseback()
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                        for (int i = 0; i < response.body().getItems().size(); i++) {
                            String bigimage = response.body().getItems().get(i).getLink();
                            String smallimage = response.body().getItems().get(i).getMedia().getM();
                            String Author = response.body().getItems().get(i).getAuthor();
                            String Title = response.body().getItems().get(i).getTitle();
                            list.add(new image(bigimage,smallimage,Author,Title));

                            Log.d(TAG, "onResponse: TITLE " + response.body().getItems().get(i).getTitle());
                            Log.d(TAG, "onResponse: Author " + response.body().getItems().get(i).getAuthor());
                            Log.d(TAG, "onResponse: GETM " + response.body().getItems().get(i).getMedia().getM());
                            Log.d(TAG, "onResponse: LINK " + response.body().getItems().get(i).getLink());

                        }
                        RecyclerView recyclerView = findViewById(R.id.recycleMainAcitivity);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(MainActivity.this);
                        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
                        Recycleadapter recycleadapter = new Recycleadapter(list,MainActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setItemAnimator(itemAnimator);
                        recyclerView.setAdapter(recycleadapter);

                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Log.d(TAG, "onResponse: " + t.getMessage());

                    }
                });

    }
}
