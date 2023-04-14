package advance.dev.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import advance.dev.dao.model.Circle;
import advance.dev.dao.model.Rectangle;
import advance.dev.dao.model.Shape;
import advance.dev.dao.model.Triangle;
import advance.dev.util.Constants;

public class ShapeManager implements IShapeManager {
	private List<Shape> shapeList = new ArrayList<Shape>();
	
	public ShapeManager() {
		readFromFile(Constants.FILE_INPUT);
	}
	
	private void readFromFile(String fileInput) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream(fileInput);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = "";
			while((line = br.readLine()) != null) {
				switch (line) {
					case "#circle": 
						shapeList.add(readCircle(br));
						break;
					case "#rect": 
						shapeList.add(readRect(br));
						break;
					case "#triangle": 
						shapeList.add(readTriangle(br));
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + line);
					}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private Shape readTriangle(BufferedReader br) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(br.readLine());
		double b = Double.parseDouble(br.readLine());
		double c = Double.parseDouble(br.readLine());
		return new Triangle(a, b, c);
	}

	private Shape readRect(BufferedReader br) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(br.readLine());
		double b = Double.parseDouble(br.readLine());
		return new Rectangle(a, b);
	}

	private Shape readCircle(BufferedReader br) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double r = Double.parseDouble(br.readLine());
		return new Circle(r);
	}

	@Override
	public List<Shape> all() {
		// TODO Auto-generated method stub
		return shapeList;
	}

	@Override
	public Shape getMaxChuVi() {
		// TODO Auto-generated method stub
		Shape max = shapeList.get(0);
		for (Shape shape : shapeList) {
			if(max.chuVi() < shape.chuVi())
				max = shape;
		}
		
		return max;
	}

	@Override
	public Shape getMaxDienTich() {
		// TODO Auto-generated method stub
		Shape max = shapeList.get(0);
		for (Shape shape : shapeList) {
			if(max.dienTich() < shape.dienTich())
				max = shape;
		}
		
		return max;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
//		Collections.sort(shapeList, new Comparator<Shape>() {
//
//			@Override
//			public int compare(Shape o1, Shape o2) {
//				// TODO Auto-generated method stub
//				if(o1.chuVi() > o2.chuVi()) return 1;
//				if(o1.chuVi() < o2.chuVi()) return -1;
//				
//				return 0;
//			}
//		});
		
		Collections.sort(shapeList);
	}

}
