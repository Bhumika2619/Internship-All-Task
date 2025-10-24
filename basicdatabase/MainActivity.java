package com.example.basicdatabaseusage;
import androidx.appcompat.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editEmail, editCity, editContact;
    Button btnSubmit, btnView;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editCity = findViewById(R.id.editCity);
        editContact = findViewById(R.id.editContact);
        btnSubmit = findViewById(R.id.btnsubmit);
        btnView = findViewById(R.id.btnview);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inserted = db.insertData(
                        editName.getText().toString(),
                        editEmail.getText().toString(),
                        editCity.getText().toString(),
                        editContact.getText().toString()
                );

                if (inserted)
                    Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Insert Failed", Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllData();
                if (res.getCount() == 0) {
                    showMessage("No Data","No Records Found.");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("ID: ").append(res.getString(0)).append("\n");
                    buffer.append("Name: ").append(res.getString(1)).append("\n");
                    buffer.append("Email: ").append(res.getString(2)).append("\n");
                    buffer.append("City: ").append(res.getString(3)).append("\n");
                    buffer.append("Contact: ").append(res.getString(4)).append("\n\n");
                }

                showMessage("User Data", buffer.toString());
            }
        });
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
