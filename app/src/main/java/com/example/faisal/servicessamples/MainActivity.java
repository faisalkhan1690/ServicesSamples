package com.example.faisal.servicessamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);

        listData=new ArrayList<String>();

        listData.add("Started service");
        listData.add("Bound service");
        listData.add("Intent service");
        listData.add("Intent service");

        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listData));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,StartedServiceActivity.class));
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this,BoundServicesActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(MainActivity.this,IntentServiceActivity.class));
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "Wrong selection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
