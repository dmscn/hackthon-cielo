package br.com.damasceno.hackthon_cielo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.View.GONE;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        final TextView CPF = (TextView) findViewById(R.id.txtCPF);
        final TextView email = (TextView) findViewById(R.id.txtEmail);
        final TextView nome = (TextView) findViewById(R.id.txtNome);
        final TextView checks = (TextView) findViewById(R.id.txtChecks);
        final TextView pontos = (TextView) findViewById(R.id.txtPontos);

        final LinearLayout layInput = (LinearLayout) findViewById(R.id.layInput);
        final LinearLayout layInputBtn = (LinearLayout) findViewById(R.id.layInputBtn);
        final LinearLayout layOutput = (LinearLayout) findViewById(R.id.layOutput);
        final LinearLayout layOutputBtn = (LinearLayout) findViewById(R.id.layOutputBtn);


        Button consulta = (Button) findViewById(R.id.btnConsulta);

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO buscar cada dado no banco

                layInput.setVisibility(View.GONE);
                layInputBtn.setVisibility(View.GONE);
                layOutput.setVisibility(View.VISIBLE);
                layOutputBtn.setVisibility(View.VISIBLE);
            }
        });

        Button voltar = (Button) findViewById(R.id.btnVoltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layInput.setVisibility(View.VISIBLE);
                layInputBtn.setVisibility(View.VISIBLE);
                layOutput.setVisibility(View.GONE);
                layOutputBtn.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(ConsultaActivity.this, CartaoActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
