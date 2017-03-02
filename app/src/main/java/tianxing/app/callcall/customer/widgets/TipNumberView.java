package tianxing.app.callcall.customer.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Package_name:tianxing.app.callcall.customer.widgets
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/03  00:21
 */

public class TipNumberView extends TextView {

    private Paint mBgPaint ;
    PaintFlagsDrawFilter pfd;

    public TipNumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBgPaint = new Paint();
        mBgPaint.setColor(Color.RED);
        mBgPaint.setAntiAlias(true);

        pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);
    }

    public TipNumberView(Context context) {
        this(context,null);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        setMeasuredDimension(max, max);
    }

    @Override
    public void setBackgroundColor(int color){
        mBgPaint.setColor(color);
    }

    public void setNotifiText(int text){
        setText(text+"");
    }

    public void setNotifiText(String text){
        setText(text);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(pfd);
        canvas.drawCircle(getWidth()/2, getHeight()/2, Math.max(getWidth()/2, getHeight())/2, mBgPaint);
        super.draw(canvas);
    }

}

