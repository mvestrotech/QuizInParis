package mvestro.android.quizinparis.services;

public class TemperatureSensorData {

    public double temperature;
    public int humidity;
    public int power;

    public static TemperatureSensorData parseData(String[] bytes) {

        TemperatureSensorData data = new TemperatureSensorData();
        data.temperature = Integer.valueOf(bytes[2] + bytes[1], 16).shortValue() / 10.0;
        data.humidity = Integer.parseInt(bytes[4], 16);
        data.power = Integer.parseInt(bytes[9], 16);

        return data;
    }
}
