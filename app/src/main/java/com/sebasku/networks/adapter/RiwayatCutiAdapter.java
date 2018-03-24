package com.sebasku.networks.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sebasku.networks.R;
import com.sebasku.networks.model.RiwayatCuti;

import java.util.LinkedList;

/**
 * Created by fadil on 3/17/18.
 */

public class RiwayatCutiAdapter extends RecyclerView.Adapter<RiwayatCutiAdapter.ListCutiViewHolder> {
    private LinkedList<RiwayatCuti> listCuti;
    //deklarasi global variabel
    private Context context;

    //konstruktor untuk menerima data adapter
    public RiwayatCutiAdapter(Context context, LinkedList<RiwayatCuti> listCuti) {
        this.context = context;
        this.listCuti = listCuti;
    }

    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListCutiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cuti, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListCutiViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListCutiViewHolder holder, int position) {
        final RiwayatCuti mCurrent = listCuti.get(position);
        holder.awalCuti.setText(mCurrent.getAwalCuti());
        //holder.tlAwalCuti.setText("Awal Cuti : ");
        holder.akhirCuti.setText(mCurrent.getAkhirCuti());
        //holder.tlAkhirCuti.setText("Akhir Cuti : ");
        holder.keterangan.setText(mCurrent.getKeterangan());
        //holder.tlKet.setText("Keterangan : ");
    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listCuti.size();
    }

    public class ListCutiViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        final RiwayatCutiAdapter mAdapter;
        private TextView awalCuti;
        private TextView akhirCuti;
        private TextView keterangan;
        private TextView tlKet;
        private CardView tlCard;
        private TextView tlAwalCuti;
        private TextView tlAkhirCuti;

        //untuk casting view yang digunakan pada list item
        public ListCutiViewHolder(View itemView, RiwayatCutiAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            awalCuti = itemView.findViewById(R.id.tv_awal_cuti);
            akhirCuti = itemView.findViewById(R.id.tv_akhir_cuti);
            keterangan = itemView.findViewById(R.id.tv_keterangan);
            tlAwalCuti = itemView.findViewById(R.id.tl_awal_cuti);
            tlAkhirCuti = itemView.findViewById(R.id.tv_akhir_cuti);
            tlCard = itemView.findViewById(R.id.cd_view);
            tlKet = itemView.findViewById(R.id.tl_keterangan);
            this.mAdapter = adapter;
            //itemView.setOnClickListener(this);
        }
    }
}

