package com.ksinha.favouritewebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edUrl;
    private Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUrl = findViewById(R.id.ed_url);
        btnOpen = findViewById(R.id.btn_open);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = String.valueOf(edUrl.getText());
                url.trim();
                if(url.equals("") || url == null){
                    Toast.makeText(getApplicationContext(), "Please provide URL !!!", Toast.LENGTH_SHORT).show();
                } else if(!url.startsWith("http")){
                    Toast.makeText(getApplicationContext(), "Please Enter correct URL !!!", Toast.LENGTH_SHORT).show();
                } else {
                    // Implicit Intent
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
                }
                /*
                Uri webpage = Uri.parse(url);

                // Implicit Intent
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } */
            }
        });
    }
}