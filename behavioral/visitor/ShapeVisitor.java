public interface ShapeVisitor {

    void visit(Circle circle);
    void visit(Triangle triangle);
    void visit(Parallelogram parallelogram);
    void visit(Drawing drawing);
}

