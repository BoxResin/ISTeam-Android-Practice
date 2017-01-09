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

public class LoginActivity extends AppCompatActivity implements TextWatcher
{

    private Button btnLogin;
    private EditText editId;
    private EditText editPassword;
    private TextView textNotice;
    private TextView textSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login);
        editId = (EditText) findViewById(R.id.edit_id);
        editPassword = (EditText) findViewById(R.id.edit_password);
        textNotice = (TextView) findViewById(R.id.text_notice);
        textSignUp = (TextView) findViewById(R.id.text_signup);

        editId.addTextChangedListener(this);
        editPassword.addTextChangedListener(this);
        textSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 0)
        {
            if(resultCode == RESULT_OK)
            {
                editId.setText(data.getStringExtra("id"));
                editPassword.setText(data.getStringExtra("password"));
            }
        }
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
        if(editId.getText().toString().length() > 0 && editPassword.getText().toString().length() > 0)
        {
            textNotice.setVisibility(View.INVISIBLE);
            btnLogin.setEnabled(true);
        }
        else
        {
            textNotice.setVisibility(View.VISIBLE);
            btnLogin.setEnabled(false);
        }
    }
}
