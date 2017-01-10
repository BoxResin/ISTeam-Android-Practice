package m2j9702.test.practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Main extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        MyView myView = (MyView) findViewById(R.id.myview);
        myView.setClickListener(new MyViewListener1());
    }
}
