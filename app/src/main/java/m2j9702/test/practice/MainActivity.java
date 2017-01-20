package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnTest = (Button) findViewById(R.id.btn_test);
        final Button btnTest2 = (Button) findViewById(R.id.btn_test2);
        final Button btnTest3 = (Button) findViewById(R.id.btn_test3);

        btnTest.setOnClickListener(new View.OnClickListener() //버튼 눌렀을 때 호출될 메소드 등록
        {
            @Override
            public void onClick(View v)
            {
                //버튼이 눌릴 때마다 할 동작
                btnTest2.setTextColor(0xB3F12A62);
            }
        });
        btnTest2.setOnClickListener(new View.OnClickListener() //버튼 눌렀을 때 호출될 메소드 등록
        {
            @Override
            public void onClick(View v)
            {
                //버튼이 눌릴 때마다 할 동작
                btnTest3.setTextSize(15.0f);
            }
        });
        btnTest3.setOnClickListener(new View.OnClickListener() //버튼 눌렀을 때 호출될 메소드 등록
        {
            @Override
            public void onClick(View v)
            {
                //버튼이 눌릴 때마다 할 동작
                btnTest.setBackgroundColor(0xC3A1C0C4);
                btnTest2.setBackgroundColor(0xC3A1C0C4);
            }
        });

    }
}
