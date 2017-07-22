package br.com.damasceno.hackthon_cielo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PontosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos);

        final EditText email = (EditText) findViewById(R.id.edtEmail);
        final EditText pontos = (EditText) findViewById(R.id.edtPontos);
        Button btnPontua = (Button) findViewById(R.id.btnPontua);

        btnPontua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBController db = new DBController(PontosActivity.this);

                if(db.emailCadastrado(email.toString())) {
                    db.addPontos(email.toString(), Integer.parseInt(pontos.toString()));
                } else {
                    Intent intent = new Intent(PontosActivity.this, CadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
