package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String , HashSet<Vote>> polls;

    /**
     * constructor
     * @param type type of voting
     * @param question question of voting
     */
    public Voting(int type , String question){
        this.type=type;
        this.question=question;
        voters = new ArrayList<Person>();
        polls = new HashMap<String, HashSet<Vote>>();
    }

    /**
     * getter for question
     * @return question
     */
    public String getQuestion(){
        return "\"" + question + "\"";
    }

    /**
     * add a new option to poll
     * @param option new option
     */
    public void creatPoll(String option){
        HashSet<Vote> V = new HashSet<Vote>();
        polls.put(option ,V);
    }

    /**
     * Add a new vote
     * @param person person who wants to vote
     * @param date date of voting
     * @param chosenOptions options he/she wants to vote
     */
    public void vote(Person person, String date ,ArrayList<String> chosenOptions ){
        Vote v = new Vote(person , date);
        if(voters.contains(person)){
            System.out.println("you have already voted !");
            return;
        }
        // For type 0 polls
        if(this.type==0){
            if(chosenOptions.size()!=1){
                System.out.println("YOU HAVE CHOSEN MORE THAN 1 OPTION");
            }
            else {
                polls.get(chosenOptions.get(0)).add(v);
                voters.add(person);
                System.out.println("you voted successfully ");
            }
        }
        // For type 1 polls
        else {
            for (String s : polls.keySet()) {
                if(chosenOptions.contains(s)){
                    polls.get(s).add(v);

                }
            }
            System.out.println("you voted successfully ");
            voters.add(person);
        }
    }

    /**
     * getter for voters
     * @return list of all voters
     */
    public ArrayList<Person> getVoters(){
        return voters;
    }

    /**
     * this is the same with printResult method. it prints all the votes for each option in a voting.
     */
    public void printVotes(){
        int i =1;
        int j =1;
        for (String op: polls.keySet()) {
            i=1;
            System.out.println("option "+j+" " + op + ':');
            for (Vote v : polls.get(op)) {
               System.out.println("voter" +i +" "+v.getPerson().getFirstName() + " "
                       + v.getPerson().getLastName() + " date of vote :  "+v.getCalendar().getYear()+" "
                       +v.getCalendar().getMonth()+" "+v.getCalendar().getDay()+" "+v.getCalendar().getDayOfWeekString());
               i++;
            }
            System.out.println();
            j++;
        }

    }

    /**
     *
     * @return polls
     */
    public HashMap<String , HashSet<Vote>> getPolls(){
        return polls;
    }

    /**
     * generate random vote for a person
     * @param person person who wants to vote
     * @param date date of voting
     */
    public void randomChoice (Person person , String date){
        if(voters.contains(person)){
            System.out.println("you have already voted!");
            return;
        }
        Vote v = new Vote(person , date);
        Random r = new Random();
        int rNumber = r.nextInt(polls.size());
        int i = 0;
        for (String s : polls.keySet()) {
            if(i==rNumber){
                polls.get(s).add(v);
                System.out.println("you randomly voted to "+ s);
                return ;
            }
            i++;
        }
    }

}
