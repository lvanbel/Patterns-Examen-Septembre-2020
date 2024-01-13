public class PaypalStrategy implements PaymentStrategy{

  private String password;
  private String email;

  public PaypalStrategy(String password, String email) {
    this.password = password;
    this.email = email;
  }

  @Override
  public void pay(int amount) {
    String encryptedPassword= password.replaceAll(".", "*");
    System.out.println(amount + " euros paid using Paypal / email: " + email + ", password: " +
        encryptedPassword);
  }
}
