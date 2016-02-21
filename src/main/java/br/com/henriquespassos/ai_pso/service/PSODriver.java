package br.com.henriquespassos.ai_pso.service;

public class PSODriver {

    public static void main(String args[]) {

        PSODriver driver = new PSODriver();

        Param param = driver.getParam();

        Problem problem = driver.getProblemSvm();

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

    public Problem getProblemEcg() {

        Problem problem = new ProblemEcg();

        problem.setLocLow(new double[]{80, 2, 2, 20});
        problem.setLocHigh(new double[]{100, 6, 6, 60});

        problem.setVelLow(new double[]{-1, -1, -1, -1});
        problem.setVelHigh(new double[]{1, 1, 1, 1});

        problem.setError(1E-20);
        problem.setSize(4);

        return problem;
    }

    public Problem getProblemSvm() {

        Problem problem = new ProblemEcg();

        problem.setLocLow(new double[]{0.03125, 3.0517578125e-05});
        problem.setLocHigh(new double[]{32768, 8});

        problem.setVelLow(new double[]{-1, -1});
        problem.setVelHigh(new double[]{1, 1});

        problem.setError(1E-20);
        problem.setSize(2);

        return problem;
    }
}