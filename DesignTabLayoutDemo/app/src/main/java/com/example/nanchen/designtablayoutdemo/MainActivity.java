package com.example.nanchen.designtablayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = (ViewPager) findViewById(R.id.main_vp);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tab_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);

        //设置Toolbar和DrawerLayout实现动画和联动
        this.setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(toggle);//设置监听
        toggle.syncState();//加上同步
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
//            list.add(String.format(Locale.CHINA,"第02d%页",i));
            list.add("第"+i+"页");
        }
        vp.setAdapter(new MyAdapter(getSupportFragmentManager(),list));

        tabLayout.setupWithViewPager(vp);

        NavigationView navigationView = (NavigationView) findViewById(R.id.main_navigation);
        navigationView.setNavigationItemSelectedListener(this);

        Button btn = (Button) findViewById(R.id.main_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1:
                Toast.makeText(this,"你点击了菜单1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item2:
                Toast.makeText(this,"你点击了菜单2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item3:
                Toast.makeText(this,"你点击了菜单3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item4:
                Toast.makeText(this,"你点击了菜单4",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn:
                Snackbar.make(v,"Snackbar",Snackbar.LENGTH_SHORT)
                        .setAction("进入下一个Activity", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Toast.makeText(MainActivity.this,"你点击了撤销按钮！",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,CoordinatorActivity.class));
                            }

                        }).show();
                break;
        }
    }
}
