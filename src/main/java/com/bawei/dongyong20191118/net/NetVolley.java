package com.bawei.dongyong20191118.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.dongyong20191118.app.AppUrl;
import com.bawei.dongyong20191118.contates.Icontates;

import java.util.Map;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 10:26
 * @Description:
 */
public class NetVolley {
    static  NetVolley netVolley=new NetVolley();

    public static NetVolley getInstance() {
        return netVolley;
    }

    private NetVolley() {
    }

    RequestQueue requestQueue= Volley.newRequestQueue(AppUrl.context);

    public  interface MyCallBack{
        void onSccess(String json);
        void onError(String error);
    }


    public  void  doGet(String temUrl, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(temUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               myCallBack.onSccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 myCallBack.onError(error.getMessage());
            }
        });
       requestQueue.add(stringRequest);
    }
    public  void doPost(String temUel, final Map<String ,String>map, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, temUel, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 myCallBack.onSccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 myCallBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map != null) {
                    return map;
                }
                return super.getParams();
            }
        };
        requestQueue.add(stringRequest);
    }



}
