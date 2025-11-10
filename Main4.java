import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file = "students_lab4.txt";
        StudentManager4 manager = new StudentManager4(file);

        boolean run = true;
        while (run) {
            System.out.println("\n===== Student Menu (Lab 4) =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");
            String ch = sc.nextLine();

            switch (ch) {
                case "1":
                    System.out.print("Roll No: ");
                    int r = Integer.parseInt(sc.nextLine());
                    System.out.print("Name: ");
                    String n = sc.nextLine();
                    System.out.print("Email: ");
                    String e = sc.nextLine();
                    System.out.print("Course: ");
                    String c = sc.nextLine();
                    System.out.print("Marks: ");
                    double m = Double.parseDouble(sc.nextLine());

                    manager.addStudent(new Student(r, n, e, c, m));
                    System.out.println("Student Added.");
                    break;

                case "2":
                    manager.viewAll();
                    break;

                case "3":
                    System.out.print("Enter Name: ");
                    Student s = manager.searchByName(sc.nextLine());
                    System.out.println(s != null ? s : "Not Found.");
                    break;

                case "4":
                    System.out.print("Enter Name: ");
                    System.out.println(manager.deleteByName(sc.nextLine()) ? "Deleted." : "Not Found.");
                    break;

                case "5":
                    manager.sortByMarks();
                    System.out.println("Sorted by Marks:");
                    manager.viewAll();
                    break;

                case "6":
                    FileUtil4.writeStudents(file, manager.getList());
                    System.out.println("Saved Successfully.");
                    run = false;
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        }

        System.out.println("\nRandomAccessFile Demo (Read 2nd line):");
        String line = FileUtil4.readLineAt(file, 1);
        System.out.println(line);
    }
}
