package barrenLandAnalysis;

import java.io.IOException;

/**
 * Main class to run the app and get input from user.
 * Kindly enter input of the form {“0 292 399 307”}
 *
 * @author  Mayank Dasila
 */
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
