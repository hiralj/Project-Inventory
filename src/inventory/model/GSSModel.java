package inventory.model;

import inventory.presenter.DefaultPresenter;

/**
 * 
 * @author admin
 * 
 *         Used while creating 1. New Grade 2. New Material i.e. GSS Combination
 */
public class GSSModel extends AbstractModel {
	private String grade;
	private String shape;
	private float size;
	private float size2;
	private GSSModel material;

	public GSSModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GSSModel(String grade, String shape, float size, float size2) {
		super();
		this.grade = grade;
		this.shape = shape;
		this.size = size;
		this.size2 = size2;
	}


	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		String oldGrade = this.grade;
		this.grade = grade;		
		firePropertyChange(DefaultPresenter.GSS_GRADE_PROPERTY, oldGrade, grade);
	}

	public GSSModel getMaterial() {
		return material;
	}

	public void setMaterial(GSSModel material) {
		GSSModel oldMaterial = this.material;
		this.material = material;
		firePropertyChange(DefaultPresenter.GSS_MATERIAL_PROPERTY, oldMaterial, material);
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public float getSize2() {
		return size2;
	}

	public void setSize2(float size2) {
		this.size2 = size2;
	}

}
