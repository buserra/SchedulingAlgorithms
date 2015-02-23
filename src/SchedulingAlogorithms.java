
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Buser
 */
public class SchedulingAlogorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          int i;
          int numberProcessInQueue = 50;
          float quanta = 1;
          float totalCPUClock;
          RandomQueue rando = new RandomQueue();
          ArrayList<SimProcess> temp;
          Report report = new Report();
          FCFS fcfs = new FCFS();
          SJF sjf = new SJF();
          RR rr = new RR();


        for(i =0; i<5; i++){
          //get random queue
          temp = rando.getQueue(numberProcessInQueue);
          report.setupReport(i,temp);
          
          //**FCFS & set up report for run i********/
          totalCPUClock = fcfs.run(temp);
          report.runFCFS("FCFS", temp, i, totalCPUClock);
          /********************************/

          //**SJF********/
          totalCPUClock = sjf.run(temp);
          report.runSJF("SJF",temp, i, totalCPUClock);
          /********************************/
          

          //**RR********/
          totalCPUClock = rr.run(temp);
          report.runRR("RR",temp,i, totalCPUClock);
          /********************************/
        }
        report.finalReport((i+1));
    }   

}


