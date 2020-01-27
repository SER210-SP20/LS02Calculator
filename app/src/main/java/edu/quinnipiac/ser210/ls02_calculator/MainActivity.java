package edu.quinnipiac.ser210.ls02_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.num1);
        input2 = (EditText) findViewById(R.id.num2);
        resultView = (TextView) findViewById(R.id.res);
        Spinner op_spinner = (Spinner) findViewById(R.id.operations_spinner);
       op_spinner.setSelection(0,true);
        op_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (input1.getText() != null && input2.getText() != null){

                    String selected = (String) adapterView.getItemAtPosition(i);
                    performOp(selected.charAt(0));

                   }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button add = (Button) findViewById(R.id.sum);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                performOp('+');
            }
        });
    }
    public void subtraction(View v){
        performOp('-');
    }
    private void performOp(char op) {
        Log.v("Debug", "method performOp called");
        if ((input1.getText() != null) && (input2.getText() != null)) {

            // read from input1 and input2
            double num1 = Double.valueOf(input1.getText().toString());
            double num2 = Double.valueOf(input2.getText().toString());

            Log.v("Debug", "num 1 " + num1 + "num 2" + num2);
            double result = 0;

            // peform operation the two values

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

            }
            //update the value of text in the result textView
            resultView.setText(Double.toString(result));
        }
    }
}
