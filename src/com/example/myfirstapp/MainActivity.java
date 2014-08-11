package com.example.myfirstapp;

import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends ActionBarActivity
{	
	 public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	 
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.ddfdfdfdasdsadsadsa
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/** Called when the user clicks the Send button 
	 * @throws ExecutionException 
	 * @throws InterruptedException */
	public void sendMessage(View view) throws InterruptedException, ExecutionException {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		
		EditText preTaxEditText = (EditText) findViewById(R.id.pre_Tax);		
		String pre_tax = preTaxEditText.getText().toString();
		
		EditText postTaxEditText = (EditText) findViewById(R.id.post_Tax);	
		String post_tax = postTaxEditText.getText().toString();
		
		String userid = "HewittSav_02352_il5i";
		String password = "FEpassword2";
		
		TestConnection t=new TestConnection();
		t.execute("http://192.168.144.1:8088/api/login/"+ userid +"/" + password);
		String ticket = t.get();
		ticket = ticket.replace("\"", "");
				
		TestConnection2 t1 = new TestConnection2();
		t1.execute("http://192.168.144.1:8088/api/" + ticket + "/demoFacade/runSavingsTransaction/"
			//+ pre_tax + "/" + post_tax);
			+ writeJSON(pre_tax, post_tax));// pre_tax + "/" + post_tax);
		
		//t1.get()
		
		//JSONObject object = writeJSON();
		
		SavingsTxnResult data = new Gson().fromJson(t1.get(), SavingsTxnResult.class);
		
		//put output on screen
		/*String strMessage = "Pre_tax = " + data.getPreTaxRate() + ", Post_tax = " 
			+ data.getPostTaxRate() + ", " + data.getConfirmMsg();*/
		
		String strMessage = data.getConfirmMsg() + " " + " for Pre-Tax =" + data.getPreTaxRate() +
			" and Post-Tax =" + data.getPostTaxRate();
		intent.putExtra(EXTRA_MESSAGE, strMessage);
		
		//start activity
		startActivity(intent);
	}
	
	public String writeJSON(String nPreTax, String nPostTax)
    {
         JSONObject object = new JSONObject();
         try
         {
             object.put("_strPreTaxRate", new Integer(nPreTax));
             object.put("_strPostTaxRate", new Integer(nPostTax));
             
         }
         catch (JSONException e)
         {
             e.printStackTrace();
         }
         System.out.println(object);
         return object.toString();
    }


}
