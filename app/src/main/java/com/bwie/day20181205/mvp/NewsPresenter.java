package com.bwie.day20181205.mvp;

import com.bwie.day20181205.NewsCallBack;
import com.bwie.day20181205.bean.NewsBean;

import java.util.List;

/**
 * author：张腾
 * date：2018/12/5
 */
public class NewsPresenter {
    public NewsModel newsModel;
    public NewsView newsView;

    public NewsPresenter(NewsView newsView){
        this.newsView = newsView;
        newsModel = new NewsModel();
    }

    public void news(){
        newsModel.showNews(new NewsCallBack() {
            @Override
            public void onSuccess(List<NewsBean.DataBean> list) {
                newsView.onSuccess(list);
            }

            @Override
            public void onFailer(String msg) {
                newsView.onFailer(msg);
            }
        });
    }
}
