package com.example.tecnoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {

    private ImageView mouse, teclado, procesador, audifonos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mouse = (ImageView) findViewById(R.id.mouse);
        procesador = (ImageView) findViewById(R.id.proces);
        teclado = (ImageView) findViewById(R.id.teclado);
        audifonos = (ImageView) findViewById(R.id.audif);

        mouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AdminAddNewProductActivity.class );
                intent.putExtra("Categoria", "Mouse");
                startActivity(intent);
            }
        });

        teclado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AdminAddNewProductActivity.class );
                intent.putExtra("Categoria", "Teclado");
                startActivity(intent);
            }
        });

        procesador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AdminAddNewProductActivity.class );
                intent.putExtra("Categoria", "Procesador");
                startActivity(intent);
            }
        });

        audifonos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AdminAddNewProductActivity.class );
                intent.putExtra("Categoria", "Audifonos");
                startActivity(intent);
            }
        });

    }

    public void Signoff(View view){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "sesion cerrada correctamente", Toast.LENGTH_SHORT).show();

        goToLogin();
    }

    private void goToLogin() {
        Intent i = new Intent(this, LonginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}