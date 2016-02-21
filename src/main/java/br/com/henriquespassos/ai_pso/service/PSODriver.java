package br.com.henriquespassos.ai_pso.service;

public class PSODriver {

    public static void main(String args[]) {

        PSODriver driver = new PSODriver();

        Param param = driver.getParam();

        Problem problem = driver.getProblemSet();

        new PSOProcess(param, problem).execute();
    }

    public Param getParam() {

        Param param = new Param();

        param.setSwarmSize(30);
        param.setMaxIteration(100);
        param.setC1(2.0);
        param.setC2(2.0);
        param.setwUpperbound(1.0);
        param.setwLowerbound(0.0);

        return param;
    }

    public Problem getProblemSet() {

        Problem problem = new ProblemSet();

        problem.setLocLow(new double[]{1, -1});
        problem.setLocHigh(new double[]{4, 1});

        problem.setVelLow(new double[]{-1, -1});
        problem.setVelHigh(new double[]{1, 1});

        problem.setError(1E-20);
        problem.setSize(2);

        return problem;
    }
}