package com.burhan.multiactiondialogboxexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import burhan.com.multiactiondialogbox.DialogItems;
import burhan.com.multiactiondialogbox.MultiActionDialog;

public class MainActivity extends AppCompatActivity
{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        DialogItems items = new DialogItems();

        items.add(1,"Football", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));
        items.add(2,"Cricket", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));
        items.add(3,"Badminton", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));
        items.add(4,"Tennis", ContextCompat.getDrawable(this,android.R.drawable.btn_plus));

        final MultiActionDialog multiActionDialog = new MultiActionDialog();
        multiActionDialog.initialise(items, MultiActionDialog.HORIZONTAL_ORIENTATION, button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                multiActionDialog.show(MainActivity.this);

            }
        });
    }
}
