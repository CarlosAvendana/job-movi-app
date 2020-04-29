package com.example.form.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.form.R;
import com.example.form.logic.Data;

public class ForgotPassword extends AppCompatActivity {

    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        final EditText UserName = (EditText) findViewById(R.id.userName);
        final EditText Password = (EditText) findViewById(R.id.password);
        final EditText Confirm = (EditText) findViewById(R.id.confirmpass);

        Button confirmButton = (Button) findViewById(R.id.ConfirmBtn);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userExist(UserName.getText().toString())){
                    if(Password.getText().toString().equals(Confirm.getText().toString())){
                        Data.getInstance().usuarios.get(position).setPassword(Password.getText().toString());
                        Toast.makeText(getApplicationContext(), "PASSWORD CHANGED", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ForgotPassword.this, MainActivity.class);
                        ForgotPassword.this.startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "PASSWORDS NO COINCIDEN", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "ERROR, USUARIO NO EXISTE", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean userExist(String x){
        for(int i = 0; i< Data.getInstance().usuarios.size(); i++)
            if(x.equals(Data.getInstance().usuarios.get(i).getId())) {
                position=i;
                return true;
            }
        return false;
    }
}
