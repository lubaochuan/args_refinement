The arguments passed to the program consist of flags and values.
Flags should be one character, preceded by a minus sign. Each
flag should have zero, or one value associated with it.

You should write a parser for this kind of arguments. This parser
takes a schema detailing what arguments the program expects.
The schema specifies the number and types of flags and values
the program expects. For example, the schema `l,p#,d*` defines three
command-line arguments: `–l` is a Boolean argument, `-p` is an integer
argument, and `-d` is a string argument.

Once the schema has been specified, the program should pass
the actual argument list to the args parser. It will verify that
the arguments match the schema. The program can then ask the args
parser for each of the values, using the names of the flags.
The values are returned with the correct types, as specified in the schema.

For example, if the program is to be called with these arguments:
```
-l -p 8080 -d /usr/logs
```
this indicates a schema with 3 flags: `l`, `p`, `d`. The `l` (logging) flag
has no values associated with it, it is a boolean flag, `true` if present,
`false` if not. the `p` (port) flag has an integer value, and the `d`
(directory) flag has a string value.

If a flag mentioned in the schema is missing in the arguments, a suitable
default value should be returned. For example `false` for a boolean, `0` for
a number, and `""` for a string. If the arguments given do not match the schema,
it is important that a good error message is given, explaining exactly what
is wrong.

Here is an example use case:
```java
public class ArgsMain {
  public static void main(String[] args) {
    try {
      Args arg = new Args("l,p#,d*", args);
      boolean logging = arg.getBoolean('l');
      int port = arg.getInt('p');
      String directory = arg.getString('d');
      executeApplication(logging, port, directory);
    } catch (ArgsException e) {
      System.out.printf("Argument error: %s\n", e.errorMessage());
    }
  }

  private static void executeApplication(boolean logging, int port, String directory) {
    System.out.printf("logging is %s, port:%d, directory:%s\n",logging, port, directory);
  }
}
```
If you are feeling ambitious, extend your code to support lists, eg.
```
-g this,is,a,list -d 1,2,-3,5
```

So the `g` flag indicates a list of strings, `["this", "is", "a", "list"]` and
the `d` flag indicates a list of integers, `[1, 2, -3, 5]`.

Make sure your code is extensible, in that it is straightforward and obvious
how to add new types of values.

Schema:
* `char` - Boolean arg.
* `char*` - String arg.
* `char#` - Integer arg.
* `char##` - Double arg.
* `char[*]` - one element of a string array.

Example schema: `f,s*,n#,a##,p[*]`
Coresponding command line: `-f -s Bob -n 1 -a 3.2 -p e1 -p e2 -p e3`

Simple tests for the "Boolean and String" version of Args:
```
% javac ArgsMain.java
% java ArgsMain -l -d tmp
The argument format is valid
logging is true
directory is tmp
```

To compile test:
```
javac -cp .:junit-platform-console-standalone-1.9.0.jar ArgsTest.java
```

To run test:
```
java -jar junit-platform-console-standalone-1.9.0.jar --class-path . --select-class ArgsTest
```

## Suggested Test Cases
* make sure you have a test with a negative integer (confusing `-` sign)
* the order of the arguments need not match the order given in the schema.
* have some tests that suitable default values are correctly assigned if flags
given in the schema are missing in the args given.

Sources:
* https://codingdojo.org/kata/Args/
* http://www.jamesshore.com/downloads/Clean_Code_Args.pdf
* https://github.com/unclebob/javaargs
* https://www.freecodecamp.org/news/clean-coding-for-beginners/
* https://gleichmann.wordpress.com/2008/12/03/refining-uncle-bobs-clean-code/
