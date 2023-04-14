package advance.dev;

import advance.dev.dao.IShapeManager;
import advance.dev.dao.ShapeManager;
import advance.dev.dao.model.Shape;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IShapeManager shapeManager = new ShapeManager();
		for (Shape shape : shapeManager.all()) {
			System.out.println(shape);
		}
		
		System.out.println("Hinh co chu vi lon nhat");
		System.out.println(shapeManager.getMaxChuVi());

		System.out.println("Hinh co dien tich lon nhat");
		System.out.println(shapeManager.getMaxDienTich());
	}

}
