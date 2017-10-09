package com.example.charles.beautifulbulldog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import io.realm.Realm;

public class BulldogActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Spinner spinner;
    private Button button;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulldog);

        textView = (TextView) findViewById(R.id.bulldog_name);
        imageView = (ImageView) findViewById(R.id.bulldog_image);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.vote_button);
        realm = Realm.getDefaultInstance();

        Log.v("hi", "there");

        String id = (String) getIntent().getStringExtra("bulldog");
        Bulldog bulldog = realm.where(Bulldog.class).equalTo("id", id).findFirst();
        textView.setText(bulldog.getName());

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
