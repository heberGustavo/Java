package com.apps.heber.interestcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView valor_resultado;
    TextView vencimento_resultado;
    TextView pagamento_resultado;
    TextView juros_resultado;
    TextView multa_resultado;

    TextView diferenca;
    TextView valorTotal;

    Button voltarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        valor_resultado = findViewById(R.id.valor_resultado);
        vencimento_resultado = findViewById(R.id.vencimento_resultado);
        pagamento_resultado = findViewById(R.id.pagamento_resultado);
        juros_resultado = findViewById(R.id.juros_resultado);
        multa_resultado = findViewById(R.id.multa_resultado);
        valorTotal = findViewById(R.id.valorTotal_resultado);
        diferenca = findViewById(R.id.diferenca_resultado);
        voltarButton = findViewById(R.id.voltar_button_resultado);

        Intent intent = getIntent();
        double valor = intent.getDoubleExtra("VALOR",0);
        String vencimento = intent.getStringExtra("VENCIMENTO");
        String pagamento = intent.getStringExtra("PAGAMENTO");

        double multa = intent.getDoubleExtra("MULTA", 0);
        String messageMulta = intent.getStringExtra("ID_MULTA");
        double juros = intent.getDoubleExtra("JUROS", 0);
        String messageJuros = intent.getStringExtra("ID_JUROS");

        // Juros '%' e Multa '%'
        if (messageMulta.equals("%") && messageJuros.equals("%")){
            double valor_total = valor + ((juros/100)*valor) + ((multa/100)*valor);
            double dif = valor_total - valor;
            diferenca.setText(String.valueOf(dif));
            valorTotal.setText(String.valueOf(valor_total));
        }

        // Juros 'R$' e Multa '%'
        if (messageJuros.equals("R$") && messageMulta.equals("%")){
            double valor_total = valor + juros + ((multa/100)*valor);
            double dif = valor_total - valor;
            diferenca.setText(String.valueOf(dif));
            valorTotal.setText(String.valueOf(valor_total));
        }

        // Juros '%' e Multa 'R$'
        if (messageJuros.equals("%") && messageMulta.equals("R$")){
            double valor_total = valor +  ((juros/100)*valor) + multa;
            double dif = valor_total - valor;
            diferenca.setText(String.valueOf(dif));
            valorTotal.setText(String.valueOf(valor_total));
        }

        // Juros 'R$' e Multa 'R$'
        if (messageMulta.equals("R$") && messageJuros.equals("R$")){
            double valor_total = valor + juros + multa;
            double dif = valor_total - valor;
            diferenca.setText(String.valueOf(dif));
            valorTotal.setText(String.valueOf(valor_total));
        }


        // Mostra os resultados na tela
        valor_resultado.setText(String.valueOf(valor));
        vencimento_resultado.setText(vencimento);
        pagamento_resultado.setText(pagamento);
        juros_resultado.setText(String.valueOf(juros));
        multa_resultado.setText(String.valueOf(multa));

        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultadoActivity.super.onBackPressed();

            }
        });

    }
}
