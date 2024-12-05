package com.example.gmailapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText massageEmail;
    Button sendEmailBtn, sendIntentBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        massageEmail = findViewById(R.id.edit_text);
        sendEmailBtn = findViewById(R.id.send_email);
        sendIntentBtn = findViewById(R.id.send_second_activity);

        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String massage = massageEmail.getText().toString();

                sendEmail(massage);
            }
        });

        sendIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                String massage = massageEmail.getText().toString();
                secondActivityIntent.putExtra(Intent.EXTRA_TEXT, massage);
                startActivity(secondActivityIntent);
            }
        });


    }

    private void sendEmail(String massage) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_TEXT, massage);

        startActivity(emailIntent);
    }


}