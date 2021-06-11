public class FootballClub extends SportClub{
	private int wins;
    	private int draws;
    	private int defeats;
    	private int goals;
    	private int score;
    	private int points;
    	private int matchesPlayed;

	//default constructer
    	public FootballClub() {
    	}

	public FootballClub(String clubName, int wins, int draws, int defeats, int goals, int score, int points, int matchesPlayed) {
        	super(clubName);
        	this.wins = wins;
        	this.draws = draws;
        	this.defeats = defeats;
        	this.goals = goals;
        	this.score = score;
        	this.points = points;
        	this.matchesPlayed = matchesPlayed;
    	}

	
    	public FootballClub(String clubName, String clubLocation, int wins, int draws, int defeats, int goals, int score, int points, int matchesPlayed) {
        	super(clubName, clubLocation);
        	this.wins = wins;
        	this.draws = draws;
        	this.defeats = defeats;
        	this.goals = goals;
        	this.score = score;
        	this.points = points;
        	this.matchesPlayed = matchesPlayed;
    	}
	//get the wins
    	public int getWins() {
        	return wins;
    	}
	//set the wins to the variable
    	public void setWins(int wins) {
        	this.wins = wins;
    	}
	//get the draws
    	public int getDraws() {
        	return draws;
    	}
	//set the draws to the variable
    	public void setDraws(int draws) {
        	this.draws = draws;
    	}
	//get the defeat
    	public int getDefeats() {
        	return defeats;
    	}
	//set the defeat to the variable
    	public void setDefeats(int defeats) {
        	this.defeats = defeats;
    	}
	//get the goals
    	public int getGoals() {
        	return goals;
    	}
	//set the goals to the variable
    	public void setGoals(int goals) {
        	this.goals = goals;
    	}
	//get the scores
    	public int getScore() {
        	return score;
    	}
	//set the scores to the variable
    	public void setScore(int score) {
        	this.score = score;
    	}
	//get the point
    	public int getPoints() {
        	return points;
    	}
	//set the point to the variable
    	public void setPoints(int points) {
        	this.points = points;
    	}
	//get the played matches
    	public int getMatchesPlayed() {
        	return matchesPlayed;
    	}
	//set the played matches to the variable
    	public void setMatchesPlayed(int matchesPlayed) {
        	this.matchesPlayed = matchesPlayed;
    	}

    	@Override
    	public String toString() {
        	return "FootballClub{" + "wins=" + wins + ", draws=" + draws + ", defeats=" + defeats + ", goals=" + goals + ", score=" + score + ", points=" + points + ", matchesPlayed=" + matchesPlayed + '}';
    	}
}
