package chandresh.confMgmt.talk;

/**
 * @author CHANDREV
 * Factory class for generating the instance of Talk type
 */
public class TalkFactory {

	public static Talk getTalkInstance(String talkType){
		if(talkType==null)
			return null;
		
		if(talkType.equals(Talk.LIGHTNING))
			return new LightningTalk();
		else if(talkType.contains((CharSequence) Talk.MINUTES))
			return new GeneralTalk(); 
		
		return null;
	}
}
