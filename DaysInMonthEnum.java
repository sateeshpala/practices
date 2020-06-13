package nearestbirthdays;

public enum DaysInMonthEnum {

	JANUARY(1, 31, "January"),
	FEBRUARY(2, 28, "february"),
	MARCH(3, 31, "march"),
	APRIL(4, 30, "april"),
	MAY(5, 31, "may"),
	JUNE(6, 30, "june"),
	JULY(7, 31, "july"),
	AUGUST(8, 31, "august"),
	SEPTEMBER(9, 30, "september"),
	OCTOBER(10, 31, "october"),
	NOVEMBER(11, 30, "novemeber"),
	DECEMEBR(12, 31, "december");
	
	private int index;
	private int daysInMonth;
	private String monthInString;
	
	private DaysInMonthEnum(int index, int daysInMonth, String month){
		
		this.index = index;
		this.daysInMonth = daysInMonth;
		this.monthInString = month;
	}

	public int getIndex() {
		return index;
	}

	public int getDaysInMonth() {
		return daysInMonth;
	}

	public String getMonthInString() {
		return monthInString;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setDaysInMonth(int daysInMonth) {
		this.daysInMonth = daysInMonth;
	}
	
}
