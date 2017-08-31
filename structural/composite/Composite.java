// The composite pattern is a structural software design pattern that is used
// to represent part-whole hierarchies as tree structures so that clients can
// treat individual objects and compositions of objects uniformly. In order to
// achieve this, a common interface is defined that is implemented by both Leaf
// and Composite objects. Leaf objects implement the inteface directly, whereas
// Composite objects implement the interface by recursively calling their
// children.
//
// This pattern greatly simplifies code that interacts with complex object
// hierarchies, as programmers do not need to discriminate between leaf and
// branch nodes. The key concept is that a single instance of an object can be
// manipulated in the same way as a group of objects.
//
// Advantages:
// - Allows composing objects into tree structures.
// - Same operations can be applied to both Leaf and Composite objects.
//
// Disadvantages:
// - Can oversimplify a system, as both Composite and Leaf objects need to
//   implement the same interface.
//
// Examples: java.awt.Component, REST GET requests.
//
// In the example below we represent a file system by defining interface Entry
// and its concrete implementations: Directory, File and Link. A file system is
// by definition organized as a tree, with Directory being the Composite object
// and File and Link being the Leaf objects. All classes implement method ls(),
// which returns a String representation of each object. For Leaf objects, this
// method is implemented directly and returns the name of the File and the name
// and target of the Link. For the Composite object though, this is implemented
// by recursively calling the children.

public class Composite {

    private static boolean testFile() {
        File file = new File("report.txt");
        return "report.txt".equals(file.ls());
    }

    private static boolean testLink() {
        Link link = new Link("temp", "/tmp");
        return "temp => /tmp".equals(link.ls());
    }

    private static boolean testDirectory_Empty() {
        Directory directory = new Directory("Downloads");
        return "Downloads:\n".equals(directory.ls());
    }

    private static boolean testDirectory_Populated() {
        Directory directory = new Directory("Downloads");
        File file = new File("archive.zip");
        Link link = new Link("config", "/home/test/config");
        directory.add(file);
        directory.add(link);
        return ("Downloads:\n" +
                "    archive.zip\n" +
                "    config => /home/test/config\n").equals(directory.ls());
    }

    private static boolean testDirectory_Nested() {
        Directory root = new Directory("/");

        Directory etc = new Directory("etc");
        File crontab = new File("crontab");
        etc.add(crontab);
        root.add(etc);

        Directory home = new Directory("home");
        Directory chris = new Directory("chris");
        File picture = new File("picture.png");
        File report = new File("report.txt");
        Link temp = new Link("temp", "/tmp");
        chris.add(picture);
        chris.add(report);
        chris.add(temp);
        home.add(chris);
        root.add(home);

         return ("/:\n" +
                 "    etc:\n" +
                 "        crontab\n" +
                 "    home:\n" +
                 "        chris:\n" +
                 "            picture.png\n" +
                 "            report.txt\n" +
                 "            temp => /tmp\n").equals(root.ls());
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testFile()) {
            System.out.println("File test failed!");
            counter++;
        }
        if (!testLink()) {
            System.out.println("Link test failed!");
            counter++;
        }
        if (!testDirectory_Empty()){
            System.out.println("Empty directory test failed!");
            counter++;
        }
        if (!testDirectory_Populated()){
            System.out.println("Populated directory test failed!");
            counter++;
        }
        if (!testDirectory_Nested()){
            System.out.println("Nested directory test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

