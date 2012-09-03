package exam.e02;

public class HomeForSaleList {
	/*
	 * Instance variables: This should contain a list of up to ten (10)
	 * HomeForSale instances stored within an Array
	 * 
	 * Consider: How will you know if the array is full?
	 */
	private HomeForSale[] list;
	private int counter;
	private static final int SIZE = 10;

	/*
	 * Constructor: Just the basics, no parameters.
	 */
	public HomeForSaleList() {
		list = new HomeForSale[SIZE];
		counter = 0;
	}

	/*
	 * This method should add a HomeForSale to the end of the list, if there is
	 * room and return true, or, if there isn’t room, it should do nothing and
	 * return false.
	 */
	public boolean addHomeForSale(HomeForSale hfs) {
		if (counter < SIZE) {
			list[counter] = hfs;
			return true;
		} else
			return false;
	}

	/*
	 * This method should search the list of homes from the 0th index through
	 * the last valid index looking for a HomeForSale which compares equal to
	 * the hfs. The first such match should be removed. If the matching item is
	 * not the last item in the array, the last item should be swapped in to
	 * fill the hole. If no match is found, the method should return without
	 * damaging the list. Otherwise, the
	 */
	public boolean removeHome(HomeForSale hfs) {
		if (counter > 0) {
			int i;
			boolean found = false;
			for (i = 0; i < counter; i++) {
				if (hfs.equals(list[i])) {
					found = true;
					break;
				}
			}

			if (!found)
				return false;

			for (int j = i; j < counter - 1; j++)
				swap(list[j], list[j + 1]);

			list[counter--] = null;
			return true;
		} else
			return false;
	}

	/*
	 * Place your swap method here. Please notice the blanks. Needless to say,
	 * these are to help you – do fill them in as you complete the method.
	 */
	private void swap(HomeForSale hfs1, HomeForSale hfs2) {
		HomeForSale temp = hfs1;
		hfs1 = hfs2;
		hfs2 = temp;
	}

	/*
	 * This method should return a list of the names of the snacks in the same
	 * order as they are stored within the Array.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < counter; i++) {
			sb.append(list[i].toString()).append("\n");
		}
		return sb.toString();
	}
}
