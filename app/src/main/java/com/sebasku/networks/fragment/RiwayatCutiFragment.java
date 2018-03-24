package com.sebasku.networks.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sebasku.networks.adapter.RiwayatCutiAdapter;
import com.sebasku.networks.R;
import com.sebasku.networks.model.RiwayatCuti;

import java.util.LinkedList;

public class RiwayatCutiFragment extends Fragment {
    private final LinkedList<RiwayatCuti> listRiwayatCuti = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private RiwayatCutiAdapter mAdapter;
    View viewRiwayatCuti;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRiwayatCuti  = inflater.inflate(R.layout.fragment_riwayat_cuti, container, false);
        listRiwayatCuti.addLast(new RiwayatCuti("15 januari 2018", "20 februari 2018","Umroh"));
        listRiwayatCuti.addLast(new RiwayatCuti("28 januari 2018", "13 februari 2018","Nikah"));
        listRiwayatCuti.addLast(new RiwayatCuti("13 januari 2018", "17 februari 2018","Berobat"));
        listRiwayatCuti.addLast(new RiwayatCuti("2 januari 2018", "1 februari 2018","Change Study"));
        listRiwayatCuti.addLast(new RiwayatCuti("25 januari 2018", "12 februari 2018","UAS"));
        mRecyclerView = viewRiwayatCuti.findViewById(R.id.rv_riwayat_cuti);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RiwayatCutiAdapter(getActivity(),listRiwayatCuti);
        mRecyclerView.setAdapter(mAdapter);
        return viewRiwayatCuti;
    }
}

