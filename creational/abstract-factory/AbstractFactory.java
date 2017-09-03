// The abstract factory pattern is a creational software design pattern that
// provides a way to encapsulate a group of individual factories that have a
// common theme without specifying their concrete classes. The client receives
// a concrete implementation of the abstract factory and then uses the generic
// interface of the factory to create objects that are part of the common
// theme. The client does not know which concrete objects have been returned by
// each of these internal factories, but only uses the generic interfaces of
// these products.
//
// This pattern insulates the creation of objects from their usage and makes it
// easy to create families of related objects without having to depend on their
// concrete classes. Thus new derived types can be introduced with no change to
// the code that uses the interface or base class.
//
// Advantages:
// - Insulates object creation from usage.
// - Groups factories of related objects together.
//
// Disadvantages:
// - May result in unnecessary complexity in many cases.
// - Higher level of separation and abstraction can result in systems that are
//   more difficult to debug and maintain.
//
// Examples: DocumentBuilder
//
// In the example below, a UI application supports three different styles
// (Windows, Linux and OSX) that should be interchangeable at runtime. All
// available Controls (Button, ComboBox and ProgressBar) have a separate
// implementation for each style and the abstract factory pattern is used to
// insulate object creation from usage. ControlFactory.getFactory() is called
// by the UI to obtain the correct ControlFactory according to the given Style.
// That factory is subsequently used to create all necessary controls. Client
// code calls draw() on each Control to display it using the interface and
// without being aware of the type of Control at hand.

public class AbstractFactory {

    private static boolean testWindowsControlFactory() {
        ControlFactory factory = ControlFactory.getFactory(Style.Windows);
        return factory.createControl(Control.Type.Button) instanceof WindowsButton &&
               factory.createControl(Control.Type.ComboBox) instanceof WindowsComboBox &&
               factory.createControl(Control.Type.ProgressBar) instanceof WindowsProgressBar;
    }

    private static boolean testLinuxControlFactory() {
        ControlFactory factory = ControlFactory.getFactory(Style.Linux);
        return factory.createControl(Control.Type.Button) instanceof LinuxButton &&
               factory.createControl(Control.Type.ComboBox) instanceof LinuxComboBox &&
               factory.createControl(Control.Type.ProgressBar) instanceof LinuxProgressBar;
    }

    private static boolean testOSXControlFactory() {
        ControlFactory factory = ControlFactory.getFactory(Style.OSX);
        return factory.createControl(Control.Type.Button) instanceof OSXButton &&
               factory.createControl(Control.Type.ComboBox) instanceof OSXComboBox &&
               factory.createControl(Control.Type.ProgressBar) instanceof OSXProgressBar;
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testWindowsControlFactory()) {
            System.out.println("Windows control factory test failed!");
            counter++;
        }
        if (!testLinuxControlFactory()) {
            System.out.println("Linux control factory test failed!");
            counter++;
        }
        if (!testOSXControlFactory()) {
            System.out.println("OSX control factory test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

