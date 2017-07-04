package com.sola.randomuser.utils;

import com.sola.randomuser.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public interface RandUserRequests {

    @GET("/api/")
    Call<User> getUsers(@Query("page") int page, @Query("results") int results);

}
