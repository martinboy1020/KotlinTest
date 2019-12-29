package example.com.kotlintest

class WeatherBean(val base: String, val coordObject: WeatherBean.coord, val weatherList: List<WeatherBean.weather>) {

    class coord(val lon: Int, val lat: Int)
    class weather(val data: List<WeatherInfo>) {
        class WeatherInfo(val id: Int, val main: String, val description: String, val icon: String)
    }

}