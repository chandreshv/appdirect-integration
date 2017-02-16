package chandresh.confMgmt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import chandresh.confMgmt.talk.Talk;
import chandresh.confMgmt.talk.TalkFactory;
import static chandresh.confMgmt.util.Printer.printOnConsole;
public class InputParser {
	
	
	public static final String VALID_INPUT_FILE_XTNS="txt";
	public static final String VALID_INPUT_FILE_XTNS_SEPARATOR=",";

	public List<Talk> parseInput(File inp) throws IllegalArgumentException {
		
		validateInputFile(inp);
		List<String> inputList = getInputListFromFile(inp);
		return getAllTalkList(inputList);

	}

	public List<Talk> getAllTalkList(List<String> inputList) {
		//Convert each line to talk object
		List<Talk> allTalks = new ArrayList<Talk>();
		for (String eachInput : inputList) {

			String[] inpTokens = eachInput.split(" ");
			if (inpTokens.length > 0) {
				String duration = inpTokens[inpTokens.length - 1];

				Talk talk = TalkFactory.getTalkInstance(duration);
				if (talk != null) {
					if (talk.validateInputAndUpdateTalk(eachInput)) {
						allTalks.add(talk);
					}
				}else{
					printOnConsole("Duration of input talk '"+eachInput+"' is missing or not supported");
				}
			}
		}

		return allTalks;

	}

	/**
	 * @param inp
	 * @return List<String> List of Talks from Input file
	 */
	private List<String> getInputListFromFile(File inp) {
		BufferedReader br = null;
		List<String> inputList = new ArrayList<String>();
		try {
			String eachLine;
			br = new BufferedReader(new FileReader(inp));
			while ((eachLine = br.readLine()) != null) {
				inputList.add(eachLine);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("No such file exist");
		} catch (IOException e) {
			throw new IllegalArgumentException("IOException");
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				throw new IllegalArgumentException("IOException");
			}
		}

		return inputList;

	}

	private void validateInputFile(File inp) {
		
		//print("Validating input file and format");
		
		if (inp == null){
			printOnConsole("Invalid input file: NULL");
			throw new IllegalArgumentException("Invalid input file: NULL");
		}
		
		//Validate file format
		String fileName = inp.getName();
		String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
		String validInpFileXtnsList[] = VALID_INPUT_FILE_XTNS.split(VALID_INPUT_FILE_XTNS_SEPARATOR);
		boolean isXtnValid = false;
		
		for(String eachXtn:validInpFileXtnsList){
			if(eachXtn.equals(extension)){
				isXtnValid=true;
				break;
			}
		}
		
		if (!isXtnValid){
			printOnConsole("Invalid input file format. Allowed extensions are "+ VALID_INPUT_FILE_XTNS);
			throw new IllegalArgumentException("Invalid input file format. Allowed extensions are "+ VALID_INPUT_FILE_XTNS);
		}

	}

}
