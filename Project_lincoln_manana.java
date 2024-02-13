public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double heightInches;
    private double weightPounds;

    // No-arg constructor
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "";
        this.heightInches = 0.0;
        this.weightPounds = 0.0;
    }

    // Constructor with arguments
    public Policy(String policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double heightInches, double weightPounds) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
    }

    // Getters and setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(double heightInches) {
        this.heightInches = heightInches;
    }

    public double getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(double weightPounds) {
        this.weightPounds = weightPounds;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        return (weightPounds * 703) / (heightInches * heightInches);
    }

    // Method to calculate policy price
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;
        if (age > 50) {
            additionalFee += 75.0;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            additionalFee += 100.0;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }
        return baseFee + additionalFee;
    }
}

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the Policy Number:");
        String policyNumber = scanner.nextLine();

        System.out.println("Please enter the Provider Name:");
        String providerName = scanner.nextLine();

        System.out.println("Please enter the Policyholder’s First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Please enter the Policyholder’s Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Please enter the Policyholder’s Age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Please enter the Policyholder’s Smoking Status (smoker/non-smoker):");
        String smokingStatus = scanner.nextLine();

        System.out.println("Please enter the Policyholder’s Height (in inches):");
        double height = scanner.nextDouble();

        System.out.println("Please enter the Policyholder’s Weight (in pounds):");
        double weight = scanner.nextDouble();

        // Create Policy object
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                age, smokingStatus, height, weight);

        // Display policy information
        System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getLastName());
        System.out.println("Policyholder’s Age: " + policy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder’s Height: " + policy.getHeightInches() + " inches");
        System.out.println("Policyholder’s Weight: " + policy.getWeightPounds() + " pounds");
        System.out.printf("Policyholder’s BMI: %.2f\n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());
        
        scanner.close();
    }
}