package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView warn;
    private EditText id;
    private EditText pwd;
    private Button btn;
    public static int l1 = 0, l2 = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        warn = (TextView) findViewById(R.id.warn);
        id = (EditText) findViewById(R.id.id);
        pwd = (EditText) findViewById(R.id.pwd);
        btn = (Button) findViewById(R.id.btn);

        btn.setEnabled(false);
        id.addTextChangedListener(new CustomWatcher(id, warn, btn));
        pwd.addTextChangedListener(new CustomWatcher(pwd, warn, btn));
        btn.setEnabled(false);
    }
}
