package com.project.interopsister;

public class myvoucherModel {

    private String diskon;
    private String info;
    private String kode_voucher;
    private String nama_merch;
    private String alamat;
    private String id;

    private myvoucherModel() {

    }

    private myvoucherModel(String diskon, String info, String kode_voucher, String nama_merch, String alamat, String id ) {
        this.diskon = diskon;
        this.info = info;
        this.kode_voucher = kode_voucher;
        this.nama_merch = nama_merch;
        this.alamat = alamat;
        this.id = id;
    }

    //getter
    public String getDiskon() {
        return diskon;
    }
    public String getInfo() {
        return info;
    }
    public String getKode_voucher() {
        return kode_voucher;
    }
    public String getNama_merch() {
        return nama_merch;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getId() {
        return id;
    }

    //setter
    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setKode_voucher(String kode_voucher) {
        this.kode_voucher = kode_voucher;
    }

    public void setNama_merch(String nama_merch) {
        this.nama_merch = nama_merch;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
