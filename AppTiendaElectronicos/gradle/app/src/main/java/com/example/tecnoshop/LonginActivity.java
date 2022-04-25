package com.example.tecnoshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LonginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    EditText Txt_MailSesion, Txt_PasswordSesion;
    private GoogleApiClient googleApiClient;
    public static final int SIGN_IN_CODE = 777;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;



    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longin);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

//        if(user != null){
//            goToHome();
//        }

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.Mail, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);
        awesomeValidation.addValidation(this,R.id.PasswordSesion, ".{6,}",R.string.invalid_password);

        Txt_MailSesion = findViewById(R.id.Mail);
        Txt_PasswordSesion = findViewById(R.id.PasswordSesion);
    }

    public void login(View view){
        //Toast.makeText(this,"El campo [votos] no debe estar vacio", Toast.LENGTH_LONG).show();
        if(awesomeValidation.validate()){
            String mail = Txt_MailSesion.getText().toString();
            String password = Txt_PasswordSesion.getText().toString();

            firebaseAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        goToHome();
                    }else{
                        Toast.makeText(LonginActivity.this,"hubo un error al iniciar sesion, usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }else{
            Toast.makeText(LonginActivity.this,"hubo un error al iniciar sesion, usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
        }
    }

    private void goToHome() {

        Intent i = new Intent(this, AdminActivity.class);
        i.putExtra("Mail", Txt_MailSesion.getText().toString());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

    }

    public void forgotPassword(View view){
        Intent i = new Intent(this, ForgotPaswordActivity.class);
        startActivity(i);
    }

    public  void signGoogle(View view){
        //Toast.makeText(this, "hola buenas", Toast.LENGTH_SHORT).show();
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, SIGN_IN_CODE);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_CODE){
           GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
           handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if(!result.isSuccess()){
            goToHome();
        }else{
            Toast.makeText(this, "ocurrio un error al intentar iniciar sesion con google", Toast.LENGTH_SHORT).show();
        }
    }
}