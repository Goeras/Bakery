package businessObjects;

public abstract class Cake {

	// Här har jag gjort attribut för varje lager/del i tårtan med variabelnamn som passar alla tre tårttyper.(värdena sätts i Builder)
	// Dels för att återanvända kod, men även för att tex spara alla tårtobjekt i exempelvis en "List<Cake>"
	protected int iD = 0;
	protected String name;
	
	protected String firstCakeBottom;
	protected String firstCream;
	protected String secondCakeBottom;
	protected String secondCream;
	protected String thirdCakeBottom;
	
	protected String cover;
	protected String decor;
	protected String sprinkle;
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstCakeBottom() {
		return firstCakeBottom;
	}
	public void setFirstCakeBottom(String firstCakeBottom) {
		this.firstCakeBottom = firstCakeBottom;
	}
	public String getFirstCream() {
		return firstCream;
	}
	public void setFirstCream(String firstCream) {
		this.firstCream = firstCream;
	}
	public String getSecondCakeBottom() {
		return secondCakeBottom;
	}
	public void setSecondCakeBottom(String secondCakeBottom) {
		this.secondCakeBottom = secondCakeBottom;
	}
	public String getSecondCream() {
		return secondCream;
	}
	public void setSecondCream(String secondCream) {
		this.secondCream = secondCream;
	}
	public String getThirdCakeBottom() {
		return thirdCakeBottom;
	}
	public void setThirdCakeBottom(String thirdCakeBottom) {
		this.thirdCakeBottom = thirdCakeBottom;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getDecor() {
		return decor;
	}
	public void setDecor(String decor) {
		this.decor = decor;
	}
	public String getSprinkle() {
		return sprinkle;
	}
	public void setSprinkle(String sprinkle) {
		this.sprinkle = sprinkle;
	}
	@Override
	public String toString() {
		return "\nTårtans id: " + iD + "\n"
				+ "Tårttyp: " + name;
	}
	
	

	
	
	
}
