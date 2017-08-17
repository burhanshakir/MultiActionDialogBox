package com.burhan.multiactiondialogboxexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import burhan.com.multiactiondialogbox.DialogItems;
import burhan.com.multiactiondialogbox.MultiActionDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogItems items = new DialogItems();

        items.add(1,"Football", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));
        items.add(2,"Cricket", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));
        items.add(3,"Badminton", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));
        items.add(4,"Tennis", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));

        MultiActionDialog multiActionDialog = new MultiActionDialog();
    }
}
