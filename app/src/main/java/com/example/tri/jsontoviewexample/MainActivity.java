package com.example.tri.jsontoviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicLayout dn = new DynamicLayout(this);
        JsonObject jsonObject = parseFile("coba.json");
        View dynamicView = dn.buatDynamicLayout(jsonObject);
        setContentView(dynamicView);
        root = (ViewGroup) ((ViewGroup) dynamicView).getChildAt(0);
        for (int x = 0; x < root.getChildCount(); x++) {
            if (root.getChildAt(x) instanceof Button) {
                root.getChildAt(x).setOnClickListener(this);
            }
        }
    }

    private JsonObject parseFile(String file) {
        JsonObject jsonObject = new JsonObject();
        try {
            JsonElement jElement = new JsonParser().parse(new InputStreamReader(getApplicationContext().getResources().getAssets().open(file)));
            jsonObject = jElement.getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public void onClick(View v) {
        if(v.findViewWithTag("btnLogin") != null){
            String nama = ((EditText) root.findViewWithTag("tes")).getText().toString();
            Log.d("NAMA =>",nama);
        }
    }
}
