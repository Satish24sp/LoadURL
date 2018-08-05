package com.example.hp.loadurl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String strURL = "http://www.google.com";
                if(strURL.matches(""))
                {
                    Toast.makeText(MainActivity.this, "Please Provide URL", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, WebActivity.class);
                    intent.putExtra("website", strURL);
                    startActivity(intent);
                }

            }
        });

    }
}