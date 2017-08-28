public class PerimeterShapeVisitor implements ShapeVisitor {

    private double totalPerimeter = 0.0;

    public void visit(Circle c) {
        totalPerimeter += 2 * Math.PI * c.getRadius();
    }

    public void visit(Triangle t) {
        totalPerimeter += PointUtils.getDistance(t.getVertexA(), t.getVertexB()) +
                          PointUtils.getDistance(t.getVertexB(), t.getVertexC()) +
                          PointUtils.getDistance(t.getVertexC(), t.getVertexA());
    }

    public void visit(Parallelogram p) {
        double a = PointUtils.getDistance(p.getVertexA(), p.getVertexB());
        double b = PointUtils.getDistance(p.getVertexB(), p.getVertexC());
        double c = PointUtils.getDistance(p.getVertexC(), p.getVertexA());
        double maxSide = a > b ? a : b;
        maxSide = maxSide > c ? maxSide : c;
        totalPerimeter += 2 * (a + b + c - maxSide);
    }

    public void visit(Drawing d) {
    }

    public double getTotalPerimeter() {
        return totalPerimeter;
    }
}

