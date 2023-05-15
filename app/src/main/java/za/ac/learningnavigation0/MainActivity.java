package za.ac.learningnavigation0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer_layout;
    ActionBarDrawerToggle toggle;
    FrameLayout content_frame;
    Toolbar my_toolbar;
    NavigationView nav_view;
    AFragment aFragment = new AFragment();
    BFragment bFragment = new BFragment();
    CFragment cFragment = new CFragment();
    DFragment dFragment = new DFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the toolbar from the layout as a support action bar :)
        my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Navigation on a DrawerLayout");

        // Initiate the ui elements that you will
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        content_frame = (FrameLayout) findViewById(R.id.content_frame);
        nav_view = (NavigationView)findViewById(R.id.nav_view);

        // Make the drawer layout accessible on the toolbar button
        toggle = new ActionBarDrawerToggle(this, drawer_layout, my_toolbar, R.string.str_open, R.string.str_close);
        toggle.syncState();

        setCurrentFragment(aFragment);
        handleNavigationDrawer();
    }

    public void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }

    private void handleNavigationDrawer() {
//        drawer_layout.addDrawerListener();

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // what must happen when an item is clicked
                if (item.getItemId() == R.id.nav_a){
                    setCurrentFragment(aFragment);
                    drawer_layout.closeDrawers();
                    return true;
                }
                if (item.getItemId() == R.id.nav_b){
                    setCurrentFragment(bFragment);
                    drawer_layout.closeDrawers();
                    return true;
                }
                if (item.getItemId() == R.id.nav_c){
                    setCurrentFragment(cFragment);
                    drawer_layout.closeDrawers();
                    return true;
                }
                if (item.getItemId() == R.id.nav_d){
                    setCurrentFragment(dFragment);
                    drawer_layout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }
}