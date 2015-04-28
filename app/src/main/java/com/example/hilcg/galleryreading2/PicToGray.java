package com.example.hilcg.galleryreading2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.liu.common.CommonUtility;

/**
 * Created by hilcg on 2015/4/9.
 */
public class PicToGray extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic_to_gray);

        Button btnStartToGray = (Button)findViewById(R.id.button_start_to_gray);
        final ImageView imageView = (ImageView)findViewById(R.id.pic_to_gray);

        /**
        imageView.setDrawingCacheEnabled(true);
        Bitmap obmp = Bitmap.createBitmap(imageView.getDrawingCache());
        final int width = obmp.getWidth();
        final int height = obmp.getHeight();
        imageView.setDrawingCacheEnabled(false);
        **/
        Drawable drawable = getResources().getDrawable(R.drawable.avatar);
        BitmapDrawable bd = (BitmapDrawable)drawable;
        final Bitmap bitmap = bd.getBitmap();

        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();

        btnStartToGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PicToGray.this, "图片属性: width: " + width + "; height: " + height + "GetPixel():" + bitmap.getPixel(100, 100), Toast.LENGTH_SHORT).show();
                imageView.setImageBitmap(CommonUtility.bitmap2Gray(bitmap));
            }
        });
    }
}
