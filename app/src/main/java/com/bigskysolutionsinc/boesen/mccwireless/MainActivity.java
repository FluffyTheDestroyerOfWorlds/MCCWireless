package com.bigskysolutionsinc.boesen.mccwireless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Button button  = (Button)findViewById(R.id.btnNext1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // startActivity(new Intent(MainActivity.this, Campare.class));
                    Intent intent = new Intent(MainActivity.this, Campare.class);
                    TextView holdName = (TextView)findViewById(R.id.txtName);
                    TextView holdMonthly = (TextView)findViewById(R.id.txtMonthly);
                    intent.putExtra("txtName", holdName.getText().toString());
                    intent.putExtra("txtMonthly", holdMonthly.getText().toString());
                    startActivity(intent);
                }
            });
        }

}


/*
Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
intent.putExtra("some_key", value);
intent.putExtra("some_other_key", "a value");
startActivity(intent);

On the second activity:

Bundle bundle = getIntent().getExtras();
int value = bundle.getInt("some_key");
String value2 = bundle.getString("some_other_key");


 */