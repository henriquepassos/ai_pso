package br.com.henriquespassos.ai_pso.service;

public class Param {

    private int swarmSize;
    private int maxIteration;
    private double c1;
    private double c2;
    private double wUpperbound;
    private double wLowerbound;

    public Param() {
    }

    public int getSwarmSize() {
        return swarmSize;
    }

    public void setSwarmSize(int swarmSize) {
        this.swarmSize = swarmSize;
    }

    public int getMaxIteration() {
        return maxIteration;
    }

    public void setMaxIteration(int maxIteration) {
        this.maxIteration = maxIteration;
    }

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }

    public double getwUpperbound() {
        return wUpperbound;
    }

    public void setwUpperbound(double wUpperbound) {
        this.wUpperbound = wUpperbound;
    }

    public double getwLowerbound() {
        return wLowerbound;
    }

    public void setwLowerbound(double wLowerbound) {
        this.wLowerbound = wLowerbound;
    }
}