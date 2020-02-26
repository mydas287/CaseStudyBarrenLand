package barrenLandAnalysis;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;


/**
 * This class contains all the logic for calculating all the fertile land area in square meters, 
 * sorted from smallest area to greatest, separated by a space. 
 *
 * @author  Mayank Dasila
 */
public class BarrenLandAnalysis 
{

	//~ Instance attributes ------------------------------------------------------------------------
	
	private HashMap<Integer, Integer> mapFertileLand   = null;
	private LinkedList<Integer[]>     barrenRectangle  = null;
	private LinkedList<Integer[]>     queue            = null;	
	private int                       adjMatrix[][]    = null;
	
	 //~ Static attributes/initializers -------------------------------------------------------------
	
	final static int WIDTH  = 400;
	final static int HEIGHT = 600;
	
	//~ Constructors -------------------------------------------------------------------------------
	
	public BarrenLandAnalysis() 
	{
		barrenRectangle = new LinkedList<Integer[]>();
		queue = new LinkedList<Integer[]>();
		mapFertileLand = new HashMap<Integer, Integer>();
		adjMatrix = new int[WIDTH][HEIGHT];
	}
	
	//~ Methods ------------------------------------------------------------------------------------

	/**
     * break down the input and add to list
     * 
     * @param String input
     */ 
	public void readStandardInput(String input) 
	{

		//split if multiple rectangles and add to array 
		String[] splitInput = input.split(",");
		
		//remove the special chars from the input string
		for (String temp : splitInput) 
		{			
			temp = temp.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+","");

			//add each rectangle coordinate to the list
			if (!temp.isEmpty() || !(temp == null)) 
			{
				//convert int to integer and add to list
				int[] numbers = Arrays.stream(temp.split("[ ,]+")).mapToInt(Integer::parseInt).toArray();
				Integer[] values = new Integer[numbers.length];
				for (int i = 0; i < numbers.length; i++) {
					values[i] = Integer.valueOf(numbers[i]);
				}
				barrenRectangle.add(values);
			}
		}
	}

	/**
     * add zeros to the entire grid
     * Then identify the Barren land rectangles by adding 1 to it
     * This helps to parse the entire grsph and identify pacthes of land which are barren
     * 
     * This will form an adjacency matrix like below
     * 
     *  0 0 0 0 0 0 0 0 0
     *  0 0 0 0 0 1 1 1 0
     *  0 0 0 0 0 1 1 1 0
     *  0 1 1 1 0 0 0 0 0
     *  0 1 1 1 0 0 1 1 1
     *  0 0 0 0 0 0 1 1 1
     */ 
	public void identifyBarrenLand() 
	{
		//adding zeros to the entire grid
		for (int i = 0; i < WIDTH; i++)
		{
			for (int j = 0; j < HEIGHT; j++)
			{
				adjMatrix[i][j] = 0;
			}
		}

		ListIterator<Integer[]> iterator = barrenRectangle.listIterator();
		
		//add ones to the barren land rectangles
		while (iterator.hasNext()) {

			Integer[] rectangle = iterator.next();
			if (rectangle == null || rectangle.length == 0)
			{
				break;
			}
			for (int i = rectangle[0]; i <= rectangle[2]; i++)
			{
				for (int j = rectangle[1]; j <= rectangle[3]; j++)
				{
                    // System.out.println("i ==" +i + " j =="+ j);
					adjMatrix[i][j] = 1;
				}
			}					
		}
	}
	
	/**
     * Convert output to the sample output form
     */ 
	public String getStandardOutput() 
	{
		int[] result = new int[mapFertileLand.values().size()];
		int i = 0;

		for (Map.Entry<Integer, Integer> entry : mapFertileLand.entrySet()) {
			result[i] = entry.getValue();
			i++;
		}

		if (result == null || result.length == 0)
		{
			return "0";
		}
		else
		{
			Arrays.sort(result);
			return (Arrays.toString(result)).replaceAll("\\[|\\]|,", "");
		}		
	}

	/**
     * Read input from STDIN
     */ 
	public void readInputFromSTDIN() throws IOException 
	{
		System.out.println("Enter your input: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		readStandardInput(input);
		scanner.close();
	}

	/**
     * Performing BFS for disconnected components.
	 * Traverse through the entire adjacency matrix and identify the connected components.
	 * The final area is the total nodes each connected component has.
     */ 	 
	public void getFertileLand() 
	{
		int fertileLand = 1;
		int i = 0;
		int j = 0;

		while (i < WIDTH && j < HEIGHT) 
		{
			if (queue.isEmpty()) 
			{
				Integer node[] = { i, j };

				// If node[i][j] has not been visited add to queue
				// As the queue was empty, this is a new fertile land
				if (adjMatrix[i][j] == 0) 
				{
					fertileLand++;
					mapFertileLand.put(fertileLand, 0);
					queue.add(node);
				}
				// Make sure we pass through all the Land
				if (i == (WIDTH - 1)) 
				{
					i = 0;
					j++;
				} 
				else
				{
					i++;
				}					
			}
			else
			{
				Integer node[] = queue.pop();

				int x = node[0];
				int y = node[1];

				if (adjMatrix[x][y] == 0) 
				{
					if (x > 0)
						addQueue(x - 1, y);
					if (x < (WIDTH - 1))
						addQueue(x + 1, y);
					if (y > 0)
						addQueue(x, y - 1);
					if (y < (HEIGHT - 1))
						addQueue(x, y + 1);

					adjMatrix[x][y] = fertileLand;
					mapFertileLand.put(fertileLand, (mapFertileLand.get(fertileLand) + 1));
				}
			}
		}
	}
	
	/**
	 * If node is not visited, add to queue
     */ 	
	public void addQueue(int i, int j) 
	{
		if (adjMatrix[i][j] == 0) {
			queue.add(new Integer[] { i, j });
		}
	}
}