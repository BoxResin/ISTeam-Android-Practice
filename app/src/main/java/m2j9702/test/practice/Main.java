package m2j9702.test.practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity implements View.OnClickListener
{

    private DrawingView drawingView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Button btnRed = (Button) findViewById(R.id.btn_red);
        Button btnGreen = (Button) findViewById(R.id.btn_green);
        Button btnBlue = (Button) findViewById(R.id.btn_blue);
        drawingView = (DrawingView) findViewById(R.id.drawingview);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        TextView textView = (TextView) v;
        drawingView.changeColor(textView.getCurrentTextColor());

    }
}
