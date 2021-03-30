
public class Vanilla  extends CoffeeDecorator {
	
	private double cost = .50;

	public Vanilla(Coffee specialCoffee) {
		super(specialCoffee);
		// TODO Auto-generated constructor stub
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addVanilla();
	}
	
	private double addVanilla() {
		
		//System.out.println(" + Vanilla: $.50");
		
		return cost;
	}

}
