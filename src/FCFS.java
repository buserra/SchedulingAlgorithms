
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Buser
 */
public class FCFS{
    //setQueue
    //getReport
    public ArrayList<SimProcess> cpuQueue = new ArrayList();
    public ArrayList<SimProcess> inQueue;
    public ArrayList<SimProcess> completedQueue = new ArrayList();
    
    public void run(ArrayList testQueue, Report report){
        int queueLength;
        float cpuClock = 0;
        float tempArvalTme;
        boolean flag = true;
        ArrayList<SimProcess> qPoint;
        SimProcess spPoint;
        
       //I will need this somewhere
        inQueue = testQueue;
        queueLength = inQueue.size();
        /*
        for(SimProcess temp : inQueue){
            System.out.print(temp.toString());
        }}*/
        
        do{
            //add new arrivals to cpu queue
            for(SimProcess temp : inQueue){
                tempArvalTme = temp.getarrivalTime();
                if(tempArvalTme<cpuClock){
                    inQueue.remove(temp);
                    cpuQueue.add(temp);
                }
            }
            
            //send process to cpu or idle
            if(cpuQueue.size()>0){
                //process
                spPoint = cpuQueue.remove(0);
                
                
            }
            else{
                System.out.print("CPUTime: "+cpuClock+", Idle");
            }
            
            
            
             
            
            
        }while(flag);
        
    }  
}
