package com.liu.common;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static boolean distanceBetOMAndOverThre(List<Integer> listA, List<Integer> listB)
    {
        double disBetOM = 0;

        for ( int i = 0; i < listA.size(); i ++ )
        {
            disBetOM = disBetOM + Math.pow((listA.get(i) - listB.get(i)), 2);
        }

        return Math.sqrt(disBetOM) < 10 ? true : false;
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

            for ( int j = i + 1 ; j < allPicOMList.size(); j ++ )
            {
                if ( i == j )
                {
                    continue;
                }

                double distance = distanceBetOM(allPicOMList.get(i), allPicOMList.get(j));

                listTemp.add(distance);

                allOMList.add(listTemp);
            }
        }

        System.out.println("AllOMlist:" + allOMList.toString());
    }

    public static Set<Integer> isTheSamePic(List<List<Integer>> allPicOMList)
    {

        Set<Integer> allSamePicIndexSet = new HashSet<Integer>();

        for ( int i = 0; i < allPicOMList.size(); i ++ )
        {

            for ( int j = i + 1 ; j < allPicOMList.size(); j ++ )
            {

                if ( distanceBetOMAndOverThre( allPicOMList.get(i), allPicOMList.get(j)) )
                {
                    allSamePicIndexSet.add(i);
                    allSamePicIndexSet.add(j);
                }

            }
        }

        System.out.println("allSamePicIndex1:" + allSamePicIndexSet.toString());
        Log.e("allSamePicIndex2:", allSamePicIndexSet.toString());

        return allSamePicIndexSet;
    }
}
