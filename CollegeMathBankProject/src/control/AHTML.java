package control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AHTML 
{
	public void PrintHTML(HttpServletRequest req, HttpServletResponse res) throws IOException;
	public void ProcessRequest(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
