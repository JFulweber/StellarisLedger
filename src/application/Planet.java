package application;

import java.util.Arrays;

public class Planet {

	private String name;
	private String sysName;
	private String basePlanet;
	private boolean[] modifiers = new boolean[22];
	private boolean[] research = new boolean[8];
	private boolean colonizable;
	private int size;
	private String modifieroutput;
	private double habitability;
	private String type;
	private double habAdd;
	private String[] PlanetTypes = {"Arid","Tundra","Arctic","Ocean","Continental","Tropical","Desert"};
	private String[] ColonizableTypes = {"Arctic","Arid","Continental","Desert","Ocean","Tropical","Tundra"};

	int[] values = new int[11];


	public Planet(String type, int size, String sysName, String name, boolean[] modifiers, boolean[] research, String basePlanet){
		this.name = name;
		this.sysName = sysName;
		this.basePlanet = basePlanet;
		this.research = research;
		this.modifiers = modifiers;
		this.size = size;
		this.type = type;
	}
	public String getSysName() {
		return this.sysName;
	}

	public void setSysName(String type){
		this.sysName = type;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHabAdd(double habAdd){
		this.habAdd = habAdd;
	}
	public Double getHabAdd(){
		return this.habAdd;
	}

	public double getHabitability() {


		this.determineModifierOutput();
		this.determineHabitability();

			this.habitability+=habAdd;

		return this.habitability;
	}

	public void determineHabitability() {
		int planetIndex = Arrays.asList(PlanetTypes).indexOf(this.type);
		int basePlanetIndex = Arrays.asList(PlanetTypes).indexOf(this.basePlanet);
		int absDist=0;
		int steps=0;

		if(this.type.equals("Gaia")){
			this.habitability=100.0;
		}
		else if(this.type.equals("Tomb")){
			this.habitability=20.0;
		}
		else{
			// figuring out habitability %

		absDist = Math.abs(basePlanetIndex-planetIndex);
		if(absDist>=3)steps = 7 - absDist;
		else steps = absDist;

		//System.out.println(PlanetTypes[basePlanetIndex]);
		if(steps==0)this.habitability=80.0;
		else if(steps==1)this.habitability=60.0;
		else if(steps==2)this.habitability=20.0;
		else if(steps==3)this.habitability=0.0;
		}
		this.habitability=this.habitability+values[0];
	}

	public void setHabitability(double habitability){
		this.habitability = habitability;
	}

	public boolean[] getModifiers() {
		return this.modifiers;
	}

	public void setModifiers(boolean[] modifiers) {
		this.modifiers = modifiers;
	}

	public int getSize(){
		return this.size;
	}

	public void setSize(int size){
		this.size = size;
	}

	public void setResearch(boolean[] research){
		this.research = research;
	}
	public void determineModifierOutput(){
		for(int i = 0; i<values.length;i++)values[i] = 0;
		if(this.getModifiers()[0])
		{
			values[0]+=-10;
			values[1]+=-5;
			values[5]+=20;
		}
		if(this.getModifiers()[1]){
			values[0]+=-10;
			values[1]+=-5;
			values[2]+=20;
		}
		if(this.getModifiers()[2]){
			values[0]+=-5;
			values[9]+=5;
		}
		if(this.getModifiers()[3]){
			values[5]+=5;
			values[3]+=5;
		}
		if(this.getModifiers()[4]){
			values[0]+=-10;
			values[1]+=-5;
			values[4]+=20;
		}
		if(this.getModifiers()[5]){
			values[0]+=-10;
		}
		if(this.getModifiers()[6]){
			values[0]+=-5;
			values[6]+=5;
		}
		if(this.getModifiers()[7]){
			values[0]+=-5;
			values[1]+=-5;
			values[3]+=20;
		}
		if(this.getModifiers()[8]){
			values[10]+=-15;
		}
		if(this.getModifiers()[9]){
			values[10]+=15;
		}
		if(this.getModifiers()[10]){
			values[6]+=25;
		}
		if(this.getModifiers()[11]){
			values[6]+=50;
		}
		if(this.getModifiers()[12]){
			values[6]+=-25;
		}
		if(this.getModifiers()[13]){
			values[2]+=25;
		}
		if(this.getModifiers()[14]){
			values[0]+=5;
			values[1]+=15;
		}
		if(this.getModifiers()[15]){
			values[0]+=5;
			values[9]+=-33;
			values[8]+=10;
		}
		if(this.getModifiers()[16]){
			values[0]+=10;
			values[7]+=20;
		}
		if(this.getModifiers()[17]){
			values[0]+=-5;
			values[7]+=-10;
		}
		if(this.getModifiers()[18]||this.getModifiers()[19]){
			values[6]+=10;
		}
		if(this.getModifiers()[20]){
			values[6]+=15;
		}
		if(this.getModifiers()[21]){
			values[1]+=10;
			values[2]+=10;
			values[8]+=10;
		}
		this.modifieroutput = "";
		if(values[5]!=0)this.modifieroutput=this.modifieroutput+"Energy: "+values[5] +"%, ";
		if(values[6]!=0)this.modifieroutput=this.modifieroutput+"Minerals: "+values[6] +"%, ";
		if(values[3]!=0)this.modifieroutput=this.modifieroutput+"Phys. Res.: "+values[3] +"%, ";
		if(values[2]!=0)this.modifieroutput=this.modifieroutput+"Soc. Res.: "+values[2] +"%, ";
		if(values[4]!=0)this.modifieroutput=this.modifieroutput+"Eng. Res.: "+values[4] +"%, ";
		if(values[1]!=0)this.modifieroutput=this.modifieroutput+"Happiness: "+values[1] +"%, ";
		if(values[9]!=0)this.modifieroutput=this.modifieroutput+"Food Growth: "+values[9] +"%, ";
		if(values[7]!=0)this.modifieroutput=this.modifieroutput+"Food: "+values[7] +"%, ";
		if(values[10]!=0)this.modifieroutput=this.modifieroutput+"Build Cost: "+values[10] +"%, ";
		if(values[8]!=0)this.modifieroutput=this.modifieroutput+"Ethics Diverge: "+values[8] +"%, ";
		if(!this.modifieroutput.isEmpty())this.modifieroutput = this.modifieroutput.substring(0, this.modifieroutput.lastIndexOf(","))+".";
		else this.modifieroutput = "";
	}

	public String getModifieroutput(){
		return this.modifieroutput;
	}

	public void setColonizable(boolean colonizable){
		this.colonizable = colonizable;
	}

	public boolean getColonizable(){
		this.determineColonizable();

		return this.colonizable;
	}

	public void determineColonizable(){
		if(this.type.equals("Gaia")){
			this.colonizable=true;
		}
		else{
		if(this.type.equals("Tomb")&&research[7]==true){
			this.colonizable=true;
		}
		else {
			int planetIndex = Arrays.asList(ColonizableTypes).indexOf(this.type);
			if(research[planetIndex]==true){this.colonizable=true;
			System.out.println("Planet Index: " + planetIndex);}
			else this.colonizable=false;
		}
	}
	}

	public void setBasePlanet(String base){
		this.basePlanet = base;
	}

	public void printPlanet(){
		System.out.println("Planet colonizable: "+this.colonizable);
		System.out.println("Planet type: "+this.type);
	}


}
