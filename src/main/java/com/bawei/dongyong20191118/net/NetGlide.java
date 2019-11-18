package com.bawei.dongyong20191118.net;

import android.widget.ImageView;

import com.bawei.dongyong20191118.R;
import com.bawei.dongyong20191118.app.AppUrl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 11:40
 * @Description:
 */
public class NetGlide {

    public  static  void logUrl(String url,ImageView imageView){
             Glide.with(AppUrl.context)
                     .load(url)
                     .placeholder(R.drawable.ic_launcher_foreground)
                     .error(R.drawable.ic_launcher_background)
                     .diskCacheStrategy(DiskCacheStrategy.NONE)
                     .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                     .into(imageView);
    }


}
