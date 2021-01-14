package materials;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateAndTime {

		private LocalDateTime currentDateTime = LocalDateTime.now();

		public String getCurrentDateTime() {
			String dateAndTimeAsString = "";
			int year = currentDateTime.getYear();
			int month = currentDateTime.getMonthValue();
			int day = currentDateTime.getDayOfMonth();
			int hour24 = currentDateTime.getHour();
			int minute = currentDateTime.getMinute();
			int secondValue = currentDateTime.getSecond();
			int hour = 0;
			String second = "";
			if (secondValue < 10) {
				second = "0" + secondValue;
			} else {
				second += secondValue;
			}
			String amPm = "";
			if (hour24 < 12) {
				amPm = "AM";
				hour = hour24;
			}else {
				amPm = "PM";
				hour = hour24 - 12;
			}
			dateAndTimeAsString = dateAndTimeAsString + month + "/" + day + "/"+ year + " " + hour + ":"+ minute + ":" + second + " " + amPm ;
			return dateAndTimeAsString;
		}
		
		
		

	
}