
public class Splenda extends CoffeeDecorator{

	private double cost = .50;

	public Splenda(Coffee specialCoffee) {
		super(specialCoffee);
		// TODO Auto-generated constructor stub
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addSplenda();
	}
	
	private double addSplenda() {
		
		//System.out.println(" + Splenda: $.50");
		
		return cost;
	}
}
