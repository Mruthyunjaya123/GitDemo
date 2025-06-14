package TestData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
public class DataReader {
	
	public  List<HashMap<String, String>>  getJsonDataToMap() throws IOException
	{
		//read json to String
	 // String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "\\test\\java\\TestData\\PurchaseOrder.json")
		//	  .StandardCharsets.UTF_8);
		
		String jsonContent = FileUtils.readFileToString(
			    new File(System.getProperty("user.dir") + "\\test\\java\\TestData\\PurchaseOrder.json"),
			    StandardCharsets.UTF_8
			);
		
		
	  // String to Hash Map
	  
	  ObjectMapper mapper=new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		  
	  });
	  return data;
	}

}
