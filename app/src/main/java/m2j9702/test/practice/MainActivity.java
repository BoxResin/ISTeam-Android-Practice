package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView warn;
    private Button btn;
    int l1 = 0, l2 = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText id = (EditText) findViewById(R.id.id);
        EditText pwd = (EditText) findViewById(R.id.pwd);
        warn = (TextView) findViewById(R.id.warn);
        btn = (Button) findViewById(R.id.btn);

        id.addTextChangedListener(iid);
        pwd.addTextChangedListener(ppwd);
        btn.setEnabled(false);
    }

    TextWatcher iid = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            l1 = s.length();
            if ((l1 != 0) && (l2 != 0))
            {
                warn.setVisibility(View.INVISIBLE);
                btn.setTextColor(0xFF000000);
                btn.setEnabled(true);
            }
            else
            {
                warn.setVisibility(View.VISIBLE);
                btn.setTextColor(0xFF9c9898);
                btn.setEnabled(false);
            }
        }
    };

    TextWatcher ppwd = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            l2 = s.length();
            if ((l1 != 0) && (l2 != 0))
            {
                warn.setVisibility(View.INVISIBLE);
                btn.setTextColor(0xFF000000);
                btn.setEnabled(true);
            }
            else
            {
                warn.setVisibility(View.VISIBLE);
                btn.setTextColor(0xFF9c9898);
                btn.setEnabled(false);
            }
        }
    };
}
