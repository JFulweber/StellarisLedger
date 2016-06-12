package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {


	// TAB ONE
	ObservableList<Planet> planets = FXCollections.observableArrayList();
	ObservableList<Planet> uneditedplanets = FXCollections.observableArrayList();
	@FXML TabPane tabpane;
	@FXML Tab planetstab;
	@FXML Tab settingstab;
	@FXML ComboBox<String> planetType;
	@FXML TextField planetName;
	@FXML TextField planetSize;
	@FXML TextField systemName;
	@FXML TableView<Planet> planetTable;
	@FXML TableColumn<Planet, String> nameColumn;
	@FXML TableColumn<Planet, String> systemColumn;
	@FXML TableColumn<Planet, Boolean> colonizableColumn;
	@FXML TableColumn<Planet, Double> habitabilityColumn;
	@FXML TableColumn<Planet, Integer> sizeColumn;
	@FXML TableColumn<Planet, String> modifieroutputColumn;
	@FXML GridPane checkGrid;

	//I really wish I didn't have to do this. If you know Java/JavaFX well enough to understand my source code,
	//dear lord kill me
	ObservableList<Planet> colonizableList = FXCollections.observableArrayList();
	@FXML CheckBox checkBox1;
	@FXML CheckBox checkBox2;
	@FXML CheckBox checkBox3;
	@FXML CheckBox checkBox4;
	@FXML CheckBox checkBox5;
	@FXML CheckBox checkBox6;
	@FXML CheckBox checkBox7;
	@FXML CheckBox checkBox8;
	@FXML CheckBox checkBox9;
	@FXML CheckBox checkBox10;
	@FXML CheckBox checkBox11;
	@FXML CheckBox checkBox12;
	@FXML CheckBox checkBox13;
	@FXML CheckBox checkBox14;
	@FXML CheckBox checkBox15;
	@FXML CheckBox checkBox16;
	@FXML CheckBox checkBox17;
	@FXML CheckBox checkBox18;
	@FXML CheckBox checkBox19;
	@FXML CheckBox checkBox20;
	@FXML CheckBox checkBox21;
	@FXML CheckBox checkBox22;

	// TAB TWO
	@FXML ComboBox<String> basePlanets;
	@FXML CheckBox check1;
	@FXML CheckBox check2;
	@FXML CheckBox check3;
	@FXML CheckBox check4;
	@FXML CheckBox check5;
	@FXML CheckBox check6;
	@FXML CheckBox check7;
	@FXML CheckBox check8;
	@FXML CheckBox check9;
	@FXML CheckBox check10;
	@FXML CheckBox check11;
	@FXML CheckBox check12;
	@FXML CheckBox check13;
	@FXML TableView<Planet> colonizableTable;
	@FXML TableColumn<Planet, String> colonizablePlanets;
	@FXML TableColumn<Planet, Boolean> colonizableResults;
	@FXML TableColumn<Planet, Double> colonizableHab;
	//Configs con = new Configs();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TAB 1 INIT
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
		systemColumn.setCellValueFactory(new PropertyValueFactory<>("sysName"));
		colonizableColumn.setCellValueFactory(new PropertyValueFactory<>("colonizable"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		habitabilityColumn.setCellValueFactory(new PropertyValueFactory<>("habitability"));
		modifieroutputColumn.setCellValueFactory(new PropertyValueFactory<>("modifieroutput"));
		initPlanetTypes();
		// TAB 2 INIT

		 check1.setOnAction(checkupdater);
		 check2.setOnAction(checkupdater);
		 check3.setOnAction(checkupdater);
		 check4.setOnAction(checkupdater);
		 check5.setOnAction(checkupdater);
		 check6.setOnAction(checkupdater);
		 check7.setOnAction(checkupdater);
		 check8.setOnAction(checkupdater);
		 check9.setOnAction(checkupdater);
		 check10.setOnAction(checkupdater);
		 check11.setOnAction(checkupdater);
		 check12.setOnAction(checkupdater);
		 check13.setOnAction(checkupdater);
		 colonizablePlanets.setCellValueFactory(new PropertyValueFactory<>("name"));
		 colonizableResults.setCellValueFactory(new PropertyValueFactory<>("colonizable"));
		 colonizableHab.setCellValueFactory(new PropertyValueFactory<>("habitability"));
		 colonizableTable.getColumns().clear();
		 colonizableTable.getColumns().addAll(colonizablePlanets,colonizableResults,colonizableHab);

		 colonizableList.add(new Planet("Arctic", 0, "", "Arctic", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		 colonizableList.add(new Planet("Arid", 0, "", "Arid", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		 colonizableList.add(new Planet("Continental", 0, "", "Continental", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		 colonizableList.add(new Planet("Desert", 0, "", "Desert", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		 colonizableList.add(new Planet("Ocean", 0, "", "Ocean", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		 colonizableList.add(new Planet("Tropical", 0, "", "Tropical", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		 colonizableList.add(new Planet("Tundra", 0, "", "Tundra", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		// colonizableList.add(new Planet("Tomb", 0, "", "Tomb", getModifiersBoolean(), getResearchBoolean(), basePlanets.getValue()));
		 colonizableTable.setItems(colonizableList);
		 basePlanets.setOnAction(baseplanetupdater);
	}
	//just putting combobox options in the combobox
	public void initPlanetTypes(){

		ObservableList<String> planetTypes = FXCollections.observableArrayList();
		ObservableList<String> planetTypes2 = FXCollections.observableArrayList();
		planetTypes.addAll("Arid","Arctic","Continental","Desert","Gaia","Ocean","Tomb","Tropical","Tundra");
		planetTypes2.addAll("Arid","Arctic","Continental","Desert","Ocean","Tropical","Tundra");
		planetType.setItems(planetTypes);
		basePlanets.setItems(planetTypes2);

	}

	//put planet into table
	public void enterPlanet(){
		if(planetType.getValue()==null||planetName.getLength()==0||planetSize.getLength()==0||basePlanets.getValue()==null){
			System.out.println("Planet Type Not Chosen");
		}else{
			Planet newPlanet = new Planet(planetType.getValue(),Integer.parseInt(planetSize.getText()),systemName.getText(),
					planetName.getText(),getModifiersBoolean(),getResearchBoolean(),basePlanets.getValue());
			planets.add(newPlanet);
			planetTable.getColumns().clear();
			//include/don't include system names if system name is there or not
			if(systemName.getLength()!=0)planetTable.getColumns().addAll(sizeColumn,colonizableColumn,systemColumn, nameColumn,habitabilityColumn,modifieroutputColumn);
			else planetTable.getColumns().addAll(sizeColumn,colonizableColumn,nameColumn,habitabilityColumn,modifieroutputColumn);
			planetTable.setItems(planets);
			habitabilityupdater();
		}
	}
	// turning checkboxes into the modifier array for the planets. i tried using a for loop
	// and casting checkbox to node to iterate through the gridbox
	// instead of each individually but I couldn't get it to work. feel free to try.
	public boolean[] getModifiersBoolean(){
		boolean[] modifiers = new boolean[22];

		if(checkBox1.isSelected())modifiers[0]=true;
		if(checkBox2.isSelected())modifiers[1]=true;
		if(checkBox3.isSelected())modifiers[2]=true;
		if(checkBox4.isSelected())modifiers[3]=true;
		if(checkBox5.isSelected())modifiers[4]=true;
		if(checkBox6.isSelected())modifiers[5]=true;
		if(checkBox7.isSelected())modifiers[6]=true;
		if(checkBox8.isSelected())modifiers[7]=true;
		if(checkBox9.isSelected())modifiers[8]=true;
		if(checkBox10.isSelected())modifiers[9]=true;
		if(checkBox11.isSelected())modifiers[10]=true;
		if(checkBox12.isSelected())modifiers[11]=true;
		if(checkBox13.isSelected())modifiers[12]=true;
		if(checkBox14.isSelected())modifiers[13]=true;
		if(checkBox15.isSelected())modifiers[14]=true;
		if(checkBox16.isSelected())modifiers[15]=true;
		if(checkBox17.isSelected())modifiers[16]=true;
		if(checkBox18.isSelected())modifiers[17]=true;
		if(checkBox19.isSelected())modifiers[18]=true;
		if(checkBox20.isSelected())modifiers[19]=true;
		if(checkBox21.isSelected())modifiers[20]=true;
		if(checkBox22.isSelected())modifiers[21]=true;


		return modifiers;
	}


	public boolean[] getResearchBoolean(){
		boolean[] research = new boolean[7];

		if(check1.isSelected())research[0]=true;
		if(check2.isSelected())research[1]=true;
		if(check3.isSelected())research[2]=true;
		if(check4.isSelected())research[3]=true;
		if(check5.isSelected())research[4]=true;
		if(check6.isSelected())research[5]=true;
		if(check7.isSelected())research[6]=true;
		if(check8.isSelected())research[7]=true;


		return research;
	}

	// event handler updater w/ checkbox change (not needed for modifiers; only research/traits!)
	EventHandler<ActionEvent> checkupdater = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event){

			if(event.getSource() instanceof CheckBox){
					habitabilityupdater();
					colonizabilityupdater();
					System.out.println("Event Handled w/ " + ((CheckBox) event.getSource()).getText());
			};
		}
	};

	EventHandler<ActionEvent> baseplanetupdater = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event){

			if(event.getSource() instanceof ComboBox){
					habitabilityupdater();
					colonizabilityupdater();
					System.out.println("Event Handled w/ combo box");
			};
		}
	};
	public void habitabilityupdater(){
		Double habAdd = 0.0;
		Planet tempPlanet;

		if(check9.isSelected())habAdd+=5.0;
		if(check10.isSelected())habAdd+=5.0;
		if(check11.isSelected())habAdd+=10.0;
		if(check12.isSelected())habAdd+=20.0;
		if(check13.isSelected())habAdd+=-10.0;


		for(int j = 0; j<planets.toArray().length; j++){
			System.out.println("Planet Names: " + planets.get(j).getName());
			tempPlanet = planets.get(j);
			tempPlanet.setHabAdd(habAdd);
			System.out.println("habAdd = " + tempPlanet.getHabAdd());
			System.out.println("Temp Planet Habitability: " + tempPlanet.getHabitability());
			tempPlanet.printPlanet();
			planets.set(j, tempPlanet);
			planetTable.setItems(planets);
		}
		for(int j = 0; j<colonizableList.toArray().length; j++){
			System.out.println("Planet Names: " + colonizableList.get(j).getName());
			tempPlanet = colonizableList.get(j);
			tempPlanet.setBasePlanet(basePlanets.getValue());
			tempPlanet.setHabAdd(habAdd);
			System.out.println("habAdd = " + tempPlanet.getHabAdd());
			System.out.println("Temp Planet Habitability: " + tempPlanet.getHabitability());
			tempPlanet.printPlanet();
			colonizableList.set(j, tempPlanet);
			colonizableTable.setItems(planets);
		}

	}

	public void colonizabilityupdater(){
		Planet tempPlanet;

		for(int j = 0; j<planets.toArray().length; j++){
			System.out.println("Planet Names: " + planets.get(j).getName());
			tempPlanet = planets.get(j);
			tempPlanet.setResearch(getResearchBoolean());
			tempPlanet.determineColonizable();
			System.out.println("Tempplanet colonizable: " + tempPlanet.getColonizable());

			planets.set(j, tempPlanet);
			planetTable.setItems(planets);
		}
		for(int j = 0; j<colonizableList.toArray().length; j++){
			System.out.println("Planet Names: " + colonizableList.get(j).getName());
			tempPlanet = colonizableList.get(j);
			tempPlanet.setBasePlanet(basePlanets.getValue());
			tempPlanet.setResearch(getResearchBoolean());
			tempPlanet.determineColonizable();
			System.out.println("Tempplanet colonizable: " + tempPlanet.getColonizable());

			colonizableList.set(j, tempPlanet);
			colonizableTable.setItems(colonizableList);
		}
	}

	};
