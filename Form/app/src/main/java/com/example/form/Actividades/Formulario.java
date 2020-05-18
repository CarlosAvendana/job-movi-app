package com.example.form.Actividades;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.form.R;
import com.example.form.logic.Form;
import com.example.form.logic.ModelData;

import java.util.ArrayList;
import java.util.Calendar;

public class Formulario extends AppCompatActivity {

    String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
            "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
            "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
            "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
            "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
            "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
            "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
            "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
            "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
            "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
            "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
            "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
            "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
            "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
            "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
            "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
            "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
            "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
            "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands",
            "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
            "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
            "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
            "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon",
            "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
            "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga",
            "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
            "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
            "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
            "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};

    String positions[] = {"Developer", "Human Resources", "Technical Support", "Project Administrator", "Data Base Administrator", "Network Technician"};

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
        final ImageButton cancelButton = (ImageButton) findViewById(R.id.CancelBtn);

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

        ArrayAdapter<String> spinnerArrayAdapterCountry = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countries);
        spinnerArrayAdapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(spinnerArrayAdapterCountry);

        ArrayAdapter<String> spinnerArrayAdapterJobs = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, positions);
        spinnerArrayAdapterJobs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        position.setAdapter(spinnerArrayAdapterJobs);


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
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                fechaFld.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
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
                country.setSelection(1);
                email.setText(aux.get_email_address());
                phoneNumber.setText(aux.get_phone_number());
                areaCode.setText(aux.get_area());
                position.setSelection(1);
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
                        addFormulario();
                    }
                });
            }
        }//final if extras

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFormulario();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Formulario.this, NavDrawerActivy.class);
                Formulario.this.startActivity(intent);
                finish();
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
                    String name = path.substring(path.lastIndexOf("/") + 1);
                    filepath.setText(path);
                }
                break;
        }
    }

    public boolean formValidation() {
        boolean valid = true;
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getText().toString().isEmpty()) {
                valid = false;
                Toast.makeText(getApplicationContext(), "COMPLETE THIS SHIT ASSHOLE", Toast.LENGTH_LONG).show();
                fields.get(i).setHintTextColor(Color.RED);
                fields.get(i).setTextColor(Color.RED);
            } else {
                fields.get(i).setHintTextColor(Color.GREEN);
                fields.get(i).setTextColor(Color.GREEN);
            }
        }
        return valid;
    }

    public boolean validEmail() {
        String emailContent = email.getText().toString().trim();
        boolean valid = true;
        if (!Patterns.EMAIL_ADDRESS.matcher(emailContent).matches()) {
            valid = false;
            email.setHintTextColor(Color.RED);
            email.setTextColor(Color.RED);
            Toast.makeText(getApplicationContext(), "Incorrect email format dick", Toast.LENGTH_LONG).show();
        }
        return valid;
    }

    public void addFormulario() {
        if (formValidation()) {
            if (validEmail()) {
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
                ModelData.getInstance().getFormList().add(f);
                Toast.makeText(getApplicationContext(), "DATOS CORRECTOS", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(), NavDrawerActivy.class);
                intent.putExtra("addForm", f);
                startActivity(intent);
                finish();
            }
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
            Intent intent = new Intent(getBaseContext(), NavDrawerActivy.class);
            intent.putExtra("edithForm", f);
            startActivity(intent);
            finish();
        }

    }

}//Cierre de la clase formulario
