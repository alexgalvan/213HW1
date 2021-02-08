package src;
import java.util.*;

public class Date {
    private int year;
    private int month;
    private int day;

    //taking mm/dd/yyyy and create a Date object
    public Date(String d){
        String dates[] = d.split("/");
		month = Integer.parseInt(dates[0]);
		day = Integer.parseInt(dates[1]);
		year = Integer.parseInt(dates[2]);
	}
    
    //creating an object with today's date (see Calendar class)
    public Date(){
        Calendar cal = Calendar.getInstance();

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);
    }

    public boolean isValid(){
        Calendar currentDate = Calendar.getInstance();
        Calendar thisDate = Calendar.getInstance();
            thisDate.set(year, month, day);

        
        if(year < 1900){
            return false;
        }

        if(thisDate.after(currentDate)){
            return false;
        }

        if (month > 12 || month < 1) {
			return false;
		}
		if (day > 31 || day < 1) {
			return false;
		}
		// ensures for months April,June,September, and November do not have more than
		// 30 days
		if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
			return false;
		}
		// ensures Feburary has no more than 28 days on non leapyears, and 29 on
		// leapyears
		if ((month == 2 && !leapYear(year) && day > 28) || (month == 2 && leapYear(year) && day > 29)) {
			return false;
		}

		return true;
        
    }

    // User created method, checks if there is a leap year
	private static boolean leapYear(int yr) {
		if (yr % 4 == 0) {
			if (yr % 100 == 0) {
				if (yr % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getMonth(){
		return this.month;
	}
	
	public int getDay(){
		return this.day;
	}



	public static void main(String[] args) {
		Date currentDate = new Date(); //test case for default constructor
		Date validDate = new Date("03/01/2003"); //valid test case  
		Date before1900 = new Date("01/11/1899"); //invalid test case; year is before 1900
		Date afterCurrent = new Date("01/11/2030"); //invalid test case; year is after current date
		Date validFeb = new Date("02/29/2000"); //valid test case; year 2000 was a leapyear
		Date invalidFeb = new Date("02/29/2019");
	}
}