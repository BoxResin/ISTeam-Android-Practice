package m2j9702.test.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onRestart()
    {
        super.onRestart();

        Log.d("ASDF", "OnRestart");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ASDF", "OnCreate");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("ASDF", "OnStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        Log.d("ASDF", "OnResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("ASDF", "OnPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("ASDF", "OnStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("ASDF", "OnDestroy");
    }
}
