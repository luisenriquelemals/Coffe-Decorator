
public class BuildingOrder {
	Coffee Order;
	String info;
	
	
	BuildingOrder () {
		Order = new BasicCoffee();
		info = "******** New Order ********\n"
			 + "Black Coffe: $3.99\n";
	}
	
	public void addSugar() {
		Order = new Sugar(Order);
		info += "+ sugar: $.50\n";
	}
	
	public void addExtraShot() {
		Order =  new ExtraShot(Order);
		info += "+ extra shot: $1.20\n";
	}
	
	public void addCream() {
		Order = new Cream(Order);
		info += "+ cream: $.50\n";
	}
	
	public void addVanilla() {
		Order =  new Vanilla(Order);
		info += "+ Vanilla Extract: $.50\n";
	}
	
	public void addSplenda() {
		Order = new Splenda(Order);
		info += "+ Splenda: $.50\n";
	}
	
	public double getTotal() {
		double total = Order.makeCoffee();
		info += "Total: "+total;
		return total;
	}
	

}// end of BuildingOrder
