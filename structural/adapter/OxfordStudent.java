public final class OxfordStudent {

    private final int id;
    private final String name;
    private final String familyName;
    private final String department;
    private final String course;

    public OxfordStudent(int id, String name, String familyName,
                         String department, String course) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.department = department;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getDepartment() {
        return department;
    }

    public String getCourse() {
        return course;
    }
}

