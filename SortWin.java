import java.util.Comparator;

public class SortWin implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub one, FootballClub two) {
        return one.getWins()-two.getWins();
    }


}