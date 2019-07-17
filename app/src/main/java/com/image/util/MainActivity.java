package com.image.util;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView image1,image2,image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        initData();
    }
    private void initData(){
        Bitmap bitmap = AssetsUtils.getImageFromAssetsFile(this,"timg.jpg");
        List<ImagePiece> bitmaps = ImageSplitter.split(bitmap,1,3);
        if (bitmaps != null && bitmaps.size() > 0){
            for (int i = 0; i < bitmaps.size(); i++){
                ImagePiece imagePiece = bitmaps.get(i);
                switch (i){
                    case 0:
                        image1.setImageBitmap(imagePiece.bitmap);
                        break;
                    case 1:
                        image2.setImageBitmap(imagePiece.bitmap);
                        break;
                    case 2:
                        image3.setImageBitmap(imagePiece.bitmap);
                        break;
                }
            }
        }
    }
}
