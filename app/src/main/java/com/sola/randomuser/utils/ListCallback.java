package com.sola.randomuser.utils;

import android.util.Log;

import com.sola.randomuser.models.User;
import com.sola.randomuser.presenters.ListPresenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class ListCallback implements Callback<User> {

    private static final String TAG = "Result list requset";
    private ListPresenter presenter;

    public ListCallback(ListPresenter presenter) {
        this.presenter = presenter;
    }

//    @Override
//    public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
//        Log.d(TAG, "response " + response.isSuccessful());
//
//        if (!response.isSuccessful()) {
//            if (response.code() == 403) {
//                InputStream is = response.errorBody().byteStream();
//                presenter.loadFailure(decodeErrorMessage(is));
//            }
//        } else {
//            presenter.loadSuccesfully(response.body());
//        }
//    }
//
//    @Override
//    public void onFailure(Call<List<Result>> call, Throwable t) {
//        Log.d(TAG, "fail " + t.getMessage());
//        presenter.loadFailure("Load failure! Check internet connection");
//    }


    public String decodeErrorMessage(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        try {
            while (br.read() != -1) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        Log.d(TAG, "response " + response.isSuccessful());

        if (!response.isSuccessful()) {
            if (response.code() == 403) {
                InputStream is = response.errorBody().byteStream();
                presenter.loadFailure(decodeErrorMessage(is));
            }
        } else {
            presenter.loadSuccesfully(response.body());
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        Log.d(TAG, "fail " + t.getMessage());
        presenter.loadFailure("Load failure! Check internet connection");
    }
}
