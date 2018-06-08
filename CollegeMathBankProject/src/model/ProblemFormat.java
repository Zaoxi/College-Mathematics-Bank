package model;

// db에서 읽어온 문제 하나를 저장하는 형식 클래스
public class ProblemFormat {
	private String content;
	private String imagePath;
	private String solution;
	private String rightAnswer;
	private String rightAnswerImagePath;
	
	public ProblemFormat(String _content, String _imagePath, String _solution, String _rightAnswer, String _rightAnswerImagePath)
	{
		content = _content;
		imagePath = _imagePath;
		solution = _solution;
		rightAnswer = _rightAnswer;
		rightAnswerImagePath = _rightAnswerImagePath;
	}
	
	public String GetContent()
	{
		return content;
	}
	public String GetImagePath()
	{
		return imagePath;
	}
	public String GetSolution()
	{
		return solution;
	}
	public String GetRightAnswer()
	{
		return rightAnswer;
	}
	public String GetRightAnswerImagePath()
	{
		return rightAnswerImagePath;
	}
}
