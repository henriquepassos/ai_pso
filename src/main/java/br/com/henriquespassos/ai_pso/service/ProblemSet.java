package br.com.henriquespassos.ai_pso.service;

public class ProblemSet implements Problem {

    private double[] locLow;
    private double[] locHigh;

    private double[] velLow;
    private double[] velHigh;

    private double error;
    private int size;

    public ProblemSet() {
    }

    @Override
    public double evaluate(Location location) {

        double evaluate;

        double x = location.getLoc()[0];
        double y = location.getLoc()[1];

        evaluate = Math.pow(2.8125 - x + x * Math.pow(y, 4), 2)
                + Math.pow(2.25 - x + x * Math.pow(y, 2), 2)
                + Math.pow(1.5 - x + x * y, 2);

        return evaluate;
    }

    @Override
    public double[] getLocLow() {
        return locLow;
    }

    @Override
    public void setLocLow(double[] locLow) {
        this.locLow = locLow;
    }

    @Override
    public double[] getLocHigh() {
        return locHigh;
    }

    @Override
    public void setLocHigh(double[] locHigh) {
        this.locHigh = locHigh;
    }

    @Override
    public double[] getVelLow() {
        return velLow;
    }

    @Override
    public void setVelLow(double[] velLow) {
        this.velLow = velLow;
    }

    @Override
    public double[] getVelHigh() {
        return velHigh;
    }

    @Override
    public void setVelHigh(double[] velHigh) {
        this.velHigh = velHigh;
    }

    @Override
    public double getError() {
        return error;
    }

    @Override
    public void setError(double error) {
        this.error = error;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}