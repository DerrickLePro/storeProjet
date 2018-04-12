package org.lepro.storeprojet.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * 
 * @author derrick.kaffo
 *
 */

public class DateUtils {

	private static final Logger logger = Logger.getLogger(DateUtils.class);

	/**
	 * dd/MM/yyyy
	 */
	public static final String dd_MM_YYYY_SLASH = "dd/MM/yyyy"; // 02/01/2014

	/**
	 * dd/MM/yyyy HH:mm
	 */
	public static final String dd_MM_YYYY_SLASH_HH_MM = "dd/MM/yyyy HH:mm"; // 02/01/2014
																			// 20:02

	/**
	 * dd/MM/yyyy HH:mm:ss
	 */
	public static final String dd_MM_YYYY_SLASH_HH_MM_SS = "dd/MM/yyyy HH:mm:ss"; // 02/01/2014
																					// 20:02:00

	/**
	 * dd_MM_yyyy
	 */
	public static final String dd_MM_YYYY_UDERSCORE = "dd_MM_yyyy"; // 02_01_2014

	/**
	 * ddMMyyyy
	 */
	public static final String dd_MM_YYYY_NOTHING = "ddMMyyyy"; // 02_01_2014

	/**
	 * dd-MM-yyyy
	 */
	public static final String dd_MM_YYYY_TIRET = "dd-MM-yyyy"; // 02-01-2014

	/**
	 * dd.MM.yyyy
	 */
	public static final String dd_MM_YYYY_DOT = "dd.MM.yyyy"; // 02-01-2014

	/**
	 * dd-MMM-yyyy
	 */
	public static final String DD_MMM_YYYY = "dd-MMM-yyyy"; // 02-Jan-2014

	/**
	 * dd MMM yyyy
	 */
	public static final String DD_MMM_YYYY2 = "dd MMM yyyy"; // 02 Jan. 2014

	/**
	 * dd-MM-yyyy HH:mm
	 */
	public static final String dd_MM_YYYY_HH_MM_TIRET = "dd-MM-yyyy HH:mm";

	/**
	 * dd MMM yyyy HH:mm
	 */
	public static final String dd_MMM_YYYY_HH_MM = "dd MMM yyyy HH:mm";

	/**
	 * dd MMM yyyy HH:mm:ss
	 */
	public static final String dd_MMM_YYYY_HH_MM_SS = "dd MMM yyyy HH:mm:ss";

	/**
	 * dd-MM-yyyy HH:mm:ss
	 */
	public static final String dd_MM_YYYY_HH_MM_SS_TIRET = "dd-MM-yyyy HH:mm:ss";

	/**
	 * ddMMyyyyHHmmss
	 */
	public static final String ddMMYYYYHHMMSS = "ddMMyyyyHHmmss";

	/**
	 * yyyyMMddHHmmss
	 */
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * yyyyMMddHHmmss
	 */
	public static final String HHMMSS = "HHmmss";

	/**
	 * HH:mm
	 */
	public static final String TIME_HH_MM = "HH:mm";

	/**
	 * ddMMyyyy
	 */
	public static final String ddMMYYYY = "ddMMyyyy";

	/**
	 * yyyyMMdd
	 */
	public static final String yyyyMMdd = "yyyyMMdd";

	public static LocalDate convertDateToLocalDate(Date date) {

		if (date == null)
			return null;

		LocalDate localDate = LocalDate.parse(date.toString());

		return localDate;

	}

	public static java.sql.Date convertLocalDateToDate(LocalDate localDate) {

		if ((localDate == null))
			return null;

		// localDate.getMonth().getValue();
		// Calendar c = Calendar.getInstance();
		// c.set(localDate.getYear(), localDate.getMonth().getValue(),
		// localDate.getDayOfMonth());
		// java.sql.Date d = new java.sql.Date(c.getTimeInMillis());
		// return d;

		return java.sql.Date.valueOf(localDate);

	}

	public static String convertLocalDateToDateStr(LocalDate localDate) {
		if ((localDate == null))
			return null;

		String s = localDate.getDayOfMonth() + "-" + localDate.getMonth().getValue() + "-" + localDate.getYear();
		return s;

	}

	public static String convertLocalDateToDateStrMysql(LocalDate localDate) {
		if ((localDate == null))
			return null;

		String s = localDate.getYear() + "-" + localDate.getMonth().getValue() + "-" + localDate.getDayOfMonth();
		return s;
	}

	private static SimpleDateFormat d = new SimpleDateFormat("YYYY.MM.dd");

	public static Date convertDate(String str) {
		try {
			return d.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// ExceptionDelegator.displayException(e);
			logger.error(e.getMessage());
		}
		return null;
	}

	public static LocalDateTime convertDateToLocalDateTime(Date date) {
		if (date == null) {
			return null;
		}

		LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		return ldt;
	}

	public static Timestamp convertLocalDateTimeToTimestamp(LocalDateTime ldt) {
		if (ldt == null) {
			return null;
		}

		return Timestamp.valueOf(ldt);
	}

	public static Date asDate(LocalDate localDate) {
		if (localDate == null)
			return null;

		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
		if (localDateTime == null)
			return null;
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate asLocalDate(Date date) {
		if (date == null)
			return null;
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		if (date == null)
			return null;
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static LocalDate createDateFromStr(String dateStr) {
		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);

		LocalDate xmas = LocalDate.parse(dateStr, germanFormatter);
		return xmas;
	}

	/**
	 * @param indate
	 * @param format
	 * @return indate to string format
	 */
	public static String convertDateToString(Date indate, String format) {
		if (indate == null)
			return " - ";

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat(format);

		try {
			dateString = sdfr.format(indate);
		} catch (Exception ex) {
			logger.error("Conversion error " + ex.getMessage());
			// ExceptionDelegator.displayException(ex);
		}
		return dateString;
	}

	/**
	 * @param indate
	 * @param format
	 * @return
	 */
	public static Date convertStringToDate(String indate, String format) {
		if (indate == null)
			return null;

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = formatter.parse(indate);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			logger.error("Conversion error " + e.getMessage());
			// ExceptionDelegator.displayException(e);
		}
		return date;
	}

	/**
	 * @param lDate
	 * @param format
	 * @return
	 */
	public static String convertLocalDateTimeToString(LocalDateTime lDate, String format) {
		if (lDate == null)
			return " - ";

		String dateString = null;
		DateTimeFormatter dtfr = DateTimeFormatter.ofPattern(format);

		try {
			dateString = lDate.format(dtfr);
		} catch (Exception ex) {
			logger.error("Conversion error " + ex.getMessage());
			// ExceptionDelegator.displayException(ex);
		}
		return dateString;
	}

	public static LocalDateTime convertStringtoLocalDateTime(String indate, String format) {
		if (indate.isEmpty())
			return null;

		DateTimeFormatter dtfr = DateTimeFormatter.ofPattern(format);
		LocalDateTime date = null;
		try {
			date = LocalDateTime.parse(indate, dtfr);
		} catch (Exception e) {
			logger.error("Conversion error " + e.getMessage());
			// ExceptionDelegator.displayException(e);
		}
		return date;
	}

	public static Timestamp convertDateToTimestamp(java.util.Date date) {
		return date == null ? null : new java.sql.Timestamp(date.getTime());
	}

	public static Timestamp convertLocalDateToTimestamp(java.time.LocalDate localDate) {

		if (localDate == null) {
			return null;
		}

		Timestamp timeStamp = null;
		try {
			Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			timeStamp = new Timestamp(date.getTime());
		} catch (Exception e) {
			logger.error("Conversion error " + e.getMessage());
			// ExceptionDelegator.displayException(e);
		}
		return timeStamp;
	}

	public static LocalDateTime localDateFromTimestamp(Timestamp timestamp) {
		LocalDateTime ldt = null;
		try {
			ldt = LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));
		} catch (Exception e) {
			logger.error("Conversion error " + e.getMessage());
			// ExceptionDelegator.displayException(e);
		}
		return ldt;
	}

	public static LocalDateTime convertTimestampToLocalDateTime(Timestamp ts) {
		return ts == null ? null : ts.toLocalDateTime();
	}

	public static Integer computeDiffYear(LocalDate indate) {
		if (indate == null)
			return null;
		LocalDate current = LocalDate.now();
		int r = indate.compareTo(current);
		if (r > 0) {
			logger.info("Indate is after current date");
			return 0;
		} else {
			return current.getYear() - indate.getYear();
		}
	}

}
