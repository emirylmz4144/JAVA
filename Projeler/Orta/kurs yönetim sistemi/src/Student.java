public class Student {


    private String name,studentNumber;
    private int classes;
    private Course math;
    private Course physics;
    private Course chemical;
    private double avarage;
    private boolean isPass;


    Student(String name, int classes, String studentNumber, Course math, Course physics, Course chemical)
    {
        this.name = name;
        this.classes = classes;
        this.studentNumber = studentNumber;
        this.math = math;
        this.physics = physics;
        this.chemical = chemical;
        calcAvarage();
        this.isPass = false;
    }


    public void addCheckExamNote(int math, int physics, int chemical)
    {

        if (math >= 0 && math <= 100)
            this.math.setNote(math);

        if (physics>= 0 && physics <= 100)
            this.physics.setNote(physics);

        if (chemical >= 0 && chemical<= 100)
            this.chemical.setNote(chemical);

    }
    public void addCheckQuizNote(int math, int physics, int chemical)
    {

        if (math >= 0 && math <= 100)
            this.math.setQuiz(math);

        if (physics>= 0 && physics <= 100)
            this.physics.setQuiz(physics);

        if (chemical >= 0 && chemical<= 100)
            this.chemical.setQuiz(chemical);


    }


    public void isPass()
    {

        this.isPass = isCheckPass();
        printExamNote();
        printQuizNote();
        System.out.println("Ortalama : " + this.avarage);
        if (this.isPass) {
            System.out.println("Sınıfı Geçti. ");
        } else {
            System.out.println("Sınıfta Kaldı.");
        }

    }

    public boolean isCheckPass() {
        return this.avarage > 55;
    }

    public void calcAvarage()
    {
        realNote();
        setAvarage((this.physics.getRealNote() + this.chemical.getRealNote() + this.math.getRealNote()) / 3);
    }
    public void realNote()
    {
        this.math.setRealNote((this.math.getNote()*0.8)+(this.math.getQuiz()*0.2));
        this.physics.setRealNote((this.physics.getNote()*0.8)+(this.physics.getQuiz()*0.2));
        this.chemical.setRealNote((this.chemical.getNote()*0.8)+(this.chemical.getQuiz()*0.2));
    }


    public void printExamNote()
    {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.math.getNote());
        System.out.println("Fizik Notu : " + this.physics.getNote());
        System.out.println("Kimya Notu : " + this.chemical.getNote());
    }
    public void printQuizNote()
    {
        System.out.println("Matematik Quizi : " + this.math.getQuiz());
        System.out.println("Fizik Quizi: " + this.physics.getQuiz());
        System.out.println("Kimya Quizi : " + this.chemical.getQuiz());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        if (studentNumber==null)
            studentNumber="Bu öğrenciye numara atanmamış";
        else
            this.studentNumber=studentNumber;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public Course getMath() {
        return math;
    }

    public void setMath(Course math) {
        this.math = math;
    }

    public Course getPhysics() {
        return physics;
    }

    public void setPhysics(Course physics) {
        this.physics = physics;
    }

    public Course getChemical() {
        return chemical;
    }

    public void setChemical(Course chemical) {
        this.chemical = chemical;
    }

    public double getAvarage() {
        return avarage;
    }

    public void setAvarage(double avarage) {
        if (avarage<0)
            this.avarage=20;
        else
            this.avarage=avarage;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

}