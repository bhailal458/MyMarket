package com.example.sony.loginscreensimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText edtuser,edtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();

        edtuser = (EditText)findViewById(R.id.edtuname);
        edtpass = (EditText)findViewById(R.id.edtPass);
        TextView signup = (TextView)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Login.this,SignUp.class);
                startActivity(i);
            }
        });

        Button btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtuser.getText().toString().trim().equalsIgnoreCase("")){
                    edtuser.setError("Enter Email or UserName");
                }
                else if(edtpass.getText().toString().trim().equalsIgnoreCase("")){
                    edtpass.setError("Enter password");
                }
                else{
                    Intent i= new Intent(Login.this,NavigationDraw.class);
                    startActivity(i);

                }

            }
        });
    }
}
