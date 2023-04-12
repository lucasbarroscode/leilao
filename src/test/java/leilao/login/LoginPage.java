package leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	
	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		browser.navigate().to(URL_LOGIN);
	}


	public void fecharPagina() {
		this.browser.quit();
		
	}


	public void preencheFormularioDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
		
	}


	public void efetuaLogin() {
		browser.findElement(By.id("login-form")).submit();
		
	}


	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}


	public String getNomeUsuarioLogado() {
		
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} 
		catch (NoSuchElementException e) {
			return null;
		}
		
	}


	public void navegaParaPaginaDeLances() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
		
	}


	public boolean contemTexto(String texto) {
		// TODO Auto-generated method stub
		return browser.getPageSource().contains(texto);
	}


	public boolean isPaginaDeLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
	}
	


	
}
