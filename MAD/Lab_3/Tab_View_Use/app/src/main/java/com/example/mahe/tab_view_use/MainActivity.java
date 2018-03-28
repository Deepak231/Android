package com.example.mahe.tab_view_use;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TabLayout tablay = (TabLayout) findViewById(R.id.tablayout1);

        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter pageadpt = new PagerAdapter(getSupportFragmentManager(),tablay.getTabCount());
        pager.setAdapter(pageadpt);

        tablay.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tablay.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private class PagerAdapter extends FragmentPagerAdapter {
        int numtabs;
        public PagerAdapter(FragmentManager fm,int n) {
            super(fm);
            this.numtabs = n;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0: ArtistActivity tab1 = new ArtistActivity();
                    return tab1;
                case 1: AlbumActivity tab2 = new AlbumActivity();
                    return tab2;
                case 2: SongsActivity tab3= new SongsActivity();
                    return tab3;
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return numtabs;
        }
    }
}
