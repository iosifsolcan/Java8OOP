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
    assertEquals(testPersonsDataList.get(0).getFirstName(), personsDataList.get(0).getFirstName());
    assertEquals(testPersonsDataList.get(0).getLastName(), personsDataList.get(0).getLastName());
    assertEquals(
        testPersonsDataList.get(0).getDateOfBirth(), personsDataList.get(0).getDateOfBirth());

    assertEquals(testPersonsDataList.get(1).getFirstName(), personsDataList.get(4).getFirstName());
    assertEquals(testPersonsDataList.get(1).getLastName(), personsDataList.get(4).getLastName());
    assertEquals(
        testPersonsDataList.get(1).getDateOfBirth(), personsDataList.get(4).getDateOfBirth());
  }
}
