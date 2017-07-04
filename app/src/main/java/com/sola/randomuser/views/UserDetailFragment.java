package com.sola.randomuser.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sola.randomuser.R;
import com.sola.randomuser.databinding.UserDetailsBinding;
import com.sola.randomuser.models.Result;
import com.squareup.picasso.Picasso;

/**
 * Created by Sola2Be on 04.07.2017.
 */

public class UserDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        Result result = (Result) getArguments().getSerializable("result");
        UserDetailsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.user_details, container, false);
        View v = binding.getRoot();
        ImageView avatar = (ImageView) v. findViewById(R.id.avatar);
        if (result != null) {
            Picasso.with(getContext()).load(result.getPicture().getMedium()).into(avatar);
            binding.setUser(result);
        }
        return v;

    }
}
