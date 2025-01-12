import java.text.*;
import java.util.*;

public class SalesDataPoint {
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	public Date date;
	public int store;
	public int item;
	public int units;
	public WeatherDataPoint todayWeather;
	public WeatherDataPoint tomorrowWeather;

	public SalesDataPoint(Date date, int store, int item, int units) {
		this.date = date;
		this.store = store;
		this.item = item;
		this.units = units;
	}

	public static SalesDataPoint parse (String line) {
		SalesDataPoint dp = null;
		try {
			String[] pieces = line.split(",");
			Date date = df.parse(pieces[0]);
			int store = Integer.parseInt(pieces[1]);
			int item = Integer.parseInt(pieces[2]);
			int units = Integer.parseInt(pieces[3]);
			dp = new SalesDataPoint(date, store, item, units);
		} catch (Exception e) { e.printStackTrace(); }
		return dp;
	}
	
	public static SalesDataPoint parseTest (String line) {
		SalesDataPoint dp = null;
		try {
			String[] pieces = line.split(",");
			Date date = df.parse(pieces[0]);
			int store = Integer.parseInt(pieces[1]);
			int item = Integer.parseInt(pieces[2]);
			int units = 0;
			dp = new SalesDataPoint(date, store, item, units);
		} catch (Exception e) { e.printStackTrace(); }
		return dp;
	}

	public String toString () {
		return store + "_" + item + "_" + df.format(date) + "," + units;
	}

	public static String formatDate(Date date) {
		return df.format(date);
	}
}
