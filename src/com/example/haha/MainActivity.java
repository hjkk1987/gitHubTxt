package com.example.haha;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv_img = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		widget_init();
	}

	/**
	 * @description:
	 * 
	 * @throws:
	 * @author: HuJun
	 * @date: 2015��4��30�� ����3:33:14
	 */
	private void widget_init() {
		iv_img = (ImageView) findViewById(R.id.iv_img);

		// TODO Auto-generated method stub
		Bitmap baseBitmap = Bitmap.createBitmap(800, 800,
				Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(baseBitmap);
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(4.0f);
		paint.setStyle(Style.STROKE);//绘制空心圆与实心圆
		canvas.drawLine(0, 0, 300, 100, paint);
		paint.setAntiAlias(false);
		canvas.drawCircle(100, 100, 50, paint);
		iv_img.setImageBitmap(baseBitmap);

	}
}
