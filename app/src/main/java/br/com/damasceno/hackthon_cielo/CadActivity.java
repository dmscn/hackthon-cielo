package br.com.damasceno.hackthon_cielo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad);

        final EditText email = (EditText) findViewById(R.id.edtEmail);
        final EditText cpf = (EditText) findViewById(R.id.edtCPF);
        final EditText nome = (EditText) findViewById(R.id.edtNome);
        Button btnCad = (Button) findViewById(R.id.btnCad);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBController db = new DBController(CadActivity.this);
                db.cadastra(email.toString(), cpf.toString(), nome.toString());
            }
        });
    }
}
