package com.bwie.day20181205.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.day20181205.R;
import com.bwie.day20181205.bean.NewsBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * author：张腾
 * date：2018/12/5
 */
public class MyAdapter extends BaseAdapter{
    private List<NewsBean.DataBean> list = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<NewsBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getThumbnail_pic_s02()!=null) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder1 holder1;
        ViewHolder2 holder2;
        int type = getItemViewType(i);
        switch (type){
            case 0:
                if (view == null){
                    view = View.inflate( context, R.layout.layout_item1,null );
                    holder1 = new ViewHolder1();
                    holder1.textView = view.findViewById( R.id.textView);
                    holder1.imageView = view.findViewById( R.id.imageView );
                    view.setTag( holder1 );
                }else {
                    holder1 = (ViewHolder1) view.getTag();
                }
                holder1.textView.setText( list.get( i ).getTitle() );
                ImageLoader.getInstance().displayImage( list.get( i ).getThumbnail_pic_s(),holder1.imageView);
                break;
            case 1:
                if (view == null){
                    view = View.inflate( context, R.layout.layout_item2,null );
                    holder2 = new ViewHolder2();
                    holder2.textView = view.findViewById( R.id.text_title);
                    holder2.img_pic1 = view.findViewById( R.id.img_pic1 );
                    holder2.img_pic2 = view.findViewById( R.id.img_pic2 );
                    holder2.img_pic3 = view.findViewById( R.id.img_pic3 );
                    view.setTag( holder2 );
                }else {
                    holder2 = (ViewHolder2) view.getTag();
                }
                holder2.textView.setText( list.get( i ).getTitle() );
                ImageLoader.getInstance().displayImage( list.get( i ).getThumbnail_pic_s(),holder2.img_pic1);
                ImageLoader.getInstance().displayImage( list.get( i ).getThumbnail_pic_s02(),holder2.img_pic2);
                ImageLoader.getInstance().displayImage( list.get( i ).getThumbnail_pic_s03(),holder2.img_pic3);
                break;
        }
        return view;
    }

    class ViewHolder1{
        TextView textView;
        ImageView imageView;
    }

    class ViewHolder2{
        TextView textView;
        ImageView img_pic1,img_pic2,img_pic3;
    }
}
