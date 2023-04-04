import java.text.ParseException;

public class ArgsMain {
  public static void main(String[] args) {
    try{
      Args arg = new Args("l,d*", args);
      boolean valid = arg.isValid();
      boolean logging = arg.getBoolean('l');
      String directory = arg.getString('d');
      if(valid){
        System.out.println("The argument format is valid");
      }else{
        System.out.println("The argument format is invalid");
      }

      System.out.println("logging is "+logging);
      System.out.println("directory is "+directory);
    } catch (ParseException e) {
      System.out.printf("Argument error: %s\n", e.getMessage());
    }


  }
}