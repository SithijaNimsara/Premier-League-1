public class Date {

	private int year=0;
    	private int month=0;
    	private int date=0;

    	public Date() {
    	}

    	public Date(int year, int month, int date) {
        	this.year = year;
        	this.month = month;
        	this.date = date;
    	}

    	public int getYear() {
        	return year;
    	}

    	public void setYear(int year) {
        	if (year<= 2020) {
            		this.year = year;
        	}
        	else {
            		System.out.println("Year is wrong !!!");
        	}
    	}

    	public int getMonth() {
        	return month;
    	}

    	public void setMonth(int month) {
        	if (0<month && 12 >=month) {
            		this.month = month;
        	}
        	else {
            		System.out.println("Month is wrong !!!");
        	}
    	}

    	public int getDate() {
        	return date;
    	}

    	public void setDate(int date) {
        	if (year%4 == 0 && month==2) {
            		if (date<=29) {
                		this.date = date;
            		}
            		else {
                		System.out.println("Date is wrong !!!");
            		}
        	}
        	else if (year%4 != 0 && month==2) {
            		if (date<=28) {
                		this.date = date;
            		}
            		else {
                		System.out.println("Date is wrong !!!");
            		}
        	}
        	else if (1 <= month && month <= 7) {
            		if (month%2==0) {
                		if (date<=30) {
                    			this.date=date;
                		}
                		else {
                    			System.out.println("Date is wrong !!!");
                		}
            		}
            		else {
                		if (date<=31) {
                    			this.date=date;
                		}
                		else {
                    			System.out.println("Date is wrong !!!");
                		}
            		}
        	}
        	else if (8 <= month && month <= 12){
            		if (month%2==0) {
                		if (date<=31) {
                    			this.date=date;
                		}
                		else {
                    			System.out.println("Date is wrong !!!");
                		}
            		}
            		else {
                		if (date<=30) {
                    			this.date=date;
                		}
                		else {
                    			System.out.println("Date is wrong !!!");
                		}
            		}
        	}
	}

}
