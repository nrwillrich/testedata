class DateTimeCalc {
	int day, month, year, hour, minutes;
	
	int[] maxDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public DateTimeCalc(String date) {
		String[] dayMonthYear = date.substring(0, 10).split("\\/");
		String[] hourMin = date.substring(11, 16).split(":");
		day = Integer.parseInt(dayMonthYear[0]);
		month = Integer.parseInt(dayMonthYear[1]);
		year = Integer.parseInt(dayMonthYear[2]);
		hour = Integer.parseInt(hourMin[0]);
		minutes = Integer.parseInt(hourMin[1]);
	}
	
	public void incDays(long amount) {
		long diff = day + amount - maxDays[month];
		
		if (diff <= 0) {
			day += amount;
		} else {
			day = 0;
			incMonth();
			incDays(diff);
		}
	}

	public void decDays(long amount) {
		long diff = day - amount;
		
		if (diff > 1) {
			day -= amount;
		} else {
			decMonth();
			day = maxDays[month];
			decDays(Math.abs(diff));
		}
	}
	
	public void incMins(long amount) {
		long diff = minutes + amount - 60;
		if (diff <= 0) {
			minutes += amount;
		} else {
			minutes = 0;
			incHour();
			incMins(diff);
		}
	}
	
	public void decMins(long amount) {
		long diff = minutes - amount;
		if (diff >= 0) {
			minutes -= amount;
		} else {
			decHour();
			minutes = 60;
			decMins(Math.abs(diff));
		}
	}

	public String toString() {
		return String.format("%02d/%02d/%d %02d:%02d", day, month, year, hour, minutes);
	}
	
	private void incMonth() {
		if (month < 12) {
			month++;
		} else {
			month = 1;
			year++;
		}
	}
	
	private void decMonth() {
		if (month > 1) {
			month--;
		} else {
			month = 12;
			year--;
		}
	}
	
	private void incHour() {
		if (hour < 22) {
			hour++;
		} else {
			hour = 0;
			incDays(1);
		}
	}
	
	private void decHour() {
		if (hour > 0) {
			hour--;
		} else {
			hour = 23;
			decDays(1);
		}
	}
}