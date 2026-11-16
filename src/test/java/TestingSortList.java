import org.example.PersonsData.PersonsData;
import org.example.ReadFromFile.ReadFromFile;
import org.example.SortList.SortList;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingSortList {
  PersonsData personsData = new PersonsData();
  private List<PersonsData> testingSortList = new ArrayList<>();
  private List<PersonsData> sortedList = new ArrayList<>();
  private SortList sortList = new SortList();
  private final String inputFile = "src/main/resources/personsData.csv";
  private final String outputFile = "src/main/resources/personsDataOut.txt";
  private List<PersonsData> list;
  private ReadFromFile read = new ReadFromFile();

  @Test
  public void testingSortList() {

    Month month1 = Month.of(3);
    list = read.readFromFile(inputFile);
    personsData.makeOutputFile(inputFile, month1, outputFile, list);

    PersonsData person = new PersonsData();
    person.setFirstName("Alex");
    person.setLastName("Mihailescu");
    sortedList.add(person);

    PersonsData person2 = new PersonsData();
    person2.setFirstName("Andreea");
    person2.setLastName("Coman");
    sortedList.add(person2);

    testingSortList = sortList.sortList(personsData.getPersonsDataList());
    assertEquals(sortedList.get(0).getFirstName(), testingSortList.get(0).getFirstName());
    assertEquals(sortedList.get(0).getLastName(), testingSortList.get(0).getLastName());
    assertEquals(sortedList.get(1).getFirstName(), testingSortList.get(2).getFirstName());
    assertEquals(sortedList.get(1).getLastName(), testingSortList.get(2).getLastName());
  }
}
