package com.example.jette.helloworld;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

public class VotingDiscoveryListener implements NsdManager.DiscoveryListener{
    private final NsdManager nsdMgr;
    private final VotingResolveListener resolveListener;

    public VotingDiscoveryListener(final NsdManager nsdMgr, VotingResolveListener votingResolveListener) {
        this.nsdMgr = nsdMgr;
        this.resolveListener = votingResolveListener;
    }

    @Override
    public void onStartDiscoveryFailed(String s, int i) {

    }

    @Override
    public void onStopDiscoveryFailed(String s, int i) {

    }

    @Override
    public void onDiscoveryStarted(String s) {

    }

    @Override
    public void onDiscoveryStopped(String s) {
    }

    @Override
    public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
        this.nsdMgr.resolveService(nsdServiceInfo, this.resolveListener);
    }

    @Override
    public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
    }

}
