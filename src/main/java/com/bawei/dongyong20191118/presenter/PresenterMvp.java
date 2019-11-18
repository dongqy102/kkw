package com.bawei.dongyong20191118.presenter;

import com.bawei.dongyong20191118.bace.BaceActivity;
import com.bawei.dongyong20191118.bace.BacePresenter;
import com.bawei.dongyong20191118.contates.Icontates;
import com.bawei.dongyong20191118.model.ModelMvp;

import java.util.Map;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 10:33
 * @Description:
 */
public class PresenterMvp extends BacePresenter {

    public ModelMvp modelMvp;
    @Override
    protected void initData() {
         modelMvp=new ModelMvp();
    }

    @Override
    public void start(String url, Map<String, String> map) {
      modelMvp.postInfo(url, map, new Icontates.MyCallBack() {
          @Override
          public void onSccess(String json) {
              getView().onSccess(json);
          }

          @Override
          public void onErrorSccess(String error) {
              getView().onErrorSccess(error);
          }
      });
    }
}
