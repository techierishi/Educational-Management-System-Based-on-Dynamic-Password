package cn.edu.hustwb.util.test;

import org.junit.Test;

import cn.edu.hustwb.util.DynamicEncrypt;

public class DynamicEncryptTest {

	@Test
	public void testEncrypt() {
		DynamicEncrypt de = new DynamicEncrypt();
		de.Encrypt(de.CreateDynamicPassword());
		
	}

}
