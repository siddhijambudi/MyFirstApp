// Copyright (c) 2014 Financial Engines, Inc.  All Rights Reserved.
//                    Palo Alto, CA 

/*
 * File:		SavingsTxnResult.java
 * Author:	cchen
 */

package com.example.myfirstapp;



public class SavingsTxnResult
{
	private String _strPreTaxRate;
	private String _strPostTaxRate;
	private String _strConfirmMsg;
	
	public String getPreTaxRate()
	{
		return _strPreTaxRate;
	}
	public void setPreTaxRate(String strPreTaxRate)
	{
		_strPreTaxRate = strPreTaxRate;
	}
	public String getPostTaxRate()
	{
		return _strPostTaxRate;
	}
	public void setPostTaxRate(String strPostTaxRate)
	{
		_strPostTaxRate = strPostTaxRate;
	}
	public String getConfirmMsg()
	{
		return _strConfirmMsg;
	}
	public void setConfirmMsg(String strConfirmMsg)
	{
		_strConfirmMsg = strConfirmMsg;
	}
	
	
}
