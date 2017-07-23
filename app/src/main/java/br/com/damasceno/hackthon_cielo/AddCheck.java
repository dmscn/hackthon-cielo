package br.com.damasceno.hackthon_cielo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_check);

        final EditText cpf = (EditText) findViewById(R.id.edtCheckCPF);
        Button btnCheck = (Button) findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBController db = new DBController(AddCheck.this);

                if(db.cpfCadastrado(cpf.getText().toString()) == true) {
                    db.addCheck(cpf.getText().toString());
                } else {
                    Intent intent = new Intent(AddCheck.this, CadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
