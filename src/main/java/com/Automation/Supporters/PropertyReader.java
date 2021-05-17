package com.Automation.Supporters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.Automation.CustomisedExceptions.FrameWorkExceptions;


public class PropertyReader {
	
	private String filepath;
	private FileInputStream FIP;
	private Properties properties;
	private String Value;
	

	public PropertyReader(String filepath) throws IOException
	{
		this.filepath=filepath;
		FIP= new FileInputStream(filepath);
		properties = new Properties();
		properties.load(FIP);
	}
	
	public String GetPropertyValue(String Key) throws FrameWorkExceptions {

		if(properties!=null)
		{
			Value=properties.getProperty(Key);
		}
		else
		{
			System.out.println(" properties file is Null ");
			FrameWorkExceptions FE= new FrameWorkExceptions("Properties file is Null");
			throw FE;
		}
		return Value;
	}
	
	public String GetPropertyValue(String Key, String DefaultValue) throws FrameWorkExceptions {

		if(properties!=null)
		{
			Value=properties.getProperty(Key);
			if(Value==null)
			{
				Value=DefaultValue;
			}
		}
		else
		{
			System.out.println(" properties file is Null ");
			FrameWorkExceptions FE= new FrameWorkExceptions("Properties file is Null");
			throw FE;
		}
		return Value;
	}
	
	public String GetPropertyValue(Object Key) throws FrameWorkExceptions {

		if(properties!=null)
		{
			Value=(String) properties.get(Key);
		}
		else
		{
			System.out.println(" properties file is Null ");
			FrameWorkExceptions FE= new FrameWorkExceptions("Properties file is Null");
			throw FE;
		}
		return Value;
	}
	
	public String GetPropertyValue(Object Key, Object DefaultValue) throws FrameWorkExceptions {

		if(properties!=null)
		{
			Value=(String) properties.getOrDefault(Key, DefaultValue);
			if(Value==null)
			{
				Value=(String) DefaultValue;
			}
		}
		else
		{
			System.out.println(" properties file is Null ");
			FrameWorkExceptions FE= new FrameWorkExceptions("Properties file is Null");
			throw FE;
		}
		return Value;
	}
	
	public void Setproperty(String key, String Value) throws IOException {
		
		properties.setProperty(key, Value);
		FileOutputStream FOP= new FileOutputStream(filepath);
		properties.store(FOP, "Values saved Successfully");

	}
	
	public void Setproperty(Object key, Object Value) throws IOException {
		
		properties.put(key, Value);
		FileOutputStream FOP= new FileOutputStream(filepath);
		properties.store(FOP, "Values saved Successfully");

	}
	
	public Map<String, String> getpropertydata() {

		Map<String, String> Data= new LinkedHashMap<>();
		Set Keyset= properties.keySet();
		for(Object obj:Keyset)
		{
			String key= (String) obj;
			Value= properties.getProperty(key);
			Data.put(key, Value);
		}
		
		return Data;
	}
	
	public Set<String> GetKeys()
	{
		Set<String> Keys= new LinkedHashSet<>();
		Set keyset= properties.keySet();
		for(Object obj:keyset)
		{
			String Key= (String) obj;
			Keys.add(Key);
		}
		return Keys;
	}	
	
	public List<String> Getvalues()
	{
		List<String> Values= new ArrayList<>();
		Set Keys=properties.keySet();
		for(Object obj:Keys)
		{
			String Key= (String) obj;
			String Value=properties.getProperty(Key);
			Values.add(Value);
		}
		return Values;
	}

}
