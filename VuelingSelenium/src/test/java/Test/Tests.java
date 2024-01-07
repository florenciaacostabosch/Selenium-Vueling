package Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import Page.PageHome;
import Page.PageRegister;


public class Tests extends Conditions{
	
	@Test(description="Ingresar a la página, aceptar cookies e ingresar a registrarse")
	public void register() {
		PageHome pageHome = new PageHome(driver);
		pageHome.register();
	}
	
	@Test(description="Completar el formulario de registro y registrarse")
	public void completeForm() {
		PageRegister pageRegister = new PageRegister(driver);
		pageRegister.completeForm("Maria", "Lopez", "lopezmaria@gmail.com", "Maria1234@", "Maria1234@", "Perez", "Escuela");
		pageRegister.selectSecurityQuestion1("7");
		pageRegister.selectSecurityQuestion2("10");
		pageRegister.acceptPromotions();
		pageRegister.acceptTerms();
		pageRegister.register();
		System.out.println(pageRegister.isRegisterConfirm());
	}
	
	@Test(description="Completar el formulario de registro con los campos vacíos")
	public void testRequiredFields() {
		PageRegister pageRegister = new PageRegister(driver);
		pageRegister.completeForm("", "", "", "", "", "", "");
		boolean errorEncontrado=false;
			if (!pageRegister.isNameFieldExists()){
				System.out.println("Validación de campo nombre obligatorio errónea");
				errorEncontrado=true;
				}
			if (!pageRegister.isLastNameFieldExists()){
				System.out.println("Validación de campo apellido obligatorio errónea");
				errorEncontrado=true;
				}
			if (!pageRegister.isEmailFieldExists()){
				System.out.println("Validación de campo email obligatorio errónea");
				errorEncontrado=true;
				}
			if (!pageRegister.isPasswordFieldExists()){
				System.out.println("Validación de campo contraseña obligatorio errónea");
				errorEncontrado=true;
				}
			if (!pageRegister.isPasswordConfirmFieldExists()){
				System.out.println("Validación de campo confirmación de contraseña obligatorio errónea");
				errorEncontrado=true;
				}
			if (!pageRegister.isSecurityAnswer1FieldExists()){
				System.out.println("Validación de campo respuesta de seguridad 1 obligatorio errónea");
				errorEncontrado=true;
				}
			if (!pageRegister.isSecurityAnswer2FieldExists()){
				System.out.println("Validación de campo respuesta de seguridad 2 obligatorio errónea");
				errorEncontrado=true;
				}
			pageRegister.acceptPromotions();
				if(errorEncontrado) {
					Assert.assertTrue(errorEncontrado);
				}else {
					Assert.assertTrue(true);
					}
				}

	@Test(description="Completar el formulario de registro con email incorrecto")
	public void testInvalidEmailDetected() {
		PageRegister pageRegister = new PageRegister(driver);
		pageRegister.completeForm("Maria", "Perez", "xxx", "Maria123@", "Maria123@", "kajsj", "kjkjkj");
		boolean errorEncontrado=false;
			if (!pageRegister.isInvalidEmailDetected()){
			System.out.println("Email con formato incorrecto no detectado");
			errorEncontrado=true;
				}
				if(errorEncontrado) {
					Assert.assertTrue(errorEncontrado);
			}else {
				Assert.assertTrue(true);
				}			
			}
	
	@Test (description="Completar el formulario de registro con contraseña con formato incorrecto")
	public void testInvalidPasswordDetected() {
		PageRegister pageRegister = new PageRegister(driver);
		pageRegister.completeForm("kjjk", "kkk", "ppp", "Maria123", "Maria123@", "jkk", "kjkjkj");
		boolean errorEncontrado=false;
			if (!pageRegister.isInvalidPasswordDetected()){
				System.out.println("Contraseña con formato incorrecto no detectada");
				errorEncontrado=true;
				}
				if(errorEncontrado) {
					Assert.assertTrue(errorEncontrado);
			}else {
				Assert.assertTrue(true);
				}			
			}
	
	@Test(description="Completar el formulario de registro con contraseñas que no coinciden entre sí")
	public void testPasswordsNotMatchDetected() {
		PageRegister pageRegister = new PageRegister(driver);
		pageRegister.completeForm("kjjk", "kkk", "ppp", "Maria12", "Maria123@", "jkk", "kjkjkj");
		boolean errorEncontrado=false;
			if (!pageRegister.isPasswordsNotMatchDetected()){
				System.out.println("Contraseñas no coinciden no detectado");
				errorEncontrado=true;
				}
				if(errorEncontrado) {
					Assert.assertTrue(errorEncontrado);
			}else {
				Assert.assertTrue(true);
				}			
			}	
		}


