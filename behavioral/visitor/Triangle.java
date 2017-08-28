public final class Triangle implements Shape {

    private final Point vertexA;
    private final Point vertexB;
    private final Point vertexC;

    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    public Point getVertexA() {
        return this.vertexA;
    }

    public Point getVertexB() {
        return this.vertexB;
    }

    public Point getVertexC() {
        return this.vertexC;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

