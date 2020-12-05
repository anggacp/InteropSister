package com.project.interopsister;

public class user_dataModel {

    private String nama;
    private String urlLogo;

    private user_dataModel() {

    }

    private user_dataModel(String nama, String urlLogo) {
        this.nama = nama;
        this.urlLogo = urlLogo;
    }

    public String getNama() {
        return nama;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
}
