package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editInput = (EditText) findViewById(R.id.edit_input);
        final Button btn = (Button) findViewById(R.id.btn);

        editInput.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                Log.i("asdf", "On key");
                if(s.toString().length() >= 8)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
        /*
        editInput.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                Log.i("asdf", "On key");
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    if(editInput.getText().toString().length() >= 8)
                        btn.setEnabled(true);
                    else
                        btn.setEnabled(false);
                }
                return true;
            }
        });*/
    }
}
