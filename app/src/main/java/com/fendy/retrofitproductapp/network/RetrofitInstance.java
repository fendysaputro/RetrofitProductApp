package com.fendy.retrofitproductapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.2.73:5002/api/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
