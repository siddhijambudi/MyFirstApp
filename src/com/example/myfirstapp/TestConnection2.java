// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		TestConnection2.java
 * Author:	sjambudi
 */

package com.example.myfirstapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.util.Log;

public class TestConnection2 extends AsyncTask<String, Void, String> 
{
	//private int responseHttp = 0;
		private String result="";

		@Override
		protected String doInBackground(String... urltest) {
		    // TODO Auto-generated method stub
		    try {
		        URL url = new URL(urltest[0]);
		        URLConnection connection = url.openConnection();
		        InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String line = reader.readLine();
				result = line;
				while((line = reader.readLine()) != null) {
				    result += line;
				}
				in.close();
		       /* connection.setConnectTimeout(2000);
		        HttpURLConnection httpConnection = (HttpURLConnection) connection;*/
		       /* responseHttp = httpConnection.getResponseCode();
		        if (responseHttp == HttpURLConnection.HTTP_OK) {
		            flag = "true";
		        } else {
		            flag = "false";
		        }*/
		    } catch (Exception e) {
		    	Log.d(e.toString(), e.getMessage());
		        e.printStackTrace();
		        
		    }
		  
		    return result;
		}
}

