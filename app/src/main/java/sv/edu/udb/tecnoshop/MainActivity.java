package sv.edu.udb.tecnoshop;

import static sv.edu.udb.tecnoshop.R.drawable.desccase;
import static sv.edu.udb.tecnoshop.R.drawable.descdisco;
import static sv.edu.udb.tecnoshop.R.drawable.descfuente;
import static sv.edu.udb.tecnoshop.R.drawable.descgrafica;
import static sv.edu.udb.tecnoshop.R.drawable.descpmadre;
import static sv.edu.udb.tecnoshop.R.drawable.descwatercool;
import static sv.edu.udb.tecnoshop.R.drawable.ic_cataudifonos;
import static sv.edu.udb.tecnoshop.R.drawable.ic_catcoolers;
import static sv.edu.udb.tecnoshop.R.drawable.ic_catlaptop;
import static sv.edu.udb.tecnoshop.R.drawable.ic_catmause;
import static sv.edu.udb.tecnoshop.R.drawable.ic_catprocesadores;
import static sv.edu.udb.tecnoshop.R.drawable.ic_catteclados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import sv.edu.udb.tecnoshop.adapter.CategoryAdapter;
import sv.edu.udb.tecnoshop.adapter.DiscountedProductAdapter;
import sv.edu.udb.tecnoshop.model.Category;
import sv.edu.udb.tecnoshop.model.DiscountedProducts;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;


    ImageView allCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });


        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, descgrafica));
        discountedProductsList.add(new DiscountedProducts(2, descdisco));
        discountedProductsList.add(new DiscountedProducts(3, desccase));
        discountedProductsList.add(new DiscountedProducts(4, descpmadre));
        discountedProductsList.add(new DiscountedProducts(5, descfuente));
        discountedProductsList.add(new DiscountedProducts(6, descwatercool));

        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, ic_catmause));
        categoryList.add(new Category(2, ic_cataudifonos));
        categoryList.add(new Category(3, ic_catcoolers));
        categoryList.add(new Category(4, ic_catlaptop));
        categoryList.add(new Category(5, ic_catprocesadores));
        categoryList.add(new Category(6, ic_catteclados));

        // adding data to model

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

}