
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
public class Report {

    public ArrayList<String> reports = new ArrayList();

    public void run(String name, ArrayList<SimProcess> inQueue, int reportNum, float totalClock) {
        int i = 0;
        String temp;
        float avgTurnAroundTime;
        float avgWaitTime;
        float avgResponceTime;
        float throughPut;

        temp = reports.get(reportNum);

        avgTurnAroundTime = this.calulateTAT(inQueue);
        avgWaitTime = this.calculateAWT(inQueue);
        avgResponceTime = this.calculateART(inQueue);
        throughPut = ((float) inQueue.size()) / totalClock;

    }

    public void setupReport(int i, ArrayList<SimProcess> inQueue) {
        String temp;
        temp = new String("**********\nSTATISTICS REPORT for RUN " + (i+1) + "\n**********\n\n"
                + "Queue Processes\n**********\n\n");
        Report.CustomComparator pidOrder = new Report.CustomComparator();
        Collections.sort(inQueue, pidOrder);
        for (SimProcess x : inQueue) {
            i++;
            temp = temp + x.toString() + ", ";
            if ((i % 3) == 0) {
                temp = temp + "\n";
            }
        }
        temp = temp +"\n\n";
        reports.add(i, temp);
    }

    private float calculateART(ArrayList<SimProcess> inQueue) {
        float total = 0;
        float avg;
        int size = inQueue.size();

        for (SimProcess temp : inQueue) {
            total = total + (temp.timeFirstCpu - temp.arrivalTime);
        }
        avg = total / (float) size;
        return avg;
    }

    private float calculateAWT(ArrayList<SimProcess> inQueue) {
        float total = 0;
        float avg;
        int size = inQueue.size();

        for (SimProcess temp : inQueue) {
            total = total + temp.waitingTime;
        }
        avg = total / (float) size;
        return avg;
    }

    private float calulateTAT(ArrayList<SimProcess> inQueue) {
        float total = 0;
        float avg;
        int size = inQueue.size();

        for (SimProcess temp : inQueue) {
            total = total + (temp.timeCompleted - temp.arrivalTime);
        }
        avg = total / (float) size;
        return avg;
    }

    private class CustomComparator implements Comparator<SimProcess> {

        @Override
        public int compare(SimProcess o1, SimProcess o2) {
            float x = o1.getarrivalTime();
            float y = o2.getarrivalTime();
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
