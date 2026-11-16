import org.example.PersonsData.PersonsData;
import org.example.ReadFromFile.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingReadFromFile {
  private List<PersonsData> personsDataList;
  private List<PersonsData> testPersonsDataList = new ArrayList<>();
  private ReadFromFile reader = new ReadFromFile();
  private final String inputFile = "src/main/resources/personsData.csv";

  @Test
  public void testingReadFromFile() {

    PersonsData firstPerson = new PersonsData();
    firstPerson.setFirstName("Mihai");
    firstPerson.setLastName("Sima");
    firstPerson.setDateOfBirth(LocalDate.of(1994, 03, 11));
    testPersonsDataList.add(firstPerson);

    PersonsData lastPerson = new PersonsData();
    lastPerson.setFirstName("Andreea");
    lastPerson.setLastName("Coman");
    lastPerson.setDateOfBirth(LocalDate.of(2003, 03, 23));
    testPersonsDataList.add(lastPerson);

    personsDataList = reader.readFromFile(inputFile);
    assertEquals(
        testPersonsDataList.getFirst().getFirstName(), personsDataList.getFirst().getFirstName());
    assertEquals(
        testPersonsDataList.getFirst().getLastName(), personsDataList.getFirst().getLastName());
    assertEquals(
        testPersonsDataList.getFirst().getDateOfBirth(),
        personsDataList.getFirst().getDateOfBirth());
    assertEquals(
        testPersonsDataList.getLast().getFirstName(), personsDataList.getLast().getFirstName());
    assertEquals(
        testPersonsDataList.getLast().getLastName(), personsDataList.getLast().getLastName());
    assertEquals(
        testPersonsDataList.getLast().getDateOfBirth(), personsDataList.getLast().getDateOfBirth());
  }
}
