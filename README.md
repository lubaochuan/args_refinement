Simple tests for the "Boolean only" version of Args:
```
% javac ArgsMain.java
% java ArgsMain -l
The argument format is valid
logging is true
% java ArgsMain -h
The argument format is invalid
logging is false
```