# HsVersionChecker


<pre><code>
VersionChecker.check("com.google.android.googlequicksearchbox", "1.0.0", new VersionChecker.OnResponseListener() {
            @Override
            public void onResponse(boolean result, VersionCheckInfo info) {
                if(result){
                    boolean isUpdate = info.isUpdate();
                    String latestVersion = info.getLatestVersion();
                }
            }
        });

        </pre></code>