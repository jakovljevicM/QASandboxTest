package test.ui.pages.objects;

import java.util.List;

public class UseCase {
	
	private String title;
	private String description;
	private String expectedResult;
	private List<String> steps;
	private boolean automated;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	public List<String> getSteps() {
		return steps;
	}
	public void setSteps(List<String> steps) {
		this.steps = steps;
	}
	public boolean isAutomated() {
		return automated;
	}
	public void setAutomated(boolean automated) {
		this.automated = automated;
	}
	
	
 
}
