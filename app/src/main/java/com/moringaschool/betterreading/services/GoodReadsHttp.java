package com.moringaschool.betterreading.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.moringaschool.betterreading.Constants;
import com.moringaschool.betterreading.models.Work;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoodReadsHttp {

    public static void findBooks(String searchedBook, Callback callback){


        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_PARAMETER,Constants.GOODREADS_API_KEY);
        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETER,searchedBook);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization",Constants.GOODREADS_API_KEY)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static List<Work> searchResults(Response response){
        List<Work> results = new ArrayList<>();
        try {
            String xmlResponse = response.body().string();
            if (response.isSuccessful()){
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONArray jsonArray = jsonResponse.getJSONObject("GoodreadsResponse")
                        .getJSONObject("search")
                        .getJSONObject("results")
                        .getJSONArray("work");

                Type collectionType = new TypeToken<List<Work>>() {}.getType();
                Gson gson = new GsonBuilder().create();
                results= gson.fromJson(jsonArray.toString(), collectionType);
            }
        } catch (JSONException  | NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return results;
    }

}
