package tianxing.app.callcall.customer.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tianxing.app.callcall.customer.R;


/**
 * 火拼
 */
public class PartnerFragment extends BaseFragment {

    private View view;
    private TextView titleTxt;
    private ImageView imgIc;

    public PartnerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_partner, container, false);
        initView();
        return view;
    }

    public void initView() {
        titleTxt = (TextView) view.findViewById(R.id.title_bar_text);
        titleTxt.setText(R.string.title_huopin);
    }

}
