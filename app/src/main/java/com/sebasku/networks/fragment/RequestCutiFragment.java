package com.sebasku.networks.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sebasku.networks.R;

    public class RequestCutiFragment extends Fragment {
        View viewRequestCuti;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            viewRequestCuti = inflater.inflate(R.layout.fragment_request_cuti, container, false);
            return viewRequestCuti;
        }
    }