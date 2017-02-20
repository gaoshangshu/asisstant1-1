package com.ustc.sse.asisstant.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.ustc.sse.asisstant.R;
import com.ustc.sse.asisstant.adapter.TitlePagerAdapter;
import com.ustc.sse.asisstant.util.Advertisement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dish_Recommand extends AppCompatActivity {

    private List<View> list=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish__recommand);

        ViewPager viewPager=(ViewPager)findViewById(R.id.dish_viewpager);

        //获取美食广告图片
        Advertisement advertisement=new Advertisement(this);
        list=advertisement.getAdvertisement();
        TitlePagerAdapter titlePagerAdapter=new TitlePagerAdapter(list);
        viewPager.setAdapter(titlePagerAdapter);


        //设置菜单
        List<Map<String,Object>> item=new ArrayList<Map<String,Object>>();
        String []name=new String[] {"中餐","西餐","快餐","甜品"};
        int []image=new int[]{R.drawable.menu_dish_chinese,R.drawable.menu_dish_west,R.drawable.menu_dish_fast,R.drawable.menu_dish_dessert};

        for (int i=0;i<4;i++)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name",name[i]);
            map.put("icon",image[i]);
            item.add(map);
        }

        GridView gridView=(GridView)findViewById(R.id.dish_gridview);

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,item,R.layout.main_menu,new String[]{"name","icon"},new int[]{R.id.menu_text,R.id.menu_image});

        gridView.setAdapter(simpleAdapter);


    }
}
