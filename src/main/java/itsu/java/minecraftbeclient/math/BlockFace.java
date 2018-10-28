package itsu.java.minecraftbeclient.math;

import javafx.geometry.Point3D;

import java.util.TreeSet;

public class BlockFace {

    public static final int FACE_TOP = 0;
    public static final int FACE_BOTTOM = 1;
    public static final int FACE_FORWARD = 2;
    public static final int FACE_BACK = 3;
    public static final int FACE_LEFT = 4;
    public static final int FACE_RIGHT = 5;

    public static int getFace(Point3D point) {
        double x = point.getX();
        double y = point.getY();
        double z = point.getZ();

        TreeSet<Double> tree = new TreeSet<>();
        tree.add(x);
        tree.add(y);
        tree.add(z);

        double max = tree.floor(5.1);
        double min = tree.higher(-5.1);
        double value;

        if (5.0 - Math.abs(max) < 5.0 - Math.abs(min)) value = max;
        else value = min;

        if (z == value && value < 0) {
            return FACE_FORWARD;

        } else if (z == value && value > 0) {
            return FACE_BACK;

        } else if (x == value && value < 0) {
            return FACE_LEFT;

        } else if (x == value && value > 0) {
            return FACE_RIGHT;

        } else if (y == value && value < 0) {
            return FACE_TOP;

        } else if (y == value && value > 0) {
            return FACE_BOTTOM;

        }

        return -1;
    }

}
