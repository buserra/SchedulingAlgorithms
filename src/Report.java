
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
    float temp = 0;
    ArrayList<Float> FCFS = new ArrayList();
    ArrayList<Float> SJF = new ArrayList();
    ArrayList<Float> RR = new ArrayList();
    
    public Report(){
        for(int i=0;i<4;i++){
            FCFS.add(i, temp);
            SJF.add(i, temp);
            RR.add(i, temp);
        }    
    }
    
    public void finalReport(int i){
        float sumAvgTurnAroundTime;
        float sumAvgWaitTime;
        float sumAvgResponceTime;
        float avgThroughPut;
        
        System.out.println("**********\nFinal Report for 5 Runs\n**********");
        
        System.out.println("FCFS\n**********");
        sumAvgTurnAroundTime = (FCFS.get(0)/5);
        sumAvgWaitTime = (FCFS.get(1)/5);
        sumAvgResponceTime = (FCFS.get(2)/5); 
        avgThroughPut = (FCFS.get(3)/5);
        System.out.println("Average Turn Around Time: "+sumAvgTurnAroundTime
                + "\nAverage Wait Time: "+sumAvgWaitTime
                + "\nAverage Responce Time: "+sumAvgResponceTime
                + "\nAverage Throughput: "+avgThroughPut);
        
        System.out.println("SJF\n**********");
        sumAvgTurnAroundTime = (SJF.get(0)/5);
        sumAvgWaitTime = (SJF.get(1)/5);
        sumAvgResponceTime = (SJF.get(2)/5); 
        avgThroughPut = (SJF.get(3)/5);
        System.out.println("Average Turn Around Time: "+sumAvgTurnAroundTime
                + "\nAverage Wait Time: "+sumAvgWaitTime
                + "\nAverage Responce Time: "+sumAvgResponceTime
                + "\nAverage Throughput: "+avgThroughPut);
        
        System.out.println("RR\n**********");
        sumAvgTurnAroundTime = (RR.get(0)/5);
        sumAvgWaitTime = (RR.get(1)/5);
        sumAvgResponceTime = (RR.get(2)/5); 
        avgThroughPut = (RR.get(3)/5);
        System.out.println("Average Turn Around Time: "+sumAvgTurnAroundTime
                + "\nAverage Wait Time: "+sumAvgWaitTime
                + "\nAverage Responce Time: "+sumAvgResponceTime
                + "\nAverage Throughput: "+avgThroughPut);
        
    }
    
    public void runRR(String name, ArrayList<SimProcess> inQueue, int reportNum, float totalClock) {
        
        String temp;
        float avgTurnAroundTime;
        float avgWaitTime;
        float avgResponceTime;
        float throughPut;

        avgTurnAroundTime = this.calulateTAT(inQueue);
        RR.add(0, (RR.get(0)+avgTurnAroundTime));
        avgWaitTime = this.calculateAWT(inQueue);
        RR.add(1, (RR.get(1)+avgWaitTime));
        avgResponceTime = this.calculateART(inQueue);
        RR.add(2, (RR.get(2)+avgWaitTime));
        throughPut = ((float) inQueue.size()) / totalClock;
        RR.add(3, (RR.get(3)+avgWaitTime));
        
        System.out.print("**********\n"
                + name +" Processes for Run: "+(reportNum+1)+"\n"
                + "     Average turn-around time: "+avgTurnAroundTime+"\n"
                + "     Average waiting time: "+avgWaitTime+"\n"
                + "     Average response time: "+avgResponceTime+"\n"
                + "     Trough Put: "+throughPut+"\n"
                + "**********\n");
    }
    
    public void runSJF(String name, ArrayList<SimProcess> inQueue, int reportNum, float totalClock) {
        
        String temp;
        float avgTurnAroundTime;
        float avgWaitTime;
        float avgResponceTime;
        float throughPut;

        avgTurnAroundTime = this.calulateTAT(inQueue);
        SJF.add(0, (SJF.get(0)+avgTurnAroundTime));
        avgWaitTime = this.calculateAWT(inQueue);
        SJF.add(1, (SJF.get(1)+avgWaitTime));
        avgResponceTime = this.calculateART(inQueue);
        SJF.add(2, (SJF.get(2)+avgWaitTime));
        throughPut = ((float) inQueue.size()) / totalClock;
        SJF.add(3, (SJF.get(3)+avgWaitTime));
        
        System.out.print("**********\n"
                + name +" Processes for Run: "+(reportNum+1)+"\n"
                + "     Average turn-around time: "+avgTurnAroundTime+"\n"
                + "     Average waiting time: "+avgWaitTime+"\n"
                + "     Average response time: "+avgResponceTime+"\n"
                + "     Trough Put: "+throughPut+"\n"
                + "**********\n");
    }

    public void runFCFS(String name, ArrayList<SimProcess> inQueue, int reportNum, float totalClock) {
        
        String temp;
        float avgTurnAroundTime;
        float avgWaitTime;
        float avgResponceTime;
        float throughPut;

        avgTurnAroundTime = this.calulateTAT(inQueue);
        FCFS.add(0, (FCFS.get(0)+avgTurnAroundTime));
        avgWaitTime = this.calculateAWT(inQueue);
        FCFS.add(1, (FCFS.get(1)+avgWaitTime));
        avgResponceTime = this.calculateART(inQueue);
        FCFS.add(2, (FCFS.get(2)+avgWaitTime));
        throughPut = ((float) inQueue.size()) / totalClock;
        FCFS.add(3, (FCFS.get(3)+avgWaitTime));
        
        System.out.print("**********\n"
                + name +" Processes for Run: "+(reportNum+1)+"\n"
                + "     Average turn-around time: "+avgTurnAroundTime+"\n"
                + "     Average waiting time: "+avgWaitTime+"\n"
                + "     Average response time: "+avgResponceTime+"\n"
                + "     Trough Put: "+throughPut+"\n"
                + "**********\n");
    }

    public void setupReport(int i, ArrayList<SimProcess> inQueue) {
        System.out.println("**********\nSTATISTICS REPORT for RUN " + (i+1) + "\n**********\n"
                + "Queue Processes\n**********");
        Report.SortIDOrder pidOrder = new Report.SortIDOrder();
        Collections.sort(inQueue, pidOrder);
        for (SimProcess x : inQueue) {
            System.out.println(x.toString() + ", ");
        }
        Report.SortArrivalOrder arrvlOrder = new Report.SortArrivalOrder();
        Collections.sort(inQueue, arrvlOrder);
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
    
    private class SortArrivalOrder implements Comparator<SimProcess> {

        @Override
        public int compare(SimProcess o1, SimProcess o2) {
            float x = o1.arrivalTime;
            float y = o2.arrivalTime;
            if (x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
            return 0;
        }
    }

    private class SortIDOrder implements Comparator<SimProcess> {

        @Override
        public int compare(SimProcess o1, SimProcess o2) {
            int x = o1.id;
            int y = o2.id;
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
