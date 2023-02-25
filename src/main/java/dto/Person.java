package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
public class Person {
    private String fName;
    private String lName;
    private int age;
}
