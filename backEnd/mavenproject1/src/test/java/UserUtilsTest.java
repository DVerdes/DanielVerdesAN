/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DVerd
 */
import com.mycompany.mavenproject1.UserUtils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.sql.Date;

public class UserUtilsTest {

     @Test
    public void testCalculateAge_ValidAge() {
        LocalDate birthLocalDate = LocalDate.of(1950, 8, 20);
        Date birthDate = Date.valueOf(birthLocalDate);
        int expectedAge = 73;
        assertEquals(expectedAge, UserUtils.calculateAge(birthDate));
    }

}
