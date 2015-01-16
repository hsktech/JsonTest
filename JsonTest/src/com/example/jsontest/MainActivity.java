package com.example.jsontest;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {

	private final static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        testJson();
    }
    
    
    public void testJson(){
    	
    	JSONObject jObject = new JSONObject();
    	String jstring;
    	
    	try
    	{
    	  jObject.put("message_type", "node.content");
    	  jObject.put("device_id", "1234");
    	  jObject.put("device_key", "alwiejfalwf");
    	  jObject.put("content_value", "on");
    	}
    	catch (JSONException e)
    	{
    	  Log.d(TAG, "Data json err : " + e.getMessage());
    	}
    	
    	jstring = jObject.toString();
    	
    	
    	Log.d(TAG, "jstring : " + jstring);
    }
    
    
    public void keyGenerator() throws NoSuchAlgorithmException{
    	KeyGenerator generator = KeyGenerator.getInstance("AES");
    	SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
    	generator.init(128, random);
    	Key secureKey = generator.generateKey();
    }
    
}
