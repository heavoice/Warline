package com.example.warline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    TextView forgotPw;
    EditText editTextEmail, editTextPass;
    Button btnLogin;
    private List<Keranjang> cartProducts = new ArrayList<>();

    public class Customer extends User {
        public Customer(String email, String pass, double saldo, String nama) {
            super(email, pass, saldo, nama);
        }
    }
    public class Admin extends User {
        public Admin(String email, String pass, double saldo, String nama) {
            super(email, pass, saldo, nama);
        }
    }

    // Create instances of user subclasses for login
    User user1 = new Customer("zozo@gmail.com", "zozo123", 500000, "Zozo");
    User user2 = new Customer("inez@gmail.com", "inez123", 250000, "Inez");
    User adminUser = new Admin("admin@gmail.com", "admin123", 0.0, "Admin");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPw = findViewById(R.id.forgotpw);
        editTextEmail = findViewById(R.id.editEmailLogin);
        editTextPass = findViewById(R.id.editPassLogin);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editemail = editTextEmail.getText().toString();
                String editpass = editTextPass.getText().toString();

                if (cekLogin(editemail, editpass)) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    // Pass the cartProducts list to the MainActivity
                    intent.putExtra("cartList", new ArrayList<>(cartProducts));
                    startActivity(intent);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean cekLogin(String email, String pass){
        if (user1.getEmail().equals(email) && user1.getPass().equals(pass)){
            SharedPreferences share = getSharedPreferences("Data", MODE_PRIVATE);
            SharedPreferences.Editor editor = share.edit();
            editor.putString("email", user1.getEmail());
            editor.putString("pass", user1.getPass());
            editor.putString("username", user1.getNama());
            editor.putLong("saldo", (long) user1.getSaldo());
            editor.apply();
            return true;
        } else if (user2.getEmail().equals(email) && user2.getPass().equals(pass)) {
            SharedPreferences share = getSharedPreferences("Data", MODE_PRIVATE);
            SharedPreferences.Editor editor = share.edit();
            editor.putString("email", user2.getEmail());
            editor.putString("pass", user2.getPass());
            editor.putString("username", user2.getNama());
            editor.putLong("saldo", (long) user2.getSaldo());
            editor.apply();
            return true;
        }
        return false;
    }
}