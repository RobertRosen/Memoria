
public class Points {


    private String playerOne;
    private String playerTwo;

    private int pointsPlayerOne;
    private int pointsPlayerTwo;
    private int newPointsPlayerOne;
    private int newPointsPlayerTwo;



    //håller koll på vems speltur det är
    public void turnCounter(int newPointsPlayerOne, int newPointsPlayerTwo){


        //man får alltid 0 poäng efter varje speltur om man matchat fel, båda två
        //man får alltid >0 poäng efter varje speltur om man matchat rätt, den ena och den andra får 0 poäng

        //förutsätter att playerOne är först ut med att göra ett drag varje spelomgång (eller om vi gör en random på speltur?)
        //en text som säger att player one börjar i gui

        //kolla om de valda korten är matchning, måste finnas metod i andra klassen som fyller i poäng
        //om matchning, sätt newPointsPlayerOne till 1 -> en text som säger att playerOne spelar igen och newPointsPlayerTwp får 0 poäng
        //om ej matchining, sätt newPointsPlayerOne till 0 -> en text som säger att playerTwo spelar istället och newPointsPlayerTwo får 0 poäng



        if (newPointsPlayerOne > 0) {

            //playerOne spelar igen

        } else {

            //playerTwo spelar istället
        }
    }



    //räknar score för playerOne som sedan ska visas i BoardGUI
    public void scorePlayerOne(int newPointsPlayerOne) {

        pointsPlayerOne = pointsPlayerOne + newPointsPlayerOne;

    }


    //räknar score för playerTwo som sedan ska visas i BoardGUI
    public void scorePlayerTwo(int newPointsPlayerTwo) {

        pointsPlayerTwo = pointsPlayerTwo + newPointsPlayerTwo;

    }


}
