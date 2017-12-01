package com.pramati.sample;

import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vivek on 30-11-2017.
 */

public interface ApiService {
/*

    @GET("db")
    Call<ResponseModel> getCategoriesData();
*/

    @GET("db")
    Call<Map<String,Map<String,Map<String,String>>>> getCategoriesData();



}
