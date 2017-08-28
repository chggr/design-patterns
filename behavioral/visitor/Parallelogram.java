public final class Parallelogram implements Shape {

    private final Point vertexA;
    private final Point vertexB;
    private final Point vertexC;

    public Parallelogram(Point vertexA, Point vertexB, Point vertexC) {
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

