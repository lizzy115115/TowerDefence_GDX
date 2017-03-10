package com.betmansmall.game.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.betmansmall.game.GameScreenInteface.DeviceSettings;
import com.betmansmall.game.TowerDefence;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DeviceSettings deviceSettings = new DeviceSettings();
        deviceSettings.setDevice("android");
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        initialize(new TowerDefence(), config);
    }
}
