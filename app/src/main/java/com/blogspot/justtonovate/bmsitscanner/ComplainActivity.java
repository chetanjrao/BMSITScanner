package com.blogspot.justtonovate.bmsitscanner;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ComplainActivity extends AppCompatActivity {
    private static final String TAG = "ComplainActivity";
    private static final Class HomeClass = ComplainActivity.class;
    private static final Class targetClass = ScanActivity.class;
    private static final int item_number = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        setupNavigation(item_number, bottomNavigationView);
        enableNavigation(HomeClass, targetClass, ComplainActivity.this, bottomNavigationView);
    }
    public void setupNavigation(int item_number, BottomNavigationView bottomNavigationView){
        Menu menu= bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(item_number);
        menuItem.setChecked(true);
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
    public void enableNavigation(final Class HomeClass, final Class targetClass, final Context context, BottomNavigationView bottomNavigationView){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.scan:
                        Intent scan = new Intent(context, targetClass);
                        context.startActivity(scan);
                        break;
                    case R.id.complain:
                        Intent complain = new Intent(context, HomeClass);
                        context.startActivity(complain);
                        break;
                }
                return false;
            }
        });
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.scan:
                        Intent scan = new Intent(context, targetClass);
                        context.startActivity(scan);
                        break;
                    case R.id.complain:
                        Intent complain = new Intent(context, HomeClass);
                        context.startActivity(complain);
                        break;
                }
            }
        });
    }
}
