package com.example.form.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.form.R;
import com.example.form.logic.Data;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate a button
        ImageButton loginButton = (ImageButton) findViewById(R.id.btn_submit);
        final EditText UserName = (EditText) findViewById(R.id.et_username);
        final EditText Password = (EditText) findViewById(R.id.et_password);
        final TextView createUser = (TextView) findViewById(R.id.createBtn);
        final TextView forgotPassword = (TextView) findViewById(R.id.forgotPass);
        // perform click event on the button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarUser(UserName.getText().toString(), Password.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "INICIO VALIDADO", Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(MainActivity.this, Formulario.class);
                    //MainActivity.this.startActivity(intent);
                    sendToNavigationDrawer();
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "DATOS INCORRECTOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "CREATE USER", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, CreateUser.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Forgot Password", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ForgotPassword.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

    }

    private boolean validarUser(String x, String y) {
        for (int i = 0; i < Data.getInstance().usuarios.size(); i++)
            if (x.equals(Data.getInstance().usuarios.get(i).getId()) && y.equals(Data.getInstance().usuarios.get(i).getPassword()))
                return true;
        return false;
    }

    private void sendToNavigationDrawer() {
        Intent i = new Intent(MainActivity.this, NavDrawerActivy.class);
        startActivity(i);
    }

}
