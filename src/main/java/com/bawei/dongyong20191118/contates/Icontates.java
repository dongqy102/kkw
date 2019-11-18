package com.bawei.dongyong20191118.contates;

import java.util.Map;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 9:07
 * @Description:
 */
public interface Icontates {

    interface MyCallBack{
        void onSccess(String json);
        void onErrorSccess(String error);
    }
    interface  Imodel{
        void  getInfo(String url,MyCallBack myCallBack);
        void  postInfo(String url, Map<String,String>map, MyCallBack myCallBack);
    }
    interface Iview{
        void onSccess(String json);
        void onErrorSccess(String error);
    }
    interface Ipresenter{
        void start(String url,Map<String,String>map);
    }


}
