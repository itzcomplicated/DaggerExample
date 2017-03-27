package com.tca.daggersample.daggersample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tca.daggersample.daggersample.models.SmartPhone;
import com.tca.daggersample.daggersample.retrofit.ServiceProvider;
import com.tca.daggersample.daggersample.retrofit.models.Events;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.textView) TextView flagShipTextView;

    @Inject SmartPhone flagShipPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        ((DIApplication)getApplication()).getDeviceComponent().inject(this);

        flagShipTextView.setText(flagShipPhone.getDeviceInfo());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Call<List<Events>> eventsCall= new ServiceProvider().getService().listRepos();


        Toast.makeText(DetailActivity.this,"Start",Toast.LENGTH_SHORT).show();


        eventsCall.enqueue(new Callback<List<Events>>() {
            @Override
            public void onResponse(Call<List<Events>> call, Response<List<Events>> response) {
                String type="";
                try {
                    Log.i("Response",response.toString());
                    type=response.body().get(0).getType();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(DetailActivity.this,"Got Response "+type,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Events>> call, Throwable throwable) {

                Toast.makeText(DetailActivity.this,"it failed :( ",Toast.LENGTH_LONG).show();

            }
        });
    }

}
