package com.com.liu.test;

import com.liu.common.CommonUtility;

import java.util.ArrayList;

/**
 * Created by Leo.Liu on 2015/4/29.
 */
public class CommonTest {

    public static void main(String[] args)
    {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(9);
        arrayList.add(7);

        System.out.println(CommonUtility.sortIndexOfList(arrayList));

    }
}
