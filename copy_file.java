import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class copy_file {
    
   public static void main(String[] args) throws FileNotFoundException {

       Scanner scan = new Scanner(System.in);
       System.out.println("What is the file to read from?");
       String input = scan.next();
       File file = new File(input);
       if (file.exists()) {

           System.out.println("What is the file to write to?");
           String output = scan.next();
           File outputfile = new File(output);

           while (outputfile.exists()){

               System.out.println("That file already exists, do you want to over write it? (y)");
               char ch = scan.next().charAt(0);

               if (ch != 'y' && ch != 'Y'){

                   System.out.println("What is the file to write to?");
                   output = scan.next();
                   outputfile = new File(output);

               }else {

                   outputfile = new File(output);
                   break;

               }

           }

           Scanner scan1= new Scanner(file);
           PrintWriter pw = new PrintWriter(outputfile);
           while(scan1.hasNextLine()){

               pw.println(scan1.nextLine());

           }
           pw.flush();
           pw.close();
           scan1.close();
           scan.close();
           System.out.println("File processing completed.");
          
       } else {

           System.out.println("Sorry, can not read from the file " + input);

       }

   }

}



