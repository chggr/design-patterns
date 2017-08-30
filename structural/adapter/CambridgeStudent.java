public final class CambridgeStudent {

    private final int studentNo;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String division;
    private final String course;

    public CambridgeStudent(int studentNo, String firstName, String middleName,
                            String lastName, String division, String course) {

        this.studentNo = studentNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.division = division;
        this.course = course;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDivision() {
        return division;
    }

    public String getCourse() {
        return course;
    }
}

