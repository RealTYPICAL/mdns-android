package com.example.jette.helloworld;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NsdManager nsdMgr = (NsdManager) this.getApplicationContext().getSystemService(Context.NSD_SERVICE);

        nsdMgr.discoverServices("_voting._tcp.",
                NsdManager.PROTOCOL_DNS_SD, new VotingDiscoveryListener(nsdMgr, new VotingResolveListener(this)));

    }
}
