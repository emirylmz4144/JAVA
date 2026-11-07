import java.util.Comparator;

public class studentComperator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int cgpaDiff = Double.compare(s2.getCPGA(), s1.getCPGA());
        if (cgpaDiff != 0)
            return cgpaDiff;

        // isme göre karşılaştır
        int nameDiff = s1.getName().compareTo(s2.getName());
        if (nameDiff != 0)
            return nameDiff;

        // Id göre karşılaştır
        return Integer.compare(s1.getID(), s2.getID());
    }
}
