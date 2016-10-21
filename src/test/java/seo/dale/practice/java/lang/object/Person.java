package seo.dale.practice.java.lang.object;

public class Person {

	private long id;

	private String name;

	private int age;

	public Person(long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		String str = "" + getId() + getName() + getAge();
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Person that = (Person) obj;

		return this.getId() == that.getId()
				&& this.getName().equals(that.getName())
				&& this.getAge() == that.getAge();
	}

}
