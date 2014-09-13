
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alan, David, Jack, Jinn
 */
public class RunningMonitor implements Runnable {

    Thread runner;
    int [] BPM = { 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 
                    45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 
                    65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85, 
                    45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 
                    65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85, 
                    45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 
                    65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85,
                    45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 
                    65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85,
                    86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 130, 132, 133, 134, 135, 
                    136, 138};
    
    double [] Temp = {34, 35, 36, 38, 39, 40, 42, 44, 34, 35, 36, 38, 39, 40, 42, 44,
                        34, 35, 36, 38, 39, 40, 36, 38, 39, 40, 36, 38, 39, 40
                        , 36, 38, 39, 40, 36, 38, 39, 40, 42, 44, 34, 35, 36, 38, 39, 40, 42, 44,
                        34, 35, 36, 38, 39, 40, 42, 44, 34, 35, 36, 38, 39, 40, 42, 44};
    
    double [] BG = {4,5,8,6,7,5,3,5,6,5,7,9,10,3,8,7,9,5,6,4,7,3,8,11,12,11,4,5,6,3,8,5,6,
                    4,5,8,6,7,5,3,5,6,5,7,9,10,3,8,7,9,5,6,4,7,3,8,11,12,11,4,5,6,3,8,5,6,
                    4,5,8,6,7,5,3,5,6,5,7,9,10,3,8,7,9,5,6,4,7,3,8,11,12,11,4,5,6,3,8,5,6};
    
    int [] BPhigh = {110, 112, 113, 114,115, 119, 122, 124, 128, 130, 134, 136, 139, 140, 145,
                        147, 149, 152, 154, 156, 158, 162, 172, 165, 180 ,182, 184, 190, 187,
                        110, 112, 113, 114,115, 119, 122, 124, 128, 130, 134, 136, 139, 140, 145,
                        147, 149, 152, 154, 156, 158, 162, 172, 165, 180 ,182, 184, 190, 187,
                        110, 112, 113, 114,115, 119, 122, 124, 128, 130, 134, 136, 139, 140, 145,
                        147, 149, 152, 154, 156, 158, 162, 172, 165, 180 ,182, 184, 190, 187};
    
    int [] BPlow = {60, 62, 64, 66, 68, 69, 71, 73, 74, 76, 77, 79, 81, 82, 83, 85, 87, 89, 90,
                        92, 93, 94, 95, 96, 97, 98, 99, 100, 103, 104, 60, 62, 64, 66, 68, 69, 
                        71, 73, 74, 76, 77, 79, 81, 82, 83, 85, 87, 89, 90,92, 93, 94, 95, 96, 
                        97, 98, 99, 100, 103, 104, 60, 62, 64, 66, 68, 69, 71, 73, 74, 76, 77, 
                        79, 81, 82, 83, 85, 87, 89, 90, 92, 93, 94, 95, 96, 97, 98, 99, 100, 103, 104,
                        60, 62, 64, 66, 68, 69, 71, 73, 74, 76, 77, 79, 81, 82, 83, 85, 87, 89, 90,
                        92, 93, 94, 95, 96, 97, 98, 99, 100, 103, 104}; //32

    public RunningMonitor() {
        start();
    }

    public void start() {
        if (runner == null) {
            runner = new Thread(this);
        }
        runner.start();
        //method to start thread
    }
    
    public String RandomBPM(){
        Random bpm = new Random(); 
        int n = bpm.nextInt(BPM.length); 
        return Integer.toString(BPM[n]);
    }
    
    public String RandomBG(){
        Random temp = new Random(); 
        int n = temp.nextInt(BG.length); 
        return Double.toString(BG[n] + Math.random()).substring(0,4);
    }
    
    public String RandomTemp(){
        Random temp = new Random(); 
        int n = temp.nextInt(Temp.length); 
        return Double.toString(Temp[n] + Math.random()).substring(0,4);
    }
    
    public String RandomBP() {
        Random bpm = new Random(); 
        int n = bpm.nextInt(70); 
        return Integer.toString(BPhigh[n]) + "/" + Integer.toString(BPlow[n]);
    }
    
    @Override
    public synchronized void run() {
        while (runner == Thread.currentThread()) {
            try {
                DoctorMonitor.BPMText.setText(RandomBPM());
                DoctorMonitor.BGText.setText(RandomBG());
                DoctorMonitor.tempText.setText(RandomTemp());
                DoctorMonitor.BPText.setText(RandomBP());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunningMonitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread failed");
        }
    }
    
    public void stop() {
        runner = null;
    }
}

