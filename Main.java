Даний код демонструє основні операції з обробки даних в Java. Він зчитує дані з файлу, виконує просту обробку даних та записує результати назад в файл.

```java
import java.io.*;
import java.util.*;

public class BasicDataProcessing {

  public static void main(String[] args) {
    ArrayList<String> data = readDataFromFile("input.txt");
    ArrayList<String> processedData = processData(data);
    writeDataToFile("output.txt", processedData);
  }

  public static ArrayList<String> readDataFromFile(String filename) {
    ArrayList<String> data = new ArrayList<String>();
    try {
      File file = new File(filename);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        data.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occured.");
      e.printStackTrace();
    }
    return data;
  }

  public static ArrayList<String> processData(ArrayList<String> data) {
    ArrayList<String> processedData = new ArrayList<String>();
    for (String line : data) {
      String[] tokens = line.split(", ");
      // perform some basic data processing
      String processedLine = tokens[0] + " has " + tokens.length + " tokens.";
      processedData.add(processedLine);
    }
    return processedData;
  }

  public static void writeDataToFile(String filename, ArrayList<String> data) {
    try {
      FileWriter writer = new FileWriter(filename);
      for (String line : data) {
        writer.write(line + "\n");
      }
      writer.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
```
Цей код складається з трьох основних функцій: `readDataFromFile`, `processData` та `writeDataToFile`. Функція `readDataFromFile` зчитує дані з файлу та повертає їх у вигляді списку рядків. Функція `processData` обробляє ці рядки, розділяючи їх на токени і створюючи новий рядок з кількості токенів. Функція `writeDataToFile` записує оброблені дані назад у файл.