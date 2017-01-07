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

        final TextView txtAlert = (TextView) findViewById(R.id.txt_alert);
        final EditText editId = (EditText) findViewById(R.id.edit_id);
        final EditText editPassword = (EditText) findViewById(R.id.edit_password);
        final Button btnLogin = (Button) findViewById(R.id.btn_login);

        TextWatcher textWatcher = new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // 아이디와 비밀번호가 모두 입력되었을 때
                if (editId.getText().toString().length() > 0 && editPassword.getText().toString().length() > 0)
                {
                    txtAlert.setVisibility(View.INVISIBLE);
                    btnLogin.setEnabled(true);
                }

                // 아이디나 비밀번호가 입력되지 않았을 때
                else
                {
                    txtAlert.setVisibility(View.VISIBLE);
                    btnLogin.setEnabled(false);
                }
            }
        };
        editId.addTextChangedListener(textWatcher);
        editPassword.addTextChangedListener(textWatcher);
    }
}