package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringBuilder salaryReport = new StringBuilder("Report for period "
                + dateFrom + " - " + dateTo + System.lineSeparator());
        LocalDate firstDate = LocalDate.parse(dateFrom, formatter);
        LocalDate lastDate = LocalDate.parse(dateTo, formatter);
        for (String name : names) {
            int fullSalary = 0;
            for (String start : data) {
                String[] parts = start.split(" ");
                LocalDate date = LocalDate.parse(parts[0], formatter);
                if (!date.isBefore(firstDate) && !date.isAfter(lastDate) && name.equals(parts[1])) {
                    int hours = Integer.parseInt(parts[2]);
                    int perHours = Integer.parseInt(parts[3]);
                    fullSalary += hours * perHours;
                }
            }
            salaryReport.append(name).append(" - ").append(fullSalary).append(System.lineSeparator());
        }
        return salaryReport.toString();
    }
}
