package com.example.hilcg.galleryreading2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_IMAGE = 2;

    private ArrayList<String> mSelectPath;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.image_view_1);
        imageView2 = (ImageView) findViewById(R.id.image_view_2);
        imageView3 = (ImageView) findViewById(R.id.image_view_3);
        imageView4 = (ImageView) findViewById(R.id.image_view_4);
        imageView5 = (ImageView) findViewById(R.id.image_view_5);
        imageView6 = (ImageView) findViewById(R.id.image_view_6);
        imageView7 = (ImageView) findViewById(R.id.image_view_7);
        imageView8 = (ImageView) findViewById(R.id.image_view_8);
        imageView9 = (ImageView) findViewById(R.id.image_view_9);

        /**
        btnToGray = (Button)findViewById(R.id.btn_to_gray);
        btnToGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "即将转入灰度化页面！", Toast.LENGTH_SHORT).show();

                Intent intentToPicGray = new Intent(MainActivity.this, PicToGray.class);
                startActivity(intentToPicGray);
            }
        });
        **/

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedMode = MultiImageSelectorActivity.MODE_MULTI;

                Intent intent = new Intent(MainActivity.this, MultiImageSelectorActivity.class);
                // 是否显示拍摄图片
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, false);
                // 最大可选择图片数量
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 9);
                // 选择模式
                intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, selectedMode);
                // 默认选择
                if (mSelectPath != null && mSelectPath.size() > 0) {
                    intent.putExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, mSelectPath);
                }
                startActivityForResult(intent, REQUEST_IMAGE);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK && data != null) {

            mSelectPath = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);

            // Now we need to set the GUI ImageView data with data read from the picked file.
            if ( mSelectPath.get(0) != null )
            {
                imageView1.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(0) ));
            }
            if ( mSelectPath.get(1) != null )
            {
                imageView2.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(1) ));
            }
            if ( mSelectPath.get(2) != null )
            {
                imageView3.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(2) ));
            }
            if ( mSelectPath.get(3) != null )
            {
                imageView4.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(3) ));
            }
            if ( mSelectPath.get(4) != null )
            {
                imageView5.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(4) ));
            }
            if ( mSelectPath.get(5) != null )
            {
                imageView6.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(5) ));
            }
            if ( mSelectPath.get(6) != null )
            {
                imageView7.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(6) ));
            }
            if ( mSelectPath.get(7) != null )
            {
                imageView8.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(7) ));
            }
            if ( mSelectPath.get(8) != null )
            {
                imageView9.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(8) ));
            }
        }
    }
}
