package calculator.binarybit.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float[] numbers = new float[30];
    int itop=-1;
    int ctop=-1;
    char[] operations = new char[15];
    String lowerDisplay="",temp="";
    int floatFlag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clearOnClick(View view)
    {
        itop=-1;
        ctop=-1;
        lowerDisplay="";
        temp="";
        TextView tv = findViewById(R.id.display);
        tv.setText("");
        tv = findViewById(R.id.updatedDisplay);
        tv.setText("");
    }
    public void dotOnClick(View view)
    {
        if(temp.equals(""))
        {
            lowerDisplay+="0.";
            temp+="0.";
        }
        else {
            lowerDisplay += ".";
            temp += ".";
        }
        TextView tv = findViewById(R.id.display);
        tv.setText(lowerDisplay);
    }
    public void numbersOnClick(View view){
        String buttonPressed=view.getTag().toString();
        lowerDisplay=lowerDisplay+buttonPressed;
        temp=temp+buttonPressed;
        TextView tv = findViewById(R.id.display);
        tv.setText(lowerDisplay);
    }
    public void operationOnClick(View view){
            String operation = view.getTag().toString();
            lowerDisplay=lowerDisplay+operation;
            TextView tv = findViewById(R.id.display);
            tv.setText(lowerDisplay);
            if(temp!="")
            {
                numbers[++itop]=Float.parseFloat(temp);
                temp="";
            }
            operations[++ctop]=operation.charAt(0);
    }
    public void equalOnClick(View view){
            numbers[++itop]=Float.parseFloat(temp);
            temp="";
            TextView tv = findViewById(R.id.updatedDisplay);
            tv.setText(lowerDisplay);
            lowerDisplay = "";
            char op;
            float a, b, c = 0;
            if(itop==0)
            {
                c=numbers[itop];
            }
            else {
                while (itop != 0) {
                    a = ipop();
                    b = ipop();
                    op = cpop();
                    switch (op) {
                        case '+':
                            c = b + a;
                            break;
                        case '-':
                            c = b - a;
                            break;
                        case '*':
                            c = a * b;
                            break;
                        case '/':
                            c = b / a;
                            break;
                    }
                    numbers[++itop] = c;
                }
            }
            lowerDisplay += "" + c;
            tv = findViewById(R.id.display);
            tv.setText(lowerDisplay);
    }

    public float ipop(){
        return numbers[itop--];
    }
    public char cpop(){
        return operations[ctop--];
    }

}