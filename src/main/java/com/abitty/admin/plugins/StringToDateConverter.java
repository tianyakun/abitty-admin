package com.abitty.admin.plugins;


import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date>{

	private final static Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);

	public Date convert(String source) {
		DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!Strings.isNullOrEmpty(source)) {
				date = dateTimeFormat.parse(source);
			}
		} catch (ParseException e) {
			logger.error("日期转换异常 source={}", source, e);
		}
		return date;
	}
}
