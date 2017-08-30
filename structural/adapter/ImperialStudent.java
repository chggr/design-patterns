public final class ImperialStudent {

    private final int cid;
    private final String name;
    private final String surname;
    private final String department;
    private final String course;

    public ImperialStudent(int cid, String name, String surname,
                           String department, String course) {
        this.cid = cid;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.course = course;
    }

    public int getCid() {
        return cid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public String getCourse() {
        return course;
    }
}

