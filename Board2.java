import java.util.*;

import javax.swing.JOptionPane;

	public class BoardConor {

		BoardConor()
		{
			clearBoard();
			set();
			
		}
	
		public boolean passed= true; //used in placeTile()
		public boolean isFirstMove=true;
		String[][] scrabbleboard = new String[16][16];
		char[][] wordBoard = new char[16][16];
		public void set()
		{
			
			for (int J =0; J<16; J++)
			for (int K =0; K<16; K++)
			{
				wordBoard[J][K] = '\0';
			}
			scrabbleboard[0][0] = "TW";
			scrabbleboard[0][3] = "DL";
			scrabbleboard[0][7] = "TW";
			scrabbleboard[0][11] = "DL";
			scrabbleboard[0][14] = "TW";

			scrabbleboard[1][1] = "DW";
			scrabbleboard[1][5] = "TL";
			scrabbleboard[1][9] = "TL";
			scrabbleboard[1][13] = "DW";

			scrabbleboard[2][2] = "DW";
			scrabbleboard[2][6] = "DL";
			scrabbleboard[2][8] = "DL";
			scrabbleboard[2][12] = "DW";

			scrabbleboard[3][0] = "DL";
			scrabbleboard[3][3] = "DW";
			scrabbleboard[3][7] = "DL";
			scrabbleboard[3][11] = "DW";
			scrabbleboard[3][14] = "DL";

			scrabbleboard[4][4] = "DL";
			scrabbleboard[4][10] = "DW";

			scrabbleboard[5][1] = "TL";
			scrabbleboard[5][5] = "TL";
			scrabbleboard[5][9] = "TL";
			scrabbleboard[5][14] = "TL";

			scrabbleboard[6][2] = "DL";
			scrabbleboard[6][6] = "DL";
			scrabbleboard[6][8] = "DL";
			scrabbleboard[6][12] = "DL";

			scrabbleboard[7][0] = "TW";
			scrabbleboard[7][3] = "DL";
			scrabbleboard[7][7] = "*";
			scrabbleboard[7][12] = "DL";
			scrabbleboard[7][14] = "TW";
			
			scrabbleboard[8][2] = "DL";
			scrabbleboard[8][6] = "DL";
			scrabbleboard[8][8] = "DL";
			scrabbleboard[8][12] = "DL";
			
			scrabbleboard[9][1] = "TL";
			scrabbleboard[9][5] = "TL";
			scrabbleboard[9][9] = "TL";
			scrabbleboard[9][14] = "TL";
			
			scrabbleboard[10][4] = "DL";
			scrabbleboard[10][10] = "DW";
			
			scrabbleboard[11][0] = "DL";
			scrabbleboard[11][3] = "DW";
			scrabbleboard[11][7] = "DL";
			scrabbleboard[11][11] = "DW";
			scrabbleboard[11][14] = "DL";
			
			scrabbleboard[12][2] = "DW";
			scrabbleboard[12][6] = "DL";
			scrabbleboard[12][8] = "DL";
			scrabbleboard[12][12] = "DW";
			
			scrabbleboard[13][1] = "DW";
			scrabbleboard[13][5] = "TL";
			scrabbleboard[13][9] = "TL";
			scrabbleboard[13][13] = "DW";
			
			scrabbleboard[14][0] = "TW";
			scrabbleboard[14][3] = "DL";
			scrabbleboard[14][7] = "TW";
			scrabbleboard[14][11] = "DL";
			scrabbleboard[14][14] = "TW";
			
			
			
		}
		
		public void clearBoard(){
			for (int J =0; J<16; J++)
				for (int K =0; K<16; K++)		
				{
					wordBoard[J][K] = '\0';
					scrabbleboard[J][K] = "\0";	//I'm not sure this is necessary but it completely wipes the board of everything
												//makes it possible to completely reset, if somehow the bonuses changed
				}
		}
		
		public void PrintBoard()
		{

			char a = 65;

			for(int y=0; y<scrabbleboard.length; y++)
			{

				if(y!=0)
				{
					System.out.print("\t");
					System.out.print(a + "   |");
					a++;
				}
			}
			System.out.println("\n");
			
			for(int i=0; i<scrabbleboard.length; i++)
			{
				if(i!=0)
				{

					System.out.println("\t");
					if(i<=9)
						System.out.print(i + "   |");
					else 
						System.out.print(i + "  |");
					for(int x=0; x<scrabbleboard.length; x++)

					{
						System.out.print("\t");
						if(wordBoard[i-1][x] != '\0')
							System.out.print(wordBoard[i-1][x] + "  |");
						else
							System.out.print(scrabbleboard[i-1][x] + "  |"  );	

					}
					System.out.print(i + "  |");
					System.out.println("\n");

				}
			}

		}
		
		
		
		public boolean isBoardEmpty(){
			for (int i =0; i<16; i++)	//cycles through the array
			for (int j =0; j<16; j++)
				{
					if (wordBoard[i][j] != '\0'){
						return false;	
					}
					
						
				}
			return true;
		}
		public void placeWord(String s, Frame f, int coordinate1Index1, char coordinate1Index2, int coordinate2Index1, char coordinate2Index2)
		{
			char[] charArray = s.toCharArray();
			System.out.println(charArray[0]);
			
			coordinate1Index1--;
			coordinate2Index1--;
			int coordinate1Index2new = coordinate1Index2-65;
			int coordinate2Index2new = coordinate2Index2-65;
			
			if ( coordinate1Index2new> 14 ||coordinate1Index1>15 ||coordinate2Index2new>14 ||  coordinate2Index1>15 ){
				System.out.println("Place letter on the board");	//checks if the letter is placed outside the board
				passed = false;
			}
										//checks if the letter is placed outside the board
			
			
			
			int index1Diff = coordinate1Index1-coordinate2Index1;
			if(checkWord(f, coordinate1Index1, coordinate1Index2new, coordinate2Index1, coordinate2Index2new) == true)
					{
			if(index1Diff==0)
			{
				
				for(int i=0; i<charArray.length && coordinate1Index2new<=coordinate2Index2new; i++) {
					if(wordBoard[coordinate1Index1-1][coordinate1Index2new] != '\0')
						System.out.println("This space is occupied");
					else
					wordBoard[coordinate1Index1][coordinate1Index2new]=charArray[i];
					coordinate1Index2new++; }
			}
			int index2Diff = coordinate1Index2-coordinate2Index2;
			if(index2Diff<0)
			if(index2Diff==0)
			{
				
				
				for(int i=0; i<charArray.length && coordinate1Index1<=coordinate2Index1; i++) {
					if(wordBoard[coordinate1Index1-1][coordinate1Index2new]!= '\0')
						System.out.println("This space is occupied");
					
					else
						wordBoard[coordinate1Index1][coordinate1Index2new]=charArray[i];
					
					coordinate1Index1++; }
			}
					}
			else
			{
				System.out.println("Word must be connected");
			}
			isFirstMove=false;
		}
		
		
		
		
		public boolean checkWord(Frame f, int pos1index1, int pos1index2, int pos2index1, int pos2index2)
		{
			Boolean isOkay=true;
			int index1Diff = pos1index1-pos2index1;
			System.out.println("TEST: pos1index1 " + pos1index1 + " pos1index2: " + pos1index2);
			System.out.println("TEST: pos2index1 " + pos2index1 + " pos2index2: " + pos2index2);
			if (isBoardEmpty()==true && wordBoard[7][7] == '\0')	
				System.out.println("Place letter in centre");
			else
			{
				
			
			if(index1Diff==0)
			{
				for(int i=0; pos1index2<=pos2index2; i++) {
					if(wordBoard[pos1index1][pos1index2]!='\0' )
								isOkay=false;
					if(wordBoard[pos2index1][pos2index2+1] == '\0' && wordBoard[pos1index1][pos2index1-1] =='\0' && wordBoard[pos1index1-1][pos2index1]=='\0' && wordBoard[pos1index1+1][pos2index1]=='\0')
						isOkay=false;
					
					
					
					pos1index2++; }
			}
			
			int index2Diff = pos1index2-pos2index2;
			if(index2Diff==0)
			{
				for(int i=0; pos1index1<=pos2index1; i++) {
					if(wordBoard[pos1index1][pos1index2]  != '\0')
					{
						isOkay=false;
					}
					
					pos1index1++; }
			}
			System.out.println("TEST: ISOKAY:" + isOkay);
			}
			return isOkay;
		}
		public boolean checkFrame(Frame f, String word)
		{
			char[] charArray = word.toCharArray();
			for(int i=0; i<charArray.length; i++)
			{
				if(f.LetterQuery(charArray[i])==false) return false;
					System.out.println(charArray[i]);
			}
			return true;
		}
		
		
		
		
		public void checkWord(){
			passed=true;
			int position1 =0, position2=0;
			int i =0, j =0;
			
			for (j =0; j<16; j++)
			for (i =0; i<16; i++)
			{
			if (wordBoard[i][j] != '\0');
			{
				position1 = i;
				position2 = j;
			}
			}
			int Pos2LessOne = position2 -1, Pos2PlusOne= position2+1, Pos1LessOne=position1-1, Pos1PlusOne=position1+1;
			
			
			if (Pos2LessOne == '\0' &&  Pos2PlusOne == '\0' &&  Pos1LessOne== '\0' &&  Pos1PlusOne== '\0'){
				System.out.println("Your word is not connected");	//if the 4 positions around the tile are null then its not connected
				passed =false;	
			}
			
			
		} 
		

		
		
		public void reset(){
			clearBoard();
			set();
		}
			
			

		public static void main(String[] args) {
			Scanner scanner = new Scanner( System.in );
			Pool P = new Pool();
			Frame F1 = new Frame(P);
			Frame F2 = new Frame(P);
			Frame F3 = new Frame(P);
			Frame F4 = new Frame(P);
			
			
			Player player[] = new Player[4];
			player[0] = new Player("Jack", 0, F1);
			player[1] = new Player("Rob", 0, F2);
			player[2] = new Player("Conor", 0, F3);
			player[3] = new Player("Zack", 0, F4);
			BoardConor B = new BoardConor();
			
			
			F1.setFrameTest();
			System.out.println(F1.LettersInFrame());
			
		
			B.placeWord("JON", F1, 8, 'H', 8, 'J' );
			F1.RemoveLetter();
			F1.RemoveLetter();
			F1.RemoveLetter();
			F1.Refill();
			
			//B.PrintScrabbleBoard();
			//B.PrintWordBoard();
			B.PrintBoard();
			B.placeWord("IF", F1, 8, 'I', 8, 'J' );
			B.PrintBoard();
		}

	

	
}

