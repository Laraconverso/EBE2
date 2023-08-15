package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.SearchPage;

public class PrimerTestBefore {
    public WebDriver driver;

    @BeforeEach
    public void setup() throws InterruptedException {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ChromeOptions);
        driver.manage().window().maximize();
        driver.get("http://testing.ctd.academy/");
    }

    @Test
    public void Prueba_1() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.escribirCiudad("este");
        searchPage.clickBuscar();

        String mensajeCorrecto = searchPage.obtenerResultadoBusqueda();
        assertTrue(mensajeCorrecto.equals("CASA DE PLAYA\nVilla Kantounes Studio Ostria"));

        searchPage.close();
    }
}
