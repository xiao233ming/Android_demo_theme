package com.example.mingming.android_demo_theme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int theme = getIntent().getIntExtra("theme",-1);

        if (theme !=-1){
            setTheme(theme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button theme1 = (Button) findViewById(R.id.theme1);
        Button theme2 = (Button) findViewById(R.id.theme2);
    }

    public void clickTheme1(View view){
        changeTheme(R.style.Theme1);
    }

    public void clickTheme2(View view){
        changeTheme(R.style.Theme2);
    }

    //改变属性
    private void changeTheme(int theme){
        //必须在activity的setContentView之前
        //activity必须重启


        overridePendingTransition(0,0);//实现无缝转换
        finish();
        Intent intent = new Intent(this,MainActivity.class);

        intent.putExtra("theme",theme);
        overridePendingTransition(0,0);
        startActivity(intent);
    }
}
