package com.bwie.day20181205.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.bwie.day20181205.R;
import com.bwie.day20181205.adapter.MyAdapter;
import com.bwie.day20181205.bean.NewsBean;
import com.bwie.day20181205.mvp.NewsPresenter;
import com.bwie.day20181205.mvp.NewsView;

import java.util.List;

/**
 * author：张腾
 * date：2018/12/5
 */
public class MyDataFragment extends Fragment implements NewsView {

    private ListView mListView;
    private NewsPresenter newsPresenter;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_mydata, container, false);
        mListView = view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsPresenter = new NewsPresenter(this);
        newsPresenter.news();
    }

    @Override
    public void onSuccess(List<NewsBean.DataBean> list) {
        myAdapter = new MyAdapter(getActivity());
        myAdapter.setList(list);
        mListView.setAdapter(myAdapter);
    }

    @Override
    public void onFailer(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
