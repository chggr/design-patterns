public class AreaShapeVisitor implements ShapeVisitor {

    private double totalArea = 0.0;

    public void visit(Circle c) {
        totalArea += Math.PI * Math.pow(c.getRadius(), 2);
    }

    public void visit(Triangle t) {
        totalArea += calculateArea(t.getVertexA(), t.getVertexB(), t.getVertexC());
    }

    public void visit(Parallelogram p) {
        totalArea += 2 * calculateArea(p.getVertexA(), p.getVertexB(), p.getVertexC());
    }

    public void visit(Drawing d) {
    }

    public double getTotalArea() {
        return totalArea;
    }

    // Heron's formula.
    private double calculateArea(Point vertexA, Point vertexB, Point vertexC) {
        double a = PointUtils.getDistance(vertexA, vertexB);
        double b = PointUtils.getDistance(vertexB, vertexC);
        double c = PointUtils.getDistance(vertexC, vertexA);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

