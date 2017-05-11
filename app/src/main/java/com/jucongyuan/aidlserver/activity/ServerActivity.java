package com.jucongyuan.aidlserver.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jucongyuan.aidlserver.R;
import com.jucongyuan.aidlserver.service.ServerService;

public class ServerActivity extends Activity {

    private EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        et = (EditText) findViewById(R.id.et);
        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str = et.getText().toString();
                if (TextUtils.isEmpty(str))
                    Toast.makeText(ServerActivity.this, "请随意输入一些数字", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(ServerActivity.this, ServerService.class);
                    intent.putExtra("str", str);
                    startService(intent);
                }
            }
        });
    }
}
