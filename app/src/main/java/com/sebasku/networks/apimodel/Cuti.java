package com.sebasku.networks.apimodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fadil on 3/25/18.
 */

public class Cuti {
    @SerializedName("awalCuti");
    private String awalCuti;
    @SerializedName("akhirCuti");
    private String awalCuti;
    @SerializedName("keterangan");
    private String keterangan;

    public Cuti(String awalCuti, String awalCuti1, String keterangan) {
        this.awalCuti = awalCuti;
        this.awalCuti = awalCuti1;
        this.keterangan = keterangan;
    }

    public String getAwalCuti() {
        return awalCuti;
    }

    public void setAwalCuti(String awalCuti) {
        this.awalCuti = awalCuti;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
