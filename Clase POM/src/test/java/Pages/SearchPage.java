package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
     private By searchBox = By.id("ciudad");
     private By buscar = By.id("btn-buscador");
     private By searchResult = By.className("categoria");

     public SearchPage(WebDriver driver) {
          super(driver);
     }

     public void escribirCiudad(String ciudad) throws InterruptedException {
          this.sendText(ciudad, searchBox);
          Thread.sleep(1000);
          this.sendKey(Keys.ENTER, searchBox);
          Thread.sleep(1000);
     }

     public void clickBuscar() throws InterruptedException {
          this.clickear(buscar);
          Thread.sleep(1000);
     }

     public String obtenerResultadoBusqueda() throws InterruptedException {
          String res = this.getText(searchResult);
          System.out.println("Resultado Card value: " + res);
          Thread.sleep(1000);
          return res;
     }
}