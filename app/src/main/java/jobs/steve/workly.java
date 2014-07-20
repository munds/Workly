package jobs.steve;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import jobs.steve.R;

public class workly extends SherlockFragmentActivity {
    ActionBar mActionBar;
    ViewPager mPager;
    Tab tab;
    String emailID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workly);
        Bundle extras = getIntent().getExtras();
        emailID = extras.getString("email");
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        mPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Find the ViewPager Position
                mActionBar.setSelectedNavigationItem(position);
            }
        };
        mPager.setOnPageChangeListener(ViewPagerListener);
        ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(fm);
        mPager.setAdapter(viewpageradapter);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(Tab tab, FragmentTransaction ft) {
                mPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(Tab tab, FragmentTransaction ft) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTabReselected(Tab tab, FragmentTransaction ft) {
                // TODO Auto-generated method stub
            }
        };
        // Create first Tab
        //tab = mActionBar.newTab().setText("Jobs").setTabListener(tabListener);
        tab = mActionBar.newTab().setIcon(R.drawable.list_actionbar_icon).setTabListener(tabListener);
        mActionBar.addTab(tab);

        // Create second Tab
        tab = mActionBar.newTab().setIcon(R.drawable.messages_actionbar_icon).setTabListener(tabListener);
        mActionBar.addTab(tab);

        // Create third Tab
        tab = mActionBar.newTab().setIcon(R.drawable.profile_actionbar_icon).setTabListener(tabListener);
        mActionBar.addTab(tab);

        TextView tv = (TextView) findViewById(R.id.text_fragment);
        tv.setText("Finding jobs for: " + emailID);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_workly, container, false);
            return rootView;
        }
    }
}
