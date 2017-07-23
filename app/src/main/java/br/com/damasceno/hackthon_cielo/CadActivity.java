package br.com.damasceno.hackthon_cielo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad);

        final EditText email = (EditText) findViewById(R.id.edtCadEmail);
        final EditText cpf = (EditText) findViewById(R.id.edtCadCPF);
        final EditText nome = (EditText) findViewById(R.id.edtCadNome);
        Button btnCad = (Button) findViewById(R.id.btnCad);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBController db = new DBController(CadActivity.this);
                db.cadastra(cpf.getText().toString(), email.getText().toString(), nome.getText().toString());

                Toast.makeText(CadActivity.this, "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
