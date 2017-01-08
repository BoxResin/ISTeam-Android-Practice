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

    private Button btnLogin;
    private EditText editId;
    private EditText editPassword;
    private TextView textNotice;
    private boolean editIdState = false;
    private boolean editPasswordState = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btn_login);
        editId = (EditText) findViewById(R.id.edit_id);
        editPassword = (EditText) findViewById(R.id.edit_password);
        textNotice = (TextView) findViewById(R.id.text_notice);

        editId.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.toString().length() > 0)
                {
                    editIdState = true;
                    checkStates();

                }
                else
                {
                    editIdState = false;
                    checkStates();
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
        editPassword.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.toString().length() > 0)
                {
                    editPasswordState = true;
                    checkStates();

                }
                else
                {
                    editPasswordState = false;
                    checkStates();
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    void checkStates()
    {
        if(editIdState && editPasswordState)
        {
            btnLogin.setEnabled(true);
            textNotice.setVisibility(View.INVISIBLE);
        }
        else
        {
            btnLogin.setEnabled(false);
            textNotice.setVisibility(View.VISIBLE);
        }
    }

}
