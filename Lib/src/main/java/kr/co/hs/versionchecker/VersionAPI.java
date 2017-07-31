package kr.co.hs.versionchecker;

import kr.co.hs.versionchecker.domain.PlayStoreInfo;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by privacydev on 2017. 7. 31..
 */

interface VersionAPI {
    @Headers("Content-Type: application/json")
    @POST("/tools/android-store-version")
    Call<PlayStoreInfo> getPlayStoreInfo(@Query("package") String packageName);
}
