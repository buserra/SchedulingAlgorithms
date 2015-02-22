
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
          int numberProcessInQueue = 6;
          float quanta = 1;
          float totalCPUClock;
          RandomQueue rando = new RandomQueue();
          ArrayList<ArrayList> randomQueues;
          ArrayList<SimProcess> temp;
          Report report = new Report();
          FCFS fcfs = new FCFS();
          SJF sjf = new SJF();
          RR rr = new RR();


        for(int i =0; i<1; i++){

          randomQueues = rando.getQueue(numberProcessInQueue);

          //**FCFS & set up report for run i********/
          temp = randomQueues.get(0);
          totalCPUClock = fcfs.run(temp, i);
          report.setupReport(i,randomQueues.get(0));
          report.run("FCFS", randomQueues.get(0), i, totalCPUClock);

          //**SJF********/
          report.run("SJF",randomQueues.get(1), i, sjf.run(randomQueues.get(1), i));
          /********************************/
          

          //**RR********/
          report.run("RR",randomQueues.get(2),i,sjf.run(randomQueues.get(2), i));
          /********************************/

          System.out.println(report.reports.get(i));
        }
    }   

}

/*
ArrayList prnt = randomQueues.get(0);
            for (Object temp : prnt){
              System.out.print(temp.toString());
            }
*/
