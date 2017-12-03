package com.example.ady.fridaytest2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ady on 11/14/2017.
 */

public class Recycleadapter extends RecyclerView.Adapter<Recycleadapter.ViewHolder> {
    List<image> list = new ArrayList<>();
    Context context;
    int click = 0;

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public Recycleadapter(List<image> list, Context contex) {

        this.list = list;
        this.context = contex;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleviewlayout, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (list.get(position) != null) ;
        holder.Title.setText(list.get(position).getTitle());
        holder.Author.setText(list.get(position).getAuthor());
        Glide.with(context)
                .load(list.get(position).getM())
                .thumbnail(0.1f)
                .into(holder.listimage);

        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(context);
                final String[] myitems = {"Show Big","Show Small"};

                alert.setTitle("Choose the size!! ")
                        .setItems(myitems, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context,"you Have clicked on " + myitems[i], Toast.LENGTH_LONG).show();
                                switch (myitems[i]){
                                    case "Show Big":
                                        Intent intent = new Intent(context,Main2Activity.class);
                                        intent.putExtra("magic",list.get(position).getM());
                                        context.startActivity(intent);

                                        break;
                                    case "Show Small":
                                        setClick(1);
                                        AlertDialog.Builder showimage = new AlertDialog.Builder(context);
                                        LayoutInflater factory = LayoutInflater.from(context);
                                        final View v = factory.inflate(R.layout.alertdialoglayout, null);
                                        final ImageView imageView = v.findViewById(R.id.showsmall);
                                        Glide.with(context)
                                                .load(list.get(position).getM())
                                                .into(imageView);
                                        showimage.setView(v);
                                        showimage.create().show();
                                        break;
                                }
                            }
                        });


                alert.create();
                alert.show();

                if (getClick() == 1){

                    setClick(0);


                }

                return true;
            }
        });



        // holder.movieYear.setText("Moviie Year is: "+list.get(position).getYear());
        // holder.movieDirector.setText("The Boss of the movie is: "+list.get(position).getDirector());


    }


    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView Title;
        private final TextView Author;
        private final ImageView listimage;
        private final LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.Title);
            Author = itemView.findViewById(R.id.author);
            listimage = itemView.findViewById(R.id.listimage);
            linearLayout = itemView.findViewById(R.id.linearlayout);

        }
    }
}


