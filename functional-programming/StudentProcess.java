import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentProcess {

	public static void main(String[] args) {

		Student[] students = {
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")};

		// Making a list out of above array
		List<Student> sList = Arrays.asList(students);

		System.out.println("Task 1:");
		System.out.println("\nComplete Student List:");
		task1(sList);

		System.out.println("\n\nTask 2:");
		System.out.println("\nStudents who got 50.0-100.0 sorted by grade:");
		task2(sList);

		System.out.println("\n\nTask 3:");
		System.out.println("\nFirst Student who got 50.0-100.0:");
		task3(sList);

		System.out.println("\n\nTask 4:");
		System.out.println("\nStudents in ascending order by last name then first:");
		task4a(sList);
		System.out.println("\nStudents in descending order by last name then first:");
		task4b(sList);

		System.out.println("\n\nTask 5:");
		System.out.println("\nUnique Student last names:");
		task5(sList);

		System.out.println("\n\nTask 6:");
		System.out.println("\nStudent names in order by last name then first name:");
		task6(sList);

		System.out.println("\n\nTask 7:");
		System.out.println("\nStudents by department:");
		task7(sList);

		System.out.println("\n\nTask 8:");
		System.out.println("\nCount of Students by department:");
		task8(sList);

		System.out.println("\n\nTask 9:");
		System.out.println("\nSum of Students' grades:");
		task9(sList);

		System.out.println("\n\nTask 10:");
		System.out.println("\nAverage of Students' grades:");
		task10(sList);
	}

	//Methods

	public static void task1(List<Student> s) {
		s.forEach(System.out::println);
	}

	public static void task2(List<Student> s) {
		s.stream().filter(student -> student.getGrade() >= 50 && student.getGrade() <= 100).sorted(Comparator.comparing(Student::getGrade)).forEach(System.out::println);
	}

	public static void task3(List<Student> s) {
		System.out.println(s.stream().filter(student -> student.getGrade() >= 50).findFirst().get());
	}

	public static void task4a(List<Student> s) {
		// Ascending order
		s.stream().sorted(Comparator.comparing(Student::getLName).thenComparing(Student::getFName)).forEach(System.out::println);
	}

	public static void task4b(List<Student> s) {
		s.stream().sorted(Comparator.comparing(Student::getLName).thenComparing(Student::getFName).reversed()).forEach(System.out::println);
	}

	public static void task5(List<Student> s) {
		s.stream().map(student -> student.getLName()).distinct().sorted().forEach(System.out::println);
	}

	public static void task6(List<Student> s) {
		s.stream().sorted(Comparator.comparing(Student::getLName).thenComparing(Student::getFName)).map(student -> student.getFName() + " " + student.getLName()).forEach(System.out::println);
	}

	public static void task7(List<Student> s) {
		Map<String, List<Student>> byDept = s.stream().collect(Collectors.groupingBy(Student::getDepartment));
		byDept.forEach((k, v) -> { System.out.println(k); 
		v.forEach(System.out::println);
		});
	}

	public static void task8(List<Student> s) {
		Map<String, Long> byDept = s.stream().collect(Collectors.groupingBy(Student::getDepartment, TreeMap::new, Collectors.counting()));
		byDept.forEach((k, v) -> System.out.println(k + " has " + v + " Student(s)"));
	}

	public static void task9(List<Student> s) {
		System.out.println(s.stream().mapToDouble(student -> student.getGrade()).sum());
	}

	public static void task10(List<Student> s) {
		DecimalFormat formater = new DecimalFormat("0.00");
		System.out.println(formater.format(s.stream().mapToDouble(student -> student.getGrade()).average().orElse(Double.NaN)));
	}
}
