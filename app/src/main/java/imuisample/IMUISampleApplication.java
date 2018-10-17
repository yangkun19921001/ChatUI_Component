package imuisample;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.StrictMode;

import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.zhaoshuang.weixinrecordeddemo.BuildConfig;

//import com.squareup.leakcanary.LeakCanary;


public class IMUISampleApplication extends Application {

    @SuppressLint("MissingPermission")
    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);
        Utils.init(getApplicationContext());
        CrashUtils.init(new CrashUtils.OnCrashListener() {
            @Override
            public void onCrash(String crashInfo, Throwable e) {
                LogUtils.e(crashInfo);
                ToastUtils.showShort(crashInfo);
            }
        });

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }
}
