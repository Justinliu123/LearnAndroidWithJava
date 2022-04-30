package com.liupanlong.learnandroidwithjava.activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.liupanlong.learnandroidwithjava.R;
import com.liupanlong.learnandroidwithjava.Utils.ImageUtils;

public class ChooseImage extends AppCompatActivity {
    // 选择一个图片的回调launcher
    private ActivityResultLauncher<Intent> launcher = null;

    private ImageView showImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result -> {
            if(result == null) {
                return;
            }
            if(result.getResultCode() == Activity.RESULT_OK) {
                Bitmap bitmap = null;
          /*      try {
                    bitmap = ImageUtils.getBitmap(new FileInputStream(new File(result.getData().getData().getPath())));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }*/
                bitmap = ImageUtils.getBitmapFormUri(this, result.getData().getData());
                showImage.setImageBitmap(bitmap);
            }
        }));

        showImage = findViewById(R.id.showImage);

        Button chooseAImageButton = findViewById(R.id.chooseAImage);
        chooseAImageButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            Intent chooser = Intent.createChooser(intent, "选择一张图片");
            launcher.launch(chooser);
        });
    }
}