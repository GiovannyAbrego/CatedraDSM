package com.example.tecnoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdminAddNewProductActivity extends AppCompatActivity {

    private String NombreCategoria;
    private Button AddNewProductButton;
    private ImageView InputProductImage;
    private EditText InputNomProduct, InputDescProducto, InputPrecProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        NombreCategoria = getIntent().getExtras().get("Categoria").toString();

        Toast.makeText(this, NombreCategoria, Toast.LENGTH_SHORT).show();

        AddNewProductButton = (Button) findViewById(R.id.add_new_product);
        InputProductImage = (ImageView) findViewById(R.id.select_product_image);
        InputNomProduct = (EditText) findViewById(R.id.Nom_producto);
        InputDescProducto = (EditText) findViewById(R.id.Desc_producto);
        InputPrecProduct = (EditText) findViewById(R.id.Prec_producto);

    }
}