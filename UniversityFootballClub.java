public class UniversityFootballClub extends FootballClub {

	private String universityName;
    	private String universityLocation;
    	private String degreeType;

    	public UniversityFootballClub() {
    	}
    
    	public UniversityFootballClub(String clubName, String clubLocation, int wins, int draws, int defeats, int goals, int score, int points, int matchesPlayed, String universityName, String universityLocation, String degreeType) {
		super(clubName, clubLocation, wins, draws, defeats, goals, score, points, matchesPlayed);
        	this.universityName = universityName;
        	this.universityLocation = universityLocation;
        	this.degreeType = degreeType;
    	}

    	public String getUniversityName() {
        	return universityName;
    	}

    	public void setUniversityName(String universityName) {
        	this.universityName = universityName;
    	}

    	public String getUniversityLocation() {
        	return universityLocation;
    	}

    	public void setUniversityLocation(String universityLocation) {
        	this.universityLocation = universityLocation;
    	}

    	public String getDegreeType() {
        	return degreeType;
    	}

    	public void setDegreeType(String degreeType) {
        	this.degreeType = degreeType;
    	}

	@Override
    	public String toString() {
        	return "SchoolFoodballClub{" + "universityName='" + universityName + '\'' + ", universityLocation='" + universityLocation + '\'' + ", degreeType='" + degreeType + '\'' + '}';
    	}
}