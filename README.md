# Args Project

## Overview
This project is a command-line argument parser for Java applications. It allows developers to define a schema for expected arguments and parse command-line inputs accordingly. The parser supports multiple argument types, including boolean, string, integer and double arguments. 
<br>This implementation is based on an exercise from the book "Clean Code" by Robert C. Martin.

## Features
- **Boolean Arguments**: Flags that are either present (`true`) or absent (`false`).
- **String Arguments**: Arguments that accept a string value.
- **Integer Arguments**: Arguments that accept an integer value.
- **Double Arguments**: Arguments that accept a double value.
- **Error Handling**: Provides detailed error messages for unexpected arguments, missing values, or invalid formats.
- **Extensibility**: Uses a marshaler-based design to handle different argument types, making it easy to add support for new types.

## How It Works
1. **Schema Definition**: Define a schema string where each argument is represented by a character and its type:
   - `x` (boolean): No suffix.
   - `x*` (string): A `*` suffix.
   - `x#` (integer): A `#` suffix.
   - `x##` (double): A `##` suffix.
2. **Argument Parsing**: Pass the schema and command-line arguments to the `Args` class. The parser validates the input and extracts the values based on the schema.
3. **Accessing Values**: Use methods like `getBoolean(char)`, `getString(char)`, `getInt(char)`, and `getDouble(char)` to retrieve parsed values.

## Usage

### Example Code
```java
public class Main {
   public static void main(String[] args) {
      try {
         Args arg = new Args("l,p*,d#,x##", args);
         boolean logging = arg.getBoolean('l');
         String path = arg.getString('p');
         int delay = arg.getInt('d');
         double threshold = arg.getDouble('x');

         System.out.println("Logging: " + logging);
         System.out.println("Path: " + path);
         System.out.println("Delay: " + delay);
         System.out.println("Threshold: " + threshold);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
```
