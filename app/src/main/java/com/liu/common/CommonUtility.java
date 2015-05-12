package com.liu.common;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hilcg on 2015/4/9.
 */
public class CommonUtility {

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

    public boolean distanceBetOMAndOverThre(List<Integer> listA, List<Integer> listB)
    {
        double disBetOM = 0;

        for ( int i = 0; i < listA.size(); i ++ )
        {
            disBetOM = disBetOM + Math.pow((listA.get(i) - listB.get(i)), 2);
        }

        return Math.sqrt(disBetOM) >  2 ? true : false;
    }

    public static double distanceBetOM(List<Integer> listA, List<Integer> listB)
    {
        double disBetOM = 0;

        for ( int i = 0; i < listA.size(); i ++ )
        {
            disBetOM = disBetOM + Math.pow((listA.get(i) - listB.get(i)), 2);
        }

        return Math.sqrt(disBetOM);
    }


    public static void compareOMOfAllPic(List<List<Integer>> allPicOMList)
    {

        List<List<Double>> allOMList = new ArrayList<List<Double>>();

        for ( int i = 0; i < allPicOMList.size(); i ++ )
        {
            ArrayList listTemp = new ArrayList<Double>();

            for ( int j = 0; j < allPicOMList.size(); j ++ )
            {
                if ( i == j )
                {
                    continue;
                }

                double distance = distanceBetOM(allPicOMList.get(i), allPicOMList.get(j));

                listTemp.add(distance);
            }

            allOMList.add(listTemp);
        }

        Log.e("AllOMlist", allOMList.toString());
    }

}
