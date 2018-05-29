package com.example.jette.helloworld;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.jette.helloworld.com.example.jette.helloworld.api.IUpdateUI;
import com.example.jette.helloworld.com.example.jette.helloworld.model.Entry;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IUpdateUI {

    private static int idCounter = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        final NsdManager nsdMgr = (NsdManager) this.getApplicationContext().getSystemService(Context.NSD_SERVICE);

        nsdMgr.discoverServices("_voting._tcp.",
                NsdManager.PROTOCOL_DNS_SD, new VotingDiscoveryListener(nsdMgr, new VotingResolveListener(this, this)));

    }

    @Override
    public void update(List<Entry> entries) {

        TableLayout tl = (TableLayout) findViewById(R.id.main_table);
        for (Entry entry : entries) {

            TableRow row = new TableRow(this);
            row.setId(idCounter++);
            row.setBackgroundColor(Color.GRAY);
            row.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            TextView view = new TextView(this);
            view.setId(idCounter++);
            view.setText(entry.getUrl());
            view.setTextColor(Color.WHITE);
            view.setPadding(5, 5, 5, 5);
            row.addView(view);
            tl.addView(row, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        }
    }
}
