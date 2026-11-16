package org.example.PersonsData;

import lombok.Data;
import org.example.ReadFromFile.ReadFromFile;
import org.example.RunApp.Run;
import org.example.SortList.SortList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Data
public class PersonsData implements Comparator<PersonsData> {
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private List<PersonsData> personsDataList;
  private static final Logger log = Logger.getLogger(PersonsData.class.getName());
  private int numberOfPersonsWithXMonth;
  private ReadFromFile read = new ReadFromFile();
  private String outputFileName;
  private String inputFileName;

  public List<PersonsData> makeOutputFile(
      String inputFile, Month month, String outputFile, List<PersonsData> personsDataList1) {
    numberOfPersonsWithXMonth = 0;
    this.inputFileName = inputFile;
    personsDataList = personsDataList1;
    this.outputFileName = outputFile;
    SortList list = new SortList();
    personsDataList = list.sortList(personsDataList);
    for (int i = 0; i < personsDataList.size(); i++) {
      if (personsDataList.get(i).getDateOfBirth().getMonth() == month) numberOfPersonsWithXMonth++;
    }
    if (numberOfPersonsWithXMonth > 0) {
      System.out.println(
          numberOfPersonsWithXMonth + " persons were born in the month you entered!");
      log.info("Check the outputFile and see the persons ordered alphabetically!!");
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
        writer.write("firstName" + " ,lastName");
        writer.newLine();
        personsDataList.stream()
            .filter(personsData -> personsData.getDateOfBirth().getMonth().equals(month))
            .forEach(
                personsData -> {
                  try {
                    writer.newLine();
                    writer.write(personsData.getFirstName() + " ," + personsData.getLastName());
                    writer.newLine();
                  } catch (IOException e) {
                    System.out.println(e.getMessage());
                    log.info("some informations is missing!");
                  }
                });
      } catch (IOException e) {
        System.out.println(e.getMessage());
        log.warning("something went wrong!");
      }
    } else log.info("No one matches this month!");

    return personsDataList;
  }

  @Override
  public int compare(PersonsData o1, PersonsData o2) {
    return Comparator.comparing(PersonsData::getFirstName)
        .thenComparing(PersonsData::getLastName)
        .compare(o1, o2);
  }
}
