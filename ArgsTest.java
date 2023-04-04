import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;

public class ArgsTest {
  @Test
  public void testOneBooleanPresent() throws Exception {
    Args args = new Args("x", new String[]{"-x"});
    assertEquals(true, args.isValid());
    assertEquals(true, args.getBoolean('x'));
  }

  @Test
  public void testTwoBooleanPresent() throws Exception {
    Args args = new Args("x,y", new String[]{"-x", "-y"});
    assertEquals(true, args.isValid());
    assertEquals(true, args.getBoolean('x'));
    assertEquals(true, args.getBoolean('y'));
  }

  @Test
  public void testOneStringPresent() throws Exception {
    Args args = new Args("x*", new String[]{"-x", "hello"});
    assertEquals(true, args.isValid());
    assertEquals("hello", args.getString('x'));
  }


  @Test
  public void testWithNoSchemaButWithMultipleArguments() throws Exception {
    Args args = new Args("x,y", new String[]{"-x", "-y"});
    assertEquals(false, args.getBoolean('z'));
  }
}
