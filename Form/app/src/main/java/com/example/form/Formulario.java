package com.example.form;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Formulario extends AppCompatActivity {

    TextView filepath;
    EditText fechaFld;
    ArrayList<EditText> fields = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        fechaFld = (EditText) findViewById(R.id.Fecha);
        final DatePickerDialog[] datePickerDialog = new DatePickerDialog[1];
        final ImageButton dateBtn = (ImageButton) findViewById(R.id.calendarBtn);
        final ImageButton uploadFile = (ImageButton) findViewById(R.id.uploadFileBtn);
        filepath = (TextView) findViewById(R.id.path);
        final ImageButton confirmButton=(ImageButton) findViewById(R.id.ConfirmBtn);


        EditText nombreField=(EditText) findViewById(R.id.namefld);
        EditText apeField=(EditText) findViewById(R.id.lastfield);
        EditText streetAdd=(EditText) findViewById(R.id.streetFld);
        EditText city=(EditText) findViewById(R.id.cityFld);
        EditText state=(EditText) findViewById(R.id.statefld);
        EditText postalCode=(EditText) findViewById(R.id.postalCode);
        EditText email=(EditText) findViewById(R.id.emailfld);
        EditText areaCode=(EditText) findViewById(R.id.areafld);
        EditText phoneNumber=(EditText) findViewById(R.id.phoneFld);

        fields.add(nombreField);
        fields.add(apeField);
        fields.add(streetAdd);
        fields.add(city);
        fields.add(state);
        fields.add(postalCode);
        fields.add(email);
        fields.add(areaCode);
        fields.add(phoneNumber);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog[0] = new DatePickerDialog(Formulario.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                fechaFld.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog[0].show();
            }
        });

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent file= new Intent(Intent.ACTION_GET_CONTENT);
                file.setType("*/*");
                startActivityForResult(file, 10);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(formValidation()){
                    Toast.makeText(getApplicationContext(), "DATOS CORRECTOS", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "DATOS INCORRECTOS", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    String name= path.substring(path.lastIndexOf("/")+1);
                    filepath.setText(path);
                }
                break;
        }
    }

    public boolean formValidation(){
        boolean valid=true;
        for(int i=0;i<fields.size();i++){
            if(fields.get(i).getText().toString().isEmpty()){
                valid=false;
                fields.get(i).setHintTextColor(Color.RED);
                fields.get(i).setTextColor(Color.RED);
            }
            else {
                fields.get(i).setHintTextColor(Color.GREEN);
                fields.get(i).setTextColor(Color.GREEN);
            }
        }
    return valid;
    }
}
