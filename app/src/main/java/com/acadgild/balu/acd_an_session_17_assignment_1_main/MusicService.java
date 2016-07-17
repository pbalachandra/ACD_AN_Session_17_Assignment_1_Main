package com.acadgild.balu.acd_an_session_17_assignment_1_main;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


/**
 * Created by BALU on 5/2/2016.
 */
public class MusicService extends Service {

    MediaPlayer musicPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.melody);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        musicPlayer.start();
        musicPlayer.setLooping(true);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        musicPlayer.stop();
        musicPlayer.release();
        super.onDestroy();
    }
}
