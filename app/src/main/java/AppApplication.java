import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.aliyun.common.httpfinal.QupaiHttpFinal;

/**
 * Created by doupengkun on 2017/9/14.
 */

public class AppApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        //趣拍 初始化
        QupaiHttpFinal.getInstance().initOkHttpFinal();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
