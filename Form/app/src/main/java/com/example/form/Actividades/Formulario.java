package com.example.form;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.form.Actividades.ListaFormulariosActivity;
import com.example.form.logic.Form;

import java.util.ArrayList;
import java.util.Calendar;

public class Formulario extends AppCompatActivity {


    ArrayList<EditText> fields = new ArrayList<>();

    private EditText name;
    private EditText lastname;
    private EditText street1;
    private EditText street2;
    private EditText city;
    private EditText state;
    private EditText postalCode;
    private Spinner country;
    private EditText email;
    private EditText phoneNumber;
    private EditText areaCode;
    private Spinner position;
    private TextView filepath;
    private EditText fechaFld;

    private boolean editable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);


        final DatePickerDialog[] datePickerDialog = new DatePickerDialog[1];
        final ImageButton dateBtn = (ImageButton) findViewById(R.id.calendarBtn);
        final ImageButton uploadFile = (ImageButton) findViewById(R.id.uploadFileBtn);
        final ImageButton confirmButton = (ImageButton) findViewById(R.id.ConfirmBtn);

        name = (EditText) findViewById(R.id.namefld);
        lastname = (EditText) findViewById(R.id.lastfield);
        street1 = (EditText) findViewById(R.id.streetFld);
        street2 = (EditText) findViewById(R.id.streetFld2);
        city = (EditText) findViewById(R.id.cityFld);
        state = (EditText) findViewById(R.id.statefld);
        postalCode = (EditText) findViewById(R.id.postalCode);
        country = (Spinner) findViewById(R.id.SpinnerCountry);
        email = (EditText) findViewById(R.id.emailfld);
        phoneNumber = (EditText) findViewById(R.id.phoneFld);
        position = (Spinner) findViewById(R.id.positions);
        fechaFld = (EditText) findViewById(R.id.Fecha);
        areaCode = (EditText) findViewById(R.id.areafld);

        filepath = (TextView) findViewById(R.id.path);

        fields.add(name);
        fields.add(lastname);
        fields.add(city);
        fields.add(state);
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
                            public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
                                fechaFld.setText(dayOfMonth + "/"+ (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog[0].show();
            }
        });

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent file = new Intent(Intent.ACTION_GET_CONTENT);
                file.setType("*/*");
                startActivityForResult(file, 10);
            }
        });
/*
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(formValidation()){
                    Toast.makeText(getApplicationContext(), "DATOS CORRECTOS", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "DATOS INCORRECTOS", Toast.LENGTH_LONG).show();
                }
            }
        });
*/
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            editable = extras.getBoolean("editable");
            if (editable) {
                Form aux = (Form) getIntent().getSerializableExtra("Form");
                name.setText(aux.get_first_name());
                lastname.setText(aux.get_last_name());
                street1.setText(aux.get_street_address());
                street2.setText(aux.get_street_address2());
                city.setText(aux.get_city());
                state.setText(aux.get_state_province());
                postalCode.setText(aux.get_postal_code());
                country.setSelection(1); //preguntar a Felipe donde esta el array de paises
                email.setText(aux.get_email_address());
                phoneNumber.setText(aux.get_phone_number());
                areaCode.setText(aux.get_area());
                position.setSelection(1);//preguntar a Felipe donde esta el array de posiciones
                filepath.setText("");
                fechaFld.setText(aux.get_startDate());
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editCarrera();
                    }
                });
            }//final if editable
            else {
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addCarrera();
                    }
                });
            }
        }//final if extras

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    String name = path.substring(path.lastIndexOf("/") + 1);
                    filepath.setText(path);
                }
                break;
        }
    }

    public boolean formValidation(){
        boolean valid=true;
        for (int i = 0; i < fields.size(); i++) {
            if(fields.get(i).getText().toString().isEmpty()){
                valid=false;
                fields.get(i).setHintTextColor(Color.RED);
                fields.get(i).setTextColor(Color.RED);
            } else {
                fields.get(i).setHintTextColor(Color.GREEN);
                fields.get(i).setTextColor(Color.GREEN);
            }
        }
        return valid;
    }

    public void addCarrera() {
        if (formValidation()) {
            Form f = new Form(name.getText().toString(),
                    lastname.getText().toString(),
                    street1.getText().toString(),
                    street2.getText().toString(),
                    city.getText().toString(),
                    state.getText().toString(),
                    postalCode.getText().toString(),
                    country.getSelectedItem().toString(),
                    email.getText().toString(),
                    phoneNumber.getText().toString(),
                    position.getSelectedItem().toString(),
                    fechaFld.getText().toString(),
                    areaCode.getText().toString());
            Intent intent = new Intent(getBaseContext(), ListaFormulariosActivity.class);
            intent.putExtra("addForm", f);
            startActivity(intent);
            finish();
        }

    }

    public void editCarrera() {
        if (formValidation()) {
            Form f = new Form(name.getText().toString(),
                    lastname.getText().toString(),
                    street1.getText().toString(),
                    street2.getText().toString(),
                    city.getText().toString(),
                    state.getText().toString(),
                    postalCode.getText().toString(),
                    country.getSelectedItem().toString(),
                    email.getText().toString(),
                    phoneNumber.getText().toString(),
                    position.getSelectedItem().toString(),
                    fechaFld.getText().toString(),
                    areaCode.getText().toString());
            Intent intent = new Intent(getBaseContext(), ListaFormulariosActivity.class);
            intent.putExtra("edithForm", f);
            startActivity(intent);
            finish();
        }

    }

}//Cierre de la clase formulario
