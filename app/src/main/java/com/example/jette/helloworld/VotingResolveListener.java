package com.example.jette.helloworld;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class VotingResolveListener implements NsdManager.ResolveListener {
    private final Context context;

    public VotingResolveListener(Context mainActivity) {
        this.context = mainActivity;
    }

    @Override
    public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {

    }

    @Override
    public void onServiceResolved(NsdServiceInfo serviceInfo) {
        final String url = "http:/" + serviceInfo.getHost() + ":" + serviceInfo.getPort() + "/getCurrentVote";
        Ion.with(this.context).load(url)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String data) {
                        Log.i("info", "good news everyone");
                    }
                });
    }
}
