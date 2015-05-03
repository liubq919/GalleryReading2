package com.liu.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hilcg on 2015/4/9.
 */
public class CommonUtility {

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

    public static List<Integer> sortIndexOfList( ArrayList<Integer> list)
    {
        if ( 0 == list.size())
        {
            return null;
        }

        ArrayList<Integer> unSortedList = new ArrayList<Integer>();
        unSortedList = (ArrayList<Integer>)list.clone();
        System.out.println( "j:" + unSortedList);

        Collections.sort(list);
        Collections.reverse(list);

        System.out.println( "i:" + list);

        ArrayList<Integer> sortedIndexOfArrayList = new ArrayList<Integer>();

        for ( int i = 0; i < unSortedList.size(); i ++ )
        {
            for ( int j = 0; j < list.size(); j ++ )
            {
                if ( list.get(j) == unSortedList.get(i) )
                {
//                    System.out.println("i: " + i + "; " + "j: " + j + ", Current Value:" + list.get(i));

                    sortedIndexOfArrayList.add( j + 1);
                }
            }
        }

        return sortedIndexOfArrayList;

    }
}
