public final class CambridgeStudentAdapter implements Student {

    private final CambridgeStudent student;

    public CambridgeStudentAdapter(CambridgeStudent student) {
        this.student = student;
    }

    @Override
    public int getId() {
        return student.getStudentNo();
    }

    @Override
    public String getFirstName() {
        return student.getFirstName();
    }

    @Override
    public String getMiddleName() {
        return student.getMiddleName();
    }

    @Override
    public String getLastName() {
        return student.getLastName();
    }

    @Override
    public String getDepartment() {
        return student.getDivision();
    }

    @Override
    public String getCourse() {
        return student.getCourse();
    }

    @Override
    public String getUniversity() {
        return "University of Cambridge";
    }
}

