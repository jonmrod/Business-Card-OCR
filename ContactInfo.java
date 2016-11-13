public class ContactInfo {
  //initial fields
  private String name;
  private String email;
  private String phoneNumber;

  //this is the constructor of the class ContactInfo
  public ContactInfo() {

  }

  //set name in business card
  public void setName(String name) {
    this.name = name;
  }

  //set phone number in business card
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //set email in business card
  public void setEmailAddress(String email) {
    this.email = email;
  }

  //return name in business card
  public String getName() {
    return name;
  }

   //return phone number in business card
  public String getPhoneNumber() {
    return phoneNumber;
  }

   //return email address in business card
  public String getEmailAddress() {
    return email;
  }
}