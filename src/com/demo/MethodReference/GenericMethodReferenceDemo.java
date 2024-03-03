package com.demo.MethodReference;

interface TemperatureUtil<T> {
	T operation(T[] tempeatures_week, T avg_temperature);
}

class Myclass2 {
	static <T> int countTemperaturesEqualToAverage(T[] weekly_temps, T averageTemperature) {
		int count = 0;

		for (int i = 0; i < weekly_temps.length; ++i) {
			if (weekly_temps[i] == averageTemperature)
				count++;
		}
		return count;
	}
}

public class GenericMethodReferenceDemo {
	static <T> int getTempeartureCount(TemperatureUtil<T> tu, T[] weekly_temperatures, T avg_temp) {
		return (int) tu.operation(weekly_temperatures, avg_temp);
	}

	public static void main(String[] args) {
		Integer[] weekly_temperatures = { 30, 31, 33, 30, 32, 33, 33, 34, 35, 32 };
		Integer avgerage_temperature = 33;
		int res_count = getTempeartureCount(Myclass2::countTemperaturesEqualToAverage, weekly_temperatures,
				avgerage_temperature);
		System.out.println("Count is: " + res_count);

	}
}
