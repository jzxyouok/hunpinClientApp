package tianxing.app.callcall.customer.fragments;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tianxing.app.callcall.customer.R;
import tianxing.app.callcall.customer.VerticalData;
import tianxing.app.callcall.customer.adapter.FirstRecycleAdapter;
import tianxing.app.callcall.customer.domain.FirstRecycleBean;
import tianxing.app.callcall.customer.domain.FirstGridViewBean;

/**
 * 首页
 */
public class FirstFragment extends BaseFragment {

    private RecyclerView first_fragment_recycle_view;

    private  ArrayList<FirstGridViewBean> gvlist;
    private ArrayList<FirstRecycleBean> relist;

    private FirstRecycleAdapter adapter;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        first_fragment_recycle_view = (RecyclerView) view.findViewById(R.id.first_fragment_recycle_view);

        initRecycleView();

        return view;
    }

    /**
     * 初始化 recycleView
     */
    private void initRecycleView() {
        //有数据 回掉回来 需要更新适配器
        gvlist = VerticalData.getGridViewList();
        relist = VerticalData.getFirstRecycleData();

        adapter = new FirstRecycleAdapter(getActivity(),gvlist,relist);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), 1,false);
        first_fragment_recycle_view.setLayoutManager(layoutManager);

        first_fragment_recycle_view.setAdapter(adapter);
        //解决 item绘制 导致的闪频问题
        ((SimpleItemAnimator)first_fragment_recycle_view.getItemAnimator()).setSupportsChangeAnimations(false);

        adapter.notifyDataSetChanged();
    }

}
