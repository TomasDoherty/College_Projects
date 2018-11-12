package ie.lyit.flight;

import java.io.Serializable;

public class Date implements Serializable{

	private int day, month, year;
	
	public Date()
	{
		day=month=year=0;
	}
	
	public Date(int day, int month, int year)throws IllegalArgumentException
	{
		if(day>31 || day<1 && month>12 || month<1)
			throw new IllegalArgumentException("Invalid data entered");
		
		//if data is valid variables are set
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	public String toString()
	{
		return day+"/"+month+"/"+year;
	}
	
	public boolean equals(Object obj)
	{
		Date daO;
		if(obj instanceof Date)
			daO = (Date)obj;
		else
			return false;
		
			return day==daO.day && month==daO.month && year==daO.year;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public void setDay(int dayIn) throws IllegalArgumentException
	{
		if(day>31 || day<1)
			throw new IllegalArgumentException("Invalid Day");
		
		//when there is no invalid data
		this.day=dayIn;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public void setMonth(int monthIn) throws IllegalArgumentException
	{
		if(month>12 || month<1)
			throw new IllegalArgumentException("Invalid Month");
		
		//if valid data is entered
		this.month=monthIn;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int yearIn)throws IllegalArgumentException
	{
		if(year<1900)
			throw new IllegalArgumentException("Invalid data (year must be above 1900");
		
		//year is set if data is valid
		this.year=yearIn;
	}
}
