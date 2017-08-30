// The adapter pattern is a structural software design pattern that can be used
// to convert the interface of incompatible classes into the interface expected
// by the clients. The incompatible classes are wrapped by an Adapter class
// that exposes the desired interface. Clients call methods on the Adapter
// object, which translates them into calls to the incompatible / legacy object.
//
// Advantages:
// - Code reuse.
// - Adapt legacy code to work with a new system.
//
// Disadvantages:
// - Sometimes are implemented in an over-complicated way.
// - Adding extra functionality in the Adapter should be avoided.
//
// Examples: Arrays.toList(), IO Streams
//
// In the example below, the Ministry of Education in the United Kingdom would
// like to collect information about all students in the country. Unfortunately
// each University has its own Student domain class that can differ quite a lot
// from the domain other Universities are using and from the standard Student
// interface that the Ministry expects. For example, student's last name can be
// mapped as "lastName" in one university, but as "surname" or "familyName" in
// others. In order to overcome this problem, an Adapter class is created to
// wrap the Student domain class from each University and expose the interface
// that the Ministry requires.

public class Adapter {

    private static boolean testCambridgeStudentAdapter() {
        CambridgeStudent student = new CambridgeStudent(101, "John", "Maynard",
            "Keynes", "Mathematical Statistics", "Theory of Probability");
        CambridgeStudentAdapter adapter = new CambridgeStudentAdapter(student);

        return 101 == adapter.getId() &&
               "John".equals(adapter.getFirstName()) &&
               "Maynard".equals(adapter.getMiddleName()) &&
               "Keynes".equals(adapter.getLastName()) &&
               "Mathematical Statistics".equals(adapter.getDepartment()) &&
               "Theory of Probability".equals(adapter.getCourse()) &&
               "University of Cambridge".equals(adapter.getUniversity());
    }

    private static boolean testImperialStudentAdapter() {
        ImperialStudent student = new ImperialStudent(213, "Alexander", "Fleming",
            "Department of Medicine", "Medicine");
        ImperialStudentAdapter adapter = new ImperialStudentAdapter(student);

        return 213 == adapter.getId() &&
               "Alexander".equals(adapter.getFirstName()) &&
               "".equals(adapter.getMiddleName()) &&
               "Fleming".equals(adapter.getLastName()) &&
               "Department of Medicine".equals(adapter.getDepartment()) &&
               "Medicine".equals(adapter.getCourse()) &&
               "Imperial College London".equals(adapter.getUniversity());
    }

    private static boolean testOxfordStudentAdapter() {
        OxfordStudent student = new OxfordStudent(321, "Oscar", "Wilde",
            "Humanities", "Classical Studies");
        OxfordStudentAdapter adapter = new OxfordStudentAdapter(student);

        return 321 == adapter.getId() &&
               "Oscar".equals(adapter.getFirstName()) &&
               "".equals(adapter.getMiddleName()) &&
               "Wilde".equals(adapter.getLastName()) &&
               "Humanities".equals(adapter.getDepartment()) &&
               "Classical Studies".equals(adapter.getCourse()) &&
               "University of Oxford".equals(adapter.getUniversity());
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testCambridgeStudentAdapter()) {
            System.out.println("Cambridge adapter test failed!");
            counter++;
        }
        if (!testImperialStudentAdapter()) {
            System.out.println("Imperial adapter test failed!");
            counter++;
        }
        if (!testOxfordStudentAdapter()) {
            System.out.println("Oxford adapter test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

