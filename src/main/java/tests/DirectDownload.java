package tests;

import java.io.File;
import java.net.URL;

import com.github.axet.vget.VGet;

public class DirectDownload {

	public static void main(String[] args) {
		try {
			// ex: http://www.youtube.com/watch?v=Nj6PFaDmp6c
			String url = "http://www.youtube.com/watch?v=Nj6PFaDmp6c";
			// ex: "/Users/axet/Downloads"
			String path = "d:\\Downloads\\xxx";
			VGet v = new VGet(new URL(url), new File(path));
			v.download();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}