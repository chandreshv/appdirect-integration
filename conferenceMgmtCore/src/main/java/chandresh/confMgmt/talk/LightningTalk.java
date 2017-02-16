package chandresh.confMgmt.talk;

public class LightningTalk extends Talk{
	
	public static final int LIGHTNING_DURATION=5;

	@Override
	public boolean validateInputAndUpdateTalk(String eachInput) {
		this.setDuration(LIGHTNING_DURATION);
		this.setName(eachInput);
		
		return true;
	}

}
