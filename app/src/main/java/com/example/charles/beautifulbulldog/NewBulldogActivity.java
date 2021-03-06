package com.example.charles.beautifulbulldog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import io.realm.Realm;

public class NewBulldogActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText editText;
    private EditText editTexxt;
    private Button button;
    public Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bulldog);

        imageView = (ImageView) findViewById(R.id.bulldog_image);
        editText = (EditText) findViewById(R.id.bulldog_name);
        editTexxt = (EditText) findViewById(R.id.bulldog_age);
        button = (Button) findViewById(R.id.save_button);
        realm = Realm.getDefaultInstance();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            bulldogImageButton.setImageBitmap(imageBitmap);
        }
    }

    bulldogImageButton.setOnClickListener(new View.OnCLickLsitener() {
        @Override
                public void OnClick(View view) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) !=null) {
                startActivityForResult(takePictureIntent, 1);
            }
        }
    }
}
