package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity
{
    private TextView warn1, warn2, warn3, warn4;
    private EditText email, nick, pwd1, pwd2;
    private Button regist;
    private View space;
    public static int l1 = 0, l2 = 0, l3 = 0, l4 = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        warn1 = (TextView) findViewById(R.id.warn1);
        warn2 = (TextView) findViewById(R.id.warn2);
        warn3 = (TextView) findViewById(R.id.warn3);
        warn4 = (TextView) findViewById(R.id.warn4);
        email = (EditText) findViewById(R.id.email);
        nick = (EditText) findViewById(R.id.nick);
        pwd1 = (EditText) findViewById(R.id.pwd1);
        pwd2 = (EditText) findViewById(R.id.pwd2);
        regist = (Button) findViewById(R.id.regist);

        regist.setVisibility(GONE);
        email.addTextChangedListener(new CustomWatcher(email, space, warn1, warn2, warn3, warn4, regist));
        nick.addTextChangedListener(new CustomWatcher(nick, space, warn1, warn2, warn3, warn4, regist));
        pwd1.addTextChangedListener(new CustomWatcher(pwd1, space, warn1, warn2, warn3, warn4, regist));
        pwd2.addTextChangedListener(new CustomWatcher(pwd2, pwd1, warn1, warn2, warn3, warn4, regist));
    }
}
