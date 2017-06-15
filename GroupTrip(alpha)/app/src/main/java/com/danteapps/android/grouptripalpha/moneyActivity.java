package com.danteapps.android.grouptripalpha;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;

public class moneyActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    //tabLayout
    private TabLayout tabLayout;
    //ViewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        final ArrayList<String> peopleName = getIntent().getStringArrayListExtra("list of people name");

        //Initializing the tablayout
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        //adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Instances"));
        tabLayout.addTab(tabLayout.newTab().setText("Money"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Inititalizing viewPager
        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);

        //creating our own pager adapter
        Pager adapter =  new Pager(getSupportFragmentManager(),tabLayout.getTabCount());

        //adding adapter to pager
        viewPager.setAdapter(adapter);

        //adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
