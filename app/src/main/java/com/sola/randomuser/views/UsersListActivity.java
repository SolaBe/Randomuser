package com.sola.randomuser.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sola.randomuser.R;
import com.sola.randomuser.models.Result;
import com.sola.randomuser.presenters.ListPresenter;

import java.io.Serializable;

public class UsersListActivity extends AppCompatActivity implements ViewUserList {

    private  boolean twoPane;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Result result = (Result) view.getTag();
            if (result != null) {
                if (twoPane)
                    startDetailFragment(result);
                else
                    startDetailActivity(result);
            } else {
                Toast.makeText(UsersListActivity.this, "Cannot show details", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.usersList);
        ListPresenter presenter = ListPresenter.getInstance(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(presenter.getAdapter(this, listener));
        recycler.addOnScrollListener(presenter.getPaginator(layoutManager));

        if (findViewById(R.id.details) != null) {
            twoPane = true;
        }

        if (savedInstanceState == null) {
            presenter.loadList();
        }
    }

    @Override
    public void onSomethingWrong(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    private void startDetailActivity(Result result) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    private void startDetailFragment(Result result) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("result", result);

        UserDetailFragment fragment = new UserDetailFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.details, fragment).commit();
    }
}
