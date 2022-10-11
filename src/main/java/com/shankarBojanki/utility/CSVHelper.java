package com.shankarBojanki.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shankarBojanki.entity.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import static java.sql.Timestamp.valueOf;
import static java.util.Date.*;

public class CSVHelper {

    public static final String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Employee> csvToEmployee(InputStream is) {

        Long id;
        String first_name, last_name, email, gender, role;
        Date joined_on;
        int salery;
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser parser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<Employee> employees = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = parser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                Employee employee = new Employee();

                try {
                    employee.setId(Long.parseLong(csvRecord.get("id")));
                } catch (Exception e) {
                    id = Long.valueOf(0);
                }
                try {
                    employee.setFirst_name(csvRecord.get("first_name"));
                } catch (Exception e) {
                    first_name = null;
                }
                try {
                    employee.setLast_name(csvRecord.get("last_name"));
                } catch (Exception e) {
                    last_name = null;
                }

                try {
                    employee.setEmail(csvRecord.get("email"));
                } catch (Exception e) {
                    email = null;
                }

                try {
                    employee.setGender(csvRecord.get("gender"));
                } catch (Exception e) {
                    gender = null;
                }

                try {
                    employee.setJoined_on(valueOf(csvRecord.get("joined_on")));
                } catch (Exception e) {
                    joined_on = null;
                }

                try {
                    employee.setSalery(Integer.parseInt(csvRecord.get("salery")));
                } catch (Exception e) {
                    salery = 0;
                }

                try {
                    employee.setRole(csvRecord.get("role"));
                } catch (Exception e) {
                    role = null;
                }

                employees.add(employee);
            }
            parser.close();
            return employees;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }


    }


}
