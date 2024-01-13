import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Item> items;
	
	public ShoppingCart(){
		this.items=new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public void removeItem(Item item){
		this.items.remove(item);
	}

	public void pay(PaymentStrategy paymentStrategy){
		if(items.isEmpty()) throw new RuntimeException("Your shopping cart is empty");
		int amount = 0;
		for(Item item : items){
			amount += item.getPrice();
		}

		paymentStrategy.pay(amount);

		// vide le panier
		items= new ArrayList<Item>();
		System.out.println("Thank you and goodbye");
		System.out.println("------------------");
	}
}