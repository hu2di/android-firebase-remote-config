package com.blogspot.huyhungdinh.firebase.remote.config;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvCount;
    private TextView tvRemoteConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView) findViewById(R.id.tv_count);
        tvRemoteConfig = (TextView) findViewById(R.id.tv_remote_config);

        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvCount.setText("# " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvCount.setText("#lookdown");

                String textRemoveConfig = RemoteConfigs.getInstance().getConfig().getString(RemoteKey.remote_config_text_in_main);
                tvRemoteConfig.setText(textRemoveConfig);
            }

        }.start();
    }
}
