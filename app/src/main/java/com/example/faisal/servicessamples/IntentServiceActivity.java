package com.example.faisal.servicessamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentServiceActivity extends AppCompatActivity {

    private Button btnStartService;
    private int intentNumber=0;

    public static final String INTENT_TAG="DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        btnStartService=(Button)findViewById(R.id.btn_start_service);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentNumber++;
                Intent intent=new Intent(Intent.ACTION_SYNC, null, IntentServiceActivity.this, MyIntentService.class);
                intent.putExtra(INTENT_TAG,intentNumber+"");
                startService(intent);
            }
        });
    }
}
