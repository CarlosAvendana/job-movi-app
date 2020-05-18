package com.example.form.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.form.R;
import com.example.form.logic.Data;
import com.example.form.logic.Usuario;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        final EditText UserName = (EditText) findViewById(R.id.et_username);
        final EditText Password = (EditText) findViewById(R.id.et_password);
        final EditText Confirm = (EditText) findViewById(R.id.et_confirmpass);

        ImageButton confirmButton = (ImageButton) findViewById(R.id.ConfirmBtn);
        ImageButton cancelButton = (ImageButton) findViewById(R.id.CancelBtn);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userExist(UserName.getText().toString())) {
                    if (!Password.getText().toString().equals("")) {
                        if (Password.getText().toString().equals(Confirm.getText().toString())) {
                            Data.getInstance().usuarios.add(new Usuario(UserName.getText().toString(), Password.getText().toString()));
                            Toast.makeText(getApplicationContext(), "USUARIO CREADO", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(CreateUser.this, Login.class);
                            CreateUser.this.startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "PASSWORDS NO COINCIDEN", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "PASSWORDS VACIAS", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR, USUARIO EXISTENTE", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancelButton.setOnClickListener((v) -> {
            Intent intent = new Intent(CreateUser.this, Login.class);
            CreateUser.this.startActivity(intent);
            finish();
        });


    }

    private boolean userExist(String x) {
        for (int i = 0; i < Data.getInstance().usuarios.size(); i++)
            if (x.equals(Data.getInstance().usuarios.get(i).getId()))
                return true;
        return false;
    }
}
