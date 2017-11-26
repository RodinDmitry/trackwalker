package com.example.data_struct;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
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

    private ServerInteracter() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofitToken = new Retrofit.Builder()
                .baseUrl("http://10.55.167.250:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
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
                Log.d("retrofit", "photo id" + response.body());
                callbackLike.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.d("retrofit", "failure " + t);
            }
        });
    }

    public void updateTask(ServerTask task) {
        Call<Long> call = retrofitService.updateTask(task);
        //Log.d("retrofit", call.request().body().toString());
        call.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                if (!response.isSuccessful()) {
                    Log.d("retrofit", "not succ " + response.code()+ ' ' + response.body());
                } else {
                    Log.d("retrofit", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {

            }
        });
    }

    public interface ListCallback {
        void proceedTask(Long tid);
    }

    public void getMyTasks(String name, final ListCallback callback) {
        Call<List<Long>> call = retrofitService.getMyTasks(name);
        //Log.d("retrofit", call.request().body().toString());
        call.enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                for(Long tid: response.body()) {
                    callback.proceedTask(tid);
                }
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {

            }
        });
    }

    public interface OneCallback {
        void proceedTask(Task task);
    }

    public void getTask(Long id, final OneCallback callback) {
        Call<ServerTask> call = retrofitService.getTask(id);
        //Log.d("retrofit", call.request().body().toString());
        call.enqueue(new Callback<ServerTask>() {
            @Override
            public void onResponse(Call<ServerTask> call, Response<ServerTask> response) {
                callback.proceedTask(new Task(response.body()));
            }

            @Override
            public void onFailure(Call<ServerTask> call, Throwable t) {

            }
        });
    }
}
