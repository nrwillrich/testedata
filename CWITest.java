class CWITest {
	public static void main(String args[]) {
		String input = "01/03/2010 23:00";
		System.out.printf("%s -> %s\n", input, DateTime.changeDate(input, '+', 4000));
	}
}