package com.danteapps.android.grouptripalpha;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                moneyFragment tab1 = new moneyFragment();
                return tab1;
            case 1:
                travel tab2 = new travel();
                return tab2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}