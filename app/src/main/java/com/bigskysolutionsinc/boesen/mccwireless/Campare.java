package com.bigskysolutionsinc.boesen.mccwireless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Campare extends AppCompatActivity {
    String holdName = "";
    String holdMonthly = "";
    String holdCalcInfo = "";
    Double holdCalcTotal = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campare);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            holdName =(String) bundle.get("txtName");
            holdMonthly =(String) bundle.get("txtMonthly");
        }

        Button button  = (Button)findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do calcs
                Double x = 0.00;
                Integer i = 0;
                Double discount = 0.00;

                final RadioButton rb25  = (RadioButton) findViewById(R.id.rb25);
                final RadioButton rbUnlimited  = (RadioButton) findViewById(R.id.rbUnlimited);
                final RadioButton rb15  = (RadioButton) findViewById(R.id.rb15);
                if (rb25.isChecked()) {
                    x = 100.00;
                }
                if (rbUnlimited.isChecked()) {
                    x = 200.00;
                }
                if (rb15.isChecked()) {
                    x = 75.00;
                }

                final CheckBox chkTab = (CheckBox)findViewById(R.id.chkTablet);
                if (chkTab.isChecked()) {
                    x = (x + 20.00);
                    discount = .10;
                }

                final Spinner NumOfLines = (Spinner)findViewById(R.id.spinner);
                i = NumOfLines.getSelectedItemPosition();

                switch (i) { // NumOfLines 25 per
                    case 0:
                        x = x + 25;
                        break;
                    case 1:
                        x = x + 50;
                        discount = discount + .05;
                        break;
                    case 2:
                        x = x + 75;
                        discount = discount + .10;
                        break;
                    default:
                        x = x + 100;
                        discount = discount + .15;
                        break;
                }
                i = i + 1; // get actual lines

                holdCalcTotal = x * (1 + discount);
                holdCalcInfo = "Great News, " + holdName + " our phone plan comes to ";
                // pass to next activity
                Intent intent = new Intent(Campare.this, Summary.class);
                intent.putExtra("holdCalcTotal", holdCalcTotal);
                intent.putExtra("txtMonthly", holdMonthly);
                intent.putExtra("holdCalcInfo", holdCalcInfo);
                startActivity(intent);
            }
        });
    }
}
