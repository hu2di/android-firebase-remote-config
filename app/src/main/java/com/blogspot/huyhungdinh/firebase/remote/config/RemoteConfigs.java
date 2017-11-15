package com.blogspot.huyhungdinh.firebase.remote.config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class RemoteConfigs {

    private static RemoteConfigs _instance;
    private FirebaseRemoteConfig config;

    private RemoteConfigs(){

    }

    public FirebaseRemoteConfig getConfig(){
        return this.config;
    }

    public void setConfig(FirebaseRemoteConfig config){
        this.config = config;
    }

    public static RemoteConfigs getInstance(){
        if(_instance == null){
            _instance = new RemoteConfigs();
        }
        return _instance;
    }
}
