package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    String idstr, pwdstr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView warn = (TextView) findViewById(R.id.warn);
        EditText id = (EditText) findViewById(R.id.id);
        EditText pwd = (EditText) findViewById(R.id.pwd);
        Button btn = (Button) findViewById(R.id.btn);

        idstr = id.getText().toString();
        pwdstr = pwd.getText().toString();
        if ((idstr.getBytes().length != 0) && (pwdstr.getBytes().length != 0))
        {
            warn.setVisibility(warn.GONE);
        }
    }
}
