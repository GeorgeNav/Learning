import java.util.Arrays;

public class AiTicTacToe {
	private int ROWS;
	private int COLS;
	private TicTacToe.Seed aiPlayer;
	private TicTacToe.Seed humanPlayer;
	private TicTacToe.Seed currentPlayer;
	private TicTacToe.Seed[][] board;

	public AiTicTacToe(int ROWS, int COLS, TicTacToe.Seed aiPlayer, TicTacToe.Seed humanPlayer, TicTacToe.Seed currentPlayer, TicTacToe.Seed[][] board) {
		this.ROWS = ROWS;
		this.COLS = COLS;
		this.aiPlayer = aiPlayer;
		this.humanPlayer = humanPlayer;
		this.currentPlayer = currentPlayer;
		this.board = board;
	}
	/** is the AI first player? */
	public boolean emptyBoard() {
		boolean empty = true;
		
			for (int row = 0; row < ROWS; ++row) {
				for (int col = 0; col < COLS; ++col) {
					if (board[row][col] != TicTacToe.Seed.EMPTY) {
						empty = false;
						break;
					}
				}
			}

		return empty;
	}

	/** is the AI first player? */
	//FIND AMOUNT OF EACH TYPE OF PLAYER MOVES PER WIN CONDITION
	public int[] aiPlayer() {
		int DIAG_SIZE = 0;
		if(ROWS < COLS) {
			DIAG_SIZE = ROWS;
		} else if (COLS < ROWS) {
			DIAG_SIZE = COLS;
		}
		final int NUM_PLAYERS = 2; //Number of players
		final int DIAGS = 2; //Amount of diagonal win conditions
		final int AI = 0, OP = 1; //WC_TYPES of players AI distinguishes
		final int TLD_WIN = 0, TRD_WIN = 1; //Win condition types of diagonals ONLY TO BE USED WITH boardDiag[][]
		final int TYPE_ROW = 1, TYPE_COL = 2, TYPE_DIAG_TL = 3, TYPE_DIAG_TR = 4;
		int[][] boardRow = new int[ROWS][NUM_PLAYERS]; // boardRow[rowWinCondNum][playerType] = priority row win condition move(s) value for playerType
		int[][] boardCol = new int[COLS][NUM_PLAYERS]; // boardCol[colWinCondNum][playerType] = priority column win condition moves(s) value for playerType
		int[][] boardDiag = new int[DIAGS][NUM_PLAYERS]; // boardDiag[DIAG_TYPE][playerType] = priority diagType win condition move(s) value to stop or win

		//priority win conditions set after comparisons
		int[] pRow = new int[NUM_PLAYERS], pCol = new int[NUM_PLAYERS], pDiag = new int[NUM_PLAYERS]; // 
		int[] pRowValue = new int[] {0,0},pColValue = new int[] {0,0}, pDiagTopLeftValue = new int[] {0,0}, pDiagTopRightValue = new int[] {0,0}; //Stores highest amount of moves for AI and opposing player
		int priorityType = 0, priorityIndex = 0, priorityValue = 0;

		//aiPlayer system info start
		System.out.println("\n" + "----- aiPlayer ------");

		//Only used if it's the first turn and the AI is first (always places first move in the center)
		if (emptyBoard()) {
			int[] aiTurn = new int[] { ((ROWS-1)/2), ((COLS-1)/2)};
			//aiPlayer system info separator
			System.out.println("AI was first so used [row,col] which is the center: " + Arrays.toString(aiTurn));
			return aiTurn;
		}

		//Adds amount of opposing player moves in each row number win condition
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (board[row][col] == aiPlayer) { //Checks rows for AI move
					boardRow[row][AI]++; //Increments AI row value
				} else if (board[row][col] != aiPlayer && board[row][col] != TicTacToe.Seed.EMPTY) { //Checks rows for opposing player move
					boardRow[row][OP]++; //Increments opposing player row value
				}
			}
		} System.out.println("boardRow ROW#:[aiMoves, opMoves] =  " + Arrays.deepToString(boardRow));

		//Adds amount of opposing player moves in each column number win condition
		for (int col = 0; col < COLS; ++col) {
			for (int row = 0; row < ROWS; ++row) {
				if (board[row][col] == aiPlayer) { //Checks columns for AI move
					boardCol[col][AI]++; //Increments AI column value
				} else if (board[row][col] != aiPlayer && board[row][col] != TicTacToe.Seed.EMPTY) { //Checks columns for opposing player move
					boardCol[col][OP]++; //Increments opposing player column value
				}
			}
		} System.out.println("boardCol COL#:[aiMoves, opMoves] =  " + Arrays.deepToString(boardCol));

		//Adds amount of opposing player moves in 'top left to bottom right diagonal' win condition
		for (int row = 0, col = 0; row < ROWS && col < COLS; ++row, ++col) {
			if (board[row][col] == aiPlayer) { //Checks top left to bottom right diagonal
				boardDiag[TLD_WIN][AI]++; //Increments AI 'top left to bottom right' diagonal value
			} else if (board[row][col] != aiPlayer && board[row][col] != TicTacToe.Seed.EMPTY) { //Checks top left to bottom right diagonal
				boardDiag[TLD_WIN][OP]++; //Increments opposing player 'top left to bottom right' diagonal value
			}
		}
		//Checks amount of opposing player moves in 'top right to bottom left diagonal' win condition
		for (int row = 0, col = (COLS-1); row < ROWS && col < COLS; ++row, --col ) {
			if (board[row][col] == aiPlayer) { //Checks top right to bottom left diagonal
				boardDiag[TRD_WIN][AI]++; //Increments AI 'top right to bottom left' diagonal value
			} else if (board[row][col] != aiPlayer && board[row][col] != TicTacToe.Seed.EMPTY) { //Checks top right to bottom left diagonal
				boardDiag[TRD_WIN][OP]++; //Increments opposing player 'top right to bottom left' diagonal value
			}
		}
		//Shows both WC_TYPES of diagonal's opposing players values
		System.out.println("boardDiag DIAG_TYPE#:[aiMoves, opMoves] =  " + Arrays.deepToString(boardDiag));

		//Check which row type win conditions should be won or stopped (highest amount of opposing player moves per win condition)
		for (int index = 0; index < ROWS; ++index) {
			if( ((index+1) != ROWS) && ((boardRow[index][AI] > boardRow[index+1][AI]) && (boardRow[index][AI]+boardRow[index][OP] != ROWS)) ) { //Compares row to row finding priority index for AI (index, or index+1 = row)
				pRowValue[AI] = boardRow[index][AI];
				pRow[AI] = index;
				if( (boardRow[index][AI] == (ROWS-1)) && (boardRow[index][OP] == 0) ) {
					priorityType = TYPE_ROW;
					priorityValue = pRowValue[AI];
					priorityIndex = pRow[AI];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			} else if( ((index+1) == ROWS) && ((boardRow[index][AI] > boardRow[index-1][AI]) && (boardRow[index][AI]+boardRow[index][OP] != ROWS)) ) {
				pRowValue[AI] = boardRow[index][AI];
				pRow[AI] = index;
				if( (boardRow[index][AI] == (ROWS-1)) && (boardRow[index][OP] == 0) ) {
					priorityType = TYPE_ROW;
					priorityValue = pRowValue[AI];
					priorityIndex = pRow[AI];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			}
			if( ((index+1) != ROWS) && ((boardRow[index][OP] > boardRow[index+1][OP]) && (boardRow[index][AI]+boardRow[index][OP] != ROWS)) ) { //Compares row to row finding priority index for opposing player
				pRowValue[OP] = boardRow[index][OP];
				pRow[OP] = index;
				if( (boardRow[index][OP] == (ROWS-1)) && (boardRow[index][AI] == 0) ) {
					priorityType = TYPE_ROW;
					priorityValue = pRowValue[OP];
					priorityIndex = pRow[OP];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			} else if( ((index+1) == ROWS) && ((boardRow[index][OP] > boardRow[index-1][OP]) && (boardRow[index][AI]+boardRow[index][OP] != ROWS)) ) {
				pRowValue[OP] = boardRow[index][OP];
				pRow[OP] = index;
				if( (boardRow[index][OP] == (ROWS-1)) && (boardRow[index][AI] == 0) ) {
					priorityType = TYPE_ROW;
					priorityValue = pRowValue[OP];
					priorityIndex = pRow[OP];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			}
		} System.out.println("pRowValue [aiNumMoves, opNumMoves] =  " + Arrays.toString(pRowValue));

		//Check which column type win conditions should be won or stopped (highest amount of opposing player moves per win condition)
		for (int index = 0; index < COLS; ++index) {
			if( ((index+1) != COLS) && ((boardCol[index][AI] > boardCol[index+1][AI]) && (boardCol[index][AI]+boardCol[index][OP] != COLS)) ) { //Compare columns to columns finding priority index for AI
				pColValue[AI] = boardCol[index][AI];
				pCol[AI] = index;
				if( (boardCol[index][AI] == (COLS-1)) && (boardCol[index][OP] == 0) ) {
					priorityType = TYPE_COL;
					priorityValue = pColValue[AI];
					priorityIndex = pCol[AI];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			} else if( ((index+1) == COLS) && ((boardCol[index][AI] > boardCol[index-1][AI]) && (boardCol[index][AI]+boardCol[index][OP] != COLS)) ) {
				pColValue[AI] = boardCol[index][AI];
				pCol[AI] = index;
				if( (boardCol[index][AI] == (COLS-1)) && (boardCol[index][OP] == 0) ) {
					priorityType = TYPE_COL;
					priorityValue = pColValue[AI];
					priorityIndex = pCol[AI];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			}
			if( ((index+1) != COLS) && ((boardCol[index][OP] > boardCol[index+1][OP]) && (boardCol[index][AI]+boardCol[index][OP] != COLS)) ) { //Compare columns to columns finding priority index for opposing player
				pColValue[OP] = boardCol[index][OP];
				pCol[OP] = index;
				if( (boardCol[index][OP] == (COLS-1)) && (boardCol[index][AI] == 0) ) {
					priorityType = TYPE_COL;
					priorityValue = pColValue[OP];
					priorityIndex = pCol[OP];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			} else if((index+1) == COLS && ((boardCol[index][OP] > boardCol[index-1][OP]) && (boardCol[index][AI]+boardCol[index][OP] != COLS)) ) {
				pColValue[OP] = boardCol[index][OP];
				pCol[OP] = index;
				if( (boardCol[index][OP] == (COLS-1)) && (boardCol[index][AI] == 0) ) {
					priorityType = TYPE_COL;
					priorityValue = pColValue[OP];
					priorityIndex = pCol[OP];
					return aiFindTurn(priorityType, priorityValue, priorityIndex);
				}
			}
		} System.out.println("pColValue [aiNumMoves, opNumMoves] =  " + Arrays.toString(pColValue));

		//Check which diagonal type win conditions should be won or stopped (highest amount of opposing player moves per win condition)
		/*for (int index = 0; index < DIAGS; ++index) { // For loop used if there are more win conditions than 2 (WHEN ROW OR COL DIFFERES FROM EACH OTHER FOR EXP.)
			if((index+1) != DIAGS) {
			}*/
				//Compare diagonals to diagonals finding priority index from AI moves read from board
				if( (boardDiag[TLD_WIN][AI] > boardDiag[TRD_WIN][AI]) && (boardDiag[TLD_WIN][AI]+boardDiag[TLD_WIN][OP] != DIAG_SIZE) ) { //[DiagType][player] = TLD_WIN , AI
						//Amount of opposing player moves in diagonal starting from top left
						pDiagTopLeftValue[AI] = boardDiag[TLD_WIN][AI];
						pDiag[AI] = TLD_WIN;
						if( (boardDiag[TLD_WIN][AI] == (DIAG_SIZE-1)) && (boardDiag[TLD_WIN][OP] == 0) ){
							priorityType = TYPE_DIAG_TL;
							priorityValue = pDiagTopLeftValue[AI];
							priorityIndex = pDiag[AI];
							return aiFindTurn(priorityType, priorityValue, priorityIndex);							
						}
				} else if( (boardDiag[TRD_WIN][AI] > boardDiag[TLD_WIN][AI]) && (boardDiag[TRD_WIN][AI]+boardDiag[TRD_WIN][OP] != DIAG_SIZE) ) { //[DiagType][player] = TRD_WIN , AI
						//Amount of opposing player moves in diagonal starting from top right
						pDiagTopRightValue[AI] = boardDiag[TRD_WIN][AI];
						pDiag[AI] = TRD_WIN;
						if( (boardDiag[TRD_WIN][AI] == (DIAG_SIZE-1)) && (boardDiag[TRD_WIN][OP] == 0) ){
							priorityType = TYPE_DIAG_TR;
							priorityValue = pDiagTopRightValue[AI];
							priorityIndex = pDiag[AI];
							return aiFindTurn(priorityType, priorityValue, priorityIndex);							
						}
				}
				//Compare diagonals to diagonals finding priority index from opposing player moves read from board
				if( (boardDiag[TLD_WIN][OP] > boardDiag[TRD_WIN][OP]) && (boardDiag[TLD_WIN][AI]+boardDiag[TLD_WIN][OP] != DIAG_SIZE) ) { //[DiagType][player] = TLD_WIN , opposing player
						//Amount of opposing player moves in diagonal starting from top left
						pDiagTopLeftValue[OP] = boardDiag[TLD_WIN][OP];
						pDiag[OP] = TLD_WIN;
						if((boardDiag[TLD_WIN][OP] == (DIAG_SIZE-1)) && (boardDiag[TLD_WIN][AI] == 0)){
							priorityType = TYPE_DIAG_TL;
							priorityValue = pDiagTopLeftValue[OP];
							priorityIndex = pDiag[OP];
							return aiFindTurn(priorityType, priorityValue, priorityIndex);							
						}
				} else if( (boardDiag[TRD_WIN][AI] > boardDiag[TLD_WIN][AI]) && (boardDiag[TRD_WIN][AI]+boardDiag[TRD_WIN][OP] != DIAG_SIZE) ) { //[DiagType][player] = TRD_WIN , opposing player
						//Amount of opposing player moves in diagonal starting from top right
						pDiagTopRightValue[OP] = boardDiag[TRD_WIN][OP];
						pDiag[OP] = TRD_WIN;
						if((boardDiag[TLD_WIN][OP] == (DIAG_SIZE-1)) && (boardDiag[TRD_WIN][AI] == 0)){
							priorityType = TYPE_DIAG_TR;
							priorityValue = pDiagTopRightValue[OP];
							priorityIndex = pDiag[OP];
							return aiFindTurn(priorityType, priorityValue, priorityIndex);							
						}
				}
			/*}
		}*/ System.out.println("pDiagTopLeftValue [aiNumMoves, opNumMoves] =  " + Arrays.toString(pDiagTopLeftValue)); System.out.println("pDiagTopRightValue [aiNumMoves, opNumMoves] =  " + Arrays.toString(pDiagTopRightValue));

		/*	Following comments help make if statements
			pRow[playerType] = index of row that should be used
			boardRow[rowWinCondNum][playerType] = priority row win condition move(s) value for playerType
			boardCol[colWinCondNum][playerType] = priority column win condition moves(s) value for playerType
			boardDiag[DIAG_TYPE][playerType] = priority diagType win condition move(s) value to stop or win
			priorityArr[winConditionType][playerType] = priority playerType move(s) value
		*/
		if( ((pRowValue[AI] > pColValue[AI] || pRowValue[AI] > pColValue[OP]) || (pRowValue[OP] > pColValue[AI] || pRowValue[OP] > pColValue[OP])) &&
			((pRowValue[AI] > pDiagTopLeftValue[AI] && pRowValue[AI] > pDiagTopLeftValue[OP] && pRowValue[AI] > pDiagTopRightValue[AI] && pRowValue[AI] > pDiagTopRightValue[OP]) ||
			 (pRowValue[OP] > pDiagTopLeftValue[AI] && pRowValue[OP] > pDiagTopLeftValue[OP] && pRowValue[OP] > pDiagTopRightValue[AI] && pRowValue[OP] > pDiagTopRightValue[OP])) ) { //Checks if AI and opposing player row moves are more than column and diagonal moves
			if(pRowValue[AI] > pRowValue[OP]) {
				priorityType = TYPE_ROW;
				priorityValue = pRowValue[AI];
				priorityIndex = pRow[AI];
			} else if(pRowValue[OP] > pRowValue[AI]) {
				priorityType = TYPE_ROW;
				priorityValue = pRowValue[OP];
				priorityIndex = pRow[OP];
			}
		}
		if( (pColValue[AI] > pDiagTopLeftValue[AI] && pColValue[AI] > pDiagTopLeftValue[OP] && pColValue[AI] > pDiagTopRightValue[AI] && pColValue[AI] > pDiagTopRightValue[OP]) ||
			(pColValue[OP] > pDiagTopLeftValue[AI] && pColValue[OP] > pDiagTopLeftValue[OP] && pColValue[OP] > pDiagTopRightValue[AI] && pColValue[OP] > pDiagTopRightValue[OP]) ) { //Checks if AI and opposing player columns moves are more than diag moves
			if(pColValue[AI] > pColValue[OP]) {
				priorityType = TYPE_COL;
				priorityValue = pColValue[AI];
				priorityIndex = pCol[AI];
			} else if(pColValue[OP] > pColValue[AI]) {
				priorityType = TYPE_COL;
				priorityValue = pColValue[OP];
				priorityIndex = pCol[OP];
			}
		}
		if( (pDiagTopLeftValue[AI] > pDiagTopRightValue[AI]) || (pDiagTopLeftValue[OP] > pDiagTopRightValue[OP]) ) { //Checks if AI and opposing player diag top left moves are more than diag top right moves
			if(pDiagTopLeftValue[AI] > pDiagTopLeftValue[OP]) {
				priorityType = TYPE_DIAG_TL;
				priorityValue = pDiagTopLeftValue[AI];
				priorityIndex = pDiag[AI];
			} else if(pDiagTopLeftValue[OP] > pDiagTopLeftValue[AI]) {
				priorityType = TYPE_DIAG_TL;
				priorityValue = pDiagTopLeftValue[OP];
				priorityIndex = pDiag[OP];
			}
		}
		if( (pDiagTopRightValue[AI] > pDiagTopLeftValue[AI]) || (pDiagTopRightValue[OP] > pDiagTopLeftValue[OP]) ) { //Checks if AI and opposing player diag top right moves are more than diag top left moves
			if(pDiagTopRightValue[AI] > pDiagTopRightValue[OP]) {
				priorityType = TYPE_DIAG_TR;
				priorityValue = pDiagTopLeftValue[AI];
				priorityIndex = pDiag[AI];
			} else if(pDiagTopRightValue[OP] > pDiagTopRightValue[AI]) {
				priorityType = TYPE_DIAG_TR;
				priorityValue = pDiagTopLeftValue[OP];
				priorityIndex = pDiag[OP];
			}
		}
		System.out.println("priorityType: " + priorityType + " priorityIndex: " + priorityIndex + " priorityValue: " + priorityValue);

		//aiPlayer system info separator
		System.out.println();
		//Return AI's row and column turn
		return aiFindTurn(priorityType, priorityValue, priorityIndex);
	}

	/** Returns the AI's turn based on priorityArr win condition from aiPlayer() method */
	public int[] aiFindTurn(int priorityType, int priorityValue, int priorityIndex) {
		int[] aiTurn = new int[2];
		int TYPE_ROW = 1, TYPE_COL = 2, TYPE_DIAG_TL = 3, TYPE_DIAG_TR = 4;
		
		if(priorityType == TYPE_ROW) { //Checks where to place AI's move on specified row win condition
			for(int col = 0; col < COLS; ++col) {
				//Checks rows for a spot to place AI's move
				if(board[priorityIndex][col] == TicTacToe.Seed.EMPTY) {
					//Finalizes aiTurn return
					aiTurn[0] = priorityIndex;
					aiTurn[1] = col;
				}
			}
		}
		else if(priorityType == TYPE_COL) { //Checks where to place AI's move on specified row win condition
			for(int row = 0; row < ROWS; ++row) {
				//Checks columns for a spot to place AI's move
				if(board[row][priorityIndex] == TicTacToe.Seed.EMPTY) {
					//Finalizes aiTurn return
					aiTurn[0] = row;
					aiTurn[1] = priorityIndex;
				}
			}
		}
		else if(priorityType == TYPE_DIAG_TL) {
			//Checks 'top left to bottom right diagonal' win condition for a spot to place AI's move
			for(int row = 0, col = 0; row < ROWS && col < COLS; ++row, ++col) {
				if(board[row][col] == TicTacToe.Seed.EMPTY) {
					//Finalizes aiTurn return
					aiTurn[0] = row;
					aiTurn[1] = col;
				}
			}
		}
		else if(priorityType == TYPE_DIAG_TR) {
			//Checks 'top right to bottom left diagonal' win condition for a spot to place AI's move
			for(int row = 0, col = (COLS-1); row < ROWS && col < COLS; ++row, --col) {
				if(board[row][col] == TicTacToe.Seed.EMPTY) {
					//Finalizes aiTurn return
					aiTurn[0] = row;
					aiTurn[1] = col;
				}
			}
		}

		return aiTurn;
	}
}
