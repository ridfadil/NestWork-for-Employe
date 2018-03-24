package com.sebasku.networks.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sebasku.networks.R;

public class RequestGajiFragment extends Fragment {
    View requestGaji;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requestGaji = inflater.inflate(R.layout.fragment_request_gaji, container, false);
        return requestGaji;
    }
}