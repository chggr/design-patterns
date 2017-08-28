// The visitor pattern is a behavioral software design pattern that separates
// an algorithm from the object structure on which it operates. It allows
// creating new algorithms / operations easily, without modifying the classes
// of the object structure. Visitor classes are defined that help maintain the
// algorithm in one single location and add "virtual" functions to a family of
// classes without actually changing them. This pattern is ideal for public
// APIs, since it allows clients to perform operations using a "visiting" class.
//
// The visitor pattern should be considered when:
// - Many unrelated operations are required on an object structure.
// - The classes of the object structure should not be changed.
// - New operations are added frequently.
// - Algorithms typically involve multiple classes of the object structure but
//   it is desired to maintain the logic in a single location.
//
// Advantages:
// - Easy to add more Visitors in the future. 
// - Helps maintain the open / closed principle.
//
// Disadvantages:
// - Adds flexibility that sometimes is not needed.
// - Indirection of working with an object outside its domain can be confusing.
//
// Examples: java.lang.model.element.ElementVisitor
//
// In the example below we have a class structure that implements interface
// Shape and consists of Circle, Triangle, Parallelogram and Drawing. There are
// multiple operations that we want to execute against this structure, such as
// finding the total area or the perimeter of the shapes. There are three ways
// to implement this:
//
// 1) Add methods calculateArea() and calculatePerimeter() in every Shape. This
//    approach means that all classes in the structure will have to change when
//    a new operation needs to be added. Furthermore, the algorithms are spread
//    accross all classes, which soon become overloaded with these operations.
//
// 2) Create two separate classes AreaCalculator and PerimeterCalculator that
//    will query the type of each object, cast it to the appropriate class and
//    then select and apply the correct algorithm. This involves having a big
//    if statement to branch according to object type, which is not ideal.
//
// 3) Implement the visitor pattern. Each class in the Shape hierarchy accepts
//    a ShapeVisitor, which in turn implements visit() for each Shape subclass.
//    Each visit() method contains the logic to be executed for that particular
//    Shape subclass. Multible ShapeVisitors can be created to apply different
//    operations to the Shape class hierarchy. For example the AreaShapeVisitor
//    contains a visit() method for each Shape subclass to calculalte the area
//    for that particular Shape. Similary for the PerimeterShapeVisitor. This
//    implementation keeps each Shape subclass simple and light-weight and at
//    the same time makes it much easier to add more operations by implementing
//    ShapeVisitor. Note that the implementation of accept() is the same for
//    each Shape subclass but cannot be moved to an AbstractShape class and
//    inherited by all AbstractShape subclasses. This is because there is a
//    reference to "this", which needs to point to the subclass itself and not
//    to the abstract base class.

public class Visitor {

    private static boolean testAreaVisitor_Circle() {
        Drawing drawing = new Drawing();
        drawing.draw(new Circle(new Point(1.0, 1.0), 2.0));
        AreaShapeVisitor areaVisitor = new AreaShapeVisitor();
        drawing.accept(areaVisitor);
        return Math.PI * 4.0 == areaVisitor.getTotalArea();
    }

    private static boolean testAreaVisitor_Triangle() {
        Drawing drawing = new Drawing();
        drawing.draw(new Triangle(new Point(0.0, 0.0),
                                  new Point(1.0, 0.0),
                                  new Point(0.0, 2.0)));
        AreaShapeVisitor areaVisitor = new AreaShapeVisitor();
        drawing.accept(areaVisitor);
        return 1.0 == areaVisitor.getTotalArea();
    }

    private static boolean testAreaVisitor_Parallelogram() {
        Drawing drawing = new Drawing();
        drawing.draw(new Parallelogram(new Point(0.0, 0.0),
                                       new Point(1.0, 0.0),
                                       new Point(0.0, 2.0)));
        AreaShapeVisitor areaVisitor = new AreaShapeVisitor();
        drawing.accept(areaVisitor);
        return 2.0 == areaVisitor.getTotalArea();
    }

    private static boolean testAreaVisitor() {
        Drawing drawing = new Drawing();
        drawing.draw(new Circle(new Point(1.0, 1.0), 2.0));
        drawing.draw(new Triangle(new Point(0.0, 0.0),
                                  new Point(1.0, 0.0),
                                  new Point(0.0, 2.0)));
        drawing.draw(new Parallelogram(new Point(0.0, 0.0),
                                       new Point(1.0, 0.0),
                                       new Point(0.0, 2.0)));
        AreaShapeVisitor areaVisitor = new AreaShapeVisitor();
        drawing.accept(areaVisitor);
        return Math.PI * 4.0 + 1.0 + 2.0 == areaVisitor.getTotalArea();
    }

    private static boolean testPerimeterVisitor_Circle() {
        Drawing drawing = new Drawing();
        drawing.draw(new Circle(new Point(1.0, 1.0), 1.0));
        PerimeterShapeVisitor perimeterVisitor = new PerimeterShapeVisitor();
        drawing.accept(perimeterVisitor);
        return 2.0 * Math.PI == perimeterVisitor.getTotalPerimeter();
    }

    private static boolean testPerimeterVisitor_Triangle() {
        Drawing drawing = new Drawing();
        drawing.draw(new Triangle(new Point(0.0, 0.0),
                                  new Point(3.0, 0.0),
                                  new Point(0.0, 4.0)));
        PerimeterShapeVisitor perimeterVisitor = new PerimeterShapeVisitor();
        drawing.accept(perimeterVisitor);
        return 12.0 == perimeterVisitor.getTotalPerimeter();
    }

    private static boolean testPerimeterVisitor_Parallelogram() {
        Drawing drawing = new Drawing();
        drawing.draw(new Parallelogram(new Point(0.0, 0.0),
                                       new Point(2.0, 0.0),
                                       new Point(0.0, 1.0)));
        PerimeterShapeVisitor perimeterVisitor = new PerimeterShapeVisitor();
        drawing.accept(perimeterVisitor);
        return 6.0 == perimeterVisitor.getTotalPerimeter();
    }

    private static boolean testPerimeterVisitor() {
        Drawing drawing = new Drawing();
        drawing.draw(new Circle(new Point(1.0, 1.0), 1.0));
        drawing.draw(new Triangle(new Point(0.0, 0.0),
                                  new Point(3.0, 0.0),
                                  new Point(0.0, 4.0)));
        drawing.draw(new Parallelogram(new Point(0.0, 0.0),
                                       new Point(2.0, 0.0),
                                       new Point(0.0, 1.0)));
        PerimeterShapeVisitor perimeterVisitor = new PerimeterShapeVisitor();
        drawing.accept(perimeterVisitor);
        return 2.0 * Math.PI + 12.0 + 6.0 == perimeterVisitor.getTotalPerimeter();
    }


    public static void main(String[] args) {
        int counter = 0;
        if (!testAreaVisitor_Circle()) {
            System.out.println("Area visitor circle test failed!");
            counter++;
        }
        if (!testAreaVisitor_Triangle()) {
            System.out.println("Area visitor triangle test failed!");
            counter++;
        }
        if (!testAreaVisitor_Parallelogram()) {
            System.out.println("Area visitor parallelogram test failed!");
            counter++;
        }
        if (!testAreaVisitor()) {
            System.out.println("Area visitor test failed!");
            counter++;
        }
        if (!testPerimeterVisitor_Circle()) {
            System.out.println("Perimeter visitor circle test failed!");
            counter++;
        }
        if (!testPerimeterVisitor_Triangle()) {
            System.out.println("Perimeter visitor triangle test failed!");
            counter++;
        }
        if (!testPerimeterVisitor_Parallelogram()) {
            System.out.println("Perimeter visitor parallelogram test failed!");
            counter++;
        }
        if (!testPerimeterVisitor()) {
            System.out.println("Perimeter visitor test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

