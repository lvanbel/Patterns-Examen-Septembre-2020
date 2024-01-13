public class CrediCardStrategy implements PaymentStrategy {

  private String name;
  private String cardNumber;
  private String expiryDate;

  public CrediCardStrategy(String name, String cardNumber, String expiryDate) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.expiryDate = expiryDate;
  }

  @Override
  public void pay(int amount) {
    String encryptedCardNumber = this.cardNumber.replaceAll(".", "*");
    System.out.println(amount + " euros paid using CreditCard / name: " + this.name +
        ", card number: " + encryptedCardNumber+ " (expiration date: "+ this.expiryDate + ")");
  }
}
