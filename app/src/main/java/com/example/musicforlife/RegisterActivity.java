package com.example.musicforlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.musicforlife.users.User;
import com.example.musicforlife.users.UsersCollection;

public class RegisterActivity extends AppCompatActivity {

    EditText surname;
    EditText forename;
    EditText email;
    EditText password;
    Button registerButton;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title

        getSupportActionBar().hide(); // hide the title bar

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_register);

        surname = findViewById(R.id.surNameEditText);
        forename = findViewById(R.id.foreNameEditText);
        email = findViewById(R.id.emailLogEditText);
        password = findViewById(R.id.passwordLogEditText);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);

    }

    public void registerButtonClicked(View view){

        if(surname.getText().toString().isEmpty() || forename.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(this, "Empty fields !", Toast.LENGTH_LONG);
            toast.show();
        }else{
            UsersCollection.addUsers(email.getText().toString(), new User(surname.getText().toString(), forename.getText().toString(), email.getText().toString(), password.getText().toString()));
            Toast toast = Toast.makeText(this, "Registered Successfully ", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void loginButtonClicked(View view){
        this.startActivity(new Intent(this, LogInActivity.class));
        finish();
    }
}
