package com.example.demo.hello;

public class Greeting 
{
	
	private final long id;
	
	public long getId()
	{
		return id;
	}
	private final String content;
	
	public String getcontent()
	{
		return content;
	}
	

	
	public Greeting(long _id ,String _content)
	{
		this.content=_content;
		this.id=_id;
	}

}
