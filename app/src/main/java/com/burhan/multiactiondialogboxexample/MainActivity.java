package com.burhan.multiactiondialogboxexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        items.add(1,"Football", ContextCompat.getDrawable(this,R.drawable.calender));
        items.add(3,"Badminton", ContextCompat.getDrawable(this,R.drawable.card));
        items.add(4,"Tennis", ContextCompat.getDrawable(this,R.drawable.clock));

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

        multiActionDialog.setOnMultiActionItemClickListener(new MultiActionDialog.OnMultiActionItemClickListener() {
            @Override
            public void onItemClick(MultiActionDialog source, int pos, int actionId)
            {
                switch (actionId)
                {
                    case 1:
                        Toast.makeText(MainActivity.this, "Football", Toast.LENGTH_SHORT).show();
                            break;
                    case 3:

                        Toast.makeText(MainActivity.this, "Badminton", Toast.LENGTH_SHORT).show();

                    case 4:

                        Toast.makeText(MainActivity.this, "Tennis", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
