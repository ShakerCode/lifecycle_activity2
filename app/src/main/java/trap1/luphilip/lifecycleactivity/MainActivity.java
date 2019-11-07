package trap1.luphilip.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mPreferences;
    TextView onCreate; TextView onStart; TextView onResume; TextView onPause;
    TextView onStop; TextView onRestart; TextView onDestroy;

    Button resetLocal;
    Button resetSum;

    int onCreateLocal = 0; int onStartLocal = 0; int onResumeLocal = 0; int onPauseLocal;
    int onStopLocal = 0; int onRestartLocal = 0; int onDestroyLocal = 0;

    int onCreateSum; int onStartSum; int onResumeSum; int onPauseSum; int onStopSum;
    int onRestartSum; int onDestroySum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreate = findViewById(R.id.onCreate);
        onStart = findViewById(R.id.onStart);
        onResume = findViewById(R.id.onResume);
        onPause = findViewById(R.id.onPause);
        onStop = findViewById(R.id.onStop);
        onRestart = findViewById(R.id.onRestart);
        onDestroy = findViewById(R.id.onDestroy);
        resetLocal = findViewById(R.id.ResetLocal);
        resetSum = findViewById(R.id.ResetSum);

        mPreferences = getSharedPreferences("trap1.luphilip.lifecyclectivity", MODE_PRIVATE);
        onCreateSum = mPreferences.getInt("mPrefOnCreate", 0);
        onStartSum = mPreferences.getInt("mPrefOnStart", 0);
        onResumeSum = mPreferences.getInt("mPrefOnResume", 0);
        onPauseSum = mPreferences.getInt("mPrefOnPause", 0);
        onStopSum = mPreferences.getInt("mPrefOnStop", 0);
        onRestartSum = mPreferences.getInt("mPrefOnRestart", 0);
        onDestroySum = mPreferences.getInt("mPrefOnDestroy", 0);

        onCreateLocal += 1;
        onCreateSum += 1;
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("mPrefOnCreate", onCreateSum);
        preferencesEditor.apply();
        onCreate.setText(String.format("onCreate: Local: %s, Total: %s", onCreateLocal, onCreateSum));

        resetLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateLocal = 0; onStartLocal = 0; onResumeLocal = 0; onPauseLocal = 0;
                onStopLocal = 0; onRestartLocal = 0; onDestroyLocal = 0;
                onCreate.setText(String.format("onCreate: Local: %s, Total: %s", onCreateLocal, onCreateSum));
                onStart.setText(String.format("onCreate: Local: %s, Total: %s", onStartLocal, onStartSum));
                onResume.setText(String.format("onCreate: Local: %s, Total: %s", onResumeLocal, onResumeSum));
                onPause.setText(String.format("onCreate: Local: %s, Total: %s", onPauseLocal, onPauseSum));
                onStop.setText(String.format("onCreate: Local: %s, Total: %s", onStopLocal, onStopSum));
                onRestart.setText(String.format("onCreate: Local: %s, Total: %s", onRestartLocal, onRestartSum));
                onDestroy.setText(String.format("onCreate: Local: %s, Total: %s", onDestroyLocal, onDestroySum));
            }
        });

        resetSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateSum = 0; onStartSum = 0; onResumeSum = 0; onPauseSum = 0;
                onStopSum = 0; onRestartSum = 0; onDestroySum = 0;
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putInt("mPrefOnCreate", onCreateSum);
                preferencesEditor.putInt("mPrefOnStart", onStartSum);
                preferencesEditor.putInt("mPrefOnResume", onResumeSum);
                preferencesEditor.putInt("mPrefOnPause", onPauseSum);
                preferencesEditor.putInt("mPrefOnStop", onStopSum);
                preferencesEditor.putInt("mPrefOnRestart", onRestartSum);
                preferencesEditor.putInt("mPrefOnDestroy", onDestroySum);

                onCreate.setText(String.format("onCreate: Local: %s, Total: %s", onCreateLocal, onCreateSum));
                onStart.setText(String.format("onCreate: Local: %s, Total: %s", onStartLocal, onStartSum));
                onResume.setText(String.format("onCreate: Local: %s, Total: %s", onResumeLocal, onResumeSum));
                onPause.setText(String.format("onCreate: Local: %s, Total: %s", onPauseLocal, onPauseSum));
                onStop.setText(String.format("onCreate: Local: %s, Total: %s", onStopLocal, onStopSum));
                onRestart.setText(String.format("onCreate: Local: %s, Total: %s", onRestartLocal, onRestartSum));
                onDestroy.setText(String.format("onCreate: Local: %s, Total: %s", onDestroyLocal, onDestroySum));
                preferencesEditor.apply();
            }
        });

    }

    protected void onStart() {
        super.onStart();
        onStartLocal += 1;
        onStartSum += 1;
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("mPrefOnStart", onStartSum);
        preferencesEditor.apply();
        onStart.setText(String.format("onStart: Local: %s, Total: %s", onStartLocal, onStartSum));
    }

    protected void onResume() {
        super.onResume();
        onResumeLocal += 1;
        onResumeSum += 1;
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("mPrefOnResume", onResumeSum);
        preferencesEditor.apply();
        onResume.setText(String.format("onResume: Local: %s, Total: %s", onResumeLocal, onResumeSum));
    }

    protected void onPause() {
        super.onPause();
        onPauseLocal += 1;
        onPauseSum += 1;
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("mPrefOnPause", onPauseSum);
        preferencesEditor.apply();
        onPause.setText(String.format("onPause: Local: %s, Total: %s", onPauseLocal, onPauseSum));
    }

    protected void onStop() {
        super.onStop();
        onStopLocal += 1;
        onStopSum += 1;
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("mPrefOnStop", onStopSum);
        preferencesEditor.apply();
        onStop.setText(String.format("onStop: Local: %s, Total: %s", onStopLocal, onStopSum));
    }

    protected void onRestart() {
        super.onRestart();
        onRestartLocal += 1;
        onRestartSum += 1;
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("mPrefOnRestart", onRestartSum);
        preferencesEditor.apply();
        onRestart.setText(String.format("onRestart: Local: %s, Total: %s", onRestartLocal, onRestartSum));
    }

    public void onDestroy() {
        super.onDestroy();
        onDestroyLocal += 1;
        onDestroySum += 1;
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("mPrefOnDestroy", onDestroySum);
        preferencesEditor.apply();
        onDestroy.setText(String.format("onDestroy: Local: %s, Total: %s", onDestroyLocal, onDestroySum));
    }




}
