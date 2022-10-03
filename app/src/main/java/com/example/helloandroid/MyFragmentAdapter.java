package com.example.helloandroid;

import androidx.fragment.app.*;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    //定义碎片列表
    private List<Fragment> fragmentList2;

    //构建类的构造方法，用来接收从activity页面传递过来的碎片列表
    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList2){

        super(fm);
        this.fragmentList2 = fragmentList2;
    }
    @Override
    //根据当前位置返回碎片
    public Fragment getItem(int i) {
        return fragmentList2.get(i);
    }

    @Override
    //返回碎片的总数
    public int getCount() {
        return fragmentList2.size();
    }
}