// The memento pattern is a behavioral software design pattern that is used to
// externalize an object's state usually to provide rollback functionality. It
// is implemented using three objects:
//
// 1) The originator, whose internal state needs to be preserved.
// 2) The memento, an object to hold a copy of that state.
// 3) The caretaker, who wants to do something to the originator but wants to
//    checkpoint the originator's state beforehand to be able toundo the change
//    later if required.
//
// The caretaker first asks the originator for a memento object, then executes
// the operation or sequence of operations and uses the memento to roll back
// the originator to its original state if required. The caretaker should under
// no circumstances change the memento object.
//
// Advantages:
// - Allows restoring an object to a previous state by externalizing its
//   internal state.
// - Shields complex internals from other objects.
//
// Disadvantages:
// - Can be expensive if the originator's state is large.
// - Caretaker needs to periodically delete history to free up memory.
// - Need to take care not to violate originator's encapsulation.
//
// Examples: Serializable
//
// In the example below we have a TextForm that holds information such as
// title, author and text. We also have a TextFormEditor that allows clients
// to change the contents of the form and also provides full undo functionality
// using the memento pattern. In this case the originator is the TextForm, the
// memento is the TextForm.Memento and the caretaker is the TextFormEditor. The
// memento class has been defined in such a way so that it is immutable and its
// contents are only visible to the originator.

public class Memento {

    private static boolean testUndo_TitleChanged() {
        TextFormEditor editor = new TextFormEditor();
        editor.changeTitle("Brave New World");
        editor.changeTitle("Catch-22");
        editor.undo();
        return "Brave New World".equals(editor.getTitle());
    }

    private static boolean testUndo_AuthorChanged() {
        TextFormEditor editor = new TextFormEditor();
        editor.changeAuthor("Aldous Huxley");
        editor.changeAuthor("Joseph Heller");
        editor.undo();
        return "Aldous Huxley".equals(editor.getAuthor());
    }

    private static boolean testUndo_TextChanged() {
        TextFormEditor editor = new TextFormEditor();
        editor.appendText("Hello");
        editor.appendText(" World");
        editor.undo();
        return "Hello".equals(editor.getText());
    }

    private static boolean testUndo_ManyTimes() {
        TextFormEditor editor = new TextFormEditor();
        editor.changeTitle("The Grapes of Wrath");
        editor.changeAuthor("John Steinbeck");
        editor.appendText("The red country");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
        return "".equals(editor.getTitle()) &&
               "".equals(editor.getAuthor()) &&
               "".equals(editor.getText());
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testUndo_TitleChanged()) {
            System.out.println("Undo title change test failed!");
            counter++;
        }
        if (!testUndo_AuthorChanged()) {
            System.out.println("Undo author change test failed!");
            counter++;
        }
        if (!testUndo_TextChanged()) {
            System.out.println("Undo text change test failed!");
            counter++;
        }
        if (!testUndo_ManyTimes()) {
            System.out.println("Undo many times test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

