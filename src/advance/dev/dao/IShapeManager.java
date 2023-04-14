package advance.dev.dao;

import java.util.List;

import advance.dev.dao.model.Shape;

public interface IShapeManager {
	public List<Shape> all();
	public Shape getMaxChuVi();
	public Shape getMaxDienTich();
	public void sort();
}
