package exam.finale.exam4c.p1;

public class Stamp {

	private String description;
	private int faceValue;
	private double appraisedValue;

	public Stamp(String description, int faceValue, double appraisedValue) {
		this.description = description;
		this.faceValue = faceValue;
		this.appraisedValue = appraisedValue;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(description).append(", ");
		sb.append("face value: ").append(this.faceValue).append(" cents, ");
		sb.append("appraised value: ").append(this.appraisedValue).append(
				" dollars");

		return sb.toString();
	}

	public String getDescription() {
		return description;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public double getAppraisedValue() {
		return appraisedValue;
	}

	public void setAppraisal(double value) {
		appraisedValue = value;

	}
}
