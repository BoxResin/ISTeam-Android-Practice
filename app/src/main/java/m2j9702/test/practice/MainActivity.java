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

    private EditText editEmail;
    private EditText editNickname;
    private EditText editPassword;
    private EditText editPasswordCheck;
    private TextView txtEmailAlert;
    private TextView txtNicknameAlert;
    private TextView txtPasswordAlert;
    private TextView txtPasswordCheckAlert;
    private Button btnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText) findViewById(R.id.edit_email);
        editNickname = (EditText) findViewById(R.id.edit_nickname);
        editPassword = (EditText) findViewById(R.id.edit_password);
        editPasswordCheck = (EditText) findViewById(R.id.edit_password_check);

        txtEmailAlert = (TextView) findViewById(R.id.txt_email_alert);
        txtNicknameAlert = (TextView) findViewById(R.id.txt_nickname_alert);
        txtPasswordAlert = (TextView) findViewById(R.id.txt_password_alert);
        txtPasswordCheckAlert = (TextView) findViewById(R.id.txt_password_check_alert);

        btnSignUp = (Button) findViewById(R.id.btn_sign_up);

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
                int okCount = 0;

                // 이메일 체크
                if (checkEmail(editEmail.getText().toString()))
                {
                    okCount++;
                    txtEmailAlert.setVisibility(View.INVISIBLE);
                }
                else txtEmailAlert.setVisibility(View.VISIBLE);

                // 닉네임 체크
                if (!editNickname.getText().toString().equals(""))
                {
                    okCount++;
                    txtNicknameAlert.setVisibility(View.INVISIBLE);
                }
                else txtNicknameAlert.setVisibility(View.VISIBLE);

                // 비밀번호 체크
                if (editPassword.getText().toString().length() >= 8)
                {
                    okCount++;
                    txtPasswordAlert.setVisibility(View.INVISIBLE);
                }
                else txtPasswordAlert.setVisibility(View.VISIBLE);

                // 비밀번호 확인 체크
                if (editPasswordCheck.getText().toString().equals(editPassword.getText().toString()))
                {
                    okCount++;
                    txtPasswordCheckAlert.setVisibility(View.INVISIBLE);
                }
                else
                    txtPasswordCheckAlert.setVisibility(View.VISIBLE);

                if (okCount == 4)
                    btnSignUp.setVisibility(View.VISIBLE);
                else btnSignUp.setVisibility(View.INVISIBLE);
            }

	        /**
             * 이메일 형식이 올바른지 체크하는 메서드
             * @return 올바르면 true, 그렇지 않으면 false
             */
            private boolean checkEmail(String email)
            {
                if (email.equals(""))
                    return false;
                else
                {
                    String[] tokens = email.split("@");
                    if (tokens.length == 2)
                        return true;
                    else return false;
                }
            }
        };
        editEmail.addTextChangedListener(textWatcher);
        editNickname.addTextChangedListener(textWatcher);
        editPassword.addTextChangedListener(textWatcher);
        editPasswordCheck.addTextChangedListener(textWatcher);
    }
}