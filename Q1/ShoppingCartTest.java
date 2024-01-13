public class ShoppingCartTest {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		PaymentStrategy paypalStrategy = new PaypalStrategy(
				"christophe.damas@vinci.be", "azerty123"
		);
		
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		//pay by paypal
		cart.pay(paypalStrategy);
		
		ShoppingCart cart2 = new ShoppingCart();
		PaymentStrategy creditCardStrategy = new CrediCardStrategy(
				"Christophe Damas", "1234567890123456", "12/22"
		);
		
		cart2.addItem(item1);
		cart2.addItem(item1);
		//pay by credit card
		cart2.pay(creditCardStrategy);
	}

}