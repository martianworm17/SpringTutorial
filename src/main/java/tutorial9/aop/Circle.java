package tutorial9.aop;

public class Circle {
	private String name;

	public String getName() {
		System.out.println("-------- Circle's getter called. ---------");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("-------- Circle's setter called. ---------");
	}
}
