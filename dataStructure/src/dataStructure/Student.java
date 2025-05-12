package dataStructure;

public class Student {
	private int rno;
	private String name;
	private float m1, m2, m3;

	public Student(int rn, String nm, float mks1, float mks2, float mks3) {
		rno = rn;
		name = nm;
		m1 = mks1;
		m2 = mks2;
		m3 = mks3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getM1() {
		return m1;
	}

	public void setM1(float m1) {
		this.m1 = m1;
	}

	public float getM2() {
		return m2;
	}

	public void setM2(float m2) {
		this.m2 = m2;
	}

	public float getM3() {
		return m3;
	}

	public void setM3(float m3) {
		this.m3 = m3;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public static double getMarksObtained(Student s) {
		double sum = 0.0;
		sum = s.getM1() + s.getM2() + s.getM3();
		return sum;
	}

	public String toString() {

		return "Student [Roll No= " + rno + ", Name = " + name + ", Marks1 = " + m1 + ", Marks2 = " + m2 + ", Marks3 = "
				+ m3 + " ]";
	}

}
