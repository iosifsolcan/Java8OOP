package org.example.SortList;

import org.example.PersonsData.PersonsData;

import java.util.Comparator;
import java.util.List;

public class SortList {

  public List<PersonsData> sortList(List<PersonsData> list) {
    list.sort(
        Comparator.comparing(PersonsData::getFirstName).thenComparing(PersonsData::getLastName));
    return list;
  }
}
