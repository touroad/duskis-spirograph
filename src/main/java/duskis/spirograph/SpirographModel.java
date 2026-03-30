package duskis.spirograph;

import java.util.Objects;

public class SpirographModel {
    private double largeRadius;
    private double smallRadius;
    private double penDistance;
    private int numSteps;
    private double anglePerStep;

    public SpirographModel(double largeRadius, double smallRadius,
                           double penDistance, int numSteps, double anglePerStep) {
        this.largeRadius = largeRadius;
        this.smallRadius = smallRadius;
        this.penDistance = penDistance;
        this.numSteps = numSteps;
        this.anglePerStep = anglePerStep;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public void setNumSteps(int numSteps) {
        this.numSteps = numSteps;
    }

    public double getLargeRadius() {
        return largeRadius;
    }

    public void setLargeRadius(double largeRadius) {
        this.largeRadius = largeRadius;
    }

    public double getSmallRadius() {
        return smallRadius;
    }

    public void setSmallRadius(double smallRadius) {
        this.smallRadius = smallRadius;
    }

    public double getPenDistance() {
        return penDistance;
    }

    public void setPenDistance(double penDistance) {
        this.penDistance = penDistance;
    }

    public double getAnglePerStep() {
        return anglePerStep;
    }

    public void setAnglePerStep(double anglePerStep) {
        this.anglePerStep = anglePerStep;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpirographModel that = (SpirographModel) o;
        return Double.compare(largeRadius, that.largeRadius) == 0
                && Double.compare(smallRadius, that.smallRadius) == 0
                && Double.compare(penDistance, that.penDistance) == 0
                && numSteps == that.numSteps
                && Double.compare(anglePerStep, that.anglePerStep) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(largeRadius, smallRadius, penDistance, numSteps, anglePerStep);
    }
}
