import java.lang.IllegalArgumentException;

class DateTime {
	public static String changeDate(String date, char op, long value) throws IllegalArgumentException {
		if (op == '+' || op == '-') {
			return changeDateTime(date, op, Math.abs(value));
		} else {
			throw new IllegalArgumentException("Operação inválida");
		}
	}
	
	private static String changeDateTime(String date, char op, long value) {
		String result = date;
		DateTimeCalc calculo = new DateTimeCalc(date);

		if (value > 0) {
			long days = value / 1440; // 1440 minutos por dia
			if (days > 0) {
				if (op == '+') {
					calculo.incDays(days);
				} else if (op == '-') {
					calculo.decDays(days);
				}
			} 

			long minutes = value % 1440; // resto dos minutos
			if (minutes > 0) {
				if (op == '+') {
					calculo.incMins(minutes);
				} else if (op == '-') {
					calculo.decMins(minutes);
				}
			}
			result = calculo.toString();
		}
		return result;
	}
}