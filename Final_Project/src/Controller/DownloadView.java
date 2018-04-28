package Controller;




import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	private File file;

	
	public DownloadView(File file) {
		setContentType("applicationContext/download; utf-8"); 
		this.file=file;
	}


	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		String userAgent = request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE")>-1; //마이크로소프트인터넷익스플로러 이면 인코딩 다 utf-8로 바꿔야함. -1은 true의미
		String fileName = null;
		
		if(ie){
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		}
		else{
			fileName = new String(file.getName().getBytes("utf-8"));
		}

		response.setHeader("Content-Disposition", "attachment; fileName=\""
					+ fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		
		try {
		
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		out.flush();
	}
	
}
