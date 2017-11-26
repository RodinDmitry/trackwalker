package com.example.data_struct;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    @POST("/")
    Call<Long> uploadImage(@Part MultipartBody.Part filePart);

    @POST("api/task/update/")
    Call<Long> updateTask(@Body ServerTask task);
}
