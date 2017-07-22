package br.com.damasceno.hackthon_cielo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_check);

        final EditText email = (EditText) findViewById(R.id.edtEmail);
        Button btnCheck = (Button) findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBController db = new DBController(AddCheck.this);

                if(db.emailCadastrado(email.toString())) {
                    db.addCheck(email.toString());
                } else {
                    Intent intent = new Intent(AddCheck.this, CadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
