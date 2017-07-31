package kr.co.hs.versionchecker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import kr.co.hs.versionchecker.domain.PlayStoreInfo;
import kr.co.hs.versionchecker.domain.VersionCheckInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by privacydev on 2017. 7. 31..
 */

public class VersionChecker {
    public static final void check(String packageName, final String currentVersion, final OnResponseListener onResponseListener){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://carreto.pt");
        builder.addConverterFactory(GsonConverterFactory.create());

        VersionAPI api = builder.build().create(VersionAPI.class);
        Call<PlayStoreInfo> call = api.getPlayStoreInfo(packageName);
        call.enqueue(new Callback<PlayStoreInfo>() {
            @Override
            public void onResponse(Call<PlayStoreInfo> call, Response<PlayStoreInfo> response) {
                if(response.isSuccessful()){
                    PlayStoreInfo playStoreInfo = response.body();
                    boolean isUpdate = false;
                    String latestVersion = null;
                    try{
                        latestVersion = playStoreInfo.getVersion();
                        isUpdate = VersionMatcher.match(latestVersion, String.format("> %s", currentVersion));
                        if(onResponseListener != null)
                            onResponseListener.onResponse(true, new VersionCheckInfo(isUpdate, latestVersion));
                    }catch (Exception e){
                        if(onResponseListener != null)
                            onResponseListener.onResponse(false, null);
                    }
                }else{
                    if(onResponseListener != null)
                        onResponseListener.onResponse(false, null);
                }
            }

            @Override
            public void onFailure(Call<PlayStoreInfo> call, Throwable t) {
                if(onResponseListener != null)
                    onResponseListener.onResponse(false, null);
            }
        });
    }

    public static final void check(Context context, OnResponseListener onResponseListener) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_META_DATA);
        String version = packageInfo.versionName;
        check(packageName, version, onResponseListener);
    }

    public interface OnResponseListener{
        void onResponse(boolean result, VersionCheckInfo info);
    }
}
