# Business-Card-OCR
Component that parses the results of the optical character recognition (OCR) component in order to extract the name, phone number, and email address from the processed business card image

## Instructions to run
* Make sure to have Java 7 or greater installed
* Have terminal/CMD Prompt knowledge

### To Run
Go into folder directory.
Compile the BusinessCardParser and its class ContactInfo
```
javac BusinessCardParser.java
javac ContactInfo.java
```

Then run the program with the file as an argument
```
java BusinessCardParser card.txt
```
* Replace the contents in card.txt to test different cases as needed

### Output
The console will show the information as follows:

```
java BusinessCardParser card.txt

Name: Arthur Wilson
Phone: 17035551259
Email: awilson@abctech.com 
```
