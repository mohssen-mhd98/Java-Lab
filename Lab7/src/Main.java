import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //System.out.println("ksdk");
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        ArrayList<FileUtils> files = new ArrayList<FileUtils>();

        System.out.println("Enter File Method:");
        String saveFunction = sc.nextLine();

        String fName = "";
        while (true){
            System.out.println("Enter file name:");
            fName = sc.nextLine();
            if (fName.equals("none"))
                break;
            FileUtils file = new FileUtils(fName);
            files.add(file);
            String a = "";
            String s = "";
            System.out.println("Enter Text:");
            while (true){
                s = sc.nextLine();
                if(s.equals("exit"))
                    break;
                a += s + "\n";
            }
            if (saveFunction.equals("stream"))
                file.writeStream(a);
            else file.bufferWriter(a);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Files Overview:\n");
        for (FileUtils f : files){
            String fileName = f.getFileName();
            System.out.println(fileName);
            if (saveFunction.equals("stream"))
                f.readStream();
            else f.bufferReaderAbbrv();
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Reading file1:");
        files.get(0).bufferReader();
        System.out.println("---------------------------------------------------------------");

        System.out.println("---------------------------------------------------------------");
        System.out.println("Deleting file1:");
        files.get(0).deleteFile();
        files.remove(0);
        System.out.println("---------------------------------------------------------------");


        System.out.println("Files Overview2:\n");
        for (FileUtils f : files){
            String fileName = f.getFileName();
            System.out.println(fileName);
            f.bufferReaderAbbrv();
        }


    }





}
