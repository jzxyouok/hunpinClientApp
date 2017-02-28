package tianxing.app.callcall.customer.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Package_name:tianxing.app.callcall.customer.widgets
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/02/28  23:13
 */

public class MyGridView extends GridView {

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightExpendSpec =
                MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,
                        MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightExpendSpec);
    }
}
