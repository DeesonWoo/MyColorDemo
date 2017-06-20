package com.example.deeson.mycolor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * @author Deeson
 */
public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    ImageView iv_photo;
    float mHue = 0.0f;
    float mSaturation = 1f;
    float mLum = 1f;
    float MID_VALUE;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        SeekBar barHue = (SeekBar) findViewById(R.id.seekbarHue);
        SeekBar barSaturation = (SeekBar) findViewById(R.id.seekbarSaturation);
        SeekBar barLum = (SeekBar) findViewById(R.id.seekbarLum);
        MID_VALUE = barHue.getMax() * 1.0F / 2;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iv_model0);
        barHue.setOnSeekBarChangeListener(this);
        barSaturation.setOnSeekBarChangeListener(this);
        barLum.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbarHue:
                mHue = (progress - MID_VALUE) * 1.0F / MID_VALUE * 180;
                break;
            case R.id.seekbarSaturation:
                mSaturation = progress * 1.0F / MID_VALUE;
                break;
            case R.id.seekbarLum:
                mLum = progress * 1.0F / MID_VALUE;
                break;
        }
        iv_photo.setImageBitmap(ImageHelper.handleImageEffect(bitmap, mHue, mSaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
