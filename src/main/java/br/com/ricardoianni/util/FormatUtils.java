package br.com.ricardoianni.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class FormatUtils {

	public static final Locale LOCALE_BRAZIL = new Locale("pt", "BR");
	
	public static NumberFormat newNumberFormat() {
		NumberFormat nf = NumberFormat.getNumberInstance(LOCALE_BRAZIL);
		
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		nf.setGroupingUsed(false);
		
		return nf;
	}
	
	public static String formatNumber(BigDecimal number) {
		if (number == null) {
			return null;
		}
		
		return newNumberFormat().format(number);
		
	}
	
	public static String formatNumber(Double number) {
		if (number == null) {
			return null;
		}
		
		return newNumberFormat().format(number);
		
	}
	
	public static String formatCurrency(Double number) {
		Currency currency = Currency.getInstance(LOCALE_BRAZIL);
		NumberFormat currencyFormartter = NumberFormat.getCurrencyInstance(LOCALE_BRAZIL);
		
		return currencyFormartter.format(number);
	}
	
	public static String formatCurrency(BigDecimal number) {
		return formatCurrency(number.doubleValue());		
	}
	
}