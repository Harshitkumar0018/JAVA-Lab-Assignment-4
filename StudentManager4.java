import java.util.*;

public class StudentManager4 {

    private List<Student> list;
    private Map<Integer, Student> map;

    public StudentManager4(String file) {
        list = FileUtil4.readStudents(file);
        map = new HashMap<>();
        for (Student s : list) {
            map.put(s.getRollNo(), s);
        }
    }

    public void addStudent(Student s) {
        list.add(s);
        map.put(s.getRollNo(), s);
    }

    public void viewAll() {
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public Student searchByName(String name) {
        for (Student s : list)
            if (s.getName().equalsIgnoreCase(name))
                return s;
        return null;
    }

    public boolean deleteByName(String name) {
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getName().equalsIgnoreCase(name)) {
                it.remove();
                map.remove(s.getRollNo());
                return true;
            }
        }
        return false;
    }

    public void sortByMarks() {
        list.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));
    }

    public List<Student> getList() {
        return list;
    }
}
