package com.blogspot.huyhungdinh.firebase.remote.config;


import android.app.Application;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class MyApplication extends Application {

    private static final long CONFIG_EXPIRE_SECOND = 1 * 3600;

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        RemoteConfigs.getInstance().setConfig(config);
        FirebaseRemoteConfigSettings settings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG).build();
        config.setConfigSettings(settings);

        config.setDefaults(R.xml.default_config);

        long expireTime = config.getInfo().getConfigSettings().isDeveloperModeEnabled() ? 0 : CONFIG_EXPIRE_SECOND;
        config.fetch(expireTime)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            RemoteConfigs.getInstance().getConfig().activateFetched();
                        }
                    }
                });
    }
}
