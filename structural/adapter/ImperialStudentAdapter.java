public final class ImperialStudentAdapter implements Student {

    private final ImperialStudent student;

    public ImperialStudentAdapter(ImperialStudent student) {
        this.student = student;
    }

    @Override
    public int getId() {
        return student.getCid();
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
        return student.getSurname();
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
        return "Imperial College London";
    }
}

