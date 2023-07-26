package br.deivid.fuelcalculator.fuelcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.deivid.fuelcalculator.fuelcalculator.R;
import br.deivid.fuelcalculator.fuelcalculator.ResultActivity;

public class MainActivity extends AppCompatActivity {

    private EditText ethanolPriceEditText;
    private EditText gasPriceEditText;
    private EditText ethanolMilageEditText;
    private EditText gasMilageEditText;
    private Button calculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ethanolPriceEditText = findViewById(R.id.ethanol_price_edit_text);
        gasPriceEditText = findViewById(R.id.gas_price_edit_text);
        ethanolMilageEditText = findViewById(R.id.ethanol_milage_edit_text);
        gasMilageEditText = findViewById(R.id.gas_milage_edit_text);

        calculatorButton = findViewById(R.id.calculator_button);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateFields()) {
                    changeToResultActivity();
                }
            }
        });

    }


    private void changeToResultActivity(){
        Intent intent = new Intent (this, ResultActivity.class);

        String ethanolPriceStr = ethanolPriceEditText.getText().toString();
        String gasPriceStr = gasPriceEditText.getText().toString();
        String ethanolMilageStr = ethanolMilageEditText.getText().toString();
        String gasMilageStr = gasMilageEditText.getText().toString();

        double ethanolPrice = Double.parseDouble(ethanolPriceStr);
        double gasPrice = Double.parseDouble(gasPriceStr);
        double ethanolMilage = Double.parseDouble(ethanolMilageStr);
        double gasMilage = Double.parseDouble(gasMilageStr);

        intent.putExtra("ETHANOL_PRICE", ethanolPrice);
        intent.putExtra("GAS_PRICE", gasPrice);
        intent.putExtra("ETHANOL_MILAGE", ethanolMilage);
        intent.putExtra("GAS_MILAGE", gasMilage);

        startActivity(intent);
    }

    private boolean validateFields (){
        boolean correctValidation = true;
        if (ethanolPriceEditText.getText().toString().length() == 0){
            //ethanolPriceEditText.setError ("Digite o valor do etanol");
            ethanolPriceEditText.setError(getString(R.string.erro_price_ethanol));
            correctValidation = false;
        }
        if (gasPriceEditText.getText().toString().length() == 0){
            gasPriceEditText.setError(getString(R.string.erro_price_gas));
            correctValidation = false;

            if (ethanolMilageEditText.getText().toString().length() == 0){
                ethanolMilageEditText.setError(getString(R.string.erro_milage_ethanol));
                correctValidation = false;
            }
            if (gasMilageEditText.getText().toString().length() == 0){
                gasMilageEditText.setError(getString(R.string.erro_milage_gas));
                correctValidation = false;
            }
        }

        return correctValidation;
    }

}