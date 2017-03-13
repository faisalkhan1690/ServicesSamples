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

/**
 * Activity class to list all kind of services available in android Named as<p>
 * 1) Started service
 * 2) Bound service
 * 3) Intent service
 * 4) Job Scheduler
 *
 * @author Faisal Khan
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> listData = new ArrayList<>();

        listData.add("Started service");
        listData.add("Bound service");
        listData.add("Intent service");
        listData.add("Job Scheduler");


        listView.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listData));

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

                    case 3:
                        startActivity(new Intent(MainActivity.this,JobSchedulerActivity.class));
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "Wrong selection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
