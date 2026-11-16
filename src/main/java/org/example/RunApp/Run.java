package org.example.RunApp;

import lombok.Data;
import org.example.PersonsData.PersonsData;
import org.example.ReadFromFile.ReadFromFile;

import java.time.Month;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Data
public class Run {
  private static final Logger log = Logger.getLogger(Run.class.getName());
  private final ReadFromFile reader = new ReadFromFile();
  private final PersonsData personsData = new PersonsData();
  private int month;
  private Scanner scanner = new Scanner(System.in);
  private String[] parameters = new String[3];
  private String inputFile;
  private String outputFile;
  private List<PersonsData> list;

  public void runApp() {

    this.inputFile = "src/main/resources/personsData.csv";
    parameters[0] = inputFile;

    System.out.println("Enter the month(1-12):");
    month = scanner.nextInt();
    scanner.nextLine();
    parameters[1] = String.valueOf(month);

    this.outputFile = "src/main/resources/personsDataOut.txt";
    parameters[2] = outputFile;

    if (Integer.parseInt(parameters[1]) >= 1 && Integer.parseInt(parameters[1]) <= 12) {
      Month month1 = Month.of(Integer.parseInt(parameters[1]));
      list=reader.readFromFile(parameters[0]);
      personsData.makeOutputFile(parameters[0], month1, parameters[2],list);
    } else log.warning("The month is incorrect! Try again!");
  }
}
