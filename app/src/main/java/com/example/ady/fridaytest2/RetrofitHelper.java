package com.example.ady.fridaytest2;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Ady on 11/29/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "http://api.flickr.com/services/feeds/";


    //    build the retrofit object to be used
    public static Retrofit create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }
    public static Call<Response> responseback(){
        Retrofit retrofit = create();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.responseback();
    }


    //    create an interface for http verbs
    interface RetrofitService  {

       @GET("photos_public.gne?tag=kitten&format=json&nojsoncallback=1")
        Call<Response> responseback();
    }
}