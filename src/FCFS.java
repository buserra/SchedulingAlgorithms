
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
    public ArrayList<SimProcess> inQueue = new ArrayList();
    
    public void run(ArrayList testQueue, Report report){
        float cpuClock = 0;
        float tempArvalTme;
        boolean flag = true;
        ArrayList<SimProcess> qPoint;
        SimProcess spPoint;
        
        qPoint = testQueue;
        int queueLength = testQueue.size();
        
        //copy test queue
        qPoint = testQueue;
        for(SimProcess temp : qPoint){
            try {
                spPoint = (SimProcess) temp.clone();
                inQueue.add(spPoint);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(FCFS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        do{
            //add new arrivals to cpu queue
            for(SimProcess temp : inQueue){
                tempArvalTme = temp.getarrivalTime();
                if(tempArvalTme<cpuClock){
                    inQueue.remove(temp);
                    cpuQueue.add(temp);
                }
            }
            
            //send process to cpu
            if(cpuQueue.size()>0){
                //process
            }
            else{
                System.out.println("Idle");
            }
            
            
            
             
            
            
        }while(flag);
        
    }   
}
