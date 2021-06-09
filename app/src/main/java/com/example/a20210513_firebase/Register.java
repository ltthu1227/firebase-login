package com.example.a20210513_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    EditText edtName, email, typePassword_1, typePassword_2;
    Button Register;
    TextView Tv_SigIn, textView2,textView6 ;
    ImageView imgGreen, img9;
    String NameHolder, EmailHolder, TypePasswordHolder1,TypePasswordHolder2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView2 = (TextView)findViewById(R.id.textView2);
        imgGreen= (ImageView)findViewById(R.id.imgGreen);
        edtName =(EditText)findViewById(R.id.edtName);
        email = (EditText)findViewById(R.id.edtEmail);
        typePassword_1 = (EditText)findViewById(R.id.edtTypePassword1);
        typePassword_2 = (EditText)findViewById(R.id.edtTypePassword2);
        img9 = (ImageView)findViewById(R.id.imageView9);
        textView6 =(TextView)findViewById(R.id.textView6);
        Tv_SigIn = (TextView)findViewById(R.id.textView7);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Smile.class);
                startActivity(intent);
            }
        });
    }
    public void CheckEditTextIsEmptyOrNot(){
        NameHolder = edtName.getText().toString().trim();
        EmailHolder = email.getText().toString().trim();
        TypePasswordHolder1  = typePassword_1.getText().toString().trim();
        TypePasswordHolder2  = typePassword_2.getText().toString().trim();
    }
}