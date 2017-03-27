package com.tca.daggersample.daggersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.tca.daggersample.daggersample.models.SmartPhone;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SampleActivity extends AppCompatActivity {

    @BindView(R.id.message) TextView mTextMessage;

    @BindView(R.id.new_message)TextView mTextNewMessage;

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

        ButterKnife.bind(this);

        ((DIApplication)getApplication()).getDeviceComponent().inject(this);

        mTextMessage.setText(smartPhone.getDeviceInfo());

        mTextNewMessage.setText(newSmartPhone.getDeviceInfo());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @OnClick(R.id.buttonNext)
    public void loadDetailPage() {
        Intent  detailPageIntent= new Intent(this,DetailActivity.class);
        startActivity(detailPageIntent);
    }


}
