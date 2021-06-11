import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {
    //create a array list
    public ArrayList<FootballClub> array = new ArrayList<>();

    public void addMember() {
        Scanner scan = new Scanner(System.in);
	//get the club name
        System.out.println("Enter the club name:");
	//convert the name into uppercase
        String club = scan.next().toUpperCase();
	//get the club location
        System.out.println("Enter the location:");
	//convert the location into uppercase
        String location = scan.next().toUpperCase();
	//add other statistic as zero
        array.add(new FootballClub(club,location,0,0,0,0,0,0,0));

    }

    public void deleteMember() {
        Scanner scan = new Scanner(System.in);
	//get the club name which need to delete
        System.out.println("Enter the club name that you want to delete:");
	//convert the name into uppercase
        String club = scan.next().toUpperCase();
        //int integer = array.indexOf(club);
	//delete the details from the array list
        for (int i=0; i<array.size(); i++) {
            if (club.equals(array.get(i).getClubName())) {
                array.remove(i);
                break;
            }
            else if (i==array.size()-1) {
                System.out.println("Club can't found.");
            }
        }

    }

    public void displayMember() {
        Scanner scan = new Scanner(System.in);
	//get the club name which need to display
        System.out.println("Enter the club name that you want to display:");
        String club = scan.next().toUpperCase();

        for (int i=0; i<array.size(); i++) {
            if (club.equals(array.get(i).getClubName())) {
                System.out.println("Wins: " + array.get(i).getWins());
                System.out.println("Draws: " + array.get(i).getDraws());
                System.out.println("Defeats: " + array.get(i).getDefeats());
                System.out.println("Goals: " + array.get(i).getGoals());
                System.out.println("Scores: " + array.get(i).getScore());
                System.out.println("Points: " + array.get(i).getPoints());
                System.out.println("Matches played: " + array.get(i).getMatchesPlayed());
                break;
            }
            else if (i==array.size()-1) {
		//if the the user insert wrong club name
                System.out.println("Club can't found.");
            }
        }

    }

    //append string by using string builder
    public String repeat(String str, int integer){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < integer; i++) {
            string.append(str);
        }
        return string.toString();
    }

    public void cliTableView() {
	//sort the array into point then sort the array into goals
        array.sort(new SortPoint().reversed().thenComparing(new SortGoal().reversed()));
	//array list to array
        Object[][] data = new Object[array.size()][8];

        for (int i=0; i<array.size(); i++) {
            data[i][0] = array.get(i).getClubName();
            data[i][1] = array.get(i).getWins();
            data[i][2] = array.get(i).getDraws();
            data[i][3] = array.get(i).getDefeats();
            data[i][4] = array.get(i).getGoals();
            data[i][5] = array.get(i).getScore();
            data[i][6] = array.get(i).getPoints();
            data[i][7] = array.get(i).getMatchesPlayed();
        }

        for (int i=0; i<8; i++) {
            String string =  repeat("-",13);
            System.out.print("+" + string);
        }

        System.out.print("+");
        System.out.println();

        System.out.print("| "+"Club        "+ "| "+"Wins        "+ "| "+"Draws       "+"| "+ "Defeats     "+"| "+ "Goals       "+ "| "+"Scores      "+ "| "+"Points      "+ "| "+"MatchesPlay "+ "|");
        System.out.println();

        for (int i=0; i<8; i++) {
            String string =  repeat("-",13);
            System.out.print("+" + string);
        }

        System.out.print("+");
        System.out.println();

        for(int i=0; i<array.size(); i++) {
            int len = 0;
            for (int j=0; j<8; j++) {
                if (j==0) {
                    String str = (String) data[i][j];
                    len = 12 - str.length();
                    String string = repeat(" ",len);
                    System.out.print("| " + data[i][j] + string);
                }
                else  {
                    int  integer1 = (int) data[i][j];
                    len = 12 - Integer.toString(integer1).length();
                    String string = repeat(" ",len);
                    System.out.print("| " + data[i][j] +  string);
                }
            }
            System.out.print("|");
            System.out.println();
        }

        for (int i=0; i<8; i++) {
            String string =  repeat("-",13);
            System.out.print("+" + string);
        }
        System.out.print("+");
        System.out.println();
    }

    public void startFileWriter() throws FileNotFoundException {
	//read the file and add to the array list
        Scanner scan = new Scanner(new File("File (Win Draw Defeat Goal Score Point PlyMatch).txt"));
        while (scan.hasNext()) {
            String club = scan.next();
            String location = scan.next();
            int wins = Integer.parseInt(scan.next());
            int draw = Integer.parseInt(scan.next());
            int defeat = Integer.parseInt(scan.next());
            int goals = Integer.parseInt(scan.next());
            int score = Integer.parseInt(scan.next());
            int point = Integer.parseInt(scan.next());
            int matches = Integer.parseInt(scan.next());
            array.add(new FootballClub(club,location,wins,draw,defeat,goals,score,point,matches));

        }
    }


    public void fileWriter() throws IOException {
	//print to the file from the array list
        FileWriter writer = null;
        PrintWriter printer = null;
        try {
            writer = new FileWriter("File (Win Draw Defeat Goal Score Point PlyMatch).txt");
            printer = new PrintWriter(writer,true);
            for (FootballClub footballClub : array) {
                printer.print(footballClub.getClubName() + " ");
                printer.print(footballClub.getClubLocation() + " ");
                printer.print(footballClub.getWins() + " ");
                printer.print(footballClub.getDraws() + " ");
                printer.print(footballClub.getDefeats() + " ");
                printer.print(footballClub.getGoals() + " ");
                printer.print(footballClub.getScore() + " ");
                printer.print(footballClub.getPoints() + " ");
                printer.println(footballClub.getMatchesPlayed() + " ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        writer.close();
        printer.close();
    }

    ArrayList<String> playArray = new ArrayList<>();
    public void startPlayedFileWriter() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("FilePlayed (Club1 Club2 Date).txt"));
        while (scan.hasNext()) {
            playArray.add(scan.next());
        }
    }

    public void playedFileWriter(String club1, int score1, String club2, int score2, int yr, int mon, int date) throws IOException {
        FileWriter playWriter = null;
        PrintWriter playPrinter = null;
        try {
            playWriter = new FileWriter("FilePlayed (Club1 Club2 Date).txt",true);
            playPrinter = new PrintWriter(playWriter,true);
            playPrinter.println(club1+" "+score1+" "+club2+" "+score2+" "+yr+"-"+mon+"-"+date);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        playWriter.close();
        playPrinter.close();
    }

    //add a played match 
    public void addPlayedMatch() throws IOException {
        Scanner scan = new Scanner(System.in);
        Date day = new Date();
        boolean loop = true;
        int year = 0;
        int month = 0;
        int date = 0;
        while (loop) {
            try {
                System.out.println("Enter the year:");
                year = Integer.parseInt(scan.nextLine());
                day.setYear(year);
                year=day.getYear();
                System.out.println("Enter the month:");
                month = Integer.parseInt(scan.nextLine());
                day.setMonth(month);
                month=day.getMonth();
                System.out.println("Enter the date:");
                date = Integer.parseInt(scan.nextLine());
                day.setDate(date);
                date=day.getDate();
            }
            catch (NumberFormatException i) {
                System.out.println(i);
            }
            if (year!=0 && month!=0 && date!=0) {
                loop=false;
            }
            else {
                System.out.println("Invalid input. Try again !!!");
            }

        }

        System.out.println("Enter the first club name:");
        String club1 = scan.next().toUpperCase();
        String club2 = null;
        int i=0;
        int j=0;
        for (i=0; i<array.size(); i++) {
            if (club1.equals(array.get(i).getClubName())) {
                System.out.println("Enter the second club name:");
                club2 = scan.next().toUpperCase();
                for (j=0; j<array.size(); j++) {
                    if (club2.equals(array.get(j).getClubName())) {
                        break;
                    }
                    else if (j==array.size()-1) {
                        System.out.println("Club can't found.");
                        club2 = null;
                    }
                }
                break;
            }
            else if (i==array.size()-1) {
                System.out.println("Club can't found.");
                club1 = null;
            }
        }

        int score1 = 0;
        int score2 = 0;
        if (club1 != null && club2 != null) {
            System.out.println("Enter the first club's score:");
            score1 = scan.nextInt();
            System.out.println("Enter the second club's score:");
            score2 = scan.nextInt();
            logic(score1,i,score2,j);
        }
	//add data to the file
        playedFileWriter(club1,score1,club2,score2,year,month,date);
    }

    //update statistic when match played
    public void logic(int score1,int i, int score2, int j) {
        if (score1>score2) {
            array.get(i).setWins(array.get(i).getWins()+1);
            array.get(i).setGoals(array.get(i).getGoals()+score2);
            array.get(i).setScore(array.get(i).getScore()+score1);
            array.get(i).setPoints(array.get(i).getPoints()+1);
            array.get(i).setMatchesPlayed(array.get(i).getMatchesPlayed()+1);

            array.get(j).setDefeats(array.get(j).getDefeats()+1);
            array.get(j).setGoals(array.get(j).getGoals()+score1);
            array.get(j).setScore(array.get(j).getScore()+score2);
            array.get(j).setPoints(array.get(j).getPoints());
            array.get(j).setMatchesPlayed(array.get(j).getMatchesPlayed()+1);

        }
        else if (score1<score2) {
            array.get(i).setDefeats(array.get(i).getDefeats()+1);
            array.get(i).setGoals(array.get(i).getGoals()+score2);
            array.get(i).setScore(array.get(i).getScore()+score1);
            array.get(i).setPoints(array.get(i).getPoints());
            array.get(i).setMatchesPlayed(array.get(i).getMatchesPlayed()+1);

            array.get(j).setWins(array.get(j).getWins()+1);
            array.get(j).setGoals(array.get(j).getGoals()+score1);
            array.get(j).setScore(array.get(j).getScore()+score2);
            array.get(j).setPoints(array.get(j).getPoints()+1);
            array.get(j).setMatchesPlayed(array.get(j).getMatchesPlayed()+1);
        }

        else {
            array.get(i).setDraws(array.get(i).getDraws()+1);
            array.get(i).setGoals(array.get(i).getGoals()+score2);
            array.get(i).setScore(array.get(i).getScore()+score1);
            array.get(i).setMatchesPlayed(array.get(i).getMatchesPlayed()+1);

            array.get(j).setDraws(array.get(j).getDraws()+1);
            array.get(j).setGoals(array.get(j).getGoals()+score1);
            array.get(j).setScore(array.get(j).getScore()+score2);
            array.get(j).setMatchesPlayed(array.get(j).getMatchesPlayed()+1);
        }
    }


    //display the gui
    public void gui() {

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Premier League");
        AnchorPane aPane = new AnchorPane();
	aPane.setStyle("-fx-background-color:  #990000");
        Pane pane = new Pane();
        Scene scene = new Scene(aPane,600,500);
        Button btnTable = new Button("Table");

        Label lblTopic = new Label("Premier League");
        lblTopic.setLayoutX(140);
        lblTopic.setLayoutY(25);
        lblTopic.setFont(new Font("1 Style", 50));
        lblTopic.setStyle("-fx-text-fill: #000066");

        btnTable.setLayoutX(125);
        btnTable.setLayoutY(150);
        btnTable.setPrefWidth(100);

        Button btnRMatch = new Button("Random Match");
        btnRMatch.setLayoutX(125);
        btnRMatch.setLayoutY(235);
        btnRMatch.setPrefWidth(100);

        Button btnSortM = new Button("Sort Matches");
        btnSortM.setLayoutX(125);
        btnSortM.setLayoutY(315);
        btnSortM.setPrefWidth(100);

        Button btnSearch = new Button("Search");
        btnSearch.setLayoutX(400);
        btnSearch.setLayoutY(400);
        btnSearch.setPrefWidth(100);

        Label lblYear = new Label("Year");
        lblYear.setLayoutX(90);
        lblYear.setLayoutY(405);
	lblYear.setStyle("-fx-text-fill:  #ff9900");

        Label lblMonth = new Label("Month");
        lblMonth.setLayoutX(205);
        lblMonth.setLayoutY(405);
	lblMonth.setStyle("-fx-text-fill:  #ff9900");

        Label lblDate = new Label("Date");
        lblDate.setLayoutX(295);
        lblDate.setLayoutY(405);
	lblDate.setStyle("-fx-text-fill:  #ff9900");

        TextField txtYear =new TextField();
        txtYear.setLayoutX(125);
        txtYear.setLayoutY(400);
        txtYear.setPrefSize(55,25);

        TextField txtMonth =new TextField();
        txtMonth.setLayoutX(245);
        txtMonth.setLayoutY(400);
        txtMonth.setPrefSize(30,25);

        TextField txtDate =new TextField();
        txtDate.setLayoutX(325);
        txtDate.setLayoutY(400);
        txtDate.setPrefSize(30,25);


        TextArea txtArea = new TextArea();
        txtArea.setLayoutX(300);
        txtArea.setLayoutY(150);
        txtArea.setPrefSize(200,200);

        pane.getChildren().addAll(lblTopic,btnTable,btnRMatch,btnSortM,btnSearch,txtArea,lblYear,lblMonth,lblDate,txtYear,txtMonth,txtDate);

        aPane.getChildren().add(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
	
	//table button action
        btnTable.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                guiTableView();
            }
        });

	//random match button action
        btnRMatch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    txtArea.setText(guiRMatch());
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    fileWriter();
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });

	//sort button action
        btnSortM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtArea.setText(sortPlayedMatch());
            }
        });

	//search button action
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int year =0;
                int month = 0;
                int date = 0;
                try {
                    	year = Integer.parseInt(txtYear.getText());
                    	month = Integer.parseInt(txtMonth.getText());
                    	date = Integer.parseInt(txtDate.getText());
                }catch (NumberFormatException i) {
                    	txtArea.setText("Enter the values");
                }
                String finalDate = searchGui(year,month,date);
                StringBuilder strSearch = new StringBuilder();
                int i=4;
                while (i<playArray.size()) {
                    if (playArray.get(i).equals(finalDate)){
                        strSearch.append("\nDate:").append(playArray.get(i)).append("\nFirst club name:").append(playArray.get(i-4)).append("\nFirst club score:").append(playArray.get(i-3)).append("\nSecond club name:").append(playArray.get(i-2)).append("\nSecond club score:").append(playArray.get(i-1)).append("\n");
                    }
                    i+=5;
                }
                txtArea.setText(strSearch.toString());
            }
        });
    }

    //gui table in a new window
    public void guiTableView() {

        Stage stage2 = new Stage();
        AnchorPane aPane = new AnchorPane();
	aPane.setStyle("-fx-background-color:  #990000");
        Pane pane = new Pane();
        Scene scene = new Scene(aPane,500,600);

        Label topic = new Label("Table");
        topic.setLayoutX(200);
        topic.setFont(Font.font(40));
	topic.setStyle("-fx-text-fill: #000066");

        TableView<FootballClub> table = new TableView<FootballClub>();
        table.setLayoutY(75);
        //Observable data = (Observable) FXCollections.observableArrayList(array);

        TableColumn<FootballClub, String> club= new TableColumn<>("Club Name");
        club.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub, Integer> wins= new TableColumn<>("Wins");
        wins.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<FootballClub, Integer> draws= new TableColumn<>("Draws");
        draws.setCellValueFactory(new PropertyValueFactory<>("draws"));

        TableColumn<FootballClub, Integer> defeats= new TableColumn<>("Defeats");
        defeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));

        TableColumn<FootballClub, Integer> goals= new TableColumn<>("Goals");
        goals.setCellValueFactory(new PropertyValueFactory<>("goals"));

        TableColumn<FootballClub, Integer> scores= new TableColumn<>("Scores");
        scores.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<FootballClub, Integer> points= new TableColumn<>("Points");
        points.setCellValueFactory(new PropertyValueFactory<>("points"));

        TableColumn<FootballClub, Integer> matchesP= new TableColumn<>("Matches P");
        matchesP.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        table.getColumns().addAll(club,wins,draws,defeats,goals,scores,points,matchesP);

        array.sort(new SortPoint().reversed());
        for (FootballClub footballClub : array) {
            table.getItems().add(new FootballClub(footballClub.getClubName(), footballClub.getWins(), footballClub.getDraws(), footballClub.getDefeats(), footballClub.getGoals(), footballClub.getScore(), footballClub.getPoints(), footballClub.getMatchesPlayed()));
        }

        Button btnGoal = new Button("Goal");
        btnGoal.setLayoutX(0);
        btnGoal.setLayoutY(500);
        btnGoal.setPrefSize(75,25);

        Button btnWin = new Button("Win");
        btnWin.setLayoutX(100);
        btnWin.setLayoutY(500);
        btnWin.setPrefSize(75,25);

        table.setEditable(true);
        pane.getChildren().addAll(topic,btnGoal,btnWin);
        pane.getChildren().add(table);
        aPane.getChildren().add(pane);
        stage2.setScene(scene);
        stage2.show();

	//goal button action
        btnGoal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i=0; i<array.size(); i++) {
                    table.getItems().clear();
                }
                array.sort(new SortGoal().reversed());
                for (FootballClub footballClub : array) {
                    table.getItems().add(new FootballClub(footballClub.getClubName(), footballClub.getWins(), footballClub.getDraws(), footballClub.getDefeats(), footballClub.getGoals(), footballClub.getScore(), footballClub.getPoints(), footballClub.getMatchesPlayed()));
                }
            }
        });

	//win button action
        btnWin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i=0; i<array.size(); i++) {
                    table.getItems().clear();
                }
                array.sort(new SortWin().reversed());
                for (FootballClub footballClub : array) {
                    table.getItems().add(new FootballClub(footballClub.getClubName(), footballClub.getWins(), footballClub.getDraws(), footballClub.getDefeats(), footballClub.getGoals(), footballClub.getScore(), footballClub.getPoints(), footballClub.getMatchesPlayed()));

                }
            }
        });
    }

    //return random match details to text area as a string
    public  String  guiRMatch() throws IOException {
        Random random = new Random();
        int intClub1 = 0;
        int intClub2 = 0;
        do {
            intClub1 = random.nextInt(array.size());
            intClub2 = random.nextInt(array.size());
        } while (intClub1 == intClub2);
        String club1 = array.get(intClub1).getClubName();
        String club2 = array.get(intClub2).getClubName();

        int score1 = random.nextInt(16);
        int score2 = random.nextInt(16);
        logic(score1,intClub1,score2,intClub2);
        int year = 0;
        int month =0;
        int day = 0;
        while (true) {
            year = random.nextInt((2020 - 2000) + 1) + 2000;
            month = random.nextInt((12 - 1) + 1) + 1;
            day = random.nextInt((31 - 1) + 1) + 1;

            Date date = new Date();
            date.setYear(year);
            date.setMonth(month);
            date.setDate(day);

            if (date.getYear()!=0 && date.getMonth()!=0 && date.getDate()!=0) {
                break;
            }
        }
        playedFileWriter(club1,score1,club2,score2,year,month,day);

        return "\n"+year+"-"+month+"-"+day+"\nFirst club name:"+club1+"\nSecond club name:"+club2+"\nFirst club score:"+score1+"\nSecond club score:"+score2+"\n";
    }

    //return all the matches sorted details to text area as a string
    public String sortPlayedMatch() {
        System.out.println(playArray);
        int i = 4;
        while (i < playArray.size()) {
            int j = 4;
            while (j < playArray.size() - i) {

                //compare two string with the ASCII value
                if (playArray.get(j).compareTo(playArray.get(j + 5)) > 0) {

                    //get the small ASCII value and their other details to a another string from the array list
                    String club1 = playArray.get(j + 1);
                    String score1 = playArray.get(j + 2);
                    String club2 = playArray.get(j + 3);
                    String score2 = playArray.get(j + 4);
                    String date = playArray.get(j + 5);

                    //remove the small ASCII value and their other details from the array list

                    for (int k=0; k<5; k++) {
                        playArray.remove(j + 1);
                    }

                    //add the details correct place which are deleted
                    playArray.add(j-4, club1);
                    playArray.add(j-3, score1);
                    playArray.add(j-2, club2);
                    playArray.add(j-1, score2);
                    playArray.add(j , date);
                }
                j = j + 5;
            }
            i = i + 5;
        }
        StringBuilder strSort = new StringBuilder();
        System.out.println(playArray);
        int k=0;
        while (k<playArray.size()-5) {
            strSort.append("\nDate:").append(playArray.get(k + 4)).append("\nFirst club name:").append(playArray.get(k)).append("\nFirst club score:").append(playArray.get(k + 1)).append("\nSecond club name:").append(playArray.get(k + 2)).append("\nSecond club score:").append(playArray.get(k + 3)).append("\n");
            k+=5;
        }
        return strSort.toString();
    }

    //validate the dates and return the data as a string
    public String searchGui(int year, int month, int date) {
        String search = null;
        Date day = new Date();
        day.setYear(year);
        day.setMonth(month);
        day.setDate(date);
        if (day.getYear()==0 || day.getMonth()==0 || day.getDate()==0) {
            search = "Invalid input !!!"+"\n Try again";
        }

        StringBuilder strBuild = new StringBuilder();
        strBuild.append(day.getYear()).append("-").append(day.getMonth()).append("-").append(day.getDate());

        return strBuild.toString();
    }
}
