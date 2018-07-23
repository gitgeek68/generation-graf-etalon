package com.example.demo.hello;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
@Entity
public class Projects 
{
	private @Id @GeneratedValue Integer id;
	private String name;
	


	  public Projects() {}

	  public Projects(String _name) 
	  {
	    this.name = _name;
	    
	  }
	  
	  
	  public Integer getId() 
	  {
		return id;
	}
	  
	  public String getName() 
	  {
		return name;
	}


}
