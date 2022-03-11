package model;

public class Plateau implements PlateauInterface {
    private int X_MAX;
    private int Y_MAX;

    public Plateau(int x_max, int y_max) throws Exception {
        try {
            if (x_max < 0 || y_max < 0) {
                throw new Exception("Plateau size cannot be negative");
            } else {
                this.X_MAX = x_max;
                this.Y_MAX = y_max;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int getX_MAX() {
        return X_MAX;
    }

    public int getY_MAX() {
        return Y_MAX;
    }

}
