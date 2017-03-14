package com.example.sony.MyMarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sony.MyMarket.AsyncTasks.AsyncResponse;
import com.example.sony.MyMarket.AsyncTasks.WebserviceCall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

                String stremail = edtuser.getText().toString();
                String strpwd = edtpass.getText().toString();




                if(edtuser.getText().toString().trim().equalsIgnoreCase("")){
                    edtuser.setError("Enter Email or UserName");
                }
                else if(edtpass.getText().toString().trim().equalsIgnoreCase("")){
                    edtpass.setError("Enter password");
                }
                else{
                           //Toast.makeText(LoginActivity.this, "Unauthorized user", Toast.LENGTH_SHORT).show();

                        JSONObject object = new JSONObject();
                        try {
//                        object.put("mode","loginUser");
                            object.put("email", stremail);
                            object.put("password", strpwd);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        String jsonRequest = String.valueOf(object);
//                    String URL = "http://development.ifuturz.com/core/FLAT_TEST/stone_galary/admin/webservice.php";
                        String URL = "http://www.vnurture.in/pro/login.php";
                        new WebserviceCall(Login.this, URL, jsonRequest, "Loading...", true, new AsyncResponse() {
                            @Override
                            public void onSuccess(final String message, JSONArray jsonData) {
                                Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                                try {
                                    getSharedPreferences("testpref",MODE_PRIVATE).edit().putString("id",jsonData.getJSONObject(0).getString("id")).apply();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Intent i= new Intent(Login.this,NavigationDraw.class);
                                startActivity(i);



                            }

                            @Override
                            public void onFailure(String message) {
                                Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
                            }
                        }).execute();

                    }
            }
        });
    }
}
