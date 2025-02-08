public class Course {
    private Teacher courseTeacher;
    private String name;
    private String code;
    private String coursePrefixName;
    private int note;
    private int quiz;
    private double realNote;

    public Course(String name, String code, String coursePrefixName)
    {
        this.name = name;
        this.code = code;
        this.coursePrefixName =coursePrefixName ;
        this.note = 0;
        this.quiz=0;
        this.realNote=0;
    }

    public void addTeacher(Teacher teacher)
    {
        if (this.coursePrefixName.equals(teacher.branch))
        {
            this.courseTeacher = teacher;
            System.out.print("İşlem başarılı ");
        }
        else
            System.out.println(teacher.name + " Akademisyeni bu dersi veremez.");

        printTeacher();
    }

    public void printTeacher() {
        if (courseTeacher != null)
        {
            System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
        } else
        {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoursePrefixName() {
        return coursePrefixName;
    }

    public void setCoursePrefixName(String coursePrefixName) {
        this.coursePrefixName = coursePrefixName;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
       if (note<0)
           this.note=0;
       else
           this.note=note;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
       if (quiz<0)
           this.quiz=0;
       else
           this.quiz=quiz;
    }

    public double getRealNote() {
        return realNote;
    }

    public void setRealNote(double realNote) {
        this.realNote = realNote;
    }
}