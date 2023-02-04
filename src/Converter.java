
public class Converter {
    private double stepDistance = 0.00075;
    private int stepCalorie = 50;

    public double getWalkedDistance(int steps){
        double walkedDistance = steps * stepDistance;
        return walkedDistance;
    }
    public double getBurnedCalories(int steps){
        double burnedCalories = (steps * stepCalorie) / 1000;
        return burnedCalories;
    }
}
