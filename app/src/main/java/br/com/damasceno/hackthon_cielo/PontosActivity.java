package br.com.damasceno.hackthon_cielo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PontosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos);

        final EditText cpf = (EditText) findViewById(R.id.edtPontosCPF);
        final EditText pontos = (EditText) findViewById(R.id.edtPontosPontos);
        Button btnPontua = (Button) findViewById(R.id.btnPontua);

        btnPontua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBController db = new DBController(PontosActivity.this);

                if(db.cpfCadastrado(cpf.getText().toString())) {
                    db.addPontos(cpf.getText().toString(), Integer.parseInt(pontos.getText().toString()));
                    Toast.makeText(PontosActivity.this, "Checked", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Intent intent = new Intent(PontosActivity.this, CadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
