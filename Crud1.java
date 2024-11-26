package crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Employee {
	private int id;
	private String name;
	private float salary;

	Employee(int id, String e_name, float salary) {
		this.id = id;
		this.name = e_name;
		this.salary = salary;
	}

	public int get_id() {
		return id;

	}

	public String get_name() {
		return name;
	}

	public float get_salary() {
		return salary;
	}

	// override the method
	public String toString() {
		return id + " " + name + " " + salary;
	}
}

public class Crud1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> ce = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1.Insert");
			System.out.println("2.Display");
			System.out.println("3.Search");
			System.out.println("4.Delete");
			System.out.println("5.Update");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1://Insert operation
				System.out.print("Enter Employee_id: ");
				int e_id = sc.nextInt();
				System.out.print("Enter Employee_Name: ");
				String e_name = sc1.nextLine();
				System.out.print("Enter Employee_Salary: ");
				float e_sal = sc2.nextFloat();

				ce.add(new Employee(e_id, e_name, e_sal));
				break;

			case 2: ////Display operation
				System.out.println("----------Employee Data--------------");
				// Iterator function: each and every record in 1 by 1
				Iterator<Employee> i = ce.iterator();
				while (i.hasNext()) {
				Employee e = i.next();
				System.out.println(e);
				}
				// name
				System.out.println("-----------------------");
				break;

			case 3://Search operation
				boolean found = false;
				System.out.println("Enter Empno to Search : ");
				e_id = sc.nextInt();
				i = ce.iterator();
				while (i.hasNext()) {
					Employee e = i.next();
					if(e.get_id()== e_id)
					System.out.println(e);
					found = true;
				}
				// name
				System.out.println("-----------------------");
				if(!found) {
					System.out.println("Not found");
				}
				System.out.println("-----------------------");
				break;
				
			case 4://Delete operation
				found = false;
				System.out.println("Enter Empno to Delete: ");
				e_id = sc.nextInt();
				i = ce.iterator();
				while (i.hasNext()) {
					Employee e = i.next();
					if(e.get_id()== e_id)
					i.remove();
					found = true;
				}
				// name
				System.out.println("-----------------------");
				if(!found) {
					System.out.println("Not found");
				}
				else
				{
					System.out.println("Record Deleted Succesfully...");
				}
				System.out.println("-----------------------");
				break;
				
			case 5://Update operation
				found = false;
				System.out.println("Enter Empno to Update: ");
				e_id = sc.nextInt();
				ListIterator<Employee> li = ce.listIterator();
				while (li.hasNext()) {
					Employee e = li.next();
					if(e.get_id()== e_id)
					System.out.println("Enter new name");
					e_name=sc1.nextLine();
					System.out.println("Enter new Salary");
					e_sal=sc2.nextInt();
					li.set(new Employee(e_id,e_name,e_sal));
					found=true;
					
				}
				// name
				System.out.println("-----------------------");
				if(!found) {
					System.out.println("Not found");
				}
				else
				{
					System.out.println("Record Updated Succesfully...");
				}
				System.out.println("-----------------------");
				break;
				

			}
		} while (ch != 0);

	}

}
