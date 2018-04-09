package com.sebasku.networks.apimodel;

/**
 * Created by fadil on 4/2/18.
 */

public class AjukanCutiForm {
    private String email;
    private String awalCuti;
    private String akhirCuti;
    private String keterangan;

    public AjukanCutiForm(String email, String awalCuti, String akhirCuti, String keterangan) {
        this.email = email;
        this.awalCuti = awalCuti;
        this.akhirCuti = akhirCuti;
        this.keterangan = keterangan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
