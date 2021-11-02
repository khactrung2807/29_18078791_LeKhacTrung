package com.example.a29_18078791_lekhactrung;


import android.app.Service;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.os.Binder;
        import android.os.IBinder;
        import android.util.Log;

        import androidx.annotation.Nullable;

public class MusicBoundService extends Service {

    private MyBinder mBinder = new MyBinder();
    private MediaPlayer mediaPlayer;

    public class MyBinder extends Binder {
        MusicBoundService getMusicBoundService() {
            return MusicBoundService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MusicBoundService", "onCreate");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MusicBoundService", "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MusicBoundService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MusicBoundService", "onDestroy");
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void startMusic() {
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raww.test_music);
        }
        mediaPlayer.start();
    }
}