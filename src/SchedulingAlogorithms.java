
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
          Report report = new Report();
          FCFS fcfs = new FCFS();
          SJF sjf = new SJF();
          RR rr = new RR();
        
        //for(int i =0; i<4; i++){
          //admin
          int i = 1;
          randomQueues = rando.getQueue(numberProcessInQueue);
          
          //**FCFS********/
          //totalClock = fcfs.run(randomQueues.get(0), i);
          //report.run(randomQueues.get(0), totalClock);
          /********************************/
          
          //**SJF********/
          sjf.run(randomQueues.get(1), i);
          //report.run(randomQueues.get(1));
          /********************************/
          
          //**RR********/
          //rr.run(randomQueues.get(2));
          //report.run(randomQueues.get(2));
          /********************************/
          
        //}
    }   
}

/*
ArrayList prnt = randomQueues.get(0);
            for (Object temp : prnt){
              System.out.print(temp.toString());
            }
*/