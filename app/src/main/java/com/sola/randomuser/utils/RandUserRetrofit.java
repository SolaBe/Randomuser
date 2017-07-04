package com.sola.randomuser.utils;

import com.sola.randomuser.models.User;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class RandUserRetrofit {

    private final String BASE_URL = "https://randomuser.me";

    private final int USERS_PER_PAGE = 20;

    private static RandUserRetrofit retrofit;

    private RandUserRequests requests;


    private RandUserRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requests = retrofit.create(RandUserRequests.class);
    }

    public static RandUserRetrofit getInstance() {
        return retrofit == null ? new RandUserRetrofit() : retrofit;
    }

    public void loadPage(int page, Callback callback) {
        Call<User> call = requests.getUsers(page, USERS_PER_PAGE);
        call.enqueue(callback);
    }

}
