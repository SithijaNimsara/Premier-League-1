import java.io.FileNotFoundException;
import java.io.IOException;
public interface LeagueManager {

	void addMember();
    	void deleteMember();
    	void displayMember();
	String repeat(String str, int integer);
    	void cliTableView();
    	void startFileWriter() throws FileNotFoundException;
    	void fileWriter() throws IOException;
    	void startPlayedFileWriter() throws FileNotFoundException;
    	void addPlayedMatch() throws IOException;
    	void playedFileWriter(String club1, int score1, String club2, int score2, int yr, int mon, int date) throws IOException;
    	void logic(int score1,int i, int score2, int j);
    	void guiTableView();
    	void gui();
    	String guiRMatch() throws IOException;
    	String sortPlayedMatch();
    	String searchGui(int year, int month, int date);
}
