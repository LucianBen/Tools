package com.lucianben.tools.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucianben.tools.ui.BusActivity;
import com.lucianben.tools.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;


    }

    private void initView(View view) {

    }

    @OnClick(R.id.inquire_bus)
    public void onClick() {
        startActivity(new Intent(getActivity(), BusActivity.class));
    }
}
