package com.example.convertanumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number;
    Button btnconvert;
    TextView res;
    int numberval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.numbert);
        btnconvert = findViewById(R.id.btnconvert);
        res = findViewById(R.id.resval);

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber();
            }
        });
    }

    public void showNumber() {

        numberval = Integer.parseInt(number.getText().toString());

        Number num = new Number(numberval);

//             yesma chai mero code copy hana aba hai
//kasari garnai ayena yr ma tmro github yei bata open garchu ni run garne banaideu na

//                yesma aile copy gareko code hala ani timro variable name change gara
        String[] one_to_nineteen = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
                " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

        String[] ten_to_ninety = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

        String converted;

        if (numberval == 0) {
            converted = "Zero";
        } else if (numberval < 20) {
            converted = one_to_nineteen[numberval];
        } else if (numberval >= 20 && numberval < 100) {
            converted = ten_to_ninety[numberval / 10] + one_to_nineteen[numberval % 10];
        } else {
            int rem = numberval % 100;
            if (rem == 0) {
                converted = one_to_nineteen[numberval / 100] + " Hundred";
            } else {
                converted = one_to_nineteen[numberval / 100] + " Hundred and" + (rem < 20 ? one_to_nineteen[rem] : ten_to_ninety[rem / 10] + one_to_nineteen[rem % 10]);
            }
        }

        res.setText(converted);



    }

}
