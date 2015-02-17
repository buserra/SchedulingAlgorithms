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
    
    public String pid;
    public float arrivalTime;
    public float estimatedRunTime;
    
    //public int numberTimesInCPU;
    //public int cpuArrivalTime;
    //public int cpuFinishTime;
    
    public SimProcess(String pid, float aT, float eRT){
        this.pid = pid;
        this.arrivalTime = aT;
        this.estimatedRunTime = eRT;
    }
    
    public String toString(){
        return "pid: "+pid+", Arrival Time: "+arrivalTime+", Estimated Run Time: "+estimatedRunTime+"\n";
    }
    
}
