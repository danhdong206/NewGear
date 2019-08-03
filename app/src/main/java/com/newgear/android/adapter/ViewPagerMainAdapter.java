package com.newgear.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerMainAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragment = new ArrayList<>(); //Fragment List
    private List<String> mNamePage = new ArrayList<>(); // Fragment Name List

    public ViewPagerMainAdapter(FragmentManager manager) {
        super(manager);
    }

    public void add(Fragment Frag, String Title) {
        mFragment.add(Frag);
        mNamePage.add(Title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mNamePage.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
