package m2j9702.test.practice;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static m2j9702.test.practice.R.id.email;
import static m2j9702.test.practice.R.id.nick;
import static m2j9702.test.practice.R.id.pwd1;
import static m2j9702.test.practice.R.id.pwd2;

public class CustomWatcher implements TextWatcher
{
    private View view1, view2;
    private TextView warn1,warn2,warn3,warn4;
    private Button regist;
    boolean checkemail = false, checkpwd = false;
    private String emailstr = new String();
    private String str1 = new String();
    private String str2 = new String();


    public CustomWatcher(View view1, View view2, TextView warn1, TextView warn2,TextView warn3,TextView warn4, Button regist)
    {
        this.view1 = view1;
        this.view2 = view2;
        this.warn1 = warn1;
        this.warn2 = warn2;
        this.warn3 = warn3;
        this.warn4 = warn4;
        this.regist = regist;
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
        switch (view1.getId())
        {
            case email:
                checkemail = checkEmail((EditText) view1);
                break;
            case nick:
                MainActivity.l2 = s.length();
                break;
            case pwd1:
                MainActivity.l3 = s.length();
                break;
            case pwd2:
                checkpwd = checkPwd((EditText) view1, (EditText) view2);
                break;
        }
        if (checkemail)
        {
            warn1.setVisibility(View.INVISIBLE);
        }
        else
        {
            warn1.setVisibility(View.VISIBLE);
            regist.setVisibility(View.GONE);
        }
        if (MainActivity.l2 != 0)
        {
            warn2.setVisibility(View.INVISIBLE);
        }
        else
        {
            warn2.setVisibility(View.VISIBLE);
            regist.setVisibility(View.GONE);
        }
        if (MainActivity.l3 >= 8)
        {
            warn3.setVisibility(View.INVISIBLE);
        }
        else
        {
            warn3.setVisibility(View.VISIBLE);
            regist.setVisibility(View.GONE);
        }
        if (checkpwd)
        {
            warn4.setVisibility(View.INVISIBLE);
        }
        else
        {
            warn4.setVisibility(View.VISIBLE);
            regist.setVisibility(View.GONE);
        }
        if((checkemail)&&(MainActivity.l2 != 0)&&(MainActivity.l3 >= 8)&&(checkpwd))
        {
            regist.setVisibility(View.VISIBLE);
        }
        else
        {
            regist.setVisibility(View.GONE);
        }
    }

    public boolean checkEmail(EditText email)
    {
        int ck1 = 0, ck2 = 0;
        int j = email.length() - 1;
        emailstr = email.getText().toString();
        MainActivity.l1 = email.length();
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
        if ((MainActivity.l1 >= 5) && (ck1 == 1) && (ck2 == 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkPwd(EditText pwd1, EditText pwd2)
    {
        str1=pwd1.getText().toString();
        str2=pwd2.getText().toString();
        MainActivity.l4 = pwd1.length();
        if ((MainActivity.l4 >= 8) && (pwd1.length() == pwd2.length()) && (str1.equals(str2)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
