package components;

public class Multiplexer {
	public static int selection;
	public static int value1;
	public static int value2;
	public static int result;

	public int multiplex(int v1, int v2, int s) {
		if (selection == 0) {
			if (value1 == 0) {
				result = 0;
			} else {
				if (value2 == 0) {
					result = 1;
				} else {
					result = 0;
				}
			}
		} else {
			if (value1 == 0) {
				result = 1;
			} else {
				if (value2 == 0) {
					result = 0;
				} else {
					result = 1;
				}
			}
		}
		return result;
	}
}
