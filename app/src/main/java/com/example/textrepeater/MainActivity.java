package com.example.textrepeater;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText fastNameId, lastNameId, emailId, numberId, nidNumberId, passportNumberId, studentNumberId;
    Button singUpId, showAll;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fastNameId = findViewById(R.id.fastNameId);
        lastNameId = findViewById(R.id.lastNameId);
        emailId = findViewById(R.id.emailId);
        numberId = findViewById(R.id.numberId);
        nidNumberId = findViewById(R.id.nidNumberId);
        passportNumberId = findViewById(R.id.passportNumberId);
        studentNumberId = findViewById(R.id.studentNumberId);
        singUpId = findViewById(R.id.singUpId);
        showAll = findViewById(R.id.showAll);
        tvDisplay = findViewById(R.id.tvDisplay);

        singUpId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameFast = fastNameId.getText().toString();
                String nameLast = lastNameId.getText().toString();
                String nameEmail = emailId.getText().toString();
                String nameNumber = numberId.getText().toString();
                String nameNid = nidNumberId.getText().toString();
                String namePassport = passportNumberId.getText().toString();
                String nameStudentId = studentNumberId.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FName", nameFast);
                editor.putString("LName", nameLast);
                editor.putString("EEmail", nameEmail);
                editor.putString("NNumber", nameNumber);
                editor.putString("NNid", nameNid);
                editor.putString("PPassport", namePassport);
                editor.putString("SStudent", nameStudentId);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Data Save Succesfully", Toast.LENGTH_LONG).show();
                

            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                if (sharedPreferences.contains("FName") && sharedPreferences.contains("LName")
                && sharedPreferences.contains("EEmail") && sharedPreferences.contains("NNumber")
                && sharedPreferences.contains("NNid") && sharedPreferences.contains("PPassport")
                && sharedPreferences.contains("SStudent")){
                    String nameFast = sharedPreferences.getString("FName","Data Not Found");
                    String nameLast = sharedPreferences.getString("LName","Data Not Found");
                    String nameEmail = sharedPreferences.getString("EEmail","Data Not Found");
                    String nameNumber = sharedPreferences.getString("NNumber","Data Not Found");
                    String nameNid = sharedPreferences.getString("NNid","Data Not Found");
                    String namePassport = sharedPreferences.getString("PPassport","Data Not Found");
                    String nameStudentId = sharedPreferences.getString("SStudent","Data Not Found");
                    tvDisplay.setText(nameFast + " " + nameLast + "\n" + nameEmail + "\n" +
                            nameNumber + "\n" + nameNid + "\n" + namePassport + "\n" + nameStudentId );
                }
            }
        });


    }
}