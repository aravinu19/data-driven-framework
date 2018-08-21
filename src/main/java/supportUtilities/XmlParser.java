package supportUtilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParser {
	
	private static SAXReader reader;
	
	public static String[] readConfig(String path) throws DocumentException {
		
		String[] configs = new String[5];
		
		reader = new SAXReader();
		Document config = reader.read(new File(path));
		
		Element root = config.getRootElement();
		
		configs[0] = root.selectSingleNode("/config/hostname").getStringValue();
		configs[1] = root.selectSingleNode("/config/port").getStringValue();
		configs[2] = root.selectSingleNode("/config/database").getStringValue();
		configs[3] = root.selectSingleNode("/config/username").getStringValue();
		configs[4] = root.selectSingleNode("/config/password").getStringValue();
		
		return(configs);
		
	}
	
	public static void writeConfig(String path, String[] configuration) throws DocumentException, IOException {
		
		reader = new SAXReader();
		Document config = reader.read(new File(path));
		
		config.selectSingleNode("/config/port").setText("5432");
		
		FileWriter out = new FileWriter(path);
		config.write(out);
		out.close();
		
	}
	
}
