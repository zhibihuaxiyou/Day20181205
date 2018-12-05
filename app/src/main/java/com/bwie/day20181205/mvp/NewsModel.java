package com.bwie.day20181205.mvp;

import com.bwie.day20181205.NewsCallBack;
import com.bwie.day20181205.bean.NewsBean;
import com.bwie.day20181205.utils.HttpHelper;
import com.google.gson.Gson;

import java.util.List;

/**
 * author：张腾
 * date：2018/12/5
 */
public class NewsModel {
    public void showNews(final NewsCallBack newsCallBack){

        String NEWSURL = "http://www.xieast.com/api/news/news.php";

        new HttpHelper().get(NEWSURL).result(new HttpHelper.HttpListener() {
            @Override
            public void success(String data) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(data, NewsBean.class);
                List<NewsBean.DataBean> list = newsBean.getData();
                if (list!=null) {
                    newsCallBack.onSuccess(list);
                }else {
                    newsCallBack.onFailer("解析失败");
                }
            }

            @Override
            public void fail() {
                newsCallBack.onFailer("解析失败");
            }
        });
    }
}
