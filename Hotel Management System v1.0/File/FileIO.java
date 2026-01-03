package File;
import Entity.*;
import java.io.*;
import java.util.*;

public class FileIO{
    public static String loadFile(){

        String content="";

        try{
            File file=new File("./File/Greetings.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){
                content +=sc.nextLine()+"\n";
            }
            sc.close();
        }
        catch(Exception e){
            content ="Welcome to Hotel Management System\n";
        }
        return content;
    }
}
