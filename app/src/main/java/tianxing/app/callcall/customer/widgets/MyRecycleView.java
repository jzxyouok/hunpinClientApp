package tianxing.app.callcall.customer.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Package_name:tianxing.app.callcall.customer.widgets
 * Author:zhaoQiang
 * Email:zhaoq_hero@163.com
 * Date:2017/03/02  00:21
 */

public class MyRecycleView extends RecyclerView {

    public MyRecycleView(Context context) {
        super(context);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightExpendSpec =
                MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,
                        MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightExpendSpec);
    }
}
