package exam.finale.f05.p2;

import exam.finale.f05.p1.Customer;

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
	 * Returns a CustomerCollection as described in the exam instructions.
	 * 
	 * @param customerType
	 *            (String) - the type of customer
	 * @param cutoff
	 *            (int) - the cutoff number of minutes
	 * @returns CustomerCollection - the new CustomerCollection
	 */
	public CustomerCollection filter(String customerType, int cutoff) {
		CustomerCollection result = new CustomerCollection();
		for (int i = 0; i < numCustomers; i++) {
			Customer customer = customerArray[i];
			if (customer.getTypeOfService().equals(customerType)
					&& customer.getMinutes() < cutoff) {
				result.insertAtEnd(customer);
			}
		}
		return result;
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
		int i = 0;
		boolean isFind = false;
		for (; i < numCustomers; i++) {
			if (customerArray[i].getName().equals(newCustomer.getName())) {
				isFind = true;
				break;
			}
		}

		if (isFind) {
			for (int j = i; j > 0; j--) {
				customerArray[j] = customerArray[j - 1];
			}
			customerArray[0] = newCustomer;
		} else {
			insertAtEnd(newCustomer);
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
		int i = 0;
		boolean isFind = false;
		for (; i < numCustomers; i++) {
			if (customerArray[i].getName().equals(customerName)) {
				isFind = true;
				break;
			}
		}

		if (isFind) {
			int j = i;
			for (; j < numCustomers; j++) {
				customerArray[j] = customerArray[j + 1];
			}
			customerArray[j] = null;
			numCustomers--;
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