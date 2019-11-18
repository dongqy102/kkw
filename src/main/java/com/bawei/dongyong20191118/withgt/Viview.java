package com.bawei.dongyong20191118.withgt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.YuvImage;
import android.util.AttributeSet;
import android.view.View;

/**
 * @auther:董青勇
 * @Date: 2019/11/18
 * @Time: 11:09
 * @Description:
 */
public class Viview extends View {

    private  int wight;
    private  int hight;
     private Paint linPaint;
     private Paint textPaint;
     private Paint pointPaint;
     private Context context;


    public Viview(Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }

    private void initView() {

        linPaint=new Paint();
        linPaint.setStyle(Paint.Style.FILL);
        linPaint.setColor(Color.GREEN);
        linPaint.setAntiAlias(true);
        linPaint.setStrokeWidth((float)2);

        textPaint=new Paint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.GREEN);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
       pointPaint =new Paint();
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setColor(Color.GREEN);
        pointPaint.setAntiAlias(true);
        pointPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        wight=MeasureSpec.getSize(widthMeasureSpec);
        hight=MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(wight,hight);
    }

    float x=0;
    float y =0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
          Canvas.EdgeType.values();
          canvas.translate(x,y-50);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }
}
