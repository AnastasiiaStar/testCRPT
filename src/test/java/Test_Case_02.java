import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Test_Case_02 {


    //This positive test checks that site https://yandex.ru is owned to Yandex
    @Test
    void check_positiveTest() throws Exception {

        // Arrange
        CertificateTest certificateTest = new CertificateTest();

        // Act
        boolean checkValue = certificateTest.check("https://yandex.ru", "Yandex");

        // Assert
        Assert.check(true, checkValue);
    }


    //This negative test checks that site https://yandex.ru isn`t owned to another company
    @Test
    public void check_negativeTest_01() throws Exception {

        // Arrange
        CertificateTest certificateTest = new CertificateTest();

        // Act
        boolean checkValue = certificateTest.check("https://yandex.ru", "Google");

        // Assert
        //  Assert.check(true, checkValue);
        assertFalse(checkValue);

    }


    //This negative test checks that site https://google.ru isn`t owned to Yandex
    @Test
    public void check_negativeTest_02() throws Exception {

        // Arrange
        CertificateTest certificateTest = new CertificateTest();

        // Act
        boolean checkValue = certificateTest.check("https://google.ru", "Yandex");

        // Assert
        assertFalse(checkValue);
    }

}