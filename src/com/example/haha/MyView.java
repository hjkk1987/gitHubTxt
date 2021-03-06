package com.example.haha;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/*
 * File��MyView.java
 *
 * Copyright (C) 2015 haha Project
 * Date��2015��4��30�� ����3:20:10
 * All Rights SXHL(New Space) Corporation Reserved.
 * http://www.at-et.cn
 *
 */

/**
 * @description:
 * 
 * @author: HuJun
 * @date: 2015��4��30�� ����3:20:10
 */

public class MyView extends View {
	private Paint paint = null;

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStrokeWidth(4.0f);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		canvas.translate(canvas.getWidth() / 2, 200); // 将位置移动画纸的坐标点:150,150
		canvas.drawCircle(0, 0, 100, paint); // 画圆圈

		// 使用path绘制路径文字
		canvas.save();
		canvas.translate(-75, -75);
		Path path = new Path();
		path.addArc(new RectF(0, 0, 150, 150), -180, 180);
		Paint citePaint = new Paint(paint);
		citePaint.setTextSize(14);
		citePaint.setStrokeWidth(1);
		canvas.drawTextOnPath("http://www.android777.com", path, 28, 0,
				citePaint);
		canvas.restore();

		Paint tmpPaint = new Paint(paint); // 小刻度画笔对象
		tmpPaint.setStrokeWidth(1);

		float y = 100;
		int count = 60; // 总刻度数

		for (int i = 0; i < count; i++) {
			if (i % 5 == 0) {
				canvas.drawLine(0f, y, 0, y + 12f, paint);
				canvas.drawText(String.valueOf(i / 5 + 1), -4f, y + 25f,
						tmpPaint);

			} else {
				canvas.drawLine(0f, y, 0f, y + 5f, tmpPaint);
			}
			canvas.rotate(360 / count, 0f, 0f); // 旋转画纸
		}

		// 绘制指针
		tmpPaint.setColor(Color.GRAY);
		tmpPaint.setStrokeWidth(4);
		canvas.drawCircle(0, 0, 7, tmpPaint);
		tmpPaint.setStyle(Style.FILL);
		tmpPaint.setColor(Color.YELLOW);
		canvas.drawCircle(0, 0, 5, tmpPaint);
		canvas.drawLine(0, 10, 0, -65, paint);
		
	}

}
