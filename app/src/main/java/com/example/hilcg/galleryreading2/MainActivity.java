package com.example.hilcg.galleryreading2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

    // Image loading result to pass to startActivityForResult method.
    private static int LOAD_IMAGE_RESULTS = 1;

    // GUI components
    private Button button;	// The button
    //灰度化图片按钮
    private Button btnToGray;
    // ImageView
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find references to the GUI objects
        button = (Button)findViewById(R.id.button);
        btnToGray = (Button)findViewById(R.id.btn_to_gray);
        image = (ImageView)findViewById(R.id.image);

        // Set button's onClick listener object.
        button.setOnClickListener(this);

        btnToGray = (Button)findViewById(R.id.btn_to_gray);
        btnToGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "即将转入灰度化页面！", Toast.LENGTH_SHORT).show();

                Intent intentToPicGray = new Intent(MainActivity.this, PicToGray.class);
                startActivity(intentToPicGray);
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

        // Here we need to check if the activity that was triggers was the Image Gallery.
        // If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
        // If the resultCode is RESULT_OK and there is some data we know that an image was picked.
        if (requestCode == LOAD_IMAGE_RESULTS && resultCode == RESULT_OK && data != null) {
            // Let's read picked image data - its URI
            Uri pickedImage = data.getData();
            // Let's read picked image path using content resolver
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            // Now we need to set the GUI ImageView data with data read from the picked file.
            image.setImageBitmap(BitmapFactory.decodeFile(imagePath));

            // At the end remember to close the cursor or you will end with the RuntimeException!
            cursor.close();
        }
    }

    @Override
    public void onClick(View v) {
        // Create the Intent for Image Gallery.
//        Intent i = new Intent(Intent.Action_SE, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), LOAD_IMAGE_RESULTS);


        // Start new activity with the LOAD_IMAGE_RESULTS to handle back the results when image is picked from the Image Gallery.
//        startActivityForResult(i, LOAD_IMAGE_RESULTS);
    }
}
