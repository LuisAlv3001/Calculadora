package cr.ac.ucr.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvOperation;
    private boolean isResult = false;
    private boolean isSign = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOperation = findViewById(R.id.tv_operation);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_00:
                operation("00");
                break;
            case R.id.btn_0:
                operation("0");
                break;
            case R.id.btn_1:
                operation("1");
                break;
            case R.id.btn_2:
                operation("2");
                break;
            case R.id.btn_3:
                operation("3");
                break;
            case R.id.btn_4:
                operation("4");
                break;
            case R.id.btn_5:
                operation("5");
                break;
            case R.id.btn_6:
                operation("6");
                break;
            case R.id.btn_7:
                operation("7");
                break;
            case R.id.btn_8:
                operation("8");
                break;
            case R.id.btn_9:
                operation("9");
                break;
            case R.id.btn_divide:
                operation(" ÷ ");
                break;
            case R.id.btn_dot:
                operation(".");
                break;
            case R.id.btn_minus:
                operation(" - ");
                break;
            case R.id.btn_multiply:
                operation(" × ");
                break;
            case R.id.btn_result:
                result();
                break;
            case R.id.btn_sum:
                operation(" + ");
                break;
            case R.id.btn_clear:
                clear();
                break;
            default:
                break;
        }
    }

    public void operation(String number){
        if (!isResult){
            String text = tvOperation.getText().toString();
            tvOperation.setText(text + number);
        } else {
            clear();
            String text = tvOperation.getText().toString();
            tvOperation.setText(text + number);
        }
    }

    public void clear(){
        tvOperation.setText("");
        isResult = false;
    }

    public void result(){
        String text = tvOperation.getText().toString();
        int signPosition = 0;
        double result;
        String firstNumber = "";
        String secondNumber = "";
        String str = tvOperation.getText().toString();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                firstNumber += str.charAt(i);
            }else{
                signPosition = i + 1;
                i = str.length();
            }
        }
        for (int i = signPosition + 1; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                secondNumber += str.charAt(i);
            }
        }

        if (str.charAt(signPosition) == '+') {
            result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
            tvOperation.setText(text + " = " + (double) result);
            isResult = true;
        } else if(str.charAt(signPosition) == '-'){
            result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
            tvOperation.setText(text + " = " + (double) result);
            isResult = true;
        } else if(str.charAt(signPosition) == '÷'){
            result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
            tvOperation.setText(text +  " = " + (double) result);
            isResult = true;
        } else if(str.charAt(signPosition) == '×'){
            result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
            tvOperation.setText(text + " = " + (double) result);
            isResult = true;
        }
    }
}