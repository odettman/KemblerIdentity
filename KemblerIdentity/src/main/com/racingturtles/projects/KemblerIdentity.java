package com.racingturtles.projects;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

public class KemblerIdentity {
	static BigInteger bi;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		byte[] md5input;
		byte[] md5output = "Seed String".getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		String output;
		String input;
		
		do {
			md5input = md5output;
			md5output = md.digest(md5input);

			// Test
			// md5output = "Seed String".getBytes("UTF-8");
			// md5input = "Seed String".getBytes("UTF-8");
			
			input = toHex(md5input);
			output = toHex(md5output);
			
			System.out.println("Input:" + input + " Output: " + output);
			

		} while (!(Arrays.equals(md5output, md5input)));
		
	}
	
	public static String toHex(byte[] bytes) {
	    bi = new BigInteger(1, bytes);
	    return String.format("%0" + (bytes.length << 1) + "X", bi);
	}


}
