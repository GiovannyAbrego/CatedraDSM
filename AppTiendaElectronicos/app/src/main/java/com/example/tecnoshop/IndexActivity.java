package com.example.tecnoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IndexActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    FirebaseUser user = mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        if(user != null){
            goToHome();
        }

    }

    public void checkIn(View view){
        Intent i = new Intent(this, checkInActivity.class);
        startActivity(i);
    }

    public void login(View view){
        Intent i = new Intent(this, LonginActivity.class);
        startActivity(i);
    }



    private void goToHome() {
        Intent i = new Intent(this, HomeActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

    }

}