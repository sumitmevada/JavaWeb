import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
import com.mysql.jdbc.Connection;
 
import java.sql.*;
import java.util.ArrayList;
 
@WebServlet("/FileUpload")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*5)
public class FileUpload extends HttpServlet {
	private static final String SAVE_DIR="images";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		 String savePath = "/home/ubuntu" + File.separator + SAVE_DIR;
         File fileSaveDir=new File(savePath);
         if(!fileSaveDir.exists()){
             fileSaveDir.mkdir();
         }
	    int rollno= Integer.parseInt(request.getParameter("s_rollno"));
		String firstname = request.getParameter("s_first");
	    String lastname = request.getParameter("s_last");
	    String gender = request.getParameter("gender");
	    String emailid = request.getParameter("s_email");
	    String mobile = request.getParameter("s_mobile");
	    Part file = request.getPart("image");
	    
	    String fileName=extractfilename(file);
	    file.write(savePath + File.separator + fileName);
	    String filePath= savePath + File.separator + fileName ;
	    
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/AppDB","root","root"); 
		    PreparedStatement ps= con.prepareStatement("insert into file_upload(rollno,first_name, last_name,gender,email_id,mobileno,filepath) values (?,?,?,?,?,?,?)");
		    ps.setInt(1,rollno);
		    ps.setString(2,firstname);
		    ps.setString(3,lastname);
		    ps.setString(4,gender);
		    ps.setString(5,emailid);
		    ps.setString(6,mobile);
		    ps.setString(7,filePath);
		    
		    int i=ps.executeUpdate();
		    if(i>0)
		    {
		    	out.print("<h1>file uploaded successfully</h1>");
		    }
		    con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  
		}
 
	 private String extractfilename(Part file) {
        String cd = file.getHeader("content-disposition");
        String[] items = cd.split(";");
        for (String string : items) {
            if (string.trim().startsWith("filename")) {
                return string.substring(string.indexOf("=") + 2, string.length()-1);
            }
        }
        return "";
    }
		
	}