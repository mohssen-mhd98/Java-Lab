import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        //System.out.println("ksdk");
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        ArrayList<FileUtils> files = new ArrayList<FileUtils>();

        System.out.println("-----------------------------Notes----------------------------------");
        ArrayList<Note> notes = new ArrayList<Note>();
        String fName1 = "";
        while (true){
            System.out.println("Enter file name for notes:");
            fName1 = sc.nextLine();

            if (fName1.equals("none"))
                break;

            System.out.println("Enter Title:");
            String title = sc.nextLine();

            System.out.println("Enter Date:");
            String date = sc.nextLine();

            FileUtils file = new FileUtils(fName1);
            files.add(file);
            String a = "";
            String s = "";
            System.out.println("Enter Content:");
            while (true){
                s = sc.nextLine();
                if(s.equals("exit"))
                    break;
                a += s + "\n";
            }

            Note note = new Note(title, date, a);
            notes.add(note);
            file.writeObject(note);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Files Overview:\n");
        for (FileUtils f : files){
            String fileName = f.getFileName();
            System.out.println(fileName);
            Note n = f.readObject();
            System.out.println(n.getTitle() + ", " + n.getDate());
            System.out.println(n.getContent().split("\n")[0] + "...");
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Reading file1:");
        files.get(0).readObject();

        System.out.println("---------------------------------------------------------------");
        System.out.println("Deleting file1:");
        files.get(0).deleteFile();
        files.remove(0);
        System.out.println("---------------------------------------------------------------");

        System.out.println("Files Overview2:\n");
        for (FileUtils f : files){
            String fileName = f.getFileName();
            System.out.println(fileName);
            if (files.size() !=0){
                Note n = f.readObject();
                System.out.println(n.getTitle() + ", " + n.getDate());
                System.out.println(n.getContent().split("\n")[0]);
            }
        }
    }





}
