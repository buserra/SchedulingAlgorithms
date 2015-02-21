
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Buser
 */
public class SJF {

    public float run(ArrayList<SimProcess> inQueue, int run) {
        int queueLength, i, k;
        float cpuClock = 0;
        float timeRemaining;
        boolean flag = true;
        ArrayList<SimProcess> cpuQueue = new ArrayList();
        SimProcess spPoint;

        //I will need this somewhere
        queueLength = inQueue.size();
        System.out.println("**********\nCPU Activity for SJF run " + run + "\n**********");
        k = 0;
        i = 0;
        do {
            //get new arrivals
            for (i = k; i < queueLength; i++) {
                if (inQueue.get(i).arrivalTime < cpuClock) {
                    cpuQueue.add(inQueue.get(i));
                } else {
                    k = i;
                    break;
                }
            }

            //sort by sjf
            SJF.CustomComparator compare = new SJF.CustomComparator();
            Collections.sort(cpuQueue, compare);

            //run shortest job
            if (cpuQueue.isEmpty()) {
                System.out.println("cpu clock = " + cpuClock + ", Idle");
                cpuClock++;
            } else {
                spPoint = cpuQueue.remove(0);
                spPoint.timeFirstCpu = cpuClock;
                timeRemaining = spPoint.estimatedRunTime;
                while (timeRemaining > 0) {
                    System.out.println("cpu clock = " + cpuClock + ", pid: " + spPoint.pid + ", time remaining = " + timeRemaining);
                    timeRemaining--;
                    cpuClock++;
                }
                spPoint.timeCompleted = cpuClock;
            }

        } while (flag);

        System.out.println("\n");
        return cpuClock;
    }

    private class CustomComparator implements Comparator<SimProcess> {

        @Override
        public int compare(SimProcess o1, SimProcess o2) {
            float x = o1.estimatedRunTime;
            float y = o2.estimatedRunTime;
            if (x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
            return 0;
        }
    }
}