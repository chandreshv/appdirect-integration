package chandresh.confMgmt.talk;

import static chandresh.confMgmt.util.Printer.printOnConsole;

public class GeneralTalk extends Talk{

	@Override
	public boolean validateInputAndUpdateTalk(String inpTalk) {
		String[] talkTokens = inpTalk.split(" ");
		int duration=0;
		
		try{
			String durationStr = talkTokens[talkTokens.length - 1];
			duration = Integer.parseInt(durationStr.substring(0, durationStr.length()-Talk.MINUTES.length()));
		}catch(NumberFormatException nfe){
			printOnConsole("Duration of input talk '"+inpTalk+"' is missing or not supported");
			return false;
		}
		
		//Validate duration range
		if (duration > 0 && duration <= Talk.MAX_MINS_ALLOWED_FOR_EACH_TALK) {
			this.setDuration(duration);
			this.setName(inpTalk);
		} else {
			printOnConsole("Talk '"
					+ inpTalk
					+ "' cannot be scheduled as it does not fall in the allowed time limit "
					+ "( 0 to "
					+ Talk.MAX_MINS_ALLOWED_FOR_EACH_TALK + ")");
			return false;
		}
		
		return true;
	}

}
