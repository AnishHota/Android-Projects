package com.danteapps.android.grouptripalpha;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);


        //Listview
        final ListView lv = (ListView) findViewById(R.id.list);
        final ArrayList<String> people = new ArrayList<String>();
        final ArrayAdapter<String> lvAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, people);
        lv.setAdapter(lvAdapter);


        //Floating action button click
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText peopleName = (EditText) findViewById(R.id.enterName);
                String nameRecieved = peopleName.getText().toString();
                if (!nameRecieved.isEmpty())
                    lvAdapter.add(nameRecieved);
                lvAdapter.notifyDataSetChanged();
                peopleName.setText("");
            }
        });

        //Reset button click
        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.removeAll(people);
                lv.setAdapter(lvAdapter);
            }
        });

        //Remove button click
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                people.remove(pos);
                lvAdapter.notifyDataSetChanged();
                return true;
            }
        });

        //ListView onClick flash message
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Long click the name to remove it", Toast.LENGTH_SHORT).show();
            }
        });

        //Next button onClick
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(tripActivity.this, moneyActivity.class);
                i.putExtra("list of people name",people);
                startActivity(i);
            }
        });
    }
}
