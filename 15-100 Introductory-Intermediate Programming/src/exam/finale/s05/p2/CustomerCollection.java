package exam.finale.s05.p2;

import exam.finale.s05.p1.Customer;

/************************************************
 * Class CustomerCollection
 * 
 * You are to implement a method named filter, a method named insert and a
 * method named remove to this CustomerCollection class as described in the exam
 * instructions. You may NOT alter the signature of these methods. You may add
 * additional helper (private) methods if you choose, but you may NOT add
 * additional public methods, nor may you change any methods that we have
 * already defined.
 * 
 * Name: Section: Date: andrew e-mail:
 *************************************************/

public class CustomerCollection {
	private Customer[] customerArray; // unfilled array for valid customers
	private int numCustomers; // number of valid customers

	/**
	 * Constructor: allocates an array of length 1 sets numCustomers to 0 does
	 * not construct any individual customers
	 */
	public CustomerCollection() {
		customerArray = new Customer[1];
		numCustomers = 0;
	}

	/************************************************
	 * TO THE STUDENT: IMPLEMENT THIS FILTER METHOD *
	 ************************************************/
	/**
	 * Returns a CustomerCollection that has only the customers of this
	 * CustomerCollection that are the type of customer specified and have total
	 * cost under the cutoff
	 * 
	 * @param customerType
	 *            (String) - the type of customer
	 * @param cutoff
	 *            (double) - the cutoff total cost
	 * @returns CustomerCollection - the new CustomerCollection
	 */
	public CustomerCollection filter(String customerType, double cutoff) {
		CustomerCollection collection = new CustomerCollection();
		for (int i = 0; i < this.numCustomers; i++) {
			if (customerArray[i].getTypeOfService().equals(customerType)
					&& customerArray[i].getTotalCost() < cutoff)
				collection.insertAtEnd(customerArray[i]);
		}

		return collection;
	}

	/************************************************
	 * TO THE STUDENT: IMPLEMENT THIS INSERT METHOD *
	 ************************************************/
	/**
	 * Inserts a value, newCustomer, into this CustomerCollection as described
	 * in the exam instructions.
	 * 
	 * @param newCustomer
	 *            (Customer) the new Customer to be inserted into the collection
	 * @returns void
	 */
	public void insert(Customer newCustomer) {
		int position = -1;
		for (int i = 0; i < this.numCustomers; i++) {
			if (customerArray[i].getName().equals(newCustomer.getName())) {
				position = i;
				break;
			}
		}
		if (position == -1) {
			insertAtEnd(newCustomer);
		} else {
			for (int i = position; i > 0; i--) {
				customerArray[i] = customerArray[i - 1];
			}
			customerArray[0] = newCustomer;
		}
	}

	/************************************************
	 * TO THE STUDENT: IMPLEMENT THIS REMOVE METHOD *
	 ************************************************/
	/**
	 * Removes a customer from the CustomerCollection as described in the exam
	 * instructions.
	 * 
	 * @param customerName
	 *            (String) the name of the customer to be removed from the
	 *            collection
	 * @returns void
	 */
	public void remove(String customerName) {
		int position = -1;
		for (int i = 0; i < this.numCustomers; i++) {
			if (customerArray[i].getName().equals(customerName)) {
				position = i;
				break;
			}
		}

		if (position > -1) {
			for (int i = position; i < this.numCustomers; i++) {
				customerArray[i] = customerArray[i + 1];
			}
			this.numCustomers--;
		}
	}

	/************************************************
	 * TO THE STUDENT: * DO NOT MODIFY ANY CODE BELOW THESE COMMENTS *
	 ************************************************/
	/**
	 * Inserts the new item at the next available slot in the array, resizing
	 * the array as necessary.
	 * 
	 * @return void
	 */
	public void insertAtEnd(Customer newitem) {
		if (numCustomers >= customerArray.length)
			doubleLength();

		customerArray[numCustomers] = newitem;
		numCustomers++;
	}

	/**
	 * Changes the array to have twice as many available cells as it has now.
	 * All references in the original array are moved to the new array.
	 * 
	 * @return void
	 */
	private void doubleLength() {
		Customer[] newarray = new Customer[customerArray.length * 2];
		for (int i = 0; i < numCustomers; i++)
			newarray[i] = customerArray[i];
		customerArray = newarray;
	}

	/**
	 * Returns a string representing the entire contents of the collection
	 * 
	 * @return this collection's string representation
	 */
	public String toString() {
		String result = "  CustomerCollection[ " + "numCustomers="
				+ numCustomers + "/length=" + customerArray.length;
		for (int i = 0; i < numCustomers; i++)
			result += "\n    customer[" + i + "]= " + customerArray[i];
		result += "\n  ]";
		return result;
	}
}