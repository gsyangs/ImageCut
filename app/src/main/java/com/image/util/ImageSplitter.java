package com.image.util;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:create by ys
 * 时间:2019/7/17 15
 * 邮箱 894417048@qq.com
 */
public class ImageSplitter {

    public static List<ImagePiece> split(Bitmap bitmap, int xPiece, int yPiece) {

        List<ImagePiece> pieces = new ArrayList<>(xPiece * yPiece);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int pieceWidth = width / xPiece;
        int pieceHeight = height / yPiece;
        for (int i = 0; i < yPiece; i++) {//横向
            for (int j = 0; j < xPiece; j++) {//纵向
                ImagePiece piece = new ImagePiece();
                piece.index = j + i * xPiece;
                int xValue = j * pieceWidth;
                int yValue = i * pieceHeight;
                piece.bitmap = Bitmap.createBitmap(bitmap, xValue, yValue,
                        pieceWidth, pieceHeight);
                pieces.add(piece);
            }
        }

        return pieces;
    }

}
