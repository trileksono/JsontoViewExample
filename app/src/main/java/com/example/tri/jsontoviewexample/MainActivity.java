package com.example.tri.jsontoviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicLayout dn = new DynamicLayout(this);
        JsonObject jsonObject = parseFile("coba.json");
        View dynamicView = dn.buatDynamicLayout(jsonObject);
        setContentView(dynamicView);
        ViewGroup root = (ViewGroup) ((ViewGroup) ((ViewGroup) dynamicView).getChildAt(0)).getChildAt(0);
        for (int x = 0; x < root.getChildCount(); x++) {
            if (root.getChildAt(x).getTag() != null) {
                Log.d("View = >", root.getChildAt(x).getTag().toString());
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
}
