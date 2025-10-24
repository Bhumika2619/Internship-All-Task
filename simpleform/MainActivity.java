package com.example.simpleform;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editEmail, editCity, editContact;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editCity = findViewById(R.id.editCity);
        editContact = findViewById(R.id.editContact);
        btnSubmit = findViewById(R.id.btnsubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String city = editCity.getText().toString().trim();
                String contact = editContact.getText().toString().trim();

                if(name.isEmpty() || email.isEmpty() ||city.isEmpty() || contact.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Form Submitted Successfully\nName: " + name + "\nEmail: " + email + "\nCity:" + city+ "\nContact:" + contact,  Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
