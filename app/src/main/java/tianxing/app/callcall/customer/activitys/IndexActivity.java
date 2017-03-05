package tianxing.app.callcall.customer.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import tianxing.app.callcall.customer.MainActivity;
import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */
public class IndexActivity extends AppCompatActivity {

    public static String FIRST_ENTER = "firstEnter";

    private int[] img = {R.mipmap.yindao1, R.mipmap.yindao2,R.mipmap.yindao3};
    private List<ImageView> imgList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_index);
        initView();
    }

    private void initView() {
        final ImageView iv_enter = (ImageView) findViewById(R.id.iv_enter);
        iv_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Boolean) SPUtils.get_CFG(IndexActivity.this, FIRST_ENTER, true)){
                    SPUtils.put_CFG(IndexActivity.this, FIRST_ENTER, false);
                }
                startActivity(new Intent(IndexActivity.this,MainActivity.class));
                finish();
            }
        });

        for(int i=0;i<img.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            imageView.setImageResource(img[i]);
            imgList.add(imageView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                if(position == img.length-1){
                    iv_enter.setVisibility(View.VISIBLE);
                }else{
                    iv_enter.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    /**
     * 适配图片的滑动
     */
    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imgList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imgList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imgList.get(position));
            return imgList.get(position);
        }
    }
}
