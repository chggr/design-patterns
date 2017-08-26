// The builder pattern is a creational software design pattern that provides a
// solution to the telescoping constructor anti pattern. Instead of using
// multiple constructors covering all possible parameter combinations, we use
// a separate Builder static inner class to receive each parameter value step
// by step and return the constructed object at once. This makes the builder
// pattern ideal for constructing immutable objects with multiple parameters.
// In effect the construction process is separated from the representation and
// handled by a different class.
//
// Advantages:
// - Encapsulates code for construction and representation.
// - Provides control over the steps of the construction process.
//
// Disadvantages:
// - Requires creating a separate mutable Builder class.
//
// Examples: StringBuilder, DocumentBuilder, Locale.Builder
//
// In the example below, class Person has seven fields and the potential to
// grow even further. A Person with no name or surname is not valid and we
// would ideally like instances of this class to be immutable. There are three
// possible ways to create Persons:
//
// 1) Define Person as a simple POJO with getters and setters.
//    In this case instances will not be immutable and there are no safeguards
//    against clients creating invalid objects (i.e. a Person with no name).
//
// 2) Define Person with multiple constructors.
//    With this approach it is possible to have immutable instances but the
//    number of constructors required can quickly grow and become unsustainable.
//    Having more than 3-4 parameters can also make constructors hard to read.
//
// 3) Use builder pattern.
//    The builder pattern allows us to create immutable instances, ensure all
//    mandatory fields are populated, avoid the problem of telescoping
//    constructors and have a nice fluid interface for object creation.

public class Builder {

    private static boolean testBuilder_AllPopulated() {
        final Person p = new Person.Builder("Daenerys", "Targaryen")
                                   .middleName("Stormborn")
                                   .title("Mother of Dragons")
                                   .height(1.65)
                                   .weight(58)
                                   .profession("Queen")
                                   .build();

        return "Daenerys".equals(p.getName()) &&
               "Targaryen".equals(p.getSurname()) &&
               "Stormborn".equals(p.getMiddleName()) &&
               "Mother of Dragons".equals(p.getTitle()) &&
               1.65 == p.getHeight() &&
               58 == p.getWeight() &&
               "Queen".equals(p.getProfession());
    }

    private static boolean testBuilder_NonePopulated() {
        final Person p = new Person.Builder("Jon", "Snow").build();

        return "Jon".equals(p.getName()) &&
               "Snow".equals(p.getSurname()) &&
               null == p.getMiddleName() &&
               null == p.getTitle() &&
               null == p.getHeight() &&
               null == p.getWeight() &&
               null == p.getProfession();
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testBuilder_AllPopulated()) {
            System.out.println("All fields populated builder test failed!");
            counter++;
        }
        if (!testBuilder_NonePopulated()) {
            System.out.println("No fields populated builder test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

