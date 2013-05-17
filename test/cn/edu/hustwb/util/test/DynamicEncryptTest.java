package cn.edu.hustwb.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import cn.edu.hustwb.util.DynamicEncrypt;

public class DynamicEncryptTest {

	@Test
	public void testEncrypt() {
		DynamicEncrypt de = new DynamicEncrypt();
		String key = de.Encrypt("1234-3214-4564-1234");
		Assert.assertEquals("525168",  key);
	}

	@Test
	public void testServerValid() {
		DynamicEncrypt de = new DynamicEncrypt();
		Assert.assertTrue(de.ServerValid("1234-3214-4564-1234", "720248"));
	}

	@Test
	public void testCreateDynamicPassword() {
		DynamicEncrypt de = new DynamicEncrypt();
		String dp = de.CreateDynamicPassword();
		System.out.println(dp);
	}

}
