package com.example.jette.helloworld;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.util.Log;

import com.example.jette.helloworld.com.example.jette.helloworld.api.IUpdateUI;
import com.example.jette.helloworld.com.example.jette.helloworld.model.Entry;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.lang.reflect.Type;
import java.util.List;

public class VotingResolveListener implements NsdManager.ResolveListener {
    private final Context context;
    private final Type type;
    private final Gson gson;
    private final IUpdateUI updateUi;

    public VotingResolveListener(Context mainActivity, IUpdateUI updateUI) {

        this.context = mainActivity;
        this.gson = new Gson();
        this.type = new TypeToken<List<Entry>>() {
        }.getType();

        this.updateUi = updateUI;

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

                        List<Entry> entries = gson.fromJson(data, VotingResolveListener.this.type);
                        Log.i("info", "good news everyone");
                        VotingResolveListener.this.updateUi.update(entries);

                    }
                });
    }
}
