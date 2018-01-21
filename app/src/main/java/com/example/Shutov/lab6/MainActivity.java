package com.example.Shutov.lab6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint paint;
        Path path;

        public DrawView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.GRAY);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            path = new Path();
        }

        @Override
        protected void onDraw(Canvas canvas) {

            float mid = getWidth() / 2;
            float min = Math.min(getWidth()/2, getHeight());
            float half = min/2;
            float width = getWidth();
            float height = getHeight();


            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            // circle
            path.moveTo(width / 2, height / 5);

            // Upper left path
            path.cubicTo(5 * width / 14, 0,
                    0, height / 15,
                    width / 28, 2 * height / 5);

            // Lower left path
            path.cubicTo(width / 14, 2 * height / 3,
                    3 * width / 7, 5 * height / 6,
                    width / 2, height);

            // Lower right path
            path.cubicTo(4 * width / 7, 5 * height / 6,
                    13 * width / 14, 2 * height / 3,
                    27 * width / 28, 2 * height / 5);

            // Upper right path
            path.cubicTo(width, height / 15,
                    9 * width / 14, 0,
                    width / 2, height / 5);

            paint.setColor(Color.RED);
            paint.setStyle(Style.FILL);
            canvas.drawPath(path, paint);

            // star
            mid = mid - half;
            path.reset();
            paint.setColor(Color.rgb(220,24,150));
            // top left
            path.moveTo(mid + half * 0.5f, half * 0.84f + 220f);
            // top right
            path.lineTo(mid + half * 1.5f, half * 0.84f + 220f);
            // bottom left
            path.lineTo(mid + half * 0.68f, half * 1.45f + 220f);
            // top tip
            path.lineTo(mid + half * 1.0f, half * 0.5f + 220f);
            // bottom right
            path.lineTo(mid + half * 1.32f, half * 1.45f + 220f);
            // top left
            path.lineTo(mid + half * 0.5f, half * 0.84f + 220f);
            canvas.drawPath(path, paint);
            path.close();

            super.onDraw(canvas);
        }
    }

}
