package com.example.musicforlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.musicforlife.users.UsersCollection;

public class LogInActivity extends AppCompatActivity {

    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title

               getSupportActionBar().hide(); // hide the title bar

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.emailLogEditText);
        password = findViewById(R.id.passwordLogEditText);
    }

    public void registerButtonClicked(View view){
        this.startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    public void loginButtonClicked(View view){
        boolean found = false;

        if(!UsersCollection.getUsers().isEmpty()){
            for(String key : UsersCollection.getUsers().keySet()){
                if(UsersCollection.getUsers().get(key).getEmail().equals(email.getText().toString())
                        && UsersCollection.getUsers().get(key).getPassword().equals(password.getText().toString())){

                    UsersCollection.setCurrentUser(UsersCollection.getUsers().get(key));
                    found = true;
                    break;
                }
            }
        }

        if(found){
            Toast toast = Toast.makeText(this,"Logged In", Toast.LENGTH_SHORT);
            toast.show();

            this.startActivity(new Intent(this, MainActivity.class));
            finish();

        }else {
            Toast toast = Toast.makeText(this,"User Not Found", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
