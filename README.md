# mars-rovers

mvn spring-boot:run -Dspring-boot.run.arguments="firstArgument,secondArgument"

firstArgument:
1: read from file
2: read from console
3: read from API (to be done)

secondArgument: only valid for option 1, should be the name of the input file with full pathname.

Example:
mvn spring-boot:run -Dspring-boot.run.arguments="1,"/home/user/inputFileTest.txt"
