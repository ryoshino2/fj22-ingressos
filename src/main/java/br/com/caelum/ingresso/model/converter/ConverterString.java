package br.com.caelum.ingresso.model.converter;

import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;


public class ConverterString implements Converter<String, LocalTime>  {

	public YearMonth convertAnoMes(String text) {
		return YearMonth.parse(text, DateTimeFormatter.ofPattern("MM/yyyy"));
	}

	public LocalTime convert(String text) {
		return LocalTime.parse(text);
	}
}
