package com.example.warline;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class KeranjangI extends Keranjang {
    public KeranjangI(String name, double price, int quantity, int imageResource) {
        super(name, price, quantity, imageResource);
    }

    double total;

    public double totalHarga(double harga, int jumlah){
        total = harga*jumlah;
        return total;
    }

}
