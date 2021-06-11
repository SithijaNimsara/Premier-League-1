public class SportClub {

	private String clubName;
    	private String clubLocation;
	//default constructor
    	public SportClub() {
    	}
	
	public SportClub(String clubName) {
        	this.clubName = clubName;
	}

    	public SportClub(String clubName, String clubLocation) {
        	this.clubName = clubName;
        	this.clubLocation = clubLocation;
    	}
	//get the club name
    	public String getClubName() {
        	return clubName;
    	}
	
	//set the club name to the variable
    	public void setClubName(String clubName) {
        	this.clubName = clubName;
    	}
	
	//get the club location
    	public String getClubLocation() {
        	return clubLocation;
    	}
	
	//set the club location to the variable
    	public void setClubLocation(String clubLocation) {
        	this.clubLocation = clubLocation;
    	}

    	@Override
    	public String toString() {
        	return "SportClub{" + "clubName='" + clubName + '\'' + ", clubLocation='" + clubLocation + '\'' + '}';
    	}
}

