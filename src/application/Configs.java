package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.collections.ObservableList;

class Configs {
	// To be implemented at a later date. I don't know how to make saves/configs.
	// If you care to make it in a branch, feel free. Any changes you make that I use will be fully credited,
	// in which case I'll probably put a little credits area in the settings tab.
	public static Properties prop = new Properties();

	public void saveProp(String title, ObservableList<Planet> planets){
		try{
			prop.setProperty(title, planets.toString());
			prop.store(new FileOutputStream("config.lmao"), null);
		}catch(IOException e){

		}
	}
}
