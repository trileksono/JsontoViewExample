package com.example.tri.jsontoviewexample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tri.jsontoviewexample.customLayout.HorizontalLayout;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
 * Created by tri on 1/1/16.
 */
public class DynamicLayout {

    LinearLayout root;
    Context mContext;
    int CURRENT_ID = 20;

    public DynamicLayout(Context mContext) {
        this.mContext = mContext;
        this.root = verticalLayout();
    }

    /*public View buatLayout(Context mContext) {
        View view = null;
        try {
            Class widget = Class.forName("android.widget.EditText");
            view = (View) widget.getConstructor(Context.class).newInstance(new Object[]{mContext});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        root.addView(view);
        return root;
    }*/

    public View buatDynamicLayout(JsonObject object) {
        View view = null;
        String widget = object.get("clazz").getAsString();
        if(widget.equals("vertical")){
            view = verticalLayout();
        }
        if(widget.equals("horizontal")) {
            view = new HorizontalLayout(mContext);
        }

        root.addView(masukanWidget(view,object));
        return root;
    }

    public View masukanWidget(View view,JsonObject object){
        if(view != null){
            ViewGroup vGroup = (ViewGroup) view;
            JsonArray s = object.get("child").getAsJsonArray();
            for(int i=0; i<s.size(); i++){
                View v;
                JsonObject obj = s.get(i).getAsJsonObject();
                switch (obj.get("clazz").getAsString()){
                    case "edittext":
                        v = defaultTxt(obj.get("value").getAsString());
                        v.setTag(obj.get("nama").getAsString());
                        vGroup.addView(v);
                        break;
                    case "textview":
                        v = defaultLabel(obj.get("value").getAsString());
                        v.setTag(obj.get("nama").getAsString());
                        vGroup.addView(v);
                        break;
                    case "spinner":
                        v = defalutComboBox(new String[]{obj.get("value").getAsString()});
                        vGroup.addView(v);
                    case "button":
                        v = defaultBtn(obj.get("value").getAsString());
                        v.setTag(obj.get("nama").getAsString());
                        vGroup.addView(v);
                        break;
                    case "horizontal" :
                        vGroup.addView(masukanWidget(new HorizontalLayout(mContext),obj));
                        break;
                }
            }
        }
        return view;
    }

    private LinearLayout verticalLayout() {
        LinearLayout vertical = new LinearLayout(mContext);
        vertical.setOrientation(LinearLayout.VERTICAL);
        return vertical;
    }

    private LinearLayout horizontalLayout() {
        LinearLayout horizontal = new LinearLayout(mContext);
        horizontal.setOrientation(LinearLayout.HORIZONTAL);
        return horizontal;
    }

    private TextView defaultLabel(String text) {
        TextView txt = new TextView(mContext);
        txt.setText(text);
        return txt;
    }

    private EditText defaultTxt(@Nullable String hint){
        EditText txt = new EditText(mContext);
        txt.setMaxLines(1);
        txt.setHint(hint);
        return txt;
    }

    private Button defaultBtn(String txt){
        Button btn = new Button(mContext);
        btn.setText(txt);
        return btn;
    }

    private Spinner defalutComboBox(String[] isiCombo){
        Spinner spn = new Spinner(mContext);
        spn.setAdapter(new ArrayAdapter<>(mContext,android.R.layout.simple_list_item_1,isiCombo));
        return spn;
    }
}
