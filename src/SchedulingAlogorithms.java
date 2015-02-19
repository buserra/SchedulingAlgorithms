
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
          float quanta = 1;
          RandomQueue rando = new RandomQueue();
          ArrayList<ArrayList> randomQueues;
          ArrayList<SimProcess> temp;
          FCFS fcfs = new FCFS();
          SJF sjf = new SJF();
          RR rr = new RR();
        
        //for(int i =0; i<4; i++){
          int i = 1;
          randomQueues = rando.getQueue(numberProcessInQueue);
          String name = "Report for Run "+(i+1);
          Report report = new Report(name);
          temp = randomQueues.get(0);
          fcfs.run(temp, report);
          //sjf.run(randomQueues.get(1);
          //rr.run(randomQueues.get(3);
          //System.out.println(report.toString());
        //}
    }   
}

/*
ArrayList prnt = randomQueues.get(0);
            for (Object temp : prnt){
              System.out.print(temp.toString());
            }
*/