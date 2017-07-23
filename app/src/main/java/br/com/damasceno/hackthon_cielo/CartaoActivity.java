package br.com.damasceno.hackthon_cielo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CartaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao);

        final EditText num = (EditText) findViewById(R.id.edtCartaoChecks);
        final EditText premio = (EditText) findViewById(R.id.edtCartaoPremio);
        Button btnAddCartao = (Button) findViewById(R.id.btnAddCartao);

        btnAddCartao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBController db = new DBController(CartaoActivity.this);
                db.criarCartao(Integer.parseInt(num.getText().toString()), premio.getText().toString());
                finish();
            }
        });

    }
}
