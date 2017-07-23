package br.com.damasceno.hackthon_cielo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddCheck = (Button) findViewById(R.id.btnAddCheck);
        Button btnAddPonto = (Button) findViewById(R.id.btnAddPonto);

        btnAddCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCheck.class);
                startActivity(intent);
            }
        });

        btnAddPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PontosActivity.class);
                startActivity(intent);
            }
        });
    }
}
