public class ArgsMain {
  public static void main(String[] args) {
    Args arg = new Args("l,p,d", args);
    boolean valid = arg.isValid();
    boolean logging = arg.getBoolean('l');
    if(valid){
      System.out.println("The argument format is valid");
    }else{
      System.out.println("The argument format is invalid");
    }

    System.out.println("logging is "+logging);
  }
}