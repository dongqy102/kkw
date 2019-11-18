package com.bawei.dongyong20191118;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dongyong20191118.net.NetGlide;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class ShowActivity extends AppCompatActivity {
     //实例化
     private String url="http://172.17.8.100/small/user/v1/login";

    private ImageView imgg;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        //获取传值
        Intent intent = getIntent();
        String headPic = intent.getStringExtra("headPic");
        String nickName = intent.getStringExtra("nickName");
       NetGlide.logUrl(headPic,imgg);
//        Glide.with(imgg)
//                .load(url)
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .error(R.drawable.ic_launcher_background)
//                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
//                .into(imgg);
        text.setText(nickName);
    }

    private void initView() {
        imgg = (ImageView) findViewById(R.id.imgg);
        text = (TextView) findViewById(R.id.text);
    }
}
