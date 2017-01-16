package m2j9702.test.practice;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static m2j9702.test.practice.R.id.id;
import static m2j9702.test.practice.R.id.pwd;

public class CustomWatcher implements TextWatcher
{
    private View view;
    private TextView warn;
    private Button btn;

    public CustomWatcher(View view, TextView warn, Button btn)
    {
        this.view = view;
        this.warn = warn;
        this.btn = btn;
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
        switch (view.getId())
        {
            case id:
                MainActivity.l1 = s.length();
                break;
            case pwd:
                MainActivity.l2 = s.length();
                break;
        }
        if ((MainActivity.l1 != 0) && (MainActivity.l2 != 0))
        {
            warn.setVisibility(View.INVISIBLE);
            btn.setTextColor(0xFF000000);
            btn.setEnabled(true);
        }
        else
        {
            warn.setVisibility(View.VISIBLE);
            btn.setTextColor(0xFF9c9898);
            btn.setEnabled(false);
        }
    }
}
