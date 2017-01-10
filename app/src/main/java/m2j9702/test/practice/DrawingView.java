package m2j9702.test.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View
{
    private Paint paint;
    private ArrayList<Point> arrayPoint = new ArrayList<>();

    public DrawingView(Context context)
    {
        super(context);
    }

    public DrawingView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        paint = new Paint();
        paint.setStrokeWidth(10.0f);
    }

    public void changeColor(int color)
    {
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        for (int i = 0; i < arrayPoint.size() - 1; i++)
            canvas.drawLine(arrayPoint.get(i).x, arrayPoint.get(i).y, arrayPoint.get(i+1).x, arrayPoint.get(i+1).y, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        Point p = new Point((int) event.getX(), (int) event.getY());
        arrayPoint.add(p);
        invalidate();
        return true;
    }
}
