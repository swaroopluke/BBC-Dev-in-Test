package commons;

public class Resources {
	
	
	public static String locationResource(String location){
		String locationResource = "location/search/?query=" + location;
		return locationResource;
	}

	public static String weatherForecastResource(String locationId, String date){
		String forecastResource = "location/"+ locationId + "/" + date +"/";
		return forecastResource;
	}

}
