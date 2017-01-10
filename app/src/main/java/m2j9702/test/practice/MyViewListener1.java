package m2j9702.test.practice;

import android.util.Log;

public class MyViewListener1 implements MyView.ClickListener
{
    @Override
    public void onTouch(MyView view)
    {
        Log.d("ASDF","클릭");
    }
}
