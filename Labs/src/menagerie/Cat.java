package menagerie;

public class Cat extends Pet {

	public Cat(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 3;
		this.attentionCutoff = 2;
		this.sleepCutoff = 8;
	}
	
	@Override
	public String getType() {
		return "cat";
	}

	@Override
	public String act() {												// TODO
		
		return "";
	}
	
	@Override
	public void setFoodCutoff(int cutoff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttentionCutoff(int cutoff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSleepCutoff(int cutoff) {
		// TODO Auto-generated method stub
		
	}

}
