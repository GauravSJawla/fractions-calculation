
# fractions-calculation
### Problem Statement:
Write a command-line program in the language of your choice that will take operations on fractions as an input and produce a fractional result.
Constrains:
- Legal operators shall be *, /, +, - (multiply, divide, add, subtract)
- Operands and operators shall be separated by one or more spaces.
- Mixed numbers will be represented by whole_numerator/denominator. e.g."3_1/4"
- Improper fractions and whole numbers are also allowed as operands
- Example run:  
> ? 1/2 * 3_3/4  
> = 1_7/8  
> ? 2_3/8 + 9/8  
> = 3_1/2

#### Input Assumptions:
Note: Currently added check for input to start with "?". Ideally we would have regex for valid input check.
> Input will start with "?", one whitespace, first fraction/whole number, one whitespace, one of the four operand(+,-,*,/), white space and second fraction/whole number.

### Requirements/Installations:

1. Java version 8+ (JDK 1.8) [link](https://www.oracle.com/java/technologies/downloads/)
2. Maven 3.3+ [link](https://maven.apache.org/download.cgi)

### How to setup(and run) project in IntelliJ IDEA CE:

1. Clone the project locally via IntelliJ.
2. Open terminal and run command:

        mvn clean install

3. Right click on src > main > java > Main and select "Run main.Main()" (Green Play button).

### Run unit tests:
Open terminal and run command:

    mvn test
