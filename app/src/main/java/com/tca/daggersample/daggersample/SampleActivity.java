package com.tca.daggersample.daggersample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.tca.daggersample.daggersample.models.SmartPhone;

import javax.inject.Inject;

public class SampleActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private TextView mTextNewMessage;


    @Inject SmartPhone smartPhone;

    @Inject SmartPhone newSmartPhone;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        ((DIApplication)getApplication()).getDeviceComponent().inject(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(smartPhone.getDeviceInfo());

        mTextNewMessage= (TextView)findViewById(R.id.new_message);
        mTextNewMessage.setText(newSmartPhone.getDeviceInfo());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
