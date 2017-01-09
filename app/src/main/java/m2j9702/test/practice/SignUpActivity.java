package m2j9702.test.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements TextWatcher
{

    private EditText editEmail;
    private EditText editNickname;
    private EditText editPassword1;
    private EditText editPsassword2;
    private TextView noticeEmail;
    private TextView noticeNickname;
    private TextView noticePassword1;
    private TextView noticePassword2;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setResult(RESULT_CANCELED);

        editEmail = (EditText) findViewById(R.id.edit_email);
        editNickname = (EditText) findViewById(R.id.edit_nickname);
        editPassword1 = (EditText) findViewById(R.id.edit_password1);
        editPsassword2 = (EditText) findViewById(R.id.edit_password2);
        noticeEmail = (TextView) findViewById(R.id.notice_email);
        noticeNickname = (TextView) findViewById(R.id.notice_nickname);
        noticePassword1 = (TextView) findViewById(R.id.notice_password1);
        noticePassword2 = (TextView) findViewById(R.id.notice_password2);
        btn = (Button) findViewById(R.id.btn);

        editEmail.addTextChangedListener(this);
        editNickname.addTextChangedListener(this);
        editPassword1.addTextChangedListener(this);
        editPsassword2.addTextChangedListener(this);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.putExtra("id",editEmail.getText().toString());
                intent.putExtra("password",editPassword1.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

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
        int check = 0;

        if (editEmail.getText().toString().length() > 0)
        {
            check++;
            noticeEmail.setVisibility(View.INVISIBLE);
        }
        else
            noticeEmail.setVisibility(View.VISIBLE);

        if (editNickname.getText().toString().length() > 0)
        {
            check++;
            noticeNickname.setVisibility(View.INVISIBLE);
        }
        else
            noticeNickname.setVisibility(View.VISIBLE);

        if(editPassword1.getText().toString().length() < 8)
            noticePassword1.setVisibility(View.VISIBLE);
        else
        {
            check++;
            noticePassword1.setVisibility(View.INVISIBLE);
        }

        if(editPassword1.getText().toString().equals(editPsassword2.getText().toString()))
        {
            check++;
            noticePassword2.setVisibility(View.INVISIBLE);
        }
        else
            noticePassword2.setVisibility(View.VISIBLE);

        if(check == 4)
            btn.setVisibility(View.VISIBLE);
        else
            btn.setVisibility(View.INVISIBLE);
    }
}
