
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Buser
 */
public class RandomQueue {
    
    public class CustomComparator implements Comparator<SimProcess> {
    @Override
        public int compare(SimProcess o1, SimProcess o2) {
            float x = o1.getarrivalTime();
            float y = o2.getarrivalTime();
            if (x < y) return -1;
            if (x > y) return 1;
            return 0;
        }
    } 
    
    
    public ArrayList getQueue(int num){
        SimProcess process1;
        SimProcess process2;
        SimProcess process3;
        String pid;
        float arrivalTime;
        float estimatedRunTime;
        float arrivalMin = 0;
        float arrivalMax = 200;
        float estimateTimeMin = (float) 0.1;
        float estimateTimeMax = 10;
        Random generator = new Random();
        ArrayList<SimProcess> rando1 = new ArrayList();
        ArrayList<SimProcess> rando2 = new ArrayList();
        ArrayList<SimProcess> rando3 = new ArrayList();
        ArrayList<ArrayList> total = new ArrayList();
        
        for(int i =0;i<num;i++){
            pid = "p"+(i+1);
            arrivalTime = generator.nextFloat() * (arrivalMax - arrivalMin) + arrivalMin;
            estimatedRunTime = generator.nextFloat() * (estimateTimeMax - estimateTimeMin) + estimateTimeMin;
            process1 = new SimProcess(pid,arrivalTime,estimatedRunTime);
            process2 = new SimProcess(pid,arrivalTime,estimatedRunTime);
            process3 = new SimProcess(pid,arrivalTime,estimatedRunTime);
            rando1.add(process1);
            rando2.add(process2);
            rando3.add(process3);
        }
        CustomComparator compare = new CustomComparator();
        Collections.sort(rando1, compare);
        Collections.sort(rando2, compare);
        Collections.sort(rando3, compare);
        total.add(rando1);
        total.add(rando2);
        total.add(rando3);
        return total;
    }
    
    
}
