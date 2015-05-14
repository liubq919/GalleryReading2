package com.liu.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hilcg on 2015/4/21.
 */

public class ImageUtil {

    //灰度化图片
    public static Bitmap bitmap2Gray(Bitmap bmSrc)
    {
        int width, height;
        height = bmSrc.getHeight();
        width = bmSrc.getWidth();
        Bitmap bmpGray = null;
        bmpGray = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bmpGray);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmSrc, 0, 0, paint);

        return bmpGray;
    }

    //获取某一像素点的亮度值
    public static int getBrightness(int color)
    {
        int r = (color & 0x00ff0000) >> 16;
        int g = (color & 0x0000ff00) >> 8;
        int b = (color & 0x000000ff);
        int y = Math.round(0.3f*r+0.59f*g+0.11f*b);
        y = y < 0 ? 0 : y;
        y = y > 255 ? 255 : y;
        return y;
    }

    //获取图片的OM值
    public static List<Integer> getOMOfPic(Bitmap bitmap)
    {
        if ( bitmap == null )
        {
            return new ArrayList<>();
        }

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Bitmap bitMapToGray = ImageUtil.bitmap2Gray(bitmap);

        ArrayList<Integer> brightVauleList = new ArrayList<Integer>();

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

        brightVauleList.add(iPart / allPixel);

        return CommonUtility.sortIndexOfList(brightVauleList);
    }

    public static int getBitmapSize(Bitmap bitmap)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){    //API 19
            return bitmap.getAllocationByteCount();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1){//API 12
            return bitmap.getByteCount();
        }

        return bitmap.getRowBytes() * bitmap.getHeight();                //earlier version
    }
}
