package com.sola.randomuser.presenters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.sola.randomuser.models.Result;
import com.sola.randomuser.models.User;
import com.sola.randomuser.utils.ListCallback;
import com.sola.randomuser.utils.Paginator;
import com.sola.randomuser.utils.RandUserRetrofit;
import com.sola.randomuser.utils.UsersAdapter;
import com.sola.randomuser.views.ViewUserList;

import retrofit2.Callback;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class ListPresenter {

    private static int lastPage = 1;
    private static ListPresenter presenter;
    private RandUserRetrofit retrofit;
    private ViewUserList vUserList;
    private UsersAdapter adapter;
    private Paginator paginator;
    private boolean isPageLoading = false;

    public static ListPresenter getInstance(ViewUserList vUserList) {
        if (presenter == null)
            presenter = new ListPresenter(vUserList);
        return presenter;
    }

    private ListPresenter(ViewUserList vUserList) {

        this.vUserList = vUserList;
        retrofit = RandUserRetrofit.getInstance();
    }

    public void loadList() {
        Callback callback = new ListCallback(this);
        retrofit.loadPage(lastPage + 1, callback);
        isPageLoading = true;
        if (adapter.getItemCount() != 0)
            adapter.showProgress();

    }

    public void loadSuccesfully(User user) {
        if (user.getResults() != null) {
            lastPage = user.getInfo().getPage();
            adapter.addItems(user.getResults());
            adapter.hideProgress();
        }
        isPageLoading = false;
    }

    public void loadFailure(String error) {
        vUserList.onSomethingWrong(error);
    }

    public boolean isPageLoading() {
        return isPageLoading;
    }

    public UsersAdapter getAdapter(Context context, View.OnClickListener listener) {
        if (adapter == null)
            adapter = new UsersAdapter(context, listener);
        return adapter;
    }

    public Paginator getPaginator(LinearLayoutManager layoutManager) {
        if (paginator == null)
            paginator = new Paginator(layoutManager, this);
        return paginator;
    }

}
