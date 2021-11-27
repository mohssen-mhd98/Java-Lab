import java.io.*;
import java.io.File;

public class FileUtils {
    private String fileName;

    FileUtils(String fName){
        this.fileName = fName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void bufferWriter(String inputStr){
        try
        {
            // Open the FileWriter, Buffered Writer
            FileWriter fw = new
                    FileWriter("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);
            BufferedWriter WriteFileBuffer = new
                    BufferedWriter(fw);

            // Write Some Text to File
            // Using Buffered Writer)
            WriteFileBuffer.write(inputStr);
//            WriteFileBuffer.newLine();
//            WriteFileBuffer.write("Second Line");
//            WriteFileBuffer.newLine();
//            WriteFileBuffer.write("Third Line");
//            WriteFileBuffer.newLine();

            // Close both the Writers
            WriteFileBuffer.close();


        } catch (IOException Ex)
        {
            System.out.println(Ex.getMessage());
        }
    }

    public void bufferReaderAbbrv(){
        try
        {
            //Sample 04: Open the Readers Now
            FileReader fr = new
                    FileReader("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);
            BufferedReader bufferedReader = new
                    BufferedReader(fr);

            // Read the text Written
            System.out.println(bufferedReader.readLine() + " ...");
            // Close the Readers
            bufferedReader.close();


        } catch (IOException Ex)
        {
            System.out.println(Ex.getMessage());
        }
    }

    public void bufferReader(){
        try
        {
            //Sample 04: Open the Readers Now
            FileReader fr = new
                    FileReader("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);
            BufferedReader bufferedReader = new
                    BufferedReader(fr);

            // Read the text Written
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Display the file's contents on the screen, one line at a time
            }
            // Close the Readers
            bufferedReader.close();


        } catch (IOException Ex)
        {
            System.out.println(Ex.getMessage());
        }
    }

    public void writeStream(String inputStr){
        try{
            System.out.println("Writing by outPutStream: ");
            FileOutputStream fout=new FileOutputStream("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);
            byte[] byteData=inputStr.getBytes();//converting string into byte array
            fout.write(byteData);
            fout.close();
        }catch(Exception e){System.out.println(e);}
    }

    public void readStream(){
        try{
            System.out.println("Reading by InPutStream: ");
            FileInputStream fin=new FileInputStream("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);
            int i=0;
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
        }catch(Exception e){System.out.println(e);}
    }

    public void deleteFile(){
        File f= new File("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);
        if (f.delete())
            System.out.println("File " + this.fileName + "deleted successfully");
    }

    public void writeObject(Note note){
        try(FileOutputStream fs = new FileOutputStream("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);){
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(note);

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
//        catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
    }

    public Note readObject(){
        try(FileInputStream fi = new FileInputStream("D:\\documents\\java.exercises\\Lab7\\" + this.fileName);){
            ObjectInputStream is = new ObjectInputStream(fi);
            Note note = (Note) is.readObject();
            return note;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return new Note("", "", "");
    }
}
