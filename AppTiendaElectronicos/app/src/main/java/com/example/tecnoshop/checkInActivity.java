package com.example.tecnoshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class checkInActivity extends AppCompatActivity {
    EditText Txt_Mail, Txt_Password;


    private Button createAccountButton;
    private EditText InputMaill, InputPassword;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.Mail, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);
        awesomeValidation.addValidation(this,R.id.PasswordSesion, ".{6,}",R.string.invalid_password);

        Txt_Mail = findViewById(R.id.Mail);
        Txt_Password = findViewById(R.id.PasswordSesion);
    }

    public void createAccount(View view){
        //Toast.makeText(this,"El campo [votos] no debe estar vacio", Toast.LENGTH_LONG).show();
        String mail = Txt_Mail.getText().toString();
        String password = Txt_Password.getText().toString();

        if(awesomeValidation.validate()){
            firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(checkInActivity.this,"usuario creado con exito", Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(checkInActivity.this,"hubo un error al crear el usuario", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }else{
            Toast.makeText(this,"Completa todos los datos", Toast.LENGTH_LONG).show();
        }

    }
}