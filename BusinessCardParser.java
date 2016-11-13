import java.io.*;
import java.util.*;
public class BusinessCardParser {
  public static void main(String args[]) throws FileNotFoundException{
    //get file from command line argument
    if (args.length == 0) {
      System.out.println("Please enter a text file name!");
      System.exit(1);
    }
    File card = new File(args[0]);
    //placeholder for each line
    String str = null;
    //list to get each line's text
    List<String> list = new ArrayList<String>();
    //if file exists and can read
    if (card.exists() && card.canRead()) {
      Scanner sc = new Scanner(card);
      while (sc.hasNextLine()) {
        str = sc.nextLine();
        list.add(str);
      }
      getContactInfo(list);
    }
    else {
      System.out.println("file does not exist");
      System.exit(1);
    }
  }

  public static void getContactInfo(List<String> list) {
    ContactInfo bCard = new ContactInfo();
    bCard.setPhoneNumber(findPhoneNumber(list));
    bCard.setName(smallest(list));
    bCard.setEmailAddress(findEmail(list));
    showResults(bCard);
  }  

  public static void showResults(ContactInfo bCard) {
    System.out.println("Name: " + bCard.getName());
    System.out.println("Phone: " + bCard.getPhoneNumber());
    System.out.println("Email: " + bCard.getEmailAddress());
  }

  public static String smallest(List<String> words) {
    String smallest = words.get(0);
    for (int i = 1; i < words.size(); i++) {
      //get smallest string
      if (words.get(i).length() < smallest.length()) {
        //only letters
        if (words.get(i).matches("[a-zA-Z ]+")) {
          smallest = words.get(i);
        }
      }
    }
    return smallest;
  }

  public static String findPhoneNumber(List<String> words) {
    String number = "No valid phoner number found";
    for (int i = 0; i < words.size(); i++) {
      //if phone number format includes -, . , spaces, + sign in front
      if (words.get(i).replaceAll("[^\\d.]", "").matches("[+]?\\d?[- .]?(\\([0-9]\\d{2}\\)|[0-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$")) {
        number = words.get(i).replaceAll("[^\\d.]", "").replace("-", "").replace(".", "").replace(" ", "").replace("(", "").replace(")", "").replace("+", "");
        break;
      }
    }
    return number;
  }

  public static String findEmail(List<String> words) {
    String email = "No valid email found";
    for (int i = 0; i < words.size(); i++) {
      // if email has words in beginning, dot is optional, followed by @ and domain plus .com,.edu,etc (min length of 2 char)
      if (words.get(i).matches("^[\\w\\+]+(\\.[\\w]+)*@" + "[\\w]+(\\.[\\w]+)*(\\.[A-Za-z]{2,})$")) {
        email = words.get(i);
        break;
      }
    }
    return email;
  }
}