package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;


public class SpousteciTrida {

    public static void main(String[] args) throws InterruptedException {
        //      System.out.println("Zdravim, pozemstani! Zavedte me ke svemu vudci");

        System.setProperty("webdriver.gecko.driver", "C://Java-Training//Selenium//geckodriver.exe");

        // Cviceni 1
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("-private");

        WebDriver browser = new FirefoxDriver();

        //      prohlizec.navigate().to("https://www.wikipedia.org/"

        // Cviceni 2
//        browser.manage().window().maximize();

//        //Cviceni 3
//        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");
//
//        // Cviceni 4
//        String title = browser.getTitle();
//        String url = browser.getCurrentUrl();
//        int htmlKod = browser.getPageSource().length();
//
//        Thread.sleep(5000);
//
//        browser.quit();
//
//        System.out.println("Nazev stranky je " + title + " , jeho url je " + url + " a zdrojovy kod html je " + htmlKod);

        // metody ktere budeme pouzivat muzou vyhodit vyjimku a proto budeme operace delat v bloku try
        try {
            browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");
            // do toho bloku piste kod
            WebElement searchBox = browser.findElement(By.id("searchField"));

            String idValue = searchBox.getAttribute("id");
            String classValue = searchBox.getAttribute("class");
            String placeholderValue = searchBox.getAttribute("placeholder");
            String typeValue = searchBox.getAttribute("type");
            String nameValue = searchBox.getAttribute("name");
            searchBox.sendKeys("Well done biatch!");

            System.out.println("Searchbox ma toto id: " + idValue + ", tuto class: " + classValue + ", je na tomto miste: " + placeholderValue + ", je to tento typ: " + typeValue + " a nakonec toto jmeno: " + nameValue + " a ty ses dobra, zes to cely dala!");
            Thread.sleep(5000);
            
            WebElement button = browser.findElement(By.className("btn-lg"));
            button.click();

            Thread.sleep(5000);




//             cviceni 4

//            *[@autocomplete="off" and @spellcheck="false" and @dir="auto"]

//             cviceni 5
//            List<WebElement> elementyProduktu = prohlizec.findElements(By.className("product"));
////            WebElement prvniProdukt = elementyProduktu.get(0);
////            System.out.println(prvniProdukt.getText());
//            for (int i=0; i<elementyProduktu.size(); i++) {
//                WebElement prvniProdukt = elementyProduktu.get(i);
//                System.out.println(prvniProdukt.getText());
//            }



            //search box element
//            WebElement element = browser.findElement(By.id("searchField"));

        } catch (Exception ex) {
            // catch blok slouzi ke zpracovani vyjimky, v nasem pripade nechame vyjimku byt
            System.out.println("Bohuzel doslo k chybe. Jedna z poslednich informaci by mel byt: (Main.java:**cislo radku kde chyba vznikla**) ");

        } finally {
            // blok finally nam v tomto pripade poslouzi k tomu aby se WebDriver ukoncil spravne za kazdych okolnosti

            browser.quit();
        }
    }

    }
    
