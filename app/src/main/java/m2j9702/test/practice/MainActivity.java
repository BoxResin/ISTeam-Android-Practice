package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView txt1;
    private TextView txt2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.txt);
        txt2 = (TextView) findViewById(R.id.txt2);
        Button btnTest = (Button) findViewById(R.id.btn_test);
        Button btnTest2 = (Button) findViewById(R.id.btn_test2);

        btnTest.setOnClickListener(this);
        btnTest2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.btn_test)
        {
            txt1.setTextColor(0xFFFF0000);
        }
        else if (view.getId() == R.id.btn_test2)
        {
            txt2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 100);
        }
    }
}