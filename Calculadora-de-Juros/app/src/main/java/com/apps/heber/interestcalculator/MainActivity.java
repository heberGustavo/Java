package com.apps.heber.interestcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    EditText valorET;
    EditText pagamentoET;
    EditText vencimentoET;

    EditText multaET;
    RadioGroup multaRadioGroup;
    RadioButton dinheiro_multaRB;
    RadioButton porcentagem_multaRB;

    EditText jurosET;
    RadioGroup jurosRadioGroup;
    RadioButton dinheiro_jurosRB;
    RadioButton porcetagem_jurosRB;

    Button limpar;
    Button calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorET = (EditText) findViewById(R.id.valor_main);
        vencimentoET = (EditText) findViewById(R.id.vencimento_main);
        pagamentoET = (EditText) findViewById(R.id.pagamento_main);


        multaET = (EditText) findViewById(R.id.multa_textView_main);
        multaRadioGroup = (RadioGroup) findViewById(R.id.grupo_multa);
        dinheiro_multaRB = (RadioButton) findViewById(R.id.dinheiro_multa_main);
        porcentagem_multaRB = (RadioButton) findViewById(R.id.porcentagem_multa_main);

        jurosET = (EditText) findViewById(R.id.juros_textView_main);
        jurosRadioGroup = (RadioGroup) findViewById(R.id.grupo_juros);
        dinheiro_jurosRB = (RadioButton) findViewById(R.id.dinheiro_juros_main);
        porcetagem_jurosRB = (RadioButton) findViewById(R.id.porcentagem_juros_main);

        limpar = findViewById(R.id.limpar_button_main);
        calcular = findViewById(R.id.calcular_button_main);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialogHelper.setDatePickerDialog(vencimentoET, this, simpleDateFormat);
        DatePickerDialogHelper.setDatePickerDialog(pagamentoET, this, simpleDateFormat);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaCampos()){
                    mudaActivity();
                }
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparDados();
            }
        });

    }

    private boolean verificaCampos(){
        boolean verificador = true;

        if (valorET.getText().toString().length()==0){
            valorET.setError("Digite o valor");
            verificador = false;
        }

        if(vencimentoET.getText().toString().length()==0){
            vencimentoET.setError("Informe a data");
            verificador = false;
        }

        if (pagamentoET.getText().toString().length()==0){
            pagamentoET.setError("Informe a data");
            verificador = false;
        }


        if (multaET.getText().toString().length()==0){
            multaET.setError("Digite o valor");
            verificador = false;
        }

        if (jurosET.getText().toString().length()==0){
            jurosET.setError("Digite o valor");
            verificador = false;
        }

        return verificador;
    }

    private void mudaActivity(){
        Intent resultadoIntent = new Intent(MainActivity.this, ResultadoActivity.class);

        double valor = Double.parseDouble(valorET.getText().toString());
        String vencimento = String.valueOf(vencimentoET.getText());
        String pagamento = String.valueOf(pagamentoET.getText());

        double multa = Double.parseDouble(multaET.getText().toString());
        // Pegando o ID selecionado do RadioButton Multa
        int idMulta = multaRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButtonMulta = (RadioButton) findViewById(idMulta);
        String messageMulta = radioButtonMulta.getText().toString();

        double juros = Double.parseDouble(jurosET.getText().toString());
        // Pegando o ID selecionado do RadioButton JUROS
        int idJuros = jurosRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButtonJuros = (RadioButton) findViewById(idJuros);
        String messageJuros = radioButtonJuros.getText().toString();

        resultadoIntent.putExtra("VALOR", valor);
        resultadoIntent.putExtra("VENCIMENTO", vencimento);
        resultadoIntent.putExtra("PAGAMENTO", pagamento);

        resultadoIntent.putExtra("MULTA", multa);
        resultadoIntent.putExtra("ID_MULTA", messageMulta);
        resultadoIntent.putExtra("JUROS",  juros);
        resultadoIntent.putExtra("ID_JUROS", messageJuros);

        startActivity(resultadoIntent);
    }

    private void limparDados(){
        valorET.setText("");
        vencimentoET.setText("");
        pagamentoET.setText("");
        multaET.setText("");
        dinheiro_multaRB.setChecked(false);
        porcentagem_multaRB.setChecked(false);
        jurosET.setText("");
        dinheiro_jurosRB.setChecked(false);
        porcetagem_jurosRB.setChecked(false);
    }

}
