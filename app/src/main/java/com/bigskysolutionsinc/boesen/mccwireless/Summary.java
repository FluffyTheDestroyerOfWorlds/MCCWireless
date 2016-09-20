package com.bigskysolutionsinc.boesen.mccwireless;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    String holdCalcInfo = "";
    String holdMonthly = "";
    Double holdCalcTotal = 0.00;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            holdCalcInfo =(String) bundle.get("holdCalcInfo");
            holdCalcTotal = (Double) bundle.get("holdCalcTotal");
            holdMonthly = (String)bundle.get("holdMonthly");
        }
        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        txtInfo.setText(holdCalcInfo);
        TextView txtCalcCost = (TextView)findViewById(R.id.txtCalcCost); //txtCalcCost
        txtCalcCost.setText(Double.toString(holdCalcTotal));


    }
}
