package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textArea;
    Button equalButton;
    String operatorHolder="";
    String result="";
    Button clearButton;

    boolean onequalClick=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textArea= findViewById(R.id.result);


        //3lshan hwa button wahed fa 3mlnaha bltre2a de kouna mmkn 3ady n3mlha b function tht
        //dlw2ty ana 3mlt variable mn no3 button asmo equalButton
        //al equalButton da byshawr 3ala al button aly al id bta3o hwa equal_button
        //R de hya alparent bta3 kolo alviews w albuttons w kda
        equalButton=findViewById(R.id.button_equal);

        //hena msh hhtag ahot fl xml android:onclick="function"
        //3lshan ana b2olo lma atk 3ala albutton aly gbt al id bta3o da fa a3ml al2aty tlqa2y
        //onclickListener da interface gwah function onclick lazm a3mlha implementation
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=calculation(result,operatorHolder,textArea.getText().toString());

                textArea.setText(result);
                onequalClick=true;
                result="";
                operatorHolder="";
            }
        });

        clearButton =findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textArea.setText(null);
            }
        });
    }
    public void onDigitClick(View view){
        Button clickedButton;
        //lw al haga aly hdos 3leha de kanet button fa a3ml altaly
        if(view instanceof Button){

            //da casting b2olo an khznle al properties almwgoda flcurrent button aly ana clicked on it fe alvariable clickedButton
            clickedButton = ((Button) view);
            //ana ktba inside each button it's value fa ana hakhod alvalue de w a convert it to string w adefha fl textArea
            String digit = clickedButton.getText().toString();
            textArea.append(digit);


        }
    }

    public void onOperatorClick(View view){
        Button operatorButton;
        String operation;


        if(view instanceof Button){
            operatorButton = ((Button) view);
            operation =operatorButton.getText().toString();

            if(operatorHolder.isEmpty()){
                //lw aana mdostsh 3ala ay operator abl kda hydkhol hna
                //b3d kda hyhot aloperation fe alholder w yakhod al2rqam almwgoda w ymsh alshasha mstny any adkhl al lfh "left hand side"
                operatorHolder=operation;
                result=textArea.getText().toString();
                textArea.setText(null);
            }else {
                result=calculation(result,operatorHolder,textArea.getText().toString());
                operatorHolder=operation;
                textArea.setText(null);
            }
        }
    }

    public String calculation(String rhs, String operation, String lhs){
        double RHS=Double.parseDouble(rhs);
        double LHS=Double.parseDouble(lhs);
        double finalResult=0.0;

        if(operation.equals("+")){
            finalResult= RHS+LHS;
        }else if(operation.equals("x")){
            finalResult= RHS*LHS;
        }else if(operation.equals("/")){
            finalResult= RHS/LHS;
        }else if(operation.equals("-")){
            finalResult= RHS-LHS;
        }
        return finalResult+"";



}}