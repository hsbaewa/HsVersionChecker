package kr.co.hs.versionchecker.domain;

/**
 * Created by privacydev on 2017. 7. 31..
 */

public class VersionCheckInfo {
    boolean isUpdate;
    String latestVersion;

    public VersionCheckInfo(boolean isUpdate, String latestVersion) {
        this.isUpdate = isUpdate;
        this.latestVersion = latestVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public boolean isUpdate() {
        return isUpdate;
    }
}
