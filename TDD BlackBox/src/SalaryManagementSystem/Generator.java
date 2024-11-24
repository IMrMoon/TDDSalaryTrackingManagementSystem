package SalaryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    private static List<String> usedIds = new ArrayList<>();
    private static List<String> usedEmails = new ArrayList<>();
    private static List<String> usedPhoneNumbers = new ArrayList<>();

    private static final String[] firstNames = {
            "John", "Emily", "Michael", "Sarah", "David",
            "Emma", "James", "Olivia", "Daniel", "Sophia",
            "Robert", "Ava", "William", "Mia", "Joseph",
            "Isabella", "Thomas", "Amelia", "Charles", "Abigail"
    };

    private static final String[] lastNames = {
            "Smith", "Johnson", "Brown", "Taylor", "Anderson",
            "Harris", "Clark", "Lewis", "Walker", "Hall",
            "Allen", "Young", "King", "Wright", "Scott",
            "Adams", "Mitchell", "Carter", "Turner", "Phillips"
    };

    private static final String[] addresses = {
            "123 Main St", "456 Elm St", "789 Maple Ave", "101 Pine Rd", "202 Oak St",
            "303 Cedar Ln", "404 Spruce St", "505 Birch Ave", "606 Walnut St", "707 Ash Rd",
            "808 Cherry St", "909 Chestnut Ln", "1010 Poplar Rd", "1111 Sycamore St", "1212 Palm St",
            "1313 Cypress Rd", "1414 Willow Ln", "1515 Magnolia St", "1616 Redwood Rd", "1717 Fir St"
    };

    private static final String[] cities = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose",
            "Austin", "Jacksonville", "Fort Worth", "Columbus", "Charlotte",
            "Indianapolis", "Seattle", "Denver", "Washington", "Boston"
    };

    private static final String[] emailDomains = {
            "@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com", "@live.com", "@protonmail.com"
    };

    private static final String[] prefixes = {"050", "052", "053", "054", "055", "058"};

    public static Worker[] workerGenerate(int number) {
        Worker[] workers = new Worker[number];
        Random rand = new Random();

        for (int i = 0; i < number; i++) {
            String firstName = firstNames[rand.nextInt(firstNames.length)];
            String lastName = lastNames[rand.nextInt(lastNames.length)];
            String address = addresses[rand.nextInt(addresses.length)] + cities[rand.nextInt(cities.length)];
            String email = emailGenerate(firstName, lastName);
            String id = idGenerate();
            String phoneNum = phoneNumGenerate();
            int salary = salaryGenerate();
            Worker worker = new Worker(id, firstName, lastName, email, phoneNum, address, salary);
            workers[i] = worker;
        }
        return workers;
    }

    public static String emailGenerate(String firstName, String lastName) {
        Random rand = new Random();
        String email;
        do {
            email = firstName + lastName + rand.nextInt(100) + emailDomains[rand.nextInt(emailDomains.length)];
        }while (usedEmails.contains(email));
        usedEmails.add(email);
        return email;
    }

    public static String idGenerate(){
        Random rand = new Random();
        String generatedId;
        StringBuilder id = new StringBuilder();
        do {
            for (int i = 0; i < 10; i++) {
                int number = rand.nextInt(10);
                id.append(number);
            }
            generatedId = id.toString();
        }while(usedIds.contains(generatedId));
        usedIds.add(generatedId);
        return generatedId;
    }

    public static String phoneNumGenerate(){
        Random rand = new Random();
        StringBuilder phoneNum = new StringBuilder();
        String generatedPhoneNum;
        do {
            for (int i = 0; i < 7; i++) {
                int number = rand.nextInt(10);
                phoneNum.append(number);
            }
            generatedPhoneNum = prefixes[rand.nextInt(prefixes.length)] + phoneNum.toString();
        }while(usedPhoneNumbers.contains(generatedPhoneNum));
        usedPhoneNumbers.add(generatedPhoneNum);
        return generatedPhoneNum;
    }

    public static int salaryGenerate(){
        Random rand = new Random();
        return rand.nextInt(3000, 15000);
    }
}

