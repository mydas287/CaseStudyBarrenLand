package barrenLandAnalysis;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/**
*
* This test class is used to test the fertile land area in square meters, sorted from smallest area to greatest, separated by a space. 
* 
* @author Mayank Dasila
* @testedClasses BarrenLandAnalysis.java
*/
public class BarrenLandAnalysisTest 
{
	//~ Instance attributes ------------------------------------------------------------------------

	protected BarrenLandAnalysis barrenLandAnalysis;
	
	//~ Static attributes/initializers -------------------------------------------------------------
	
		final static String SAMPLE_INPUT_1          = new String("{“0 292 399 307”}");
		final static String SAMPLE_RESULT_1         = new String("116800 116800");
		final static String SAMPLE_INPUT_2          = new String("{“48 192 351 207”,“48 392 351 407”,“120 52 135 547”,“260 52 275 547”}");
		final static String SAMPLE_RESULT_2         = new String("22816 192608");
		final static String TEST_DATA               = new String("{“49 193 352 208”,“47 391 350 406”,“121 53 136 548”,“259 51 274 546”}");
		final static String TEST_RESULT             = new String("22204 193220");
		final static String NO_FERTILE_LAND         = new String("{“0 0 399 599”}");
		final static String NO_FERTILE_LAND_RESULT  = new String("0");
		final static String NO_BARREN_LAND          = new String("{“ ”}");
		final static String NO_BARREN_LAND_RESULT   = new String("240000");
	
	//~ Test Methods ------------------------------------------------------------------------
	
	/**
	 * Test to read input from STDIN and print output to STDOUT
	 */
	@Test
	public void testReadInputFromSTDIN() throws IOException 
	{	
		barrenLandAnalysis = new BarrenLandAnalysis();		
		barrenLandAnalysis.readInputFromSTDIN();
		barrenLandAnalysis.identifyBarrenLand();
		barrenLandAnalysis.getFertileLand();
		System.out.println(barrenLandAnalysis.getStandardOutput());
	}

	/**
     * Test for given Sample input 1
     */
	@Test
	public void testSampleInput1() 
	{	
		barrenLandAnalysis = new BarrenLandAnalysis();
		
		barrenLandAnalysis.readStandardInput(SAMPLE_INPUT_1);
		barrenLandAnalysis.identifyBarrenLand();
		barrenLandAnalysis.getFertileLand();		
		
		assertEquals(SAMPLE_RESULT_1,barrenLandAnalysis.getStandardOutput());
		System.out.println("Sample Input 1: "+ SAMPLE_INPUT_1);
		System.out.println("Sample Output 1: "+barrenLandAnalysis.getStandardOutput());
	}
	
	/**
     * Test for given Sample input 2
     */
	@Test
	public void testSampleInput2() 
	{	
		barrenLandAnalysis = new BarrenLandAnalysis();
		
		barrenLandAnalysis.readStandardInput(SAMPLE_INPUT_2);
		barrenLandAnalysis.identifyBarrenLand();
		barrenLandAnalysis.getFertileLand();		
		
		assertEquals(SAMPLE_RESULT_2,barrenLandAnalysis.getStandardOutput());
		System.out.println("Sample Input 2: "+ SAMPLE_INPUT_2);
		System.out.println("Sample Output 2: "+barrenLandAnalysis.getStandardOutput());
	}
	
	/**
     * Test for test data created other than sample input
     */
	@Test
	public void testTestData() 
	{	
		barrenLandAnalysis = new BarrenLandAnalysis();
		
		barrenLandAnalysis.readStandardInput(TEST_DATA);
		barrenLandAnalysis.identifyBarrenLand();
		barrenLandAnalysis.getFertileLand();
		
		assertEquals(TEST_RESULT,barrenLandAnalysis.getStandardOutput());		
		System.out.println("Test Input 1: "+ TEST_DATA);
		System.out.println("Test Output 1: "+barrenLandAnalysis.getStandardOutput());		
	}
	
	/**
     * Test for when there is no fertile land
     */
	@Test
	public void testNoFertileLand() 
	{	
		barrenLandAnalysis = new BarrenLandAnalysis();
		
		barrenLandAnalysis.readStandardInput(NO_FERTILE_LAND);
		barrenLandAnalysis.identifyBarrenLand();
		barrenLandAnalysis.getFertileLand();		
		
		assertEquals(NO_FERTILE_LAND_RESULT,barrenLandAnalysis.getStandardOutput());
		System.out.println("Test Input 2: "+ NO_FERTILE_LAND);
		System.out.println("Test Output 2: "+barrenLandAnalysis.getStandardOutput());
	}
	
	/**
     * Test for when there is no barren land
     */
	@Test
	public void testNoBarrenLand() 
	{	
		barrenLandAnalysis = new BarrenLandAnalysis();
		
		barrenLandAnalysis.readStandardInput(NO_BARREN_LAND);
		barrenLandAnalysis.identifyBarrenLand();
		barrenLandAnalysis.getFertileLand();		
		
		assertEquals(NO_BARREN_LAND_RESULT,barrenLandAnalysis.getStandardOutput());
		System.out.println("Test Input 3: "+ NO_BARREN_LAND);
		System.out.println("Test Output 3: "+barrenLandAnalysis.getStandardOutput());
	}
}
