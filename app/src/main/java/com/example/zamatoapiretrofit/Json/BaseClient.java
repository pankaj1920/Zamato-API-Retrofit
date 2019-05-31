package com.example.zamatoapiretrofit.Json;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseClient {

    private static final String BaseUrl = "https://developers.zomato.com/api/v2.1/";
    private static Retrofit retrofitEndPoint;

    public static Retrofit getBaseClient() {

        if (retrofitEndPoint == null) {
            retrofitEndPoint = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitEndPoint;
    }
}
