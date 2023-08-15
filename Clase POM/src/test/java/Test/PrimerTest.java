package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.SearchPage;

public class PrimerTest {
    public WebDriver driver;

    @Test
    public void Prueba_1() throws InterruptedException {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ChromeOptions);
        driver.manage().window().maximize();
        driver.get("http://testing.ctd.academy/");
        SearchPage searchPage = new SearchPage(driver);

        searchPage.escribirCiudad("este");
        searchPage.clickBuscar();

        String mensajeCorrecto = searchPage.obtenerResultadoBusqueda();
        assertTrue(mensajeCorrecto.equals("CASA DE PLAYA\nVilla Kantounes Studio Ostria"));

        searchPage.close();
    }
}
