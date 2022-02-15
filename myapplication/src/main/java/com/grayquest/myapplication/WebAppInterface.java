package com.grayquest.myapplication;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class WebAppInterface {

    private static final String TAG = WebAppInterface.class.getSimpleName();
    Context mContext;
    String data;

    public WebAppInterface(Context ctx) {
        this.mContext = ctx;
    }

    @JavascriptInterface
    public void showMessageInNative(String data) {
        Log.e(TAG, "Data: " + data);

        JSONObject testObjet = new JSONObject();
        try {
            testObjet.put("test", "eugdugsuidgis");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();

//        return testObjet.toString();
    }
    @JavascriptInterface
    public void showMessageInNative2(String data) {
        Log.e(TAG, "Data: " + data);

        JSONObject testObjet = new JSONObject();
        try {
            testObjet.put("test", "asasasa");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();

//        return testObjet.toString();
    }
}
