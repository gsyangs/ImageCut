package com.image.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:create by ys
 * 时间:2019/7/17 15
 * 邮箱 894417048@qq.com
 */
public class AssetsUtils {

    /**
     * 从Assets中读取图片
     */
    public static Bitmap getImageFromAssetsFile(Context context ,String fileName)
    {
        Bitmap image = null;
        AssetManager am = context.getResources().getAssets();
        try
        {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }
}
