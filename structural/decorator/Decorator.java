// The decorator pattern is a structural software design pattern that can be
// used to add or remove responsibilities from an object dynamically at run
// time, providing a flexible alternative to sub-classing for extending
// functionality. It helps adhere to the single responsibility principle, as it
// allows functionality to be divided between classes with unique areas of
// concern. It is structurally very similar to the chain of responsibility
// pattern, but in this case all classes handle the request instead of exactly
// one class, as is done in the chain of responsibility.
//
// The decorator is a hierarchical type pattern that builds functionality at
// each level by using composition from similar data types. Behavior can be
// added to an object dynamically by wrapping it with one of the decorator sub
// classes. It uses both inheritance (is-a) and composition (has-a): a common
// interface is defined that is implemented by both concrete components and
// decorator classes. The constructor of each decorator class requires an
// instance of a class from the hierarchy to add functionality to. That
// instance can be either a concrete component or another decorator.
//
// Advantages:
// - More flexible than inheritance. Features added at runtime, not compile time
// - Single responsibility principle, one class per feature
// - Keeps object hierarchy clean, uses composition to add behaviour
// - Scales well. Easy to add any number of decorators and in any order
//
// Disadvantages:
// - Might end up with multiple specialized decorator classes
//
// Examples: java.io.InputStream, java.io.OutputStream, Swing UI components
//
// In the example below we are designing an ordering system for a sandwich
// shop. Each customer selects the type of bread they want (toast, bagel or
// roll) and then adds ingredients to their sandwich (avocado, tomato, mayo,
// cucumber, tuna, lettuce, ham and cheese). It is immediately obvious that the
// number of possible sandwich combinations is huge (3 * 2 ^ 8 = 768) and thus
// we cannot use subclassing to represent each combination. Moreover we would
// like to dynamically compile each sandwich at runtime rather than statically
// at compile time.
//
// The decorator pattern can be used to overcome the aforementioned problems. A
// common Sandwich interface is defined and implemented by concrete classes
// RollSandwich, BagelSandwich and ToastSandwich. It is also implemented by
// abstract class SandwichDecorator, which can be extended by all ingredients
// that can "decorate" a sandwich. In order to compile a sandwich, we first
// need to select a base class (roll, bagel, toast) and then recursively
// decorate that with an unlimited number of decorators / ingredients. Note
// that all classes implement Sandwich and the decorators have constructors
// that accept a Sandwich and add functionality to it as required.

public class Decorator {

    private static boolean testToastCucumberTunaMayo() {
        Sandwich sandwich = new ToastSandwich();
        sandwich = new CucumberDecorator(sandwich);
        sandwich = new TunaDecorator(sandwich);
        sandwich = new MayoDecorator(sandwich);

        return "toast + cucumber + tuna + mayo".equals(sandwich.getDescription()) &&
               92 == sandwich.getPriceCents();
    }

    private static boolean testRollLettuceCheeseTomatoHam() {
        Sandwich sandwich = new RollSandwich();
        sandwich = new LettuceDecorator(sandwich);
        sandwich = new CheeseDecorator(sandwich);
        sandwich = new TomatoDecorator(sandwich);
        sandwich = new HamDecorator(sandwich);

        return "roll + lettuce + cheese + tomato + ham".equals(sandwich.getDescription()) &&
               181 == sandwich.getPriceCents();
    }

    private static boolean testBagelAvocadoTomatoLettuce() {
        Sandwich sandwich = new BagelSandwich();
        sandwich = new AvocadoDecorator(sandwich);
        sandwich = new TomatoDecorator(sandwich);
        sandwich = new LettuceDecorator(sandwich);

        return "bagel + avocado + tomato + lettuce".equals(sandwich.getDescription()) &&
               157 == sandwich.getPriceCents();
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testToastCucumberTunaMayo()) {
            System.out.println("Toast with cucumber, tuna and mayo test failed!");
            counter++;
        }
        if (!testRollLettuceCheeseTomatoHam()) {
            System.out.println("Roll with lettuce, cheese, tomato and ham test failed!");
            counter++;
        }
        if (!testBagelAvocadoTomatoLettuce()) {
            System.out.println("Bagel with avocado,, tomato and lettuce test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

