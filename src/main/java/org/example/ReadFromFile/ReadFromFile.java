package org.example.ReadFromFile;

import lombok.Data;
import org.example.PersonsData.PersonsData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Data
public class ReadFromFile {
  private String line;
  private String[] lineByParts;
  private final List<PersonsData> personsDataList = new ArrayList<>();
  private static final Logger log = Logger.getLogger(ReadFromFile.class.getName());
  private String inputFileName;

  public List<PersonsData> readFromFile(String inputFile) {
    this.inputFileName = inputFile;
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
      line = reader.readLine();
      while ((line = reader.readLine()) != null) {
        if (!line.isBlank()) {
          PersonsData personData = new PersonsData();
          lineByParts = line.split(",");
          personData.setFirstName(lineByParts[0]);
          personData.setLastName(lineByParts[1]);
          personData.setDateOfBirth(LocalDate.parse(lineByParts[2]));
          personsDataList.add(personData);
        }
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
      log.warning("something went wrong!");
    }

    return personsDataList;
  }
}
