/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package northsussexjudoprogram;
import java.util.Scanner;

public class NorthSussexJudoProgram {
    //Additional Informatiion Method
    public static void AdditionalInoformatin(){
        System.out.println("\n               Additional Information              \n");
        System.out.println("====================================================");
        System.out.println("|              Training Plan - Prices              |");
        System.out.println("====================================================");
        System.out.println("| Beginner (2 sessions/week)              | £25.00 |");
        System.out.println("| Intermediate (3 sessions/week)          | £30.00 |");
        System.out.println("| Elite (5 sessions/week)                 | £35.00 |");
        System.out.println("| Private tuition (per hour)              | £9.50  |");
        System.out.println("| Competition entry fee (per competition) | £22.00 |");
        System.out.println("====================================================\n");

        System.out.println("===========================================================");
        System.out.println("| Weight Categories             | Upper Weight Limit (kg) |");
        System.out.println("===========================================================");
        System.out.println("| Heavyweight                   | Unlimited (Over 100)    |");
        System.out.println("| Light-Heavyweight             | 100                     |");
        System.out.println("| Middleweight                  | 90                      |");
        System.out.println("| Light-Middleweight            | 81                      |");
        System.out.println("| Lightweight                   | 73                      |");
        System.out.println("| Flyweight                     | 66                      |");
        System.out.println("===========================================================\n");
    }
    
    //Calculator Method
    public static void NorthSussexJudoProgramCostCalc(int numberOfAthletes){
        Scanner input = new Scanner(System.in);

        int maxPrivateCoachingHours = 5;
        double beginnerWeeklyFee = 25.00;
        double intermediateWeeklyFee = 30.00;
        double eliteWeeklyFee = 35.00;
        double privatetuitionHourlyRate = 9.50;
        double competitionEntryFee = 22.00;

        

        for (int i = 1; i <= numberOfAthletes; i++) {

            //Calling Method Additional informations Details
            AdditionalInoformatin();

            System.out.println("\nAthlete No: " + i);

            // Input athlete information
            System.out.print("Enter the athlete's Name: ");
            String athleteName = input.next();
            System.out.print("Enter the training plan (Beginner (0) /Intermediate (1) /Elite (2)): ");
            String trainingPlan = input.next();
            System.out.print("Enter The current weight (kg): ");
            double currentWeight = input.nextDouble();
            double competitionWeightCategory;
            int numCompetitions=0;

            if (trainingPlan.equals("Beginner")|| trainingPlan.equals("0")){
                System.out.println("You don't have compitition untill your a Intermediate or Elite");
                competitionWeightCategory=66;
            }else{
                System.out.print("Enter competition weight category: ");
                competitionWeightCategory = input.nextDouble();
                System.out.print("Enter number of competitions entered this month: ");
                numCompetitions = input.nextInt(); 
            }

            switch(trainingPlan){
                case "0":
                    trainingPlan="Beginner";
                    break;
                case "1":
                    trainingPlan="Intermediate";
                    break;
                case "2":
                    trainingPlan="Elite";
                    break;
            }

            System.out.print("Enter number of hours of private coaching (Under Five): ");
            int numPrivateCoachingHours = input.nextInt();

            if(numPrivateCoachingHours>maxPrivateCoachingHours){
                System.out.println("You can receive a maximum of Five Hours' privete coaching a week");
                System.out.print("Please enter Under Five Hours : ");
                numPrivateCoachingHours = input.nextInt();

            }

            // Calculate training fees
            double trainingFee = 0.00;
            switch (trainingPlan) {
                case "Beginner":
                    trainingFee = beginnerWeeklyFee * 4; // 4 weeks in a month
                    break;
                case "Intermediate":
                    trainingFee = intermediateWeeklyFee * 4; // 4 weeks in a month
                    break;
                case "Elite":
                    trainingFee = eliteWeeklyFee * 4; // 4 weeks in a month
                    break;
                default:
                    System.out.println("Invalid training plan.");
            }

            // Calculate competition fees (only for Intermediate and Elite athletes)
            double competitionFee = 0.0;
            if (trainingPlan.equals("Intermediate") || trainingPlan.equals("1")||trainingPlan.equals("2") || trainingPlan.equals("Elite")) {
                competitionFee = numCompetitions * competitionEntryFee;
            }

            //Calculate the Private Coaching Fee
            double privateCoachingFee = numPrivateCoachingHours * privatetuitionHourlyRate;


            // Calculate total cost
            double totalCost = trainingFee + privateCoachingFee + competitionFee;

            // Compare current weight to competition weight category
            String weightComparison;
            if (currentWeight <= competitionWeightCategory) {
                weightComparison = "Meets Category";
                //It basically indicates that the athlete is qualified to compete in that category 
                //because their weight is within the permitted range for that competition.
            } else {
                weightComparison = "Above Category";
                //The athlete would not be permitted to compete in that competition category 
                //because their weight exceeds the upper limit for that category.
            }

            // Display athlete's information and costs
            System.out.println("\nAthlete: " + athleteName);
            System.out.println("Training Plan: " + trainingPlan);
            System.out.println("Total Training Fee For Month: £" + trainingFee);
            System.out.println("Total Private Coaching Fee: £" + privateCoachingFee);
            System.out.println("Total Competition Fee: £" + String.format("%.2f", competitionFee));
            System.out.println("Total Cost for the Month: £" + String.format("%.2f", totalCost));
            System.out.println("Weight Comparison: " + weightComparison);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n====================================================");
        System.out.println("|   North Sussex Judo Training Cost Calculator     |");
        System.out.println("====================================================");

        System.out.println("\nWelcome to North Sussex Judo Training Cost Calculator\n");

        System.out.print("How many athletes do you enter: ");
        int numberOfAthletes = input.nextInt();

        NorthSussexJudoProgramCostCalc(numberOfAthletes);

        System.out.print("\nDo you need to Add more Athelets (y/n): ");
        String addMore=input.next();

        while(addMore.equals("y")){
            System.out.print("\nHow many athletes do you enter: ");
            numberOfAthletes = input.nextInt();
            NorthSussexJudoProgramCostCalc(numberOfAthletes);
            System.out.print("\nDo you need to Add more Athelets y/n");
            addMore=input.next();
        }
        input.close();
    }
    
}
