package com.sebasku.networks.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fadil on 4/2/18.
 */


/*        "id": "5ac20dc3e5938d0f9cdcde76",
                "email": "farid1@gmail.com",
                "awal_cuti": "1996-01-01T17:00:00.000Z",
                "akhir_cuti": "2019-09-08T17:00:00.000Z",
                "keterangan": "umroh",
                "status": "waiting to approve"*/
public class Cuti {

    @SerializedName("id")
    @Expose
    private String idCuti;
    @SerializedName("email")
    @Expose
    private String emailCuti;
    @SerializedName("awal_cuti")
    @Expose
    private String awalCuti;
    @SerializedName("akhir_cuti")
    @Expose
    private String akhirCuti;
    @SerializedName("keterangan")
    @Expose
    private String keteranganCuti;
    @SerializedName("status")
    @Expose
    private String statusCuti;

    public Cuti(String idCuti, String emailCuti, String awalCuti, String akhirCuti, String keteranganCuti, String statusCuti) {
        this.idCuti = idCuti;
        this.emailCuti = emailCuti;
        this.awalCuti = awalCuti;
        this.akhirCuti = akhirCuti;
        this.keteranganCuti = keteranganCuti;
        this.statusCuti = statusCuti;
    }

    public String getIdCuti() {
        return idCuti;
    }

    public void setIdCuti(String idCuti) {
        this.idCuti = idCuti;
    }

    public String getEmailCuti() {
        return emailCuti;
    }

    public void setEmailCuti(String emailCuti) {
        this.emailCuti = emailCuti;
    }

    public String getAwalCuti() {
        return awalCuti;
    }

    public void setAwalCuti(String awalCuti) {
        this.awalCuti = awalCuti;
    }

    public String getAkhirCuti() {
        return akhirCuti;
    }

    public void setAkhirCuti(String akhirCuti) {
        this.akhirCuti = akhirCuti;
    }

    public String getKeteranganCuti() {
        return keteranganCuti;
    }

    public void setKeteranganCuti(String keteranganCuti) {
        this.keteranganCuti = keteranganCuti;
    }

    public String getStatusCuti() {
        return statusCuti;
    }

    public void setStatusCuti(String statusCuti) {
        this.statusCuti = statusCuti;
    }
}
