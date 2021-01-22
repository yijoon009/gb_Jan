package myday03;

//상속을 막아주는 final 키워드 사용
public final class Tri extends Shape {

	@Override
	public double getArea(double w, double h) {
		area = w * h /2;
		return area;
	}
	
	
}
