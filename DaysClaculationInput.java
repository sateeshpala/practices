package nearestbirthdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DaysClaculationInput {

	public static List<UserBean> lists = new ArrayList<UserBean>();
	
	public static HashMap<String, Integer> outValues = new HashMap<String, Integer>();

	public static List<Integer> noValues = new ArrayList<Integer>();
	
	public static final int numberDaysInYear = 365;
	public static final int numberDaysInLeapYear = 366;
	
	public static List<UserBean> usersData(int numberOfPeoples) {

		UserBean userBean = new UserBean();

		for (int i = 1; i <= numberOfPeoples; i++) {
			userBean = new UserBean();
			Scanner name = new Scanner(System.in);
			System.out.print("Enter Name of person:");
			String nameOfThePerson = name.nextLine();

			Scanner sc1 = new Scanner(System.in);
			System.out.print("Enter Date:");
			int day = sc1.nextInt();

			Scanner sc2 = new Scanner(System.in);
			System.out.print("Enter month:");
			int month = sc2.nextInt();

			Scanner sc3 = new Scanner(System.in);
			System.out.print("Enter Year:");
			long year = sc3.nextLong();

			userBean.setName(nameOfThePerson);
			userBean.setDay(day);
			userBean.setMonth(month);
			userBean.setYear(year);

			lists.add(userBean);

		}
		return lists;

	}
	
	private static HashMap<String, Integer> remainingDaysCalculationForBirthday(int currentday, int currentMonth,
			long currentYear, List<UserBean> userBean, HashMap<Integer, Integer> daysInMonth, int daysInFeb, boolean leapYear) {

		int remaingDaysInMonth = 0;
		int numberDays = 0;
		outValues = new HashMap<String, Integer>();
		
		for (int i = 1; i <= daysInMonth.size(); i++) {
			
			if (currentMonth == i) {
				remaingDaysInMonth = daysInMonth.get(i) - currentday;
			}
			
		}

		for (int i = 0; i < userBean.size(); i++) {
			int month = userBean.get(i).getMonth();
			int day = userBean.get(i).getDay();
			
			day=  day+remaingDaysInMonth;
			
			for (int j = 1; j < month; j++) {
				Integer days = daysInMonth.get(j);
				numberDays = numberDays + days;
			}
			
			numberDays = numberDays + day;
		
			if(leapYear) {
				numberDays = Math.addExact(numberDays, 1);
				if(numberDays >= numberDaysInLeapYear) {
					numberDays = Math.subtractExact(numberDays, numberDaysInLeapYear);
				}
			}else 	if(numberDays >= numberDaysInLeapYear) {
					numberDays = Math.subtractExact(numberDays, numberDaysInLeapYear);
			}
			
			outValues.put(userBean.get(i).getName(), numberDays);
			noValues.add(numberDays);
			numberDays = 0;
		}
		return outValues;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number of people:");
		int numberOfPeople = sc.nextInt();

		System.out.print("Enter current Day:");
		int todayDay = sc.nextInt();
		System.out.print("Enter Current Month:");
		int thisMonth = sc.nextInt();
		System.out.print("Enter Current Year:");
		long thisYear = sc.nextLong();

		boolean leapYear = false;
		if ((thisYear) % 4 == 0 && ((thisYear % 100 != 0) || (thisYear % 400 == 0))) {
			leapYear = true;
		} else if ((thisYear + 1) % 4 == 0 && (((thisYear + 1) % 100 != 0) || ((thisYear + 1) % 400 == 0))) {
			leapYear = true;
		}

		int daysInMonthFeb = DaysInMonthEnum.FEBRUARY.getDaysInMonth();
		if (leapYear) {
			daysInMonthFeb = DaysInMonthEnum.FEBRUARY.getDaysInMonth() + 1;
			System.out.println("leapYear" + leapYear + " daysInMonthFeb " + daysInMonthFeb);
		}

		List<UserBean> usersData = null;
		if (numberOfPeople > 0) {
			usersData = usersData(numberOfPeople);
		}

		HashMap<Integer, Integer> daysInMonth = new HashMap<Integer, Integer>();
		daysInMonth.put(1, 31);
		daysInMonth.put(2, 28);
		daysInMonth.put(3, 31);
		daysInMonth.put(4, 30);
		daysInMonth.put(5, 31);
		daysInMonth.put(6, 30);
		daysInMonth.put(7, 31);
		daysInMonth.put(8, 31);
		daysInMonth.put(9, 30);
		daysInMonth.put(10, 31);
		daysInMonth.put(11, 30);
		daysInMonth.put(12, 31);

		for (int i = 0; i < usersData.size(); i++) {
			System.out.println(usersData.get(i).getName() + " - " + usersData.get(i).getDay() + " "
					+ usersData.get(i).getMonth() + " " + usersData.get(i).getYear());
		}


		outValues = remainingDaysCalculationForBirthday(todayDay, thisMonth, thisYear, usersData, daysInMonth,
				daysInMonthFeb, leapYear);
		
		Collections.sort(noValues);
		for (int j = 0; j < noValues.size(); j++) {
			int sortingValue = noValues.get(j);
				for (int k = 0; k < outValues.size(); k++) {
					boolean istrue = false;
					int value = outValues.get(usersData.get(k).getName());
					if(sortingValue == value) {
						System.out.println(usersData.get(k).getName()+ " "+ value +"Days");
						istrue= true;
					
					}
					if(istrue) {
						continue;
					}
					
				}
		}
		
	}

}
