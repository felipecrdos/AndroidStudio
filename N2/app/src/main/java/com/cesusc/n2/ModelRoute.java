package com.cesusc.n2;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ModelRoute {

    @GET("/asteroid")
    Call<Resource> getResouces();

    @GET("/asteroid/{id}")
    Call<Resource> getResouceById(@Path("id") int id);
}
