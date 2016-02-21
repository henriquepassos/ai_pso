package br.com.henriquespassos.ai_pso.service;

import br.com.henriquespassos.ai_commons.util.DataUtils;
import br.com.henriquespassos.ai_ecg.Optimization;
import br.com.henriquespassos.ai_ecg.service.impl.ClassifierSvmImpl;
import br.com.henriquespassos.ai_ecg.service.impl.DiscretizerSaxImpl;
import br.com.henriquespassos.ai_ecg.service.impl.HeartbeatImpl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProblemEcg implements Problem {

    private double[] locLow;
    private double[] locHigh;

    private double[] velLow;
    private double[] velHigh;

    private double error;
    private int size;

    @Override
    public double evaluate(Location location) {

        List<double[]> dataset;
        try {
            dataset = DataUtils.read(new File("/home/henrique/ecg/ptbdb.csv"));
        } catch (IOException e) {
            return Double.MAX_VALUE;
        }

        List<Double> heartbeatParam = Arrays.asList(location.getLoc()[0], location.getLoc()[1]);
        List<Double> discretizerParam = Arrays.asList(location.getLoc()[0], location.getLoc()[1]);
        List<Double> classifierParam = Arrays.asList(0.0);
        return new Optimization().evaluate(dataset, heartbeatParam, discretizerParam, classifierParam, new HeartbeatImpl(), new DiscretizerSaxImpl(), new ClassifierSvmImpl());
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