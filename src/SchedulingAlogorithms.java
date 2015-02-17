
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
          Report report = new Report();
          RandomQueue rando = new RandomQueue();
          ArrayList<SimProcess> randomQueue;
        
        for(int i =0; i<4; i++){
          randomQueue = rando.getQueue();
        }
    }
    
}
