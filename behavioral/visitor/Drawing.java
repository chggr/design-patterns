import java.util.ArrayList;
import java.util.List;

public final class Drawing implements Shape {

    private final List<Shape> shapes = new ArrayList<>();

    public void draw(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
        visitor.visit(this);
    }
}

