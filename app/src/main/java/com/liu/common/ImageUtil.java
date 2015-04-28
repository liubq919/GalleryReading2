package com.liu.common;

/**
 * Created by hilcg on 2015/4/21.
 */

public class ImageUtil {

    public static int getBrightness(int color) {
        int r = (color & 0x00ff0000) >> 16;
        int g = (color & 0x0000ff00) >> 8;
        int b = (color & 0x000000ff);
        int y = Math.round(0.3f*r+0.59f*g+0.11f*b);
        y = y < 0 ? 0 : y;
        y = y > 255 ? 255 : y;
        return y;
    }
}
