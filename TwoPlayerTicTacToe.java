import java.util.*;

public class TwoPlayerTicTacToe {
    static ArrayList<Integer> P1Positons = new ArrayList<Integer>();
    static ArrayList<Integer> P2Positons = new ArrayList<Integer>();
    public static void main(String[] args)  {
       
       
        String [][] board = 
        { 
            {" ", " |" ," " , " |" ," " },
            {"__", "+", "__", "+", "__"},
            {" ", " |" ," " , " |" ," " },
            {"__", "+", "__", "+", "__"},
            {" ", " |" ," " , " |" ," " },
        };
        //Random randgen = new  Random(); // creating a random object to generate random numbers for the computer
       // int RANDOM = randgen.nextInt(9) +1; // Here 
       while (true) { 
        Scanner scan = new  Scanner(System.in);
       System.out.println("P1 turn");
        int position1 = scan.nextInt();
        System.out.println("P2 turn");
        int position2 = scan.nextInt();
        //System.out.println(position1);
        
                XorOPosition(board, position1, "Player1"); // This is a method that passes the board and the position to the board so that the player can see where they are at. I used a Switch case here.
                XorOPosition(board, position2, "Player2"); // Player 2 
                printBoard(board); // This is printing the board
               String WhoWon = Winner();
               System.out.println(WhoWon);
        }
    
    }


    public static void printBoard ( String [][] board ){
        for(int i =0; i<board.length; i++){    
            for (int j =0; j<board[i].length; j++){ 
                //board[i][j] = scan.nextInt();

                System.out.print(board[i][j]);
           }  
           System.out.println();
    }
    }
       
    public static void XorOPosition ( String[][] board, int position, String oneVSone) {
                String character =" ";

                    if(oneVSone.equals("Player1")){
                        character="X";
                        P1Positons.add(position);
                    }
                    else if (oneVSone.equals("Player2")){
                        character ="O";
                        P2Positons.add(position);
                    }
           
                switch( position) {
                    case 1: 
                        board[0][0] = character;
                        break;
                    case 2: 
                        board[0][2] = character;
                        break;
                    case 3: 
                        board[0][4] = character;
                        break;
                    case 4: 
                        board[2][0] = character;
                        break;
                    case 5: 
                        board[2][2] = character;
                        break;
                    case 6: 
                        board[2][4] = character;
                        break;
                    case 7: 
                        board[4][0] = character;
                        break;

                    case 8: 
                        board[4][2] = character;
                        break;
                    case 9: 
                        board[4][4] =character;
                        break;
                    default:
                        break;
                }
        }

    public static String Winner() {
        
        List Row1 = Arrays.asList(1,2,3);
        List Row2 = Arrays.asList(4,5,6);
        List Row3 = Arrays.asList(7,8,9);

        List Column1 = Arrays.asList(1,4,7);
        List Column2 = Arrays.asList(2,5,8);
        List Column3 = Arrays.asList(3,6,9);

        List LeftD = Arrays.asList(1,5,9);
        List RightD = Arrays.asList(3,5,7);

        List<List> HowToWin = new ArrayList<List>();

        HowToWin.add(Row1);
        HowToWin.add(Row2);
        HowToWin.add(Row3);

        HowToWin.add(Column1);
        HowToWin.add(Column2);
        HowToWin.add(Column3);

        HowToWin.add(LeftD);
        HowToWin.add(RightD);
        
        for ( List pos : HowToWin){
            if ( P1Positons.containsAll(pos)){
                return "P1 wins";
                }
            else if ( P2Positons.containsAll(pos)){
                return "P2 wins";
            }
            else if( P1Positons.size() + P2Positons.size() ==9){

                    return "Tie :(3)";
            }
        }       


        return "";
    }

    }

