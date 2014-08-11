package com.example.myfirstapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.util.Log;

/*
 * File:		TestConnection.java
 * Author:	sjambudi
 */

public class TestConnection extends AsyncTask<String, Void, String> {
	private String result="";

	@Override
	protected String doInBackground(String... urltest)
	{
		// TODO Auto-generated method stub
		try
		{
			URL url = new URL(urltest[0]);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = reader.readLine();
			result = line;
			while ((line = reader.readLine()) != null)
			{
				result += line;
			}
			in.close();
		}
		catch (Exception e)
		{
			Log.d(e.toString(), e.getMessage());
			e.printStackTrace();

		}

		return result;
	}
}
