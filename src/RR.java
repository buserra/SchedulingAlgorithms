
import java.util.ArrayList;


public class RR {


    public void run(ArrayList<SimProcess>  inQueue, int run){
      int queueLength = 0, count = 0;
      ArrayList<SimProcess> queueCopy= (ArrayList<SimProcess>)inQueue.clone();
      float cpuClock = (int)Math.ceil(queueCopy.get(0).arrivalTime);
      float timeRemaining;
      boolean flag;
      SimProcess spPoint;

        while(queueCopy.size() > 0){
            if(queueCopy.get(count).arrivalTime > cpuClock){
                System.out.println("cpu clock = "+cpuClock+", Idle");
            }
            else{
                System.out.print(queueCopy.toString());
                queueCopy.get(count).estimatedRunTime--;
                if(queueCopy.get(count).estimatedRunTime <= 0){
                    queueCopy.get(count).timeCompleted = cpuClock;
                    queueCopy.remove(count);
                }
            }
            cpuClock++;
            count = (queueCopy.size() - 1 != 0 && count % (queueCopy.size() - 1) == 0)? 0 : count++;
        }
    }
}
