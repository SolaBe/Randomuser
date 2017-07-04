package com.sola.randomuser.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sola.randomuser.R;
import com.sola.randomuser.models.Result;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            Result result = (Result) getIntent().getSerializableExtra("result");
            Bundle bundle = new Bundle();
            bundle.putSerializable("result", result);

            UserDetailFragment fragment = new UserDetailFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.userDetailContainer,
                    fragment).commit();
        }
    }
}
