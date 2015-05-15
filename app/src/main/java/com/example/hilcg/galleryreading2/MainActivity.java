package com.example.hilcg.galleryreading2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import com.liu.common.CommonUtility;
import com.liu.common.ImageUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_IMAGE = 2;

    private ArrayList<String> mSelectPath;

    private Button btnToStartCal;

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

        btnToStartCal = (Button)findViewById(R.id.btn_to_start_cal);

        imageView1 = (ImageView) findViewById(R.id.image_view_1);
        imageView2 = (ImageView) findViewById(R.id.image_view_2);
        imageView3 = (ImageView) findViewById(R.id.image_view_3);
        imageView4 = (ImageView) findViewById(R.id.image_view_4);
        imageView5 = (ImageView) findViewById(R.id.image_view_5);
        imageView6 = (ImageView) findViewById(R.id.image_view_6);
        imageView7 = (ImageView) findViewById(R.id.image_view_7);
        imageView8 = (ImageView) findViewById(R.id.image_view_8);
        imageView9 = (ImageView) findViewById(R.id.image_view_9);

        btnToStartCal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                List<Integer> pic1OM = new ArrayList<Integer>();
                List<Integer> pic2OM = new ArrayList<Integer>();
                List<Integer> pic3OM = new ArrayList<Integer>();
                List<Integer> pic4OM = new ArrayList<Integer>();
                List<Integer> pic5OM = new ArrayList<Integer>();
                List<Integer> pic6OM = new ArrayList<Integer>();
                List<Integer> pic7OM = new ArrayList<Integer>();
                List<Integer> pic8OM = new ArrayList<Integer>();
                List<Integer> pic9OM = new ArrayList<Integer>();

                List<List<Integer>> allPicOMList = new ArrayList<List<Integer>>();

                if ( mSelectPath.size() > 0 && mSelectPath.get(0) != null )
                {
                    pic1OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(0) ));
                    allPicOMList.add(pic1OM);
                }

                if ( mSelectPath.size() > 1 && mSelectPath.get(1) != null )
                {
                    pic2OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(1) ));
                    allPicOMList.add(pic2OM);
                }

                if ( mSelectPath.size() > 2 && mSelectPath.get(2) != null )
                {
                    pic3OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(2) ));
                    allPicOMList.add(pic3OM);
                }

                if ( mSelectPath.size() > 3 && mSelectPath.get(3) != null )
                {
                    pic4OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(3) ));
                    allPicOMList.add(pic4OM);
                }

                if ( mSelectPath.size() > 4 && mSelectPath.get(4) != null )
                {
                    pic5OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(4) ));
                    allPicOMList.add(pic5OM);
                }

                if ( mSelectPath.size() > 5 && mSelectPath.get(5) != null )
                {
                    pic6OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(5) ));
                    allPicOMList.add(pic6OM);
                }

                if ( mSelectPath.size() > 6 && mSelectPath.get(6) != null )
                {
                    pic7OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(6) ));
                    allPicOMList.add(pic7OM);
                }

                if ( mSelectPath.size() > 7 && mSelectPath.get(7) != null )
                {
                    pic8OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(7) ));
                    allPicOMList.add(pic8OM);
                }

                if ( mSelectPath.size() > 8 && mSelectPath.get(8) != null )
                {
                    pic9OM = ImageUtil.getOMOfPic(BitmapFactory.decodeFile( mSelectPath.get(8) ));
                    allPicOMList.add(pic9OM);
                }

//                CommonUtility.compareOMOfAllPic(allPicOMList);

                Set<Integer> allSamePics = CommonUtility.isTheSamePic(allPicOMList);

                if ( 2 == allSamePics.size() )
                {

                    Bitmap bitmap1 = null;
                    Bitmap bitmap2 = null;

                    Object[] allSamePicArray = allSamePics.toArray();

                    if ( allSamePicArray[0] == 0 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(0) );
                    }else if ( allSamePicArray[0] == 1 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(1) );
                    }else if ( allSamePicArray[0] == 2 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(2) );
                    }else if ( allSamePicArray[0] == 3 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(3) );
                    }else if ( allSamePicArray[0] == 4 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(4) );
                    }else if ( allSamePicArray[0] == 5 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(5) );
                    }else if ( allSamePicArray[0] == 6 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(6) );
                    }else if ( allSamePicArray[0] == 7 )
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(7) );
                    }else
                    {
                        bitmap1 = BitmapFactory.decodeFile( mSelectPath.get(8 ));
                    }

                    if ( allSamePicArray[1] == 0 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(0) );
                    }else if ( allSamePicArray[1] == 1 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(1) );
                    }else if ( allSamePicArray[1] == 2 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(2) );
                    }else if ( allSamePicArray[1] == 3 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(3) );
                    }else if ( allSamePicArray[1] == 4 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(4) );
                    }else if ( allSamePicArray[1] == 5 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(5) );
                    }else if ( allSamePicArray[1] == 6 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(6) );
                    }else if ( allSamePicArray[1] == 7 )
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(7) );
                    }else
                    {
                        bitmap2 = BitmapFactory.decodeFile( mSelectPath.get(8 ));
                    }

                    int bitmapsize1 = ImageUtil.getBitmapSize(bitmap1);
                    int bitmapsize2 = ImageUtil.getBitmapSize(bitmap2);

                    if ( bitmapsize1 > bitmapsize2 )
                    {
                        if ( allSamePicArray[1] == 0 )
                        {
                            imageView1.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[1] == 1 )
                        {
                            imageView2.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[1] == 2 )
                        {
                            imageView3.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[1] == 3 )
                        {
                            imageView4.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[1] == 4 )
                        {
                            imageView5.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[1] == 5 )
                        {
                            imageView6.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[1] == 6 )
                        {
                            imageView7.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[1] == 7 )
                        {
                            imageView8.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else
                        {
                            imageView9.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }
                    }
                    else
                    {
                        if ( allSamePicArray[0] == 0 )
                        {
                            imageView1.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[0] == 1 )
                        {
                            imageView2.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[0] == 2 )
                        {
                            imageView3.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[0] == 3 )
                        {
                            imageView4.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[0] == 4 )
                        {
                            imageView5.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[0] == 5 )
                        {
                            imageView6.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[0] == 6 )
                        {
                            imageView7.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else if ( allSamePicArray[0] == 7 )
                        {
                            imageView8.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }else
                        {
                            imageView9.setImageBitmap(BitmapFactory.decodeFile( null ));
                        }
                    }

                }
                else if( allSamePics.size() >= 3)
                {
                    int theBestPic = CommonUtility.remSamePic(CommonUtility.removeUnSamePic(allSamePics, allPicOMList));

//                    System.out.println("The best pic:" + theBestPic);

                    int i = 0;

//                    Toast.makeText(MainActivity.this, "allSamePics.size():" + allSamePics.size(), Toast.LENGTH_SHORT).show();

                    Iterator<Integer> iterator = allSamePics.iterator();

                    while( iterator.hasNext() )
                    {
                        if ( i == theBestPic )
                        {
                            iterator.next();
                            i ++;
                            continue;

                        }

                        switch ( iterator.next() )
                        {
                            case 0:
                                imageView1.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 1:
                                imageView2.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 2:
                                imageView3.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 3:
                                imageView4.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 4:
                                imageView5.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 5:
                                imageView6.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 6:
                                imageView7.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 7:
                                imageView8.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            case 8:
                                imageView9.setImageBitmap(BitmapFactory.decodeFile( null ));
                                break;
                            default:
                                break;
                        }

                        i ++;
//                        Toast.makeText(MainActivity.this, "next():" + iterator.next(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

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

            imageView1.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView2.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView3.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView4.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView5.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView6.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView7.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView8.setImageBitmap(BitmapFactory.decodeFile( null ));
            imageView9.setImageBitmap(BitmapFactory.decodeFile( null ));

            mSelectPath = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);

            // Now we need to set the GUI ImageView data with data read from the picked file.
            if ( mSelectPath.size() > 0 && mSelectPath.get(0) != null )
            {
                imageView1.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(0) ));
            }
            if ( mSelectPath.size() > 1 && mSelectPath.get(1) != null )
            {
                imageView2.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(1) ));
            }
            if ( mSelectPath.size() > 2 && mSelectPath.get(2) != null )
            {
                imageView3.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(2) ));
            }
            if ( mSelectPath.size() > 3 && mSelectPath.get(3) != null )
            {
                imageView4.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(3) ));
            }
            if ( mSelectPath.size() > 4 && mSelectPath.get(4) != null )
            {
                imageView5.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(4) ));
            }
            if ( mSelectPath.size() > 5 && mSelectPath.get(5) != null )
            {
                imageView6.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(5) ));
            }
            if ( mSelectPath.size() > 6 && mSelectPath.get(6) != null )
            {
                imageView7.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(6) ));
            }
            if ( mSelectPath.size() > 7 && mSelectPath.get(7) != null )
            {
                imageView8.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(7) ));
            }
            if ( mSelectPath.size() > 8 && mSelectPath.get(8) != null )
            {
                imageView9.setImageBitmap(BitmapFactory.decodeFile( mSelectPath.get(8) ));
            }
        }
    }
}
