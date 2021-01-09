package br.com.ricardoianni.util;

import java.util.Collection;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class StringUtils {

	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		
		return str.trim().length() == 0;
	}

	public static String encrypt(String rawString) {
		if (isEmpty(rawString)) {
			return null;
		}
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder.encode(rawString);
	}
	
	public static String concatenate(Collection<String> strings) {
		return concatenate(strings, ",");
	}
	
	public static String concatenate(Collection<String> strings, String delimiter) {
		if(strings == null || strings.size() == 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		
		for (String string : strings) {
			if (!first) {
				sb.append(delimiter);
			}
			
			sb.append(string);
			first = false;
		}
		
		return sb.toString();
	}
	
	public static String capatalize(String text) {
		String[] words = text.split(" ");
		String word;
		
		for (int i = 0; i < words.length; i++) {
			word = words[i].toLowerCase();
			
			if ( i > 0 && (word.equals("de") || word.equals("da") || word.equals("do") ||
				word.equals("em") || word.equals("na") || word.equals("no") || 
				word.equals("para") || word.equals("pra") || word.equals("pro") || 
				word.equals("por") || word.equals("e") || word.equals("a"))) {
				words[i] = word;
				continue;
			}
	
			words[i] = word.substring(0, 1).toUpperCase() + word.substring(1);
		}
		
		return concatenate(CollectionUtils.listOf(words), " ");
	}
	
}
