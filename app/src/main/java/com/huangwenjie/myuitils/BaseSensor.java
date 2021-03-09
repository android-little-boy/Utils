package com.huangwenjie.myuitils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/**
 * 传感器基类
 *
 */
public abstract class BaseSensor {
    private final SensorManager mManager;
    private static final String TAG = BaseSensor.class.getSimpleName();

    BaseSensor(int... typeSensor) {
        mManager = (SensorManager) MyApplication.getContext().getSystemService(Context.SENSOR_SERVICE);
        for (int i : typeSensor) {
            Sensor sensor = mManager.getDefaultSensor(i);
            mManager.registerListener(mListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void unRegister() {
        if (mManager != null) {
            mManager.unregisterListener(mListener);
        }
    }

    private final SensorEventListener mListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            sensorChanged(event);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.d(TAG, "sensor:" + sensor + ",accuracy:" + accuracy);
        }
    };

    // 传感器事件变化
    protected abstract void sensorChanged(SensorEvent event);
}
