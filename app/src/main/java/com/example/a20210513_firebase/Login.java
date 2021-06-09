package com.example.a20210513_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    ImageView imgRed, imgGreen, imgYellow;
    EditText email, password;
    Button SignIn;
    TextView register;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyCheck;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imgGreen = (ImageView)findViewById(R.id.imageView1);
        imgRed = (ImageView)findViewById(R.id.imageView2);
        imgYellow = (ImageView)findViewById(R.id.imageView3);
        email = (EditText)findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.edtPasword);
        register = (TextView)findViewById(R.id.textView5);
        SignIn= (Button)findViewById(R.id.btnSignIn);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            Intent intent = new Intent(Login.this, Smile.class);
            startActivity(intent);
        }
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if(EditTextEmptyCheck)
                {
                    LoginFunction();
                }
                else {
                    Toast.makeText(Login.this, "Please ", Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

    }
    public void CheckEditTextIsEmptyOrNot(){
        EmailHolder = email.getText().toString().trim();
        PasswordHolder = password.getText().toString().trim();
        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {
            EditTextEmptyCheck = false;
        }
        else {
            EditTextEmptyCheck = true ;
        }
    }
    public void LoginFunction(){
        progressDialog.setMessage("Please Wait");

        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(EmailHolder, PasswordHolder)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Intent intent = new Intent(Login.this, Smile.class);
                            startActivity(intent);
                        }
                        else {
                            progressDialog.dismiss();
                            Toast.makeText(Login.this, "Please Try Again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}