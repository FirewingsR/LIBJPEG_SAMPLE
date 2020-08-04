package com.ykun.libjpeg_sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yk.libjpeg_sample.libjpeg.JpegUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Bitmap inputBitmap = null;
    private ImageView mNextImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View view) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 2;
        File input = new File(Environment.getExternalStorageDirectory(), "/girl.jpg");
        ImageView preImg = findViewById(R.id.pre);
        mNextImg = findViewById(R.id.next);
        inputBitmap = BitmapFactory.decodeFile(input.getAbsolutePath(), opts);
        preImg.setImageBitmap(inputBitmap);
        JpegUtils.native_Compress(inputBitmap, 70, Environment.getExternalStorageDirectory() + "/girl_jpeg.jpg");
        Toast.makeText(this, "执行完成", Toast.LENGTH_SHORT).show();
        String filePath = Environment.getExternalStorageDirectory() + "/girl_jpeg.jpg";
        mNextImg.setImageBitmap(BitmapFactory.decodeFile(filePath, opts));
    }

}
