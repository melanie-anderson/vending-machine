package materials;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class DateAndTimeTest {

	@Test
	public void get_current_date_time_returns_accurate_data_in_proper_format_if_PM() {
		DateAndTime dat = new DateAndTime();
		LocalDateTime currentDateTime = LocalDateTime.now();
		int year = currentDateTime.getYear();
		int month = currentDateTime.getMonthValue();
		int day = currentDateTime.getDayOfMonth();
		int hour = currentDateTime.getHour() -12 ;
		int minute = currentDateTime.getMinute();
		int second = currentDateTime.getSecond(); 
		String expectedResult =  month + "/" + day + "/"+ year + " " + hour + ":"+ minute + ":" + second + " " + "PM" ;
		String actualResult = dat.getCurrentDateTime();
		
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void get_current_date_time_returns_accurate_data_in_proper_format_if_AM() {
		DateAndTime dat = new DateAndTime();
		LocalDateTime currentDateTime = LocalDateTime.now();
		int year = currentDateTime.getYear();
		int month = currentDateTime.getMonthValue();
		int day = currentDateTime.getDayOfMonth();
		int hour = currentDateTime.getHour() ;
		int minute = currentDateTime.getMinute();
		int second = currentDateTime.getSecond(); 
		String expectedResult =  month + "/" + day + "/"+ year + " " + hour + ":"+ minute + ":" + second + " " + "AM" ;
		String actualResult = dat.getCurrentDateTime();
		
		assertEquals(expectedResult, actualResult);
	}

}
