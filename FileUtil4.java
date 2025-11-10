import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil4 {

    public static List<Student> readStudents(String path) {
        List<Student> list = new ArrayList<>();
        File f = new File(path);
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",", -1);
                int roll = Integer.parseInt(p[0].trim());
                String name = p[1].trim();
                String email = p[2].trim();
                String course = p[3].trim();
                double marks = Double.parseDouble(p[4].trim());
                list.add(new Student(roll, name, email, course, marks));
            }
        } catch (Exception e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
        return list;
    }

    public static void writeStudents(String path, List<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Student s : list) {
                bw.write(s.getRollNo() + "," + s.getName() + "," + s.getEmail() + "," + s.getCourse() + "," + s.getMarks());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("File Write Error: " + e.getMessage());
        }
    }

    public static String readLineAt(String path, int lineNumber) {
        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            for (int i = 0; i <= lineNumber; i++) {
                String line = raf.readLine();
                if (i == lineNumber) return line;
            }
        } catch (Exception e) {
            System.out.println("RandomAccessFile Error: " + e.getMessage());
        }
        return null;
    }
}
