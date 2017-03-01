package com.example.sony.loginscreensimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private EditText nameET,emailET,lastnameET,passwordET,cpET,cnoET;
    RadioButton maleRB,femaleRB;
    Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

       nameET=(EditText)findViewById(R.id.edittext_name_edittext);
       emailET=(EditText)findViewById(R.id.edittext_email_edittext);
       lastnameET=(EditText)findViewById(R.id.edittext_lastname_edittext);
       passwordET=(EditText)findViewById(R.id.edittext_password_edittext);
       cpET=(EditText)findViewById(R.id.edittext_cp_edittext);
       maleRB=(RadioButton)findViewById(R.id.radiobutton_male_radiobutton) ;
       femaleRB=(RadioButton)findViewById(R.id.radiobutton_female_radiobutton) ;
       cnoET=(EditText)findViewById(R.id.edittext_cn_edittext);

        btnsignup=(Button) findViewById(R.id.signup_btn_signup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkValidation();


            }
        });
    }

    private void checkValidation() {

        String strname=nameET.getText().toString();
        String strlastname=lastnameET.getText().toString();
        String stremail=emailET.getText().toString();
        String strpassword=passwordET.getText().toString();
        String strcp=cpET.getText().toString();
        {
            if(maleRB.isChecked())
            {
                maleRB.getText().toString();
            }
            else
            {
                femaleRB.getText().toString();
            }

        }
        // String strmale=maleRB.getText().toString();
        //String strfemale=femaleRB.getText().toString();
        String strcno=cnoET.getText().toString();
        if(strname.isEmpty())
        {
            nameET.setError("Name cannot be empty");
            //Toast.makeText(SignUp.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();

        }
        if (strlastname.isEmpty())
        {
            lastnameET.setError("lastname cannot be empty");
            //  Toast.makeText(SignUp.this, "lastname cannot be empty", Toast.LENGTH_SHORT).show();

        }
        if (stremail.isEmpty())
        {
            emailET.setError("Enter Email");
            //Toast.makeText(SignUp.this, "Enter email", Toast.LENGTH_SHORT).show();
        }

        if (!isValidEmail(stremail)){
            emailET.setError("Enter valid Email");
            //Toast.makeText(SignUp.this, "Enter valid email", Toast.LENGTH_SHORT).show();
        }
        if (strpassword.isEmpty())
        {
            passwordET.setError("Password cannot be empty");
            // Toast.makeText(SignUp.this, "please enter password", Toast.LENGTH_SHORT).show();
        }
        if (strcp.isEmpty())
        {
            cpET.setError("Enter Conform Password");
            // Toast.makeText(SignUp.this, "please enter confirm password", Toast.LENGTH_SHORT).show();
        }
        if (strcno.isEmpty())
        {
            cnoET.setError("Enter Contact Number");
            //Toast.makeText(SignUp.this, "please enter contact number", Toast.LENGTH_SHORT).show();
        }
//                else if (strgender.isEmpty())
//                {
//                    Toast.makeText(SignUp.this, "enter your gender", Toast.LENGTH_SHORT).show();
//                }
        if (!strcp.equals(strpassword))
        {
            Toast.makeText(SignUp.this, "passwords & confirm password don't match", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(SignUp.this, "Congratulations!Signed up successfully", Toast.LENGTH_SHORT).show();
        }

    }


    public static boolean isValidEmail(CharSequence target) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(target);
        return matcher.matches();
    }



}
