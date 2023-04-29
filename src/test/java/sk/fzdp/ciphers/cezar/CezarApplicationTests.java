package sk.fzdp.ciphers.cezar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.Assert;

@SpringBootTest
class CezarApplicationTests {

	@Autowired
	private CezarService cezarService;
	
	@SuppressWarnings("deprecation")
	@Test
	void encode() {
		String text = cezarService.encode("Filip");
		Assert.assertEquals("Chyba", "Hknkr", text);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void decode() {
		String text = cezarService.decode("Hknkr");
		Assert.assertEquals("Chyba", "Filip", text);
	}

}
