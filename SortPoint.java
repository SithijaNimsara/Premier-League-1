import java.util.Comparator;

public class SortPoint implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub one, FootballClub two) {
        return one.getPoints()- two.getPoints();
    }
}