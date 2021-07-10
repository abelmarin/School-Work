package edu.depaul.se433.functional;

public class PositionFinder {
	public static int findPosition(int[] a, int x) {
		if (a != null && a.length > 0) {
			int position = -1;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == x) {
					position = i;
					break;
				}
			}
			return position;
		}
		throw new IllegalArgumentException();
	}
}
