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
        public static List<Integer> sortIndexOfList( ArrayList<Integer> list)
        {
            if ( 0 == list.size())
            {
                return null;
            }

            ArrayList<Integer> unSortedList = new ArrayList<Integer>();
            unSortedList = (ArrayList<Integer>)list.clone();

            Collections.sort(list);
            Collections.reverse(list);

            System.out.println(list);
            System.out.println(unSortedList);

            ArrayList<Integer> sortedIndexOfArrayList = new ArrayList<Integer>();

//
//        for( int i = 0; i < unSortedList.size(); i ++ )
//        {
//
//            System.out.println(unSortedList.get(i) + ", ");
//
//            for ( int j = 0; j < list.size(); j ++ )
//            {
//
//                System.out.print(list.get(j) + ", ");
//
//                if ( list.get(j) == unSortedList.get(i) )
//                {
//                    System.out.println(list.get(j));
//                }
//            }
//            System.out.println();
//
//        }

            return sortedIndexOfArrayList;

    }
}
