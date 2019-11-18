package com.bawei.dongyong20191118.bace;

import com.bawei.dongyong20191118.contates.Icontates;

import java.lang.ref.WeakReference;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 9:10
 * @Description:
 */
public abstract class BacePresenter <V  extends Icontates.Iview> implements Icontates.Ipresenter{
    public BacePresenter() {
        initData();
    }

    protected abstract void initData();
    public WeakReference<V>weakReference;
    //绑定
    protected  void attch(V v){
        weakReference=new WeakReference<>(v);
    }
    //解绑
    protected  void deAttch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    protected V getView(){
        return weakReference.get();
    }


}
