package com.example.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer);
        appBarLayout=findViewById(R.id.appbar);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.nav_View);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle;
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                if(item.getItemId()==R.id.home)
                {
                    addFragment(new HomeFragment());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else if (item.getItemId()==R.id.about) {
                    Toast.makeText(MainActivity.this, "AboutUs", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else if (item.getItemId()==R.id.setting) {
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                return true;
            }
        });

    }
    private void addFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction= fm.beginTransaction();
        transaction.add(R.id.frame, fragment);
        transaction.commit();
    }
}