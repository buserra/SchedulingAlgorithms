
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
public class FCFS {

    public float run(ArrayList<SimProcess> inQueue, int run) {
        int queueLength,i;
        float cpuClock = 0;
        float timeRemaining;
        boolean flag;
        SimProcess spPoint;

        //I will need this somewhere
        queueLength = inQueue.size();
        System.out.println("**********\nCPU Activity for FCFS run "+run+"\n**********");
        for(i=0;i<queueLength;i++){
            spPoint = inQueue.get(i);
            flag = true;
            do{
                if(spPoint.arrivalTime > cpuClock){
                    System.out.println("cpu clock = "+cpuClock+", Idle");
                    cpuClock++;
                }
                else{
                    spPoint.timeFirstCpu = cpuClock;
                    timeRemaining = spPoint.estimatedRunTime;
                    while(timeRemaining>0){
                        System.out.println("cpu clock = "+cpuClock+", pid: "+spPoint.pid+", time remaining = "+timeRemaining);
                        timeRemaining--;
                        cpuClock++;
                    }
                    flag = false;
                    spPoint.timeCompleted = cpuClock;
                }
            }while(flag);
        }
        System.out.println("\n");
        return cpuClock;
    }
}
