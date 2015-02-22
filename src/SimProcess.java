/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Buser
 */
public class SimProcess {
    
    int id;
    public String pid;
    public float arrivalTime;
    public float estimatedRunTime;
    public float waitingTime = 0;
    public float timeCompleted = 0;
    public float timeFirstCpu = 0;
    boolean returningProcess = false;
    boolean complete = false;
    
    //public int numberTimesInCPU;
    //public int cpuArrivalTime;
    //public int cpuFinishTime;
    
    public SimProcess(int id, String pid, float aT, float eRT){
        this.id = id;
        this.pid = pid;
        this.arrivalTime = aT;
        this.estimatedRunTime = eRT;
    }

    public SimProcess(SimProcess original){
        this.id = original.id;
        this.pid = original.pid;
        this.arrivalTime = original.arrivalTime;
        this.estimatedRunTime = original.estimatedRunTime;
    }
    
   
    public float getarrivalTime(){
        return arrivalTime;
    }
    
    public String toString(){
        return "pid: "+pid+", Arrival Time: "+arrivalTime+", Estimated Run Time: "+estimatedRunTime;
    }
    
    public void calculateWaitTime(){
        //waitingTime = ;
    }
    
}
