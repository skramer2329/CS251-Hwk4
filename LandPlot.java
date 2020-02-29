import java.text.DecimalFormat;

public class LandPlot {
	
	
	//private object fields
	private	String owner;
	private double length;
	private double width;
	
	//private static mutable variable
	private static double pricePerAcre = 100;
	//public static final constant
	public static final int SQUARE_FEET_PER_ACRE = 43560;
	
	//used for string format
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	
	public LandPlot(String name, double lengthInFeet, double widthInFeet) {
		////TODO initialize fields
		////if a negative is given, set to 0.0
		if(lengthInFeet < 0) {
			lengthInFeet = 0;
		}
		this.length = lengthInFeet;
		
		if(widthInFeet < 0) {
			widthInFeet = 0;
		}
		this.width = widthInFeet;
		
		this.owner = name;
		
	}
	
	
	public LandPlot(String name, double acres) {
		this(name, Math.sqrt(acres * SQUARE_FEET_PER_ACRE), Math.sqrt(acres * SQUARE_FEET_PER_ACRE));
		////TODO call the other constructor
		//assume the plot is a square
		//compute the length and width from the acres by:
		//// 1. convert acreage to square feet by multiplying by the conversion constant
		//// 2. take the square root of the square feet
		//// 3. do this all on one line, inside the parentheses of the constructor call
		////		eg. this(name, <BUNCH OF MATH>, <BUNCH OF MATH>);
		//What happens if a negative acreage is given? This is not tested, but think about it.
	}
	
	//basic getters included for you
	
	public String getOwner() {
		return owner;
	}


	public double getLength() {
		return length;
	}


	public double getWidth() {
		return width;
	}
	
	/**
	 * @return the size of this plot in acres.
	 */
	public double getAcres() {
		////TODO multiply length by width to get area in square feet
		////then divide by the number of square feet in an acre
		return (this.length * this.width)/ SQUARE_FEET_PER_ACRE;   
	
	}
	
	/**
	 * @return the value in dollars of this plot of land currently
	 */
	public double getValue() {
		////TODO multiply the acreage by the price per acre
		return getAcres() *pricePerAcre;
		
	}
	
	/**
	 * returns a string representation of this object.
	 * syntax: <owner>'s plot: <numberOfAcres> acres valued at <valueInDollars>
	 */
	@Override
	public String toString() {
		//TODO to pass the tests, use df2.format(value) to get the correct format for numbers
		
		return getOwner() + "'s plot: " + df2.format(getAcres()) + " acres valued at " + df2.format(getValue());
	
	}
	
	
	@Override
	public boolean equals(Object other) {
		//TODO
		//1. if this and other are the same object, return true
		//2. if other is null, return false
		//3. if other's class is not == this object's class return false
		//	(use .getClass() for this)
		//4. cast other to a LandPlot
		//5. if either double field is not equals, return false
		//6. if one owner is null and the other is not, return false
		//7. if neither owner is null, but the owners are not equal, return false
		//8. return true
		
		if(this == other) {
			return true;
		}
		else if(other == null) {
			return false;
		}
		else if(this.getClass() != other.getClass()){
			return false;
		}
	
		LandPlot o = (LandPlot) other;
		if(this.length != o.length || this.width != o.width) {
			return false;
		}
		else if(this.owner == null && o.owner != null) {
			return false;
		}
		else if(this.owner == null && o.owner ==null) {
			return true;
		}
		else if(!this.owner.equals(o.owner)) {
			return false;
		}
		
		return true;
	}


	/**
	 * @param newOwner: the new owner of this plot
	 * @return the value of this plot at the time of sale.
	 */
	public double sellLand(String newOwner) {
		//TODO change the owner and return the value
		this.owner = newOwner;
		return getValue();
	}
	
	/**
	 * divides this plot into two equal landPlots width-wise, unless its width is less than 20 feet.
	 * this plot's width should get smaller if a split occurs, and a new plot (the other half) should be returned
	 * @return the new LandPlot if created, null if not.
	 */
	public LandPlot splitWidth() {
//		//TODO split the plot
		if(this.width < 20) {
			return null;
		}
		LandPlot splitPlotWidth = new LandPlot(this.owner, this.length,this.width/2);
		this.width = this.width/2;
		
		return splitPlotWidth;
	
	}
	
	
	/**
	 * divides this plot into two equal landPlots length-wise, unless its length is less than 20 feet.
	 * this plot's length should get smaller if a split occurs, and a new plot (the other half) should be returned
	 * @return the new LandPlot if created, null if not.
	 */
	public LandPlot splitLength() {
		//TODO split the plot
		if(this.length < 20) {
			return null;
		}
		LandPlot splitPlotLength = new LandPlot(this.owner, this.length/2, this.width);
		this.length = this.length/2;
		return splitPlotLength;
	}
	


	
	//STATIC METHODS
	
	/**
	 * static method to update the current price Per Acre.
	 * if a negative value is given, set to 0.
	 * @param newPrice
	 */
	public static void updatePrice(double newPrice) {
		//TODO change the static variable that determines price per acre
		if(newPrice < 0) {
			newPrice = 0;
		}
		pricePerAcre = newPrice;
	}


	

}
