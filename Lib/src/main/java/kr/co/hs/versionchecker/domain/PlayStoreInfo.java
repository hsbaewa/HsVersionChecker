package kr.co.hs.versionchecker.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by privacydev on 2017. 7. 31..
 */

public class PlayStoreInfo {
    @SerializedName("package_name") String packageName;
    @SerializedName("status") boolean status;
    @SerializedName("author") boolean author;
    @SerializedName("app_name") String appName;
    @SerializedName("locale") String locale;
    @SerializedName("publish_date") String publishDate;
    @SerializedName("publish_date_formated") String publishDateFormated;
    @SerializedName("version") String version;
    @SerializedName("last_version_description") String latestVersionDescription;


    public String getPackageName() {
        return packageName;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isAuthor() {
        return author;
    }

    public String getAppName() {
        return appName;
    }

    public String getLocale() {
        return locale;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getPublishDateFormated() {
        return publishDateFormated;
    }

    public String getVersion() {
        return version;
    }

    public String getLatestVersionDescription() {
        return latestVersionDescription;
    }
}
