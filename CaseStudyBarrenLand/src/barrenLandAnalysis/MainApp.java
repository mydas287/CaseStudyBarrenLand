package barrenLandAnalysis;

import java.io.IOException;

public class MainApp
{
    public static void main(String args[])
    {
        BarrenLandAnalysis barrenLandAnalysis = new BarrenLandAnalysis();      
        try
        {
            barrenLandAnalysis.readInputFromSTDIN();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        barrenLandAnalysis.identifyBarrenLand();
        barrenLandAnalysis.getFertileLand();
        System.out.println(barrenLandAnalysis.getStandardOutput());
    }

}
