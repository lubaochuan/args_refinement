Schema:
* `char` - Boolean arg.
* `char*` - String arg.

Example schema: `l,d*`
Coresponding command line: `-l -d tmp`

Simple tests for the "Boolean and String" version of Args:
```
% javac ArgsMain.java
% java ArgsMain -l -d tmp
The argument format is valid
logging is true
directory is tmp
```