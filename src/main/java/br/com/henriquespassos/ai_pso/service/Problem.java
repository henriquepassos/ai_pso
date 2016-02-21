package br.com.henriquespassos.ai_pso.service;

public interface Problem {

    double evaluate(Location location);

    double[] getLocLow();

    void setLocLow(double[] locLow);

    double[] getLocHigh();

    void setLocHigh(double[] locHigh);

    double[] getVelLow();

    void setVelLow(double[] velLow);

    double[] getVelHigh();

    void setVelHigh(double[] velHigh);

    double getError();

    void setError(double error);

    int getSize();

    void setSize(int size);
}