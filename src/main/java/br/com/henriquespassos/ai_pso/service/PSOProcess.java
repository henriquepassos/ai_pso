package br.com.henriquespassos.ai_pso.service;

import java.util.Random;
import java.util.Vector;

public class PSOProcess {

    private Param param;
    private Problem problem;

    private Vector<Particle> swarm;
    private double[] pBest;
    private Vector<Location> pBestLocation;
    private double gBest;
    private Location gBestLocation;
    private double[] fitnessValueList;

    public PSOProcess(Param param, Problem problem) {
        this.param = param;
        this.problem = problem;

        swarm = new Vector<Particle>();
        pBest = new double[param.getSwarmSize()];
        pBestLocation = new Vector<Location>();
        fitnessValueList = new double[param.getSwarmSize()];
    }

    Random generator = new Random();

    public void execute() {
        initializeSwarm();
        updateFitnessList();

        for (int i = 0; i < param.getSwarmSize(); i++) {
            pBest[i] = fitnessValueList[i];
            pBestLocation.add(swarm.get(i).getLocation());
        }

        int t = 0;
        double w;
        double err = 9999;

        while (t < param.getMaxIteration() && err > problem.getError()) {
            // step 1 - update pBest
            for (int i = 0; i < param.getSwarmSize(); i++) {
                if (fitnessValueList[i] < pBest[i]) {
                    pBest[i] = fitnessValueList[i];
                    pBestLocation.set(i, swarm.get(i).getLocation());
                }
            }

            // step 2 - update gBest
            int bestParticleIndex = PSOUtility.getMinPos(fitnessValueList);
            if (t == 0 || fitnessValueList[bestParticleIndex] < gBest) {
                gBest = fitnessValueList[bestParticleIndex];
                gBestLocation = swarm.get(bestParticleIndex).getLocation();
            }

            w = param.getwUpperbound() - (((double) t) / param.getMaxIteration()) * (param.getwUpperbound() - param.getwLowerbound());

            for (int i = 0; i < param.getSwarmSize(); i++) {
                double r1 = generator.nextDouble();
                double r2 = generator.nextDouble();

                Particle p = swarm.get(i);

                // step 3 - update velocity
                double[] newVel = new double[problem.getSize()];
                for (int j = 0; j < problem.getSize(); j++) {
                    newVel[j] = (w * p.getVelocity().getVel()[j]) +
                            (r1 * param.getC1()) * (pBestLocation.get(i).getLoc()[j] - p.getLocation().getLoc()[j]) +
                            (r2 * param.getC2()) * (gBestLocation.getLoc()[j] - p.getLocation().getLoc()[j]);
                }
                Velocity vel = new Velocity();
                vel.setVel(newVel);
                p.setVelocity(vel);

                // step 4 - update location
                double[] newLoc = new double[problem.getSize()];
                for (int j = 0; j < problem.getSize(); j++) {
                    newLoc[j] = p.getLocation().getLoc()[j] + newVel[j];
                }
                Location loc = new Location();
                loc.setLoc(newLoc);
                p.setLocation(loc);
            }

            err = problem.evaluate(gBestLocation) - 0; // minimizing the functions means it's getting closer to 0

            System.out.printf("ITERATION %d:\n", t);
            for (int j = 0; j < problem.getSize(); j++) {
                System.out.printf("\tBest X%d: %s\n", j, gBestLocation.getLoc()[j]);
            }
            System.out.printf("\tValue: %s\n", problem.evaluate(gBestLocation));

            t++;
            updateFitnessList();
        }

        System.out.printf("\nSolution found at iteration %d, the solutions is:\n", (t - 1));
        for (int i = 0; i < problem.getSize(); i++) {
            System.out.printf("\tBest X%d: %s\n", i, gBestLocation.getLoc()[i]);
        }
    }

    public void initializeSwarm() {
        Particle p;
        for (int i = 0; i < param.getSwarmSize(); i++) {
            p = new Particle();

            // randomize location inside a space defined in Problem Set
            double[] loc = new double[problem.getSize()];
            for (int j = 0; j < problem.getSize(); j++) {
                loc[j] = problem.getLocLow()[j] + generator.nextDouble() * (problem.getLocHigh()[j] - problem.getLocLow()[j]);
            }
            Location location = new Location();
            location.setLoc(loc);

            // randomize velocity in the range defined in Problem Set
            double[] vel = new double[problem.getSize()];
            for (int j = 0; j < problem.getSize(); j++) {
                vel[j] = problem.getVelLow()[j] + generator.nextDouble() * (problem.getVelHigh()[j] - problem.getVelLow()[j]);
            }
            Velocity velocity = new Velocity();
            velocity.setVel(vel);

            p.setLocation(location);
            p.setVelocity(velocity);
            swarm.add(p);
        }
    }

    public void updateFitnessList() {
        for (int i = 0; i < param.getSwarmSize(); i++) {
            Location location = swarm.get(i).getLocation();
            fitnessValueList[i] = problem.evaluate(location);
        }
    }
}