package com.blogspot.justtonovate.bmsitscanner;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.blogspot.justtonovate.bmsitscanner.R;

/**
 * Created by Chethan on 2/24/2018.
 */

public class Navigation_helper {
    public void setupNavigation(int item_number, BottomNavigationView bottomNavigationView){
        Menu menu= bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(item_number);
        menuItem.setChecked(true);
    }
    public void enableNavigation(final Class HomeClass, final Class targetClass, final Context context, BottomNavigationView bottomNavigationView){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.scan:
                        Intent scan = new Intent(context, HomeClass);
                        context.startActivity(scan);
                        break;
                    case R.id.complain:
                        Intent complain = new Intent(context, targetClass);
                        context.startActivity(complain);
                        break;
                }
                return false;
            }
        });
    }
}
