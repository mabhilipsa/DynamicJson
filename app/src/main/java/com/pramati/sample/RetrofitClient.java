package com.pramati.sample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vivek on 30-11-2017.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static  final String BASE_URL="https://my-json-server.typicode.com/vivekprcs/demo/";

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOKhttpClient())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOKhttpClient() {
        HttpLoggingInterceptor logging= new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }
}
