package com.example.data_struct;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by kozlo on 25.11.2017.
 */

public class ServerInteracter {
    private static ServerInteracter instance;
    private ServerApi retrofitService;
    private String token;

    private ServerInteracter() {
        Retrofit retrofitToken = new Retrofit.Builder()
                .baseUrl("https://developers.lingvolive.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        retrofitService = retrofitToken.create(ServerApi.class);
    }

    static public ServerInteracter getInstance() {
        if (instance == null) {
            instance = new ServerInteracter();
        }
        return instance;
    }

    interface CallbackLike {
        void onResponse(Long id);
    }

    public void uploadPhoto(File image, final CallbackLike callbackLike) {
        Log.d("Retrofit", "getting token");
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", image.getName(), RequestBody.create(MediaType.parse("image/*"), image));
        retrofitService.uploadImage(filePart).enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                callbackLike.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {

            }
        });
    }

    public void updatePhoto(ServerTask task) {
        try {
            retrofitService.updateTask(task).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
