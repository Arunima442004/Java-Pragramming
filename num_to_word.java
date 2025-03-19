public class num_to_word {
static void numberToWords(char num[])  
{  
//determines the number of digits in the given number  
int len = num.length;  
//checks the given number has number or not  
if (len == 0)   
{  
//if the given number is empty prints the following statement     
System.out.println("The string is empty.");  
return;  
}  
//here, we have specified the length of the number to 4  
//it means that the number (that you want to convert) should be four or less than four digits  
if (len > 4)   
{  
//if the given number is more than four-digit number, it prints the following statement    
System.out.println("\n The given number has more than 4 digits.");  
return;  
}  
//string type array for one-digit numbers    
String[] onedigit = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};  
//string type array for two digits numbers    
//the first index is empty because it makes indexing easy   
String[] twodigits = new String[] {"", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};  
//string type array of tens multiples   
//the first two indexes are empty because it makes indexing easy   
String[] multipleoftens = new String[] {"",  "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};  
//string type array of power of tens   
String[] poweroftens = new String[] {"Hundred", "Thousand"};  
//Used for debugging purpose only   
//the valueOf() method returns the string representation of the character array argument  
System.out.print(String.valueOf(num) + ": ");  
//checks whether the length of the given string is one or not  
if (len == 1)   
{  
//if the above condition returns true, it accesses the corresponding index and prints the value of that index  
//[num[0]-'0']: getting the number equal the decimal value of the character (assuming the char is the digit)  
System.out.println(onedigit[num[0]-'0']);  
return;  
}  
int x = 0;  
//executes until num does not become not '\0'  
while (x < num.length)   
{  
//executes if the length of the string is greater than equal to three  
if (len >= 3)   
{  
if (num[x] - '0' != 0)   
{  
System.out.print(onedigit[num[x] - '0'] + " ");  
//here length can be 3 or 4  
System.out.print(poweroftens[len - 3]+ " ");  
}  
//decrements the length of the string by 1  
--len;  
}  
//executes if the given number has two digits  
else   
{  
//the if-statement handles the numbers from 10 to 19 only     
if (num[x] - '0' == 1)   
{  
//adding the digits of the given number   
//the logic behind sum up the digits is that we will use the sum for accessing the index of the array   
//for example: 17, sum of digits = 8  
//we will access the 8th index in twodigits[] array i.e. Seventeen  
int sum = num[x] - '0' + num[x + 1] - '0';  
System.out.println(twodigits[sum]);  
return;  
}  
//the else-if statement handles the number 20 only  
//compares the tens and unit place with 2 and 0 respectively  
else if (num[x] - '0' == 2 && num[x + 1] - '0' == 0)   
{  
//executes if the above else-if condition returns true    
System.out.println("Twenty");  
return;  
}  
//the else block handles the numbers from 21 to 100  
else   
{  
int i = (num[x] - '0');  
if (i > 0)  
//prints the ith index element of the array multipleoftens[]  
System.out.print(multipleoftens[i]+ " ");  
else  
//prints space  
System.out.print("");  
//increments the variable i by 1  
++x;  
//checks whether the number is not equal to zero, it means the number has only a digit  
if (num[x] - '0' != 0)  
//prints the ith index element of the array onedigit[]  
System.out.println(onedigit[num[x] - '0']);  
}  
}  
//increments the variable i by 1  
++x;  
}  
}  
//main() method  
public static void main(String args[])  
{  
//calling the user-defined method and that invokes another predefined method toCharArray()  
//the method toCharArray() converts the given number into character array  
numberToWords("1111".toCharArray());  
numberToWords("673".toCharArray());  
numberToWords("85".toCharArray());  
numberToWords("5".toCharArray());  
numberToWords("0".toCharArray());  
numberToWords("20".toCharArray());  
numberToWords("1000".toCharArray());  
numberToWords("12345".toCharArray());  
//passing empty string   
numberToWords("".toCharArray());  
}  
}  
Output:

Java Program Number to Word
The number is not limited to four digits. Then what if the user enters more than 5 five digits numbers. The above program does not work for large digit numbers.

Converting Large Numbers into Words
The logic for converting the large digit numbers is quite different. Let's see the approach to convert large digits numbers.

NumberToWordExample2.java

import java.text.DecimalFormat;  
public class NumberToWordExample2   
{  
//string type array for one digit numbers     
private static final String[] twodigits = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};  
//string type array for two digits numbers   
private static final String[] onedigit = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};  
//defining constructor of the class  
private NumberToWordExample2()   
{  
}  
//user-defined method that converts a number to words (up to 1000)  
private static String convertUptoThousand(int number)   
{  
String soFar;  
if (number % 100 < 20)  
{  
soFar = onedigit[number % 100];  
number = number/ 100;  
}  
else   
{  
soFar = onedigit[number % 10];  
number = number/ 10;  
soFar = twodigits[number % 10] + soFar;  
number = number/ 10;  
}  
if (number == 0)   
return soFar;  
return onedigit[number] + " Hundred " + soFar;  
}  
//user-defined method that converts a long number (0 to 999999999) to string    
public static String convertNumberToWord(long number)   
{  
//checks whether the number is zero or not  
if (number == 0)   
{   
//if the given number is zero it returns zero  
return "zero";   
}  
//the toString() method returns a String object that represents the specified long  
String num = Long.toString(number);  
//for creating a mask padding with "0"   
String pattern = "000000000000";  
//creates a DecimalFormat using the specified pattern and also provides the symbols for the default locale  
DecimalFormat decimalFormat = new DecimalFormat(pattern);  
//format a number of the DecimalFormat instance  
num = decimalFormat.format(number);  
//format: XXXnnnnnnnnn  
//the subString() method returns a new string that is a substring of this string  
//the substring begins at the specified beginIndex and extends to the character at index endIndex - 1  
//the parseInt() method converts the string into integer  
int billions = Integer.parseInt(num.substring(0,3));  
//format: nnnXXXnnnnnn  
int millions  = Integer.parseInt(num.substring(3,6));  
//format: nnnnnnXXXnnn  
int hundredThousands = Integer.parseInt(num.substring(6,9));  
//format: nnnnnnnnnXXX  
int thousands = Integer.parseInt(num.substring(9,12));  
String tradBillions;  
switch (billions)   
{  
case 0:  
tradBillions = "";  
break;  
case 1 :  
tradBillions = convertUptoThousand(billions)+ " Billion ";  
break;  
default :  
tradBillions = convertUptoThousand(billions)+ " Billion ";  
}  
String result =  tradBillions;  
String tradMillions;  
switch (millions)   
{  
case 0:  
tradMillions = "";  
break;  
case 1 :  
tradMillions = convertUptoThousand(millions)+ " Million ";  
break;  
default :  
tradMillions = convertUptoThousand(millions)+ " Million ";  
}  
result =  result + tradMillions;  
String tradHundredThousands;  
switch (hundredThousands)   
{  
case 0:  
tradHundredThousands = "";  
break;  
case 1 :  
tradHundredThousands = "One Thousand ";  
break;  
default :  
tradHundredThousands = convertUptoThousand(hundredThousands)+ " Thousand ";  
}  
result =  result + tradHundredThousands;  
String tradThousand;  
tradThousand = convertUptoThousand(thousands);  
result =  result + tradThousand;  
//removing extra space if any  
return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");  
}  
//main() method  
public static void main(String args[])   
{  
//calling the user-defined method that converts the parsed number into words  
System.out.println(convertNumberToWord(2));  
System.out.println(convertNumberToWord(99));  
System.out.println(convertNumberToWord(456));  
System.out.println(convertNumberToWord(1101));  
System.out.println(convertNumberToWord(19812));  
System.out.println(convertNumberToWord(674319));  
System.out.println(convertNumberToWord(909087531));  
System.out.println(convertNumberToWord(1000000000));  
System.out.println(convertNumberToWord(359999999));  
System.out.println(convertNumberToWord(1213000000L));  
System.out.println(convertNumberToWord(1000000));  
System.out.println(convertNumberToWord(1111111111));  
System.out.println(convertNumberToWord(3000200));  
System.out.println(convertNumberToWord(700000));  
System.out.println(convertNumberToWord(9000000));  
}  
}
