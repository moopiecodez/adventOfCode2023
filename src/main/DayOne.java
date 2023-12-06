package main; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class DayOne {

    public static void main(String [] args) {
        
        String sample = "resources/sampleInput.txt";
        String input = "resources/puzzle1Input.txt";
        System.out.println("hello bob");
        ArrayList<String> test = new ArrayList<String>();
        int calibrationValue = 0;
        test = getLines(input);
        //test.forEach(e -> {System.out.println(e); });
        for (String s : test) {
            calibrationValue += getNums(s);
        }
        System.out.println(calibrationValue);
    }

    public static ArrayList<String> getLines(String input) {
        FileReader reader = null;

        try {
            reader = new FileReader(input);            
        } catch (FileNotFoundException exception) {
            System.out.println("Error processing input: " + exception);
        }
        
        BufferedReader buff = new BufferedReader(reader);
        String calibrationValue = "";
        ArrayList<String> values = new ArrayList<String>();

        try {
            while ((calibrationValue = buff.readLine()) != null) {
                //smarter way to avoid reading empty line at end?
                if (!calibrationValue.isEmpty()) {
                    values.add(calibrationValue);
                }
            }
            buff.close();
        } catch (IOException exception) {
            System.out.println("Error processing input: " + exception);
        }

        return values;
    }

    //trying to make this method return the end value
    
    public static int getNums(String input) {
        int x = 0;
        //creates an array of strings containing the digits
        ArrayList<String> nums = new ArrayList<String>();
        // check why you need second \ - is it to escape string?
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(input);
        while(m.find()) {
            nums.add((m.group()));
        }
        //System.out.println(nums);
        //for each line in the array convert it to the required two digit number
        //System.out.println(nums);
        x += getValue(nums);
        return x;
    }

    public static int getValue(ArrayList<String> nums) {
        String s = "";
        String a;
        String b;
        int value;
        int length = nums.size();
        //System.out.println(nums);
        a = nums.get(0);
        b = nums.get(length - 1);
        s = "" + a + b;
        value = Integer.parseInt(s);
        return value;
    }
}
