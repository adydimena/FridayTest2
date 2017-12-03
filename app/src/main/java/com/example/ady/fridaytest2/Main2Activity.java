package com.example.ady.fridaytest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        ImageView fullpage = findViewById(R.id.fullpage);

        String image = " ";
        Bundle link = getIntent().getExtras();
        if (link!=null){
            image = link.getString("magic");
        }


        Glide.with(this)
                .load(image)
                .into(fullpage);
    }
}
