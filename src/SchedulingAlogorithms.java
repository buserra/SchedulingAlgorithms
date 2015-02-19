
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
          int numberProcessInQueue = 50;
          RandomQueue rando = new RandomQueue();
          ArrayList<SimProcess> randomQueue;
          FCFS fcfs = new FCFS();
          SJF sjf = new SJF();
          RR rr = new RR();
        
        for(int i =0; i<4; i++){
          randomQueue = rando.getQueue(numberProcessInQueue);
          String name = "Report for Run "+(i+1);
          Report report = new Report(name);
          fcfs.run(randomQueue, report);
          //sjf.run(randomQueue, report);
          //rr.run(randomQueue, report);
          System.out.println(report.toString());
          /*
            for (SimProcess temp : randomQueue){
              System.out.print(temp.toString());
          */
              
          //}
        
    }   
}
