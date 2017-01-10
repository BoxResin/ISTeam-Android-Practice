package m2j9702.test.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View
{
    private ClickListener listener;

    public interface ClickListener
    {
        void onTouch(MyView myView);
    }
    public MyView(Context context)
    {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setClickListener(ClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setStrokeWidth(10.0f);
        canvas.drawLine(30, 30, 500, 500, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            listener.onTouch(this);
        }
        return true;
    }
}
