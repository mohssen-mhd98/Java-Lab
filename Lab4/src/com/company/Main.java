package com.company;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test of VotingSystem project.
 */
public class Main {

    public static void main(String[] args) {

        VotingSystem vSystem = new VotingSystem();

        // Adding new voting and polls to my voting system
        vSystem.creatVoting("which one is your favorite actor ?",0);
        vSystem.votingList.get(0).creatPoll("Johnny Depp");
        vSystem.votingList.get(0).creatPoll("Winona Ryder");
        vSystem.votingList.get(0).creatPoll("Meryl Streep");
        vSystem.votingList.get(0).creatPoll("Matthew McConaughey");
        vSystem.votingList.get(0).creatPoll("Leonardo Dicaprio");
        
        vSystem.creatVoting("which one is your favourite movie?",1);
        vSystem.votingList.get(1).creatPoll("Lala Land");
        vSystem.votingList.get(1).creatPoll("Dune");
        vSystem.votingList.get(1).creatPoll("Shame");
        vSystem.votingList.get(1).creatPoll("Harry Potter");
        vSystem.votingList.get(1).creatPoll("Jojo rabbit");

        // Initializing persons
        Person p1 = new Person("Mohsen" ,"Mohammadian");
        Person p2 = new Person("Arshia" , "Rahimi");
        Person p3 = new Person("Niusha" ,"Mehranshad");
        Person p4 = new Person("Ali" , "Haye-shad");
        
        // Initializing array list of each persons option for poll 1
        ArrayList<String> p11 = new ArrayList<>(Arrays.asList("Johnny Depp"));
        ArrayList<String> p12 = new ArrayList<>(Arrays.asList("Winona Ryder"));
        ArrayList<String> p13 = new ArrayList<>(Arrays.asList("Johnny Depp","Matthew McConaughey"));
        ArrayList<String> p14 = new ArrayList<>(Arrays.asList("Leonardo Dicaprio"));
        
        // Initializing array list of each persons option for poll 2
        ArrayList<String> p21 = new ArrayList<>(Arrays.asList("Lala Land" ,"Shame"));
        ArrayList<String> p22 = new ArrayList<>(Arrays.asList("Lala Land" ,"Jojo rabbit","Harry Potter"));
        ArrayList<String> p23 = new ArrayList<>(Arrays.asList("Lala Land" ,"Harry Potter"));
        ArrayList<String> p24 = new ArrayList<>(Arrays.asList("Dune"));

        vSystem.printVoting(1);
        System.out.println("--------------------------------------------------------");
        vSystem.printVoting(2);
        System.out.println("\n--------------------------------------------------------");

        // Voting for voting 1
        System.out.println("Testing system by voting number 1:");
        vSystem.vote(1,p1 , "1398/3/10",p11);
        vSystem.vote(1,p2 , "1398/3/11",p12);

        // Multiple choice for this poll not allowed.
        vSystem.vote(1,p3 , "1399/03/23",p13);
        vSystem.vote(1,p4 , "1399/03/15",p14);
        System.out.println("--------------------------------------------------------");

        // Duplicate vote problem
        vSystem.vote(1,p1 , "1399/03/10",p14);

        // Random vote example
        vSystem.votingList.get(0).randomChoice(p3,"1399/08/05");

        // Poll 1 result.
        System.out.println("Results for poll 1 is:");
        vSystem.printResult(1);
        System.out.println("--------------------------------------------------------");

        System.out.println("--------------------------------------------------------");
        System.out.println("Testing system by voting number 2:");

        // Voting for poll 2
        vSystem.vote(2,p1,"1400/06/04",p21);
        vSystem.vote(2,p2,"1399/12/05",p22);
        vSystem.vote(2,p3,"1400/06/06",p23);
        vSystem.vote(2,p4,"1400/06/09",p24);
        System.out.println("--------------------------------------------------------");

        // Poll 2 result
        System.out.println("Results for poll 2 is:");
        vSystem.printResult(2);

        System.out.println("--------------------------------------------------------");

        // Removing a poll
        vSystem.deleteVoting(1);
        System.out.println("Poll 2 deleted !!! \nNew list of polls is:");
        vSystem.printListOfVoting();

    }
}
