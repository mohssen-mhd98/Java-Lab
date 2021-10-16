import java.util.ArrayList;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {


        //ArrayList<MusicCollection> categories = new ArrayList<>();
        String[] categoryNames = new String[]{"pop", "jazz", "rock", "country"};
        MusicCollection[] categories = new MusicCollection[5];

        int i = 0;
        for (String cn : categoryNames) {
            if (i!=4){
                categories[i] = new MusicCollection(cn);
                i++;
            }
        }

        categories[0].addFile(new Music("a/b/c", "Ali", 2016));
        categories[0].addFile(new Music("a/d/v", "Queen", 2019));
        categories[0].addFile(new Music("a/e", "Ehsan", 2021));

        //categories[0].listAllFiles();

        categories[1].addFile(new Music("a/d", "Michele", 2010));
        categories[1].addFile(new Music("a/d/d", "Sara", 2018));

        categories[3].addFile(new Music("b/f", "WhiteBufallo", 2021));
        categories[3].addFile(new Music("c/e", "WhiteBufallo", 2009));

        categories[4] = new MusicCollection("favorites");
        categories[4].addFile(new Music("b/f", "WhiteBufallo", 2021));
        categories[4].addFile(new Music("c/e", "WhiteBufallo", 2019));

        categories[4].removeFile(1);


        System.out.print(ANSI_RED + "\nList of all files: \n" + ANSI_RESET);
        for (MusicCollection mc: categories){
            System.out.println(mc.getName() + ":");
            mc.listAllFiles();
            System.out.println("*=======================================*");
        }

        categories[1].searchMusic("Sara");
    }
}
