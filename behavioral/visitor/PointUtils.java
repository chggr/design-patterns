public final class PointUtils {

    private PointUtils() {
        // Utility class, should not be instantiated.
    }

    public static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + 
                         Math.pow(a.getY() - b.getY(), 2));
    }
}

