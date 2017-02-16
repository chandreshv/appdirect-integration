package chandresh.confMgmt.talk;


public abstract class Talk {
	public static final int MAX_MINS_ALLOWED_FOR_EACH_TALK = 240;
	
	public static final String LIGHTNING = "lightning";
	public static final String MINUTES = "min";
	
	private String name;
	private int duration;
	private String startTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public abstract boolean validateInputAndUpdateTalk(String eachInput) ;
	
	@Override
	public boolean equals(Object o){
		if(this.getName().equals(((Talk)o).getName()) && this.getDuration()==(((Talk)o).getDuration()))
			return true;

		return false;
	}

	public String print() {
		return this.startTime+" "+this.name;
	}



	
	
	
}
