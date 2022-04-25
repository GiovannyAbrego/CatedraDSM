package com.example.tecnoshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPaswordActivity extends AppCompatActivity {
    EditText Txt_Mail;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pasword);

        Txt_Mail = findViewById(R.id.Mail);

        //firebaseAuth auth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.Mail, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);

    }

    public void sendMail(View view){
        //Toast.makeText(this, "hola buenas", Toast.LENGTH_SHORT).show();
        firebaseAuth = FirebaseAuth.getInstance();
        String mail = Txt_Mail.getText().toString();

        firebaseAuth.sendPasswordResetEmail(mail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPaswordActivity.this, "Correo enviado con exito", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(ForgotPaswordActivity.this, LonginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(ForgotPaswordActivity.this, "correo invalido", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}