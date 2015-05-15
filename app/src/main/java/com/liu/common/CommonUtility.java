package com.liu.common;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

        Collections.sort(list);
        Collections.reverse(list);

        ArrayList<Integer> sortedIndexOfArrayList = new ArrayList<Integer>();

        for ( int i = 0; i < unSortedList.size(); i ++ )
        {
            for ( int j = 0; j < list.size(); j ++ )
            {
                if ( list.get(j) == unSortedList.get(i) )
                {
                    sortedIndexOfArrayList.add( j + 1);
                }
            }
        }

        return sortedIndexOfArrayList;

    }

    //对两张图片进行比较，确定两者重复
    public static boolean distanceBetOMAndOverThre(List<Integer> listA, List<Integer> listB)
    {

        return distanceBetOM( listA, listB) < 10 ? true : false;
    }

    //通过两张图片的OM值，来计算之间的距离
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

//        System.out.println("AllOMlist:" + allOMList.toString());
    }

    //
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

//        System.out.println("allSamePicIndex1:" + allSamePicIndexSet.toString());
//        Log.e("allSamePicIndex2:", allSamePicIndexSet.toString());

        return allSamePicIndexSet;
    }

    //通过计算OM距离，获取最优的图片的序列号
    public static int remSamePic(List<List<Integer>> allPicOMList)
    {

        Map<Integer, Double> allDisBetMap = new HashMap<Integer, Double>();

        for ( int i = 0 ; i < allPicOMList.size(); i ++ )
        {

            List<Integer> tempPicOM = allPicOMList.get(i);

            for ( int j = 0; j < allPicOMList.size(); j ++ )
            {
                if ( i == j )
                {
                    continue;
                }

                if ( allDisBetMap.get(i) == null )
                {
                    allDisBetMap.put(i, distanceBetOM(tempPicOM, allPicOMList.get(j)));
                }
                else
                {
                    allDisBetMap.put(i, allDisBetMap.get(i) + distanceBetOM(tempPicOM, allPicOMList.get(j)));
                }
            }
        }

        Iterator<Integer> iterator = allDisBetMap.keySet().iterator();

        Double maxValue = 0.00;
        int maxValueIndex = 0;

        while( iterator.hasNext() )
        {
            Integer key = iterator.next();

            if ( maxValue == 0.00 || allDisBetMap.get(key) < maxValue)
            {
                maxValueIndex = key.intValue();
                maxValue = allDisBetMap.get(key);
            }

//            System.out.println("Index:" + key + "; value:" + allDisBetMap.get(key));

        }

//        System.out.println(maxValueIndex);

        return maxValueIndex;
    }

    //移除不相同，不重复的图片
    public static List<List<Integer>> removeUnSamePic(Set<Integer> allSamePics, List<List<Integer>> allPicOMList)
    {
        Iterator<Integer> iterator = allSamePics.iterator();

        List<List<Integer>> allSamePicOMlist = new ArrayList<List<Integer>>();

        while ( iterator.hasNext() )
        {
            allSamePicOMlist.add(allPicOMList.get(iterator.next()));
        }

        return allSamePicOMlist;
    }
}
