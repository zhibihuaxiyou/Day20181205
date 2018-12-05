package com.bwie.day20181205.fragment;

import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bwie.day20181205.MainActivity;
import com.bwie.day20181205.R;


/**
 * author：张腾
 * date：2018/12/5
 */
public class MyCardFragment extends Fragment{

    private Button mBtnExit;
    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_mycard, container, false);
        mImageView = view.findViewById(R.id.imageView);
        mBtnExit = view.findViewById(R.id.btn_exit);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        generationQrCode();
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences config = getActivity().getSharedPreferences("config", 0);
                SharedPreferences.Editor editor = config.edit();
                editor.remove("AUTO_ISCHECK");
                editor.commit();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void generationQrCode() {

    }

}
