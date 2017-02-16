package chandresh.confMgmt.util;

import static chandresh.confMgmt.util.Printer.printOnConsole;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import chandresh.confMgmt.conference.Conference;

public class WriteOutput {
	public static final String FILE_PATH= System.getProperty("user.dir")+"\\Output\\Output-";
	
	public void writeOutputToFile(Conference conf, String inpFileName) {
		try {

			File file = new File(FILE_PATH+inpFileName);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),false);
			BufferedWriter bw = new BufferedWriter(fw);
			List<String> scheduledTalks = conf.print();
			
			for(String eachTalk:scheduledTalks){
				bw.newLine();
				bw.write(eachTalk);
			}
			
			bw.close();
			printOnConsole("Output created at "+ file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
