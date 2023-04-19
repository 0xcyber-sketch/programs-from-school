package opgave04;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        
        
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");
        Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        TrainingPlan t1 = new TrainingPlan('A', 16, 10);
        
        t1.createSwimmer("Jan", 1994, lapTimes, "AGF");
        t1.createSwimmer("Bo", 1995, lapTimes, "Lyseng");
        t1.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        
        
        for(Swimmer s : t1.getSwimmers()) {
        	System.out.println(s.getName());
        }
        
        t1.removeSwimmer(t1.getSwimmers().get(1));
        
        System.out.println();
        
        for(Swimmer s : t1.getSwimmers()) {
        	System.out.println(s.getName());
        }
        
        
        

        
    }
    
}
