public class Driver {

	public static void main(String[] args) {
		//TODO:
		//// 1. Create 4 Strings representing different owners
		////		Make up names
		////		Store them in an array
		//// 2. Create an initial 4000ft by 4000ft plot of land
		////		Owned by one of the owners
		// 3. Split that plot into 4 equal-sized plots
		//		each one 2000ft by 2000ft
		//		storing them all in an array
		//		(make sure you understand the splitWidth and splitLength methods)
		// 4. Call printEqual on your array of LandPlots
		//		you should see lots of prints, since all plots have the same value
		// 5. Sell the plots so that each owner owns one plot
		// 6. Increase the price per acre to 200
		// 7. Print out the toString for each plot
		//		You should see the value of the plots has gone up!
		// 8. Call printEqual on your array again
		//		this time nothing should print, since all plots have a different owner
		
	String arr[] = {"Alice", "Caleb", "Bill", "George"};
	LandPlot plotA = new LandPlot("Alice", 4000, 4000);
	
	LandPlot plotC = plotA.splitLength();
	LandPlot plotD = plotC.splitWidth();
	LandPlot plotB = plotA.splitWidth();
	
	LandPlot plots[] = {plotA, plotB, plotC, plotD};
		
	printEqual(plots);
	for(int i = 1; i<= 3; i++) {
		plots[i].sellLand(arr[i]);
	}
	
	LandPlot.updatePrice(200);
	
	for(int i =0; i<4; i++) {
		System.out.println(plots[i].toString());
	}

	printEqual(plots);
		
	}
	
	private static void printEqual(LandPlot[] plots) {
		for(int i=0; i<plots.length; i++)
			for(int j=i+1; j<plots.length; j++)
				//TODO change this to only print if the two plots are equal
				if(plots[i].equals(plots[j]))
					System.out.println("Two equal plots: " + plots[i].toString() + " at " + i + " and " + plots[j].toString() + " at " + j);
	}

}
