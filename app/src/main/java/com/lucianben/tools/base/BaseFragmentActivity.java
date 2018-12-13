package com.lucianben.tools.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.lucianben.tools.R;
import com.lucianben.tools.ui.fragment.FirstFragment;
import com.lucianben.tools.ui.fragment.SecondFragment;
import com.lucianben.tools.ui.fragment.ThirdFragment;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

public class BaseFragmentActivity extends BaseActivity {
    private Fragment currentFragment = new Fragment();

    private FirstFragment firstFragment = new FirstFragment();
    private SecondFragment secondFragmen = new SecondFragment();
    private ThirdFragment thirdFragment = new ThirdFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_fragment);

        initFragment();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setSubtitle("ABC");
        toolbar.setTitle("ABC");
    }

    private void initFragment() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        BottomNavigationItem item1 = new BottomNavigationItem("首页", ContextCompat.getColor(this, R.color.colorPrimary), R.mipmap.ic_launcher);
        BottomNavigationItem item2 = new BottomNavigationItem("发现", ContextCompat.getColor(this, R.color.colorPrimary), R.mipmap.ic_launcher);
        BottomNavigationItem item3 = new BottomNavigationItem("我的", ContextCompat.getColor(this, R.color.colorPrimary), R.mipmap.ic_launcher);

        bottomNavigationView.addTab(item1);
        bottomNavigationView.addTab(item2);
        bottomNavigationView.addTab(item3);

        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0:
                        switchFragment(firstFragment);
                        break;
                    case 1:
                        switchFragment(secondFragmen);
                        break;
                    case 2:
                        switchFragment(thirdFragment);
                        break;
                }
            }
        });
        switchFragment(firstFragment);
    }

    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (targetFragment.isAdded()) {
            transaction.hide(currentFragment).show(targetFragment).commit();
        } else {
            transaction.hide(currentFragment).add(R.id.frame_main_content, targetFragment, targetFragment.getClass().getName()).commit();
        }
        currentFragment = targetFragment;
    }
}
