package AliceInWonderland;
public class RockPaperScissor {
    final static int ROCK = 1, SCISSOR = 2, PAPER = 3;

    public boolean playGame(int player1){
        int player2 = (int)Math.floor(Math.random()*(3-1+1)+1);
        if (player1 == player2){
            System.out.println("The Queen picked the same as you");
            return false;
            } else {
            switch (player1){
            case ROCK:
                if (player2 == SCISSOR){
                    System.out.println("You picked Rock");
                    System.out.println("The Queen picks Scissors");
                    return true;
                }
                if (player2 == SCISSOR){
                    System.out.println("You picked Rock");
                    System.out.println("The Queen picks Paper");
                    return false;
                }else{
                }break;
            case SCISSOR:
                if (player2 == PAPER){
                    System.out.println("You picked Scissors");
                    System.out.println("The Queen picks Paper");
                    return true;
                }
                if (player2 == PAPER){
                    System.out.println("You picked Scissors");
                    System.out.println("The Queen picks Rock");
                    return false;
                }else{
                }break;
            case PAPER:
                if (player2 == ROCK){
                    System.out.println("You picked Paper");
                    System.out.println("The Queen picks Rock");
                    return true;
                }
                if (player2 == ROCK){
                    System.out.println("You picked Paper");
                    System.out.println("The Queen picks Scissors");
                    return false;
                    }else{
                }break;
            }
        }
        return false;
    }
}