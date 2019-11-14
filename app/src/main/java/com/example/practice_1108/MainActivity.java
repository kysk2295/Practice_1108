package com.example.practice_1108;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabs;
    MyPagerAdapter adapter;
    ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.pager);
        tabs=findViewById(R.id.tabs);
        list= new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());

        adapter= new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        String[] titles= new String[]{"사진","앨범","스토리","공유"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
