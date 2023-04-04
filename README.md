Schema:
* `char` - Boolean arg.
* `char*` - String arg.
* `char#` - Integer arg.

Example schema: `l,d*,n#`
Coresponding command line: `-l -d tmp -n 1`

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