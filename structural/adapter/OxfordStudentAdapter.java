public final class OxfordStudentAdapter implements Student {

    private final OxfordStudent student;

    public OxfordStudentAdapter(OxfordStudent student) {
        this.student = student;
    }

    @Override
    public int getId() {
        return student.getId();
    }

    @Override
    public String getFirstName() {
        return student.getName();
    }

    @Override
    public String getMiddleName() {
        return "";
    }

    @Override
    public String getLastName() {
        return student.getFamilyName();
    }

    @Override
    public String getDepartment() {
        return student.getDepartment();
    }

    @Override
    public String getCourse() {
        return student.getCourse();
    }

    @Override
    public String getUniversity() {
        return "University of Oxford";
    }
}

