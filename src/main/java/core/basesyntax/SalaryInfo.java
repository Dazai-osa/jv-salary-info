package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class SalaryInfo {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        Map<String, Integer> salaryMap = new HashMap<>();
        for (String name : names) {
            int fullSalary = 0;
            LocalDate firstDate = LocalDate.parse(dateFrom, formatter).minusDays(1);
            LocalDate lustDate = LocalDate.parse(dateTo, formatter).plusDays(1);
            for (String start : data) {
                String[] parts = start.split(" ");
                LocalDate date = LocalDate.parse(parts[0], formatter);
                if (date.isAfter(firstDate) && date.isBefore(lustDate) && name.equals(parts[1])) {
                    int hours = Integer.parseInt(parts[2]);
                    int perHours = Integer.parseInt(parts[3]);
                    fullSalary += hours * perHours;
                }
            }
            salaryMap.put(name, fullSalary);
        }
        return salaryMap.toString();
    }
}
