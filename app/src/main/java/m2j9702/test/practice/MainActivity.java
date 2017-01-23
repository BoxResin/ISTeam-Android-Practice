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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
        final EditText editID = (EditText) findViewById(R.id.editID);
        final EditText editPW = (EditText) findViewById(R.id.editPW);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);

        TextWatcher textWatcher = new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                int okCount = 0;

                if (editID.getText().toString().length() > 0)
                {
                    ++okCount;
                }
                if (editPW.getText().toString().length() > 0)
                {
                    ++okCount;
                }

                if (okCount == 2)
                {
                    btnLogin.setEnabled(true);
                    txtMessage.setVisibility(View.INVISIBLE);
                }
                else
                {
                    btnLogin.setEnabled(false);
                    txtMessage.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        };
        editID.addTextChangedListener(textWatcher);
        editPW.addTextChangedListener(textWatcher);
    }
}

