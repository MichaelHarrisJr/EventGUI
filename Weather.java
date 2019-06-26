package project3;

public class Weather {

    boolean sunny;
    double  temperature;
    double  windSpeed;
    double  humidity; 

    public Weather() {}
    
    public Weather(boolean sunny, double temperature, double windSpeed, double humidity) {
        this.setSunny(sunny);
        this.setTemperature(temperature);
        this.setWindSpeed(windSpeed);
        this.setHumidity(humidity);
    }  // Weather()
    
    public final void setSunny(boolean sunny) {this.sunny = sunny;}
    public boolean    isSunny() {return this.sunny;}

    public final void setTemperature(double temperature) {this.temperature = temperature;}
    public double     getTemperature() {return this.temperature;}
    
    public final void setWindSpeed(double windSpeed) {this.windSpeed = windSpeed;}
    public double     getWindSpeed() {return this.windSpeed;}
    
    public final void setHumidity(double humidity) {this.humidity = humidity;}
    public double     getHumidity() {return this.humidity;}
    
    public boolean isGoodWeather() {return this.isSunny() && (this.getTemperature() >= 60.0 && this.getTemperature() <= 70.0) && this.getWindSpeed() <= 10.0 && (this.getHumidity() >= 0.4 && this.getHumidity() <= 0.5);}
    
}  // class Weather