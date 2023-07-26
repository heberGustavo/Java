package br.deivid.fuelcalculator.fuelcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    private TextView ethanolPriceTextView;
    private TextView gasPriceTextView;
    private TextView ethanolMilageTextView;
    private TextView gasMilageTextView;
    private TextView rateTextView;
    private TextView ethanolSpentTextView;
    private TextView gasSpentTextView;
    private TextView bestFuelTextView;
    private TextView fuelSalvingTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ethanolPriceTextView = findViewById(R.id.ethanol_price_result);
        gasPriceTextView = findViewById(R.id.gas_price_result);
        ethanolMilageTextView = findViewById(R.id.ethanol_milage_result);
        gasMilageTextView = findViewById(R.id.gas_milage_result);
        rateTextView = findViewById(R.id.rate);
        ethanolSpentTextView = findViewById(R.id.ethanol_spent);
        gasSpentTextView = findViewById(R.id.gas_spent);
        bestFuelTextView = findViewById(R.id.best_fuel);
        fuelSalvingTextView = findViewById(R.id.fuel_saving);
        backButton = findViewById(R.id.back_button);

        Intent intent = getIntent();
        double ethanolPrice = intent.getDoubleExtra("ETHANOL_PRICE",0);
        double gasPrice = intent.getDoubleExtra("GAS_PRICE",0);
        double ethanolMilage = intent.getDoubleExtra("ETHANOL_MILAGE",0);
        double gasMilage = intent.getDoubleExtra("GAS_MILAGE",0);
        double rateFuel = ethanolPrice / gasPrice *100;
        double ethanolSpent = ethanolPrice / ethanolMilage;
        double gasSpent = gasPrice / gasMilage;
        double fuelSalving = Math.abs(ethanolSpent-gasSpent);

        if (ethanolSpent < gasSpent){
            bestFuelTextView.setText("Abastaça com etanol");
        }
        else {
            bestFuelTextView.setText("Abasteça com gasolina");

            Locale locale = new Locale("pt","BR");
            NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

            ethanolPriceTextView.setText(nf.format(ethanolPrice));
            gasPriceTextView.setText(nf.format(gasPrice));
            ethanolMilageTextView.setText(String.valueOf(ethanolMilage));
            gasMilageTextView.setText(String.valueOf(gasMilage));
            ethanolSpentTextView.setText(nf.format(ethanolSpent));
            gasSpentTextView.setText(nf.format(gasSpent));
            rateTextView.setText(String.format("%.2f %%",rateFuel));
            fuelSalvingTextView.setText("Economia de "+ nf.format(fuelSalving));

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ResultActivity.super.onBackPressed();
                }
            });

        }

    }
}
