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

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity
{
    private TextView txtEmail, txtNick, txtPwd, txtPwdCheck;
    private EditText editEmail, editNick, editPwd, editPwdCheck;
    private Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = (TextView) findViewById(R.id.txt_email);
        txtNick = (TextView) findViewById(R.id.txt_nick);
        txtPwd = (TextView) findViewById(R.id.txt_pwd);
        txtPwdCheck = (TextView) findViewById(R.id.txt_pwd_check);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editNick = (EditText) findViewById(R.id.edit_nick);
        editPwd = (EditText) findViewById(R.id.edit_pwd);
        editPwdCheck = (EditText) findViewById(R.id.edit_pwd_check);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setVisibility(GONE);
        TextWatcher listener = new TextWatcher()
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
                int okCount = 0;

                //이메일 체크
                if (checkEmail(editEmail))
                {
                    txtEmail.setVisibility(View.INVISIBLE);
                    okCount++;
                }
                else
                {
                    txtEmail.setVisibility(View.VISIBLE);
                }

                //닉네임 체크
                if (editNick.length() != 0)
                {
                    txtNick.setVisibility(View.INVISIBLE);
                    okCount++;
                }
                else
                {
                    txtNick.setVisibility(View.VISIBLE);
                }

                //비밀번호 체크
                if (editPwd.length() >= 8)
                {
                    txtPwd.setVisibility(View.INVISIBLE);
                    okCount++;
                }
                else
                {
                    txtPwd.setVisibility(View.VISIBLE);
                }

                //비밀번호 확인 체크
                if (editPwd.getText().toString().equals(editPwdCheck.getText().toString()))
                {
                    txtPwdCheck.setVisibility(View.INVISIBLE);
                    okCount++;
                }
                else
                {
                    txtPwdCheck.setVisibility(View.VISIBLE);
                }

                //모든 조건 통과했을 때
                if (okCount == 4)
                {
                    btnRegister.setVisibility(View.VISIBLE);
                }
                else
                {
                    btnRegister.setVisibility(View.GONE);
                }
            }

            public boolean checkEmail(EditText email)
            {
                int ck1 = 0, ck2 = 0;
                int j = email.length() - 1;
                String emailstr = email.getText().toString();

                for (int i = 0; i < email.length(); i++)
                {
                    if (emailstr.charAt(i) == '@')
                    {
                        j = i;
                        ck1++;
                    }
                    else if (emailstr.charAt(i) == '.')
                    {
                        if (j < i)
                        {
                            ck2++;
                        }
                    }
                }
                if ((email.length() >= 5) && (ck1 == 1) && (ck2 == 1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        };

        editEmail.addTextChangedListener(listener);
        editNick.addTextChangedListener(listener);
        editPwd.addTextChangedListener(listener);
        editPwdCheck.addTextChangedListener(listener);
    }
}
