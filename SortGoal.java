import java.util.Comparator;

public class SortGoal implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub one, FootballClub two) {
        return one.getGoals()-two.getGoals();
    }
}