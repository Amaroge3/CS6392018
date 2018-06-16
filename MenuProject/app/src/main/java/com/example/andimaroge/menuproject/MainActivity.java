package com.example.andimaroge.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import java.lang.Object;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button buttonSms = (Button) findViewById(R.id.buttonSms);
        buttonSms.setOnClickListener(this);

        Button buttonPhone = (Button) findViewById(R.id.buttonPhone);
        buttonPhone.setOnClickListener(this);

        Button buttonWeb = (Button) findViewById(R.id.buttonWeb);
        buttonWeb.setOnClickListener(this);

        Button buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(this);

        Button buttonShare = (Button) findViewById(R.id.buttonShare);
        buttonShare.setOnClickListener(this);

        Button buttonNewActivity = (Button) findViewById(R.id.buttonNewActivity);
        buttonNewActivity.setOnClickListener(this);





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
            Toast t = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
            t.show();
            return true;
        }
        else if (id == R.id.action_help){
            Toast t = Toast.makeText(this, "Help", Toast.LENGTH_SHORT);
            t.show();
            final Intent helpActivity = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(helpActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSms:
                final Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:" + Uri.encode("12123630830")));
                smsIntent.putExtra("sms_body", "Andi Maroge");
                startActivity(smsIntent);
                break;

            case R.id.buttonPhone:
                final Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:2123630830"));
                startActivity(phoneIntent);
                break;
            case R.id.buttonWeb:
                final Intent webIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://google.com"));
                startActivity(webIntent);
                break;
            case R.id.buttonMap:
                String geoUri = String.format("geo:36.4908, 43.1200");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geoMap);
                break;
            case R.id.buttonShare:
                final Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "Share the love"));
                break;
            case R.id.buttonNewActivity:
                final Intent newActivityIntent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(newActivityIntent);
                break;
        }

    }

}
