package com.example.data_struct;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by kozlo on 25.11.2017.
 */

public interface ServerApi {

    @Multipart
    @POST("/api/v1.1/authenticate")
    Call<Long> uploadImage(@Part MultipartBody.Part filePart);

    @GET("/task/update")
    Call<Void> updateTask(@Query("task") ServerTask task);
}
