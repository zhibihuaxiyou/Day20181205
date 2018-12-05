package com.bwie.day20181205.mvp;

import com.bwie.day20181205.bean.NewsBean;

import java.util.List;

/**
 * author：张腾
 * date：2018/12/5
 */
public interface NewsView {
    void onSuccess(List<NewsBean.DataBean> list);
    void onFailer(String msg);
}
