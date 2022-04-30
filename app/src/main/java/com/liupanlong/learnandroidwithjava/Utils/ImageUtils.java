package com.liupanlong.learnandroidwithjava.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import java.io.IOException;

public class ImageUtils {
    public static Bitmap getBitmapFormUri(Context appContext, Uri uri){
        Context applicationContext = appContext.getApplicationContext();
        Bitmap bitmap = null;
        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                ImageDecoder.Source source = ImageDecoder.createSource(applicationContext.getContentResolver(), uri);
                bitmap = ImageDecoder.decodeBitmap(source);
            } else {
                bitmap = MediaStore.Images.Media.getBitmap(applicationContext.getContentResolver(), uri);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
