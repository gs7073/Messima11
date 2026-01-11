package com.example.messima11;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linlay;
    Button btn1, btn2, btn3, btn4, btn5;
    AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linlay = findViewById(R.id.linlay);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("1");
                adb.setMessage("hello");
                AlertDialog ad = adb.create();
                ad.show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("2");
                adb.setMessage("hello");
                adb.setIcon(R.mipmap.ic_launcher);
                AlertDialog ad = adb.create();
                ad.show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle(" 3");
                adb.setMessage("hello");
                adb.setIcon(R.mipmap.ic_launcher);

                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog ad = adb.create();
                ad.show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("4");
                adb.setMessage("choose 2 options: ");
                adb.setIcon(R.mipmap.ic_launcher);

                adb.setPositiveButton("change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        linlay.setBackgroundColor(getRandColor());
                    }
                });

                adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog ad = adb.create();
                ad.show();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("5");
                adb.setMessage("choose 3 options: ");
                adb.setIcon(R.mipmap.ic_launcher);

                adb.setPositiveButton("change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        linlay.setBackgroundColor(getRandColor());
                    }
                });

                adb.setNeutralButton("reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        linlay.setBackgroundColor(Color.WHITE);
                    }
                });

                adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog ad = adb.create();
                ad.show();
            }
        });
    }

    public int getRandColor() {
        Random rnd = new Random();
        int r = rnd.nextInt(256);
        int g = rnd.nextInt(256);
        int b = rnd.nextInt(256);
        return Color.rgb(r, g, b);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mCredits) {
            Intent t = new Intent(this, CreditsActivity.class);
            startActivity(t);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
