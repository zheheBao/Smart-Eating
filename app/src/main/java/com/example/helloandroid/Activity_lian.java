
package com.example.helloandroid;


import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Activity_lian extends AppCompatActivity {

    //创建相应的控件对象
    private ViewPager view_pager;  //创建ViewPager对象
    private RadioGroup radio_group; //创建单选按钮组
    private RadioButton radio_one; //创建“主页”按钮
    private RadioButton radio_two; //创建“收藏”按钮
    private RadioButton radio_three; //创建“个人中心”按钮

    //创建initView()方法，并在该方法中绑定控件
    private  void initView(){
        view_pager = findViewById(R.id.view_pager);
        radio_group = findViewById(R.id.radio_group);
        radio_one = findViewById(R.id.radio_one);
        radio_two = findViewById(R.id.radio_two);
        radio_three = findViewById(R.id.radio_three);
    }

    //定义碎片类的实例变量以及碎片列表对象
    private Fragment onefragment,twofragment,threefragment;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private int position = 0 ;  //用于记录当前所在的页面，默认值为0表示选中第一个页面

    //创建initData()方法，将碎片列表通过自定义适配器绑定到ViewPager控件上
    private  void  initData(){
        //将碎片进行实例化，并且存放到碎片数组
        Fragment onefragment = new OneFragment();
        Fragment twofragment = new TwoFragment();
        Fragment threefragment = new ThreeFragment();
        fragmentList.add(onefragment);
        fragmentList.add(twofragment);
        fragmentList.add(threefragment);
        //创建自定义适配器的实例
        MyFragmentAdapter adapter = new MyFragmentAdapter(this.getSupportFragmentManager(),fragmentList);
        //为ViewPager控件绑定适配器
        view_pager.setAdapter(adapter);
        //导航栏默认显示第一个卡片
        ((RadioButton)radio_group.getChildAt(position)).setChecked(true);
    }

    //创建initMove()方法，该方法中设定ViewPager控件的滑屏事件
    private  void initMove(){
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                ((RadioButton)radio_group.getChildAt(i)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    //创建initOnClick()方法，在该方法中添加RadioGroup控件的单击事件
    private  void  initOnClick(){
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_one:
                        position = 0;
                        view_pager.setCurrentItem(position);
                        break;
                    case R.id.radio_two:
                        position = 1;
                        view_pager.setCurrentItem(position);
                        break;
                    case R.id.radio_three:
                        position = 2;
                        view_pager.setCurrentItem(position);
                        break;
                    default:
                        position = 0;
                        view_pager.setCurrentItem(position);
                        break;
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lian);
        initView();    //控件的绑定
        initData();    //将三张碎片添加到ViewPager控件中
        initMove();    //滑屏时导航栏按钮随之切换
        initOnClick();   //单击导航栏按钮，碎片跟随切换
    }
}