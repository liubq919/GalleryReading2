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
import com.liu.common.ImageUtil;

import java.util.ArrayList;

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

        int color = bitmap.getPixel(0, 0);
        final int brightnessValue = ImageUtil.getBrightness(color);

        Bitmap bitMapToGray = CommonUtility.bitmap2Gray(bitmap);

        final ArrayList<Integer> brightVauleList = new ArrayList<>();

        int allPixel = ( width / 3 ) * ( height / 3);

        // Part A
        int aPart = 0;
        for ( int x = 0 ; x <= width / 3 ; x ++ )
        {
            for ( int y = 0 ; y <= height / 3; y++ )
            {
                aPart = aPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }
        brightVauleList.add( aPart / allPixel);

        final int a = aPart;

        // Part B
        int bPart = 0;
        for ( int x = width / 3; x <= ( width * 2 ) / 3; x ++ )
        {
            for ( int y = 0 ; y <= height / 3; y++ )
            {
                bPart = bPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }
        brightVauleList.add( bPart / allPixel);

        final int b = bPart;

        // Part C
        int cPart = 0;
        for ( int x = ( width * 2 ) / 3; x < width ; x ++ )
        {
            for ( int y = 0 ; y <= height / 3; y++ )
            {
                cPart = cPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }

        brightVauleList.add( cPart / allPixel);

        // Part D
        int dPart = 0;
        for ( int x = 0; x <= width / 3 ; x ++ )
        {
            for ( int y = height / 3 ; y <= ( height / 3 ) * 2; y++ )
            {
                dPart = dPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }

        brightVauleList.add( dPart / allPixel);

        // Part E
        int ePart = 0;
        for ( int x = width / 3; x <= ( width * 2 ) / 3; x ++ )
        {
            for ( int y = height / 3 ; y <= ( height / 3 ) * 2; y++ )
            {
                ePart = ePart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }

        brightVauleList.add( ePart / allPixel);

        // Part F
        int fPart = 0;
        for ( int x = ( width * 2 ) / 3; x < width ; x ++ )
        {
            for ( int y = height / 3 ; y <= ( height / 3 ) * 2; y++ )
            {
                fPart = fPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }

        brightVauleList.add( fPart / allPixel);

        // Part G
        int gPart = 0;
        for ( int x = 0 ; x <= width / 3 ; x ++ )
        {
            for ( int y = ( height / 3 ) * 2; y < height ; y++ )
            {
                gPart = gPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }

        brightVauleList.add( gPart / allPixel);

        // Part H
        int hPart = 0;
        for ( int x = width / 3; x <= ( width * 2 ) / 3; x ++ )
        {
            for ( int y = ( height / 3 ) * 2; y < height ; y++ )
            {
                hPart = hPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }

        brightVauleList.add( hPart / allPixel);

        // Part I
        int iPart = 0;
        for ( int x = ( width * 2 ) / 3; x < width ; x ++ )
        {
            for ( int y = ( height / 3 ) * 2; y < height ; y++ )
            {
                iPart = iPart + ImageUtil.getBrightness(bitMapToGray.getPixel(x,y));
            }
        }

        brightVauleList.add( iPart / allPixel );

        btnStartToGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(PicToGray.this, "图片属性: width: " + width + "; height: " + height + "a2:" + a2, Toast.LENGTH_SHORT).show();

//                Toast.makeText(PicToGray.this, "a:" + a + ";b:" + b, Toast.LENGTH_LONG).show();

                Toast.makeText(PicToGray.this, "brightVauleList:" + CommonUtility.sortIndexOfList(brightVauleList), Toast.LENGTH_LONG).show();

                imageView.setImageBitmap(CommonUtility.bitmap2Gray(bitmap));
            }
        });
    }
}
