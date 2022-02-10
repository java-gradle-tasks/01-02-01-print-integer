   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.*;

   public class MyResultResult {

      @Test
      public void test() {
         String newLine="";
         if (System.getProperty("os.name").startsWith("Windows")) {
            newLine="\r\n";
         } else {
            newLine="\n";
         }

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(byteArrayOutputStream);
         PrintStream stdout = System.out;
         System.setOut(ps);

         MyResult.main(new String[0]);

         System.setOut(stdout);

         String expected="A havi eredmeny 1000 forint."+newLine;
         String actual=byteArrayOutputStream.toString();

         int result=expected.compareTo(actual);

         Assertions.assertEquals(result,0,"A program kimenete nem megfelelo!");
      }
   }
