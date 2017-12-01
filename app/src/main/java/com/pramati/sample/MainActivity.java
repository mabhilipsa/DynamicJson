package com.pramati.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		//

      Call<Map<String,Map<String,Map<String,String>>>>call= RetrofitClient.getClient().create(ApiService.class).getCategoriesData();
      call.enqueue(new Callback<Map<String, Map<String, Map<String, String>>>>() {
          @Override
          public void onResponse(Call<Map<String, Map<String, Map<String, String>>>> call, Response<Map<String, Map<String, Map<String, String>>>> response) {
              Map<String,Map<String,Map<String,String>>> outerMap=  response.body();

              for ( Map.Entry<String,Map<String,Map<String,String>>>entryOuterMap:outerMap.entrySet()
                   ) {
                  String categoryName=entryOuterMap.getKey();
                  Log.i("CategoryName",categoryName);
                  Map<String,Map<String,String>>childCategoryMap=entryOuterMap.getValue();

                  for(Map.Entry<String,Map<String,String>>entryChildMap:childCategoryMap.entrySet()){
                      Log.i("ChildCategory",entryChildMap.getKey());
                      Map<String,String> attributesMap=entryChildMap.getValue();

                      for(Map.Entry<String,String>entryAttributesMap:attributesMap.entrySet()){
                          String specificationName=entryAttributesMap.getKey();
                          String specificationValue=entryAttributesMap.getValue();

                          Log.i("specName",specificationName);
                          Log.i("specValue",specificationValue);



                      }
                  }

              }


          }

          @Override
          public void onFailure(Call<Map<String, Map<String, Map<String, String>>>> call, Throwable t) {

          }
      });

    }
}
