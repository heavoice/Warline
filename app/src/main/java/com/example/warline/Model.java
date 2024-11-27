package com.example.warline;

import java.text.DecimalFormat;
import java.text.NumberFormat;

abstract class Product {
    private String name;

    private String harga;
    private double price;
    private int stok;
    private int ImageResource;

    public Product(String name, double price, int stok, int ImageResource) {
        this.name = name;
        this.price = price;
        this.stok = stok;
        this.ImageResource = ImageResource;
    }

    public String getName() {
        return name;
    }

    public String getHarga() {
        NumberFormat f = new DecimalFormat("#,###");
        harga = f.format(price);
        return "Rp. " + harga;
    }

    public double getPrice() {
        return price;
    }

    public int getStok() {
        return stok;
    }

    public String getStok2(){
        return Integer.toString(stok);
    }

    public int getImageResource() {
        return ImageResource;
    }
}

interface ModelUser {
    String getEmail();
    String getPass();
    double getSaldo();
    String getNama();
    String getSaldotext();
}
abstract class User implements ModelUser{
    private String email;
    private String pass;
    private double saldo;
    private String nama;

    private String saldotext;

    public User(String email, String pass, double saldo, String nama){
        this.email = email;
        this.pass = pass;
        this.saldo = saldo;
        this.nama = nama;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public String getSaldotext() {
        NumberFormat f = new DecimalFormat("#,###");
        saldotext = f.format(saldo);
        return "Rp. " + saldotext;
    }
}

abstract class Keranjang{

    private String name;

    private String harga;
    private double price;
    private int jumlah;
    private int ImageResource;
    public Keranjang(String name, double price, int jumlah, int ImageResource) {
        this.name = name;
        this.price = price;
        this.jumlah = jumlah;
        this.ImageResource = ImageResource;
    }

    public String getName() {
        return name;
    }

    public String getHarga() {
        NumberFormat f = new DecimalFormat("#,###");
        harga = f.format(price);
        return "Rp. " + harga;
    }

    public double getPrice() {
        return price;
    }
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getStok2(){
        return Integer.toString(jumlah);
    }

    public int getImageResource() {
        return ImageResource;
    }
}

