package com.bawei.dongyong20191118;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.dongyong20191118.bace.BaceActivity;
import com.bawei.dongyong20191118.bace.BacePresenter;
import com.bawei.dongyong20191118.bean.JsonData;
import com.bawei.dongyong20191118.presenter.PresenterMvp;
import com.google.gson.Gson;

import java.util.HashMap;

public class MainActivity extends BaceActivity {

    private String url="http://172.17.8.100/small/user/v1/login";
    private EditText ename;
    private EditText epass;
    private Button zhu;
    private Button deng;

    @Override
    protected void setCoDing() {

    }

    @Override
    protected void initData() {
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = ename.getText().toString().trim();
                String pwd = epass.getText().toString().trim();
                HashMap<String, String> map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);
                mpresenter.start(url,map);
            }
        });

        zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ZhuActivity.class);
               startActivityForResult(intent,2000);
               // startActivity(intent);
            }
        });

    }

    @Override
    protected void initView() {
          ename=findViewById(R.id.ename);
          epass=findViewById(R.id.epass);
          zhu=findViewById(R.id.zhu);
          deng=findViewById(R.id.deng);
    }

    @Override
    protected BacePresenter initPresenter() {
        return new PresenterMvp();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSccess(String json) {
        JsonData jsonData = new Gson().fromJson(json, JsonData.class);
        String message = jsonData.getMessage();
        String status = jsonData.getStatus();
        JsonData.ResultBean result = jsonData.getResult();
        String headPic = result.getHeadPic();
        String nickName = result.getNickName();
        if(status.equals("0000")){
            //跳转传值
            Intent intent = new Intent(MainActivity.this,ShowActivity.class);
              intent.putExtra("headPic",headPic);
              intent.putExtra("nickName",nickName);
            startActivity(intent);
        }


    }

    @Override
    public void onErrorSccess(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
          if(requestCode==2000&&resultCode==2000){
              String phone = data.getStringExtra("phone");
              String pwd = data.getStringExtra("pwd");
              epass.setText(pwd);
              ename.setText(phone);
          }
    }
}
