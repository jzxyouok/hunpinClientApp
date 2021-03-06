package tianxing.app.callcall.customer.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tianxing.app.callcall.customer.R;


/**
 * 会员
 */
public class ShopCarFragment extends BaseFragment {

    private View view;
    private TextView titleTxt;
    private ImageView imgIc;

    public ShopCarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopingcar, container, false);
        initView();
        return view;
    }

    public void initView() {
        titleTxt = (TextView) view.findViewById(R.id.title_bar_text);
        titleTxt.setText(R.string.title_shoppingCar);
    }

}
