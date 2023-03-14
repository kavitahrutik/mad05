package com.example.lab_05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login;
    String usertext,passtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usertext = username.getText().toString();
                passtext = password.getText().toString();
                login lgn = new login();
                lgn.setUsername(usertext);
                lgn.setPassword(passtext);
                MyDbHandler db = new MyDbHandler(MainActivity.this);
                boolean result = db.addUser(lgn);
                if(result) {
                    Toast.makeText(getApplicationContext(),"Data inserted", Toast.LENGTH_LONG).show();
                    db.display();}
                else {
                    Toast.makeText(getApplicationContext(),"Failed to insert", Toast.LENGTH_LONG).show();}
            }
        });

    }
}