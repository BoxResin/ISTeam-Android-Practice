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
    private boolean bCheckID = false;
    private boolean bCheckPW = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
        final EditText editID = (EditText) findViewById(R.id.editID);
        final EditText editPW = (EditText) findViewById(R.id.editPW);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);

        TextWatcher txt_listener = new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (s == editID)
                {
                    if (s.toString().length() > 0)
                    {
                        bCheckID = true;
                        if (bCheckID && bCheckPW)
                        {
                            btnLogin.setEnabled(true);
                            txtMessage.setVisibility(View.INVISIBLE);
                        }


                    }
                    else
                    {
                        bCheckID = false;
                        if (bCheckID && bCheckPW)
                        {
                            btnLogin.setEnabled(true);
                            txtMessage.setVisibility(View.INVISIBLE);
                        }

                    }


                }

                if (s == editPW)
                {
                    if (s.toString().length() > 0)
                    {
                        bCheckPW = true;
                        if (bCheckID && bCheckPW)
                        {
                            btnLogin.setEnabled(true);
                            txtMessage.setVisibility(View.INVISIBLE);
                        }


                    }
                    else
                    {
                        bCheckID = false;
                        if (bCheckID && bCheckPW)
                        {
                            btnLogin.setEnabled(true);
                            txtMessage.setVisibility(View.INVISIBLE);
                        }

                    }

                }


            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        };
        editID.addTextChangedListener(txt_listener);
        editPW.addTextChangedListener(txt_listener);
        txtMessage.addTextChangedListener(txt_listener);
    }
}

