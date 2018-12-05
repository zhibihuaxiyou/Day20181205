package com.bwie.day20181205;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * author：张腾
 * date：2018/12/5
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .diskCache(new UnlimitedDiskCache(new File(getCacheDir().getAbsolutePath())))
                .diskCacheSize(1024*10)
                .build();
        ImageLoader.getInstance().init( configuration );
    }
}
