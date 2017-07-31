package kr.co.hs.versionchecker.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import kr.co.hs.versionchecker.VersionChecker;
import kr.co.hs.versionchecker.domain.VersionCheckInfo;

/**
 * Created by privacydev on 2017. 7. 31..
 */

public class SampleActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VersionChecker.check("com.google.android.googlequicksearchbox", "1.0.0", new VersionChecker.OnResponseListener() {
            @Override
            public void onResponse(boolean result, VersionCheckInfo info) {
                if(result){
                    boolean isUpdate = info.isUpdate();
                    String latestVersion = info.getLatestVersion();
                }
            }
        });

    }
}
