package m2j9702.test.practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btnErase;
    private Button btnC;
    private Button btnPercent;
    private Button btnBracket;
    private Button btnDiv;
    private Button btnMul;
    private Button btnMin;
    private Button btnAdd;
    private Button btnEqual;
    private Button btnDot;
    private Button btnSign;
    private EditText editInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btnErase = (Button) findViewById(R.id.btn_erase);
        btnC = (Button) findViewById(R.id.btn_c);
        btnPercent = (Button) findViewById(R.id.btn_percent);
        btnBracket = (Button) findViewById(R.id.btn_bracket);
        btnDiv = (Button) findViewById(R.id.btn_div);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnMin = (Button) findViewById(R.id.btn_min);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnEqual = (Button) findViewById(R.id.btn_equal);
        btnDot = (Button) findViewById(R.id.btn_dot);
        btnSign = (Button) findViewById(R.id.btn_sign);
        editInput = (EditText) findViewById(R.id.edit_input);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btnErase.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnBracket.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnSign.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

        if (v.getId() == R.id.btn_erase)
        {
            String input = editInput.getText().toString();

            if (input.length() > 0)
            {
                editInput.setText(input.substring(0, input.length() - 1));
            }
        }
        else if (v.getId() == R.id.btn_c || v.getId() == R.id.btn_equal)
        {
            editInput.setText("");
        }
        else if (v.getId() == R.id.btn_bracket || v.getId() == R.id.btn_sign)
        {
        }
        else
        {
            Button b = (Button) v;
            editInput.setText(editInput.getText().toString() + b.getText());
        }
    }
}
