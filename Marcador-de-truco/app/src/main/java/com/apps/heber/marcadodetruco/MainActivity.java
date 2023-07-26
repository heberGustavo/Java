package com.apps.heber.marcadodetruco;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTeamATextView;
    private TextView scoreTeamBTextView;
    private int scoreTeamA;
    private int scoreteamB;

    private Button Botao1TeamA,Botao3TeamA,Botao6TeamA,Botao9TeamA,Botao12TeamA;
    private Button Botao1TeamB,Botao3TeamB,Botao6TeamB,Botao9TeamB,Botao12TeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeamA = 0;
        scoreTeamATextView = findViewById(R.id.score_team_a);
        scoreteamB = 0;
        scoreTeamBTextView = findViewById(R.id.score_team_b);

        //Team A
        Botao1TeamA = findViewById(R.id.Botao1TeamA);
        Botao3TeamA = findViewById(R.id.Botao3TeamA);
        Botao6TeamA = findViewById(R.id.Botao6TeamA);
        Botao9TeamA = findViewById(R.id.Botao9TeamA);
        Botao12TeamA = findViewById(R.id.Botao12TeamA);

        // Team B
        Botao1TeamB = findViewById(R.id.Botao1TeamB);
        Botao3TeamB = findViewById(R.id.Botao3TeamB);
        Botao6TeamB = findViewById(R.id.Botao6TeamB);
        Botao9TeamB = findViewById(R.id.Botao9TeamB);
        Botao12TeamB = findViewById(R.id.Botao12TeamB);

    }

    public void aumentarUmPontoTimeA(View v) {
        scoreTeamA += 1;
        scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        dozePontosTeamA();
    }

    public void aumentarTresPontosTimeA(View v) {
        scoreTeamA += 3;
        scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        dozePontosTeamA();
    }

    public void aumentarSeisPontosTimeA(View v) {
        scoreTeamA += 6;
        scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        dozePontosTeamA();
    }

    public void aumentarNovePontosTimeA(View v) {
        scoreTeamA += 9;
        scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        dozePontosTeamA();
    }

    public void aumentarDozePontosTimeA(View v) {
        scoreTeamA += 12;
        scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        dozePontosTeamA();
    }
    /*


     */
    public void aumentarUmPontoTimeB(View v) {
        scoreteamB += 1;
        scoreTeamBTextView.setText(String.valueOf(scoreteamB));
        dozePontosTeamB();
    }

    public void aumentarTresPontosTimeB(View v) {
        scoreteamB += 3;
        scoreTeamBTextView.setText(String.valueOf(scoreteamB));
        dozePontosTeamB();
    }

    public void aumentarSeisPontosTimeB(View v) {
        scoreteamB += 6;
        scoreTeamBTextView.setText(String.valueOf(scoreteamB));
        dozePontosTeamB();
    }

    public void aumentarNovePontosTimeB(View v) {
        scoreteamB += 9;
        scoreTeamBTextView.setText(String.valueOf(scoreteamB));
        dozePontosTeamB();
    }

    public void aumentarDozePontosTimeB(View v) {
        scoreteamB += 12;
        scoreTeamBTextView.setText(String.valueOf(scoreteamB));
        dozePontosTeamB();
    }

    public void zerarPontos(View v){
        scoreTeamA = 0;
        scoreteamB = 0;
        scoreTeamATextView.setText(String.valueOf(scoreTeamA));
        scoreTeamBTextView.setText(String.valueOf(scoreteamB));
        destravarBotao();
    }


    public void dozePontosTeamA(){
        if(scoreTeamA >= 12){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            travarBotao();
            builder.setTitle("Fim de jogo!");
            builder.setMessage("Player 1 vencedor");
            builder.show();
        }
    }

    public void dozePontosTeamB() {
        if (scoreteamB >= 12) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            travarBotao();
            builder.setTitle("Fim de jogo!");
            builder.setMessage("Player 2 vencedor");
            builder.show();
        }
    }
    public void travarBotao(){
        // Team A
        Botao1TeamA.setEnabled(false);
        Botao3TeamA.setEnabled(false);
        Botao6TeamA.setEnabled(false);
        Botao9TeamA.setEnabled(false);
        Botao12TeamA.setEnabled(false);

        // Team B
        Botao1TeamB.setEnabled(false);
        Botao3TeamB.setEnabled(false);
        Botao6TeamB.setEnabled(false);
        Botao9TeamB.setEnabled(false);
        Botao12TeamB.setEnabled(false);
    }

    public void destravarBotao(){
        // Team A
        Botao1TeamA.setEnabled(true);
        Botao3TeamA.setEnabled(true);
        Botao6TeamA.setEnabled(true);
        Botao9TeamA.setEnabled(true);
        Botao12TeamA.setEnabled(true);

        // Team B
        Botao1TeamB.setEnabled(true);
        Botao3TeamB.setEnabled(true);
        Botao6TeamB.setEnabled(true);
        Botao9TeamB.setEnabled(true);
        Botao12TeamB.setEnabled(true);
    }
}
