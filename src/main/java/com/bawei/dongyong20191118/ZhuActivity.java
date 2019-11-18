package com.bawei.dongyong20191118;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.dongyong20191118.bace.BaceActivity;
import com.bawei.dongyong20191118.bace.BacePresenter;
import com.bawei.dongyong20191118.bean.JsonBean;
import com.bawei.dongyong20191118.presenter.PresenterMvp;
import com.google.gson.Gson;

import java.util.HashMap;

public class ZhuActivity extends BaceActivity {

     private  String url="http://172.17.8.100/small/user/v1/register";
    private EditText ename;
    private EditText epass;
    private Button zhu;

    @Override
    protected void setCoDing() {

    }

    @Override
    protected void initData() {
      zhu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String phone = ename.getText().toString().trim();
              String pwd = epass.getText().toString().trim();
              HashMap<String, String> map = new HashMap<>();
              map.put("phone",phone);
              map.put("pwd",pwd);
              mpresenter.start(url,map);

               //startActivity(new Intent(ZhuActivity.this,MainActivity.class));
          }
      });


    }

    @Override
    protected void initView() {
         ename=findViewById(R.id.ename);
         epass=findViewById(R.id.epass);
         zhu=findViewById(R.id.zhu);
    }

    @Override
    protected BacePresenter initPresenter() {
        return new PresenterMvp();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_zhu;
    }

    @Override
    public void onSccess(String json) {


        JsonBean jsonBean = new Gson().fromJson(json, JsonBean.class);
        String message = jsonBean.getMessage();
        String status = jsonBean.getStatus();
        if(status.equals("0000")||status.equals("1001")){
            Intent intent = new Intent(ZhuActivity.this,MainActivity.class);
            intent.putExtra("phone",ename.getText().toString().trim());
            intent.putExtra("pwd",epass.getText().toString().trim());
            setResult(2000,intent);
            finish();
           // startActivity(intent);
        }


    }

    @Override
    public void onErrorSccess(String error) {

    }


}
