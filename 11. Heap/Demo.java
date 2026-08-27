import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Comparator;

class Student implements Comparable<Student> {
    String name;
    int percentage;

    public Student(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    @Override
    public int compareTo(Student s2) {
        return this.percentage - s2.percentage; // AscOrder
    }
}

public class Demo {
    public static void main(String[] args) {
        
        // PriorityQueue<Student> pq = new PriorityQueue<>(); // AscOrder

        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder()); // DescOrder

        pq.add(new Student("Suresh", 200));
        pq.add(new Student("Mahesh", 30));

        while (!pq.isEmpty()) {
            Student s = pq.peek();
            System.out.println(s.name + " -> " + s.percentage);
            pq.remove();
        }
    }
}