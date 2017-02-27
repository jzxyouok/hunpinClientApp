package tianxing.app.callcall.customer.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.utils.ActionBarManager;

public class AboutUSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        //透明状态栏
        ActionBarManager.getInstance().initSystemBarTran(true,this,R.color.gray_F9F9F9);

        initView();
    }

    private ImageView back;

    private void initView() {
        //初始化  数据
        back = (ImageView) findViewById(R.id.title_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
