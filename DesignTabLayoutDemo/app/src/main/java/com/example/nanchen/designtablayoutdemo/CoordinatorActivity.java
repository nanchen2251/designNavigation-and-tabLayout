package com.example.nanchen.designtablayoutdemo;

import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        Button btn = (Button) findViewById(R.id.coordinator_btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coordinator_btn:
                Snackbar.make(v,"Snackbar in coodinatorLayout!",Snackbar.LENGTH_SHORT)
                        .setAction("edit", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ActivityCompat.finishAffinity(CoordinatorActivity.this);
                            }
                        }).show();
                break;
        }
    }
}
