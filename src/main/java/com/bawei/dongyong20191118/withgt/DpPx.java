package com.bawei.dongyong20191118.withgt;

import android.content.Context;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 11:04
 * @Description:
 */
public class DpPx {

    //dp转px
    public  static int dpTOpx(Context context, int DpTOpx){
        float density = context.getResources().getDisplayMetrics().density;
        int pxdp = (int) (DpTOpx * density + 0.5);
        return pxdp;
    }
    //px转dp
    public  static int pxTodp(Context context, int pxTodp){
        float density = context.getResources().getDisplayMetrics().density;
        int dppx = (int) (pxTodp / density + 0.5);
        return dppx;
    }

}
