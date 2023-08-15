package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import Pages.SearchPage;

public class PrimerTestSetup {
    public WebDriver driver;

    @Test
    public void Prueba_1() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.setup();
        searchPage.url("http://testing.ctd.academy/");

        searchPage.escribirCiudad("este");
        searchPage.clickBuscar();

        String mensajeCorrecto = searchPage.obtenerResultadoBusqueda();
        assertTrue(mensajeCorrecto.equals("CASA DE PLAYA\nVilla Kantounes Studio Ostria"));

        searchPage.close();
    }
}
