package com.example.blood.boatfight;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class MainTwoActivity extends View {

    Paint paint = new Paint();
    Paint paintx = new Paint();
    Paint painto = new Paint();
    Paint painto1 = new Paint();
    float[][] midx = new float[3][3];
    float[][] midy = new float[3][3];
    Context ctx;
    float canvasSide, cellSide;
    boolean touchEnabled = true;
    int cnt = 0;
    int[] time = {1000};
    public static int[][] a = new int[3][3];
    public static int turn = 0;

    public void init() {
        cnt = 0;
        time[0] = 1000;
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, r.getDisplayMetrics());
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                a[row][col] = 0;
                midx[row][col] = ((px / 6) + (col * (px / 3)));
                midy[row][col] = ((px / 6) + (row * (px / 3)));
            }
        }
        float px2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, r.getDisplayMetrics());
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                a[row][col] = 0;
                midx[row][col] = ((px2 / 6) + (col * (px2 / 3)));
                midy[row][col] = ((px2 / 6) + (row * (px2 / 3)));
            }
        }
        touchEnabled = true;
        turn = 0;
    }

    public MainTwoActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);

       /* paintx.setStrokeWidth(15f);
        paintx.setColor(Color.CYAN);
        paintx.setStyle(Paint.Style.STROKE);
        paintx.setStrokeJoin(Paint.Join.ROUND);

        painto.setColor(Color.CYAN);
        painto.setStyle(Paint.Style.FILL);

        painto1.setColor(Color.rgb(57,84,166));
        painto1.setStyle(Paint.Style.FILL);*/


        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Resources r = getResources();
        float pxi = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 410, r.getDisplayMetrics());
        canvasSide = pxi;
        cellSide = canvasSide / 3;
        canvas.drawLine(cellSide, 0, cellSide, canvasSide, paint);
        canvas.drawLine(2 * cellSide, 0, 2 * cellSide, canvasSide, paint);
        canvas.drawLine(0, cellSide, canvasSide, cellSide, paint);
        canvas.drawLine(0, 2 * cellSide, canvasSide, 2 * cellSide, paint);

        float pxi2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 510, r.getDisplayMetrics());
        canvasSide = pxi2;
        cellSide = canvasSide / 3;
        canvas.drawLine(cellSide, 0, cellSide, canvasSide, paint);
        canvas.drawLine(2 * cellSide, 0, 2 * cellSide, canvasSide, paint);
        canvas.drawLine(0, cellSide, canvasSide, cellSide, paint);
        canvas.drawLine(0, 3 * cellSide, canvasSide, 3 * cellSide, paint);

        /*for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (a[row][col] == 1) {
                    canvas.drawLine((midx[row][col] - ((4 * cellSide) / 11)), (midy[row][col] - ((4 * cellSide) / 11)), (midx[row][col] + ((4 * cellSide) / 11)), (midy[row][col] + ((4 * cellSide) / 11)), paintx);
                    canvas.drawLine((midx[row][col] + ((4 * cellSide) / 11)), (midy[row][col] - ((4 * cellSide) / 11)), (midx[row][col] - ((4 * cellSide) / 11)), (midy[row][col] + ((4 * cellSide) / 11)), paintx);
                } else if (a[row][col] == 2) {
                    canvas.drawCircle(midx[row][col], midy[row][col], (4 * cellSide) / 11, painto);
                    canvas.drawCircle(midx[row][col], midy[row][col], (13 * cellSide) / 44, painto1);
                }
            }
        }*/
    }

}
