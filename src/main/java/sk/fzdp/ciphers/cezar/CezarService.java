package sk.fzdp.ciphers.cezar;

import org.springframework.stereotype.Repository;

@Repository
public class CezarService {
	
	public String encode(String text) {
		String encoded = "";
		int shift = 2;
		for(int i = 0; i < text.length(); i ++) {
			char c = text.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					encoded += (char) ('A' + (c - 'A' + shift) % 26);
				} else {
					encoded += (char) ('a' + (c - 'a' + shift) % 26);
				}
			} else {
				encoded += c;
			}
		}
		return encoded;
	}
	
	public String decode(String text) {
		String decoded = "";
		int shift = 24;
		for(int i = 0; i < text.length(); i ++) {
			char c = text.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					decoded += (char) ('A' + (c - 'A' + shift) % 26);
				} else {
					decoded += (char) ('a' + (c - 'a' + shift) % 26);
				}
			} else {
				decoded += c;
			}
		}
		return decoded;
	}
}
