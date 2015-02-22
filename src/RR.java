
import java.util.ArrayList;


public class RR {


    public Float run(ArrayList<SimProcess> inQueue, int run) {
        int queueLength = 0, count = 0;
        boolean completed = false;
        ArrayList<SimProcess> queueCopy = new ArrayList<SimProcess>(inQueue.size());
        for (SimProcess x : inQueue) {
            queueCopy.add(new SimProcess(x));
        }

        float cpuClock = (float) Math.ceil(queueCopy.get(0).arrivalTime);


        while (!completed) {
            if (inQueue.get(count).arrivalTime > cpuClock) {
                //System.out.println("cpu clock = "+cpuClock+", Idle");
                cpuClock = checkCpuIdle(inQueue, cpuClock);
            } else if (!inQueue.get(count).complete) {
                if (inQueue.get(count).timeFirstCpu == 0.0) {
                    inQueue.get(count).timeFirstCpu = cpuClock;
                }
                //System.out.println(inQueue.get(count).pid + " is running. CpuClock: " + cpuClock);
                queueCopy.get(count).estimatedRunTime--;
                if (queueCopy.get(count).estimatedRunTime <= 0.0) {
                    inQueue.get(count).timeCompleted = cpuClock + 1;
                    inQueue.get(count).waitingTime = inQueue.get(count).timeCompleted - (float)Math.ceil(inQueue.get(count).arrivalTime)
                            - (float)Math.ceil(inQueue.get(count).estimatedRunTime) + (inQueue.get(count).timeFirstCpu - inQueue.get(count).arrivalTime);

                    inQueue.get(count).complete = true;
                    //System.out.println(inQueue.get(count).pid + " is complete. CpuC.lock: " + cpuClock);

                }
                cpuClock++;
            }

            completed = checkComplete(inQueue);
            count++;
            count = (count > (queueCopy.size() - 1)) ? 0 : count++;
        }
        return cpuClock;
    }

    public static boolean checkComplete(ArrayList<SimProcess> que) {
        boolean comp = true;
        for (SimProcess x : que) {
            if (x.complete == false) {
                comp = false;
            }
        }
        return comp;
    }

    public static float checkCpuIdle(ArrayList<SimProcess> que, float clock) {

        for (SimProcess x : que) {
            if (x.arrivalTime < clock && x.complete == false) {
                return clock;
            }
        }
            clock++;
            return clock;
    }

}
