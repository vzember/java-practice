
public class Student {
	private String firstName;
	private String lastName;
	private double grade;
	private String department;


	public Student(String f, String l, double g, String d) {
		if (g > 100 || g < 0) {
			throw new IllegalArgumentException("Please enter a number between 0 and 100.");
		}
		else if (f == null || l == null || d == null) {
			throw new IllegalArgumentException("Please enter a first name, last name, and departmet name.");
		}
		else {
			firstName = f;
			lastName = l;
			grade = g;
			department = d;
		}
	}

	//Setters
	public void setFName(String f) {
		if (f != null) {
			firstName = f;
		}
	}

	public void setLName(String l) {
		if (l != null) {
			lastName = l;
		}
	}

	public void setGrade(double g) {
		if (g <= 100 && g >= 0) {
			grade = g;
		}
	}

	public void setDepartment(String d) {
		if (d != null) {
			department = d;
		}
	}


	//Getters
	public String getFName() {
		return firstName;
	}

	public String getLName() {
		return lastName;
	}

	//Get full name of student
	public String getName() {
		return (firstName + " " + lastName);
	}

	public double getGrade() {
		return grade;
	}

	public String getDepartment() {
		return department;
	}

	//To String
	@Override
	public String toString() {
		return (firstName + "\t" + lastName + "\t" + grade + "\t" + department);
	}

	// Equals
	public boolean equals (String f, String l, double g, String d) {
		boolean isEqual = false;
		if (firstName.equals(f) && lastName.equals(l) && (grade == g) && department.equals(d)) {
			isEqual = true;
		}
		return isEqual;
	}
}
