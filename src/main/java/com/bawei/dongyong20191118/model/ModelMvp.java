package com.bawei.dongyong20191118.model;

import com.bawei.dongyong20191118.contates.Icontates;
import com.bawei.dongyong20191118.net.NetVolley;

import java.util.Map;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 10:33
 * @Description:
 */
public class ModelMvp implements Icontates.Imodel {
    @Override
    public void getInfo(String url, Icontates.MyCallBack myCallBack) {

    }

    @Override
    public void postInfo(String url, Map<String, String> map, final Icontates.MyCallBack myCallBack) {
        NetVolley.getInstance().doPost(url, map, new NetVolley.MyCallBack() {
            @Override
            public void onSccess(String json) {
                myCallBack.onSccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onErrorSccess(error);
            }
        });
    }
}
