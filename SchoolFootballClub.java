public class SchoolFootballClub extends FootballClub {

	private String schoolName;
    	private String schoolLocation;
    	private String grade;
	//default constructer
    	public SchoolFoodballClub() {
    	}

    	public SchoolFoodballClub(String clubName, String clubLocation, int wins, int draws, int defeats, int goals, int score, int points, int matchesPlayed, String schoolName, String schoolLocation, String grade) {
		super(clubName, clubLocation, wins, draws, defeats, goals, score, points, matchesPlayed);
        	this.schoolName = schoolName;
        	this.schoolLocation = schoolLocation;
        	this.grade = grade;
    	}

	//get the school name
    	public String getSchoolName() {
        	return schoolName;
    	}
	//set the school name to the variable
    	public void setSchoolName(String schoolName) {
        	this.schoolName = schoolName;
    	}
	//get the school location
    	public String getSchoolLocation() {
        	return schoolLocation;
    	}
	//set the school location to the variable
    	public void setSchoolLocation(String schoolLocation) {
        	this.schoolLocation = schoolLocation;
    	}
	//get the grade
    	public String getGrade() {
        	return grade;
    	}
	//set the grade to the variable
    	public void setGrade(String grade) {
        	this.grade = grade;
    	}

	@Override
    	public String toString() {
        	return "SchoolFoodballClub{" + "schoolName='" + schoolName + '\'' + ", schoolLocation='" + schoolLocation + '\'' + ", grade='" + grade + '\'' + '}';
    	}
}
