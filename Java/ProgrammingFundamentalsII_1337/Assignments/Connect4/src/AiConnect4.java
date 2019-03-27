import java.util.Arrays;

public class AiConnect4 {
	private int WIN_VALUE;
	private int ROWS;
	private int COLS;
	private int highestCount = (-1);
	private int highestCountTemp = (-1);
	private int[] ColumnOptions;
	private int[] aiTurn = new int[] {-1,-1};
	private int[] aiTurnTemp = new int[] {-1,-1};
	private boolean connect4, ticTacToe;
	private Connect4.Seed aiPlayer;
	private Connect4.Seed opPlayer;
	private Connect4.Seed[][] board;

	public AiConnect4(int WIN_VALUE, int ROWS, int COLS, int[] ColumnOptions, Connect4.Seed aiPlayerOne, Connect4.Seed aiPlayerTwo, Connect4.Seed humanPlayerOne, Connect4.Seed humanPlayerTwo, Connect4.Seed[][] board, boolean connect4, boolean ticTacToe) {
		this.WIN_VALUE = WIN_VALUE;
		this.ROWS = ROWS;
		this.COLS = COLS;
		if(aiPlayerOne != null && aiPlayerTwo != null) {
			this.aiPlayer = aiPlayerOne;
			this.opPlayer = aiPlayerTwo;
		}
		if(aiPlayerOne != null && aiPlayerTwo == null) {
			this.aiPlayer = aiPlayerTwo;
		}
		if(aiPlayerOne == null && aiPlayerTwo != null) {
			this.aiPlayer = aiPlayerTwo;
		}
		if(humanPlayerOne != null) {
			this.opPlayer = humanPlayerOne;
		}
		if(humanPlayerTwo != null) {
			this.opPlayer = humanPlayerOne;
		}
		this.board = board;
		this.ColumnOptions = ColumnOptions;
		this.connect4 = connect4;
		this.ticTacToe = ticTacToe;
	}

	/** Find place to set move based on board's current state and opponent's soon to be winning moves */
	public int[] aiPlayer() {
		for(int row = 0; row < ROWS; ++row) {
			for(int col = 0; col < COLS; ++col) {
				if(hasWon(aiPlayer, row, col)) { // Checks for ai win anywhere
					//Return AI's row and column turn
					return aiTurn;
				} else if(hasWon(opPlayer, row, col)) { // Checks for opponent can win anywhere
					//Return AI's row and column turn
					return aiTurn;
				}
			}
		}
		findMove(aiPlayer);
		findMove(opPlayer);
		//Return AI's row and column turn
		return aiTurn;
	}

	/** Checks to see if anyone can win */
	public boolean hasWon(Connect4.Seed theSeed, int row, int col) {
		//{l{-1,0},tl{-1,-1},t{0,-1},tr{1,-1},r{1,0},dr{1,1},d{0,1},dl{-1,1}};
		final int[][] DIRECTIONS = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
		final String [] DIR_TEXT = new String[] {"LEFT", "TOP LEFT", "TOP", "TOP RIGHT", "RIGHT", "DOWN RIGHT", "DOWN", "DOWN LEFT"};
		int seedCount = 0;

		for(int index = 0; index < DIRECTIONS.length; ++index) {
			int[] direction = DIRECTIONS[index];
			int dx = direction[0];
			int dy = direction[1];
			boolean SENTINEL = true;
			seedCount = 0;

			for(int count = 1; count <= WIN_VALUE; ++count) {
				if(	(row+(dy*count) >= 0 && col+(dx*count) >= 0) &&
					(row+(dy*count) < ROWS && col+(dx*count) < COLS) ) {
					if(board[row+(dy*count)][col+(dx*count)] == theSeed) {
						seedCount++;
					} else if(board[row+(dy*count)][col+(dx*count)] != theSeed && board[row+(dy*count)][col+(dx*count)] != Connect4.Seed.EMPTY) { // Failed due to opposite move or empty space
						SENTINEL = false;
						break;
					} else if(board[row+(dy*count)][col+(dx*count)] == Connect4.Seed.EMPTY) {
						aiTurnTemp[0] = row+(dy*count);
						aiTurnTemp[1] = col+(dx*count);
					}
				} else { // Out of array bounds
					SENTINEL = false;
					break;
				}
			}
			if(SENTINEL && aiTurnTemp[0] != (-1) && aiTurnTemp[1] != (-1) && (seedCount+1) == WIN_VALUE) {
				if(connect4 && ColumnOptions[aiTurnTemp[0]] == aiTurnTemp[1]) {
					aiTurn[0] = aiTurnTemp[0];
					aiTurn[1] = aiTurnTemp[1];
					return true;
				} else if(ticTacToe) {
					aiTurn[0] = aiTurnTemp[0];
					aiTurn[1] = aiTurnTemp[1];
					return true;
				}
			}
		}
		return false;
	}

	/** Tries to find move if no one can win with hasWon() method */
	public void findMove(Connect4.Seed theSeed) {
		//{l{-1,0},tl{-1,-1},t{0,-1},tr{1,-1},r{1,0},dr{1,1},d{0,1},dl{-1,1}};
		final int[][] DIRECTIONS = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
		final String [] DIR_TEXT = new String[] {"LEFT", "TOP LEFT", "TOP", "TOP RIGHT", "RIGHT", "DOWN RIGHT", "DOWN", "DOWN LEFT"};
		boolean SENTINEL = true;
		int seedCount = 0;
		for(int row = 0; row < ROWS; ++row) {
			for(int col = 0; col < COLS; ++col) {
				for(int index = 0; index < DIRECTIONS.length; ++index) {
					int[] direction = DIRECTIONS[index];
					int dx = direction[0];
					int dy = direction[1];
					SENTINEL = true;
					seedCount = 0;

					for(int count = 1; count <= WIN_VALUE; ++count) {
						if(	(row+(dy*count) >= 0 && col+(dx*count) >= 0) &&
							(row+(dy*count) < ROWS && col+(dx*count) < COLS) ) {
							if(board[row+(dy*count)][col+(dx*count)] == theSeed) {
								seedCount++;
							} else if(board[row+(dy*count)][col+(dx*count)] != theSeed && board[row+(dy*count)][col+(dx*count)] != Connect4.Seed.EMPTY) { // Failed due to opposite move or empty space
								SENTINEL = false;
								break;
							} else if(seedCount >= highestCount && board[row+(dy*count)][col+(dx*count)] == Connect4.Seed.EMPTY && SENTINEL == true) {
								if(connect4) {
									if(ColumnOptions[col+(dx*count)] == row+(dy*count)) {
										aiTurnTemp[0] = row+(dy*count);
										aiTurnTemp[1] = col+(dx*count);
										highestCountTemp = seedCount;
									}
								} else if(ticTacToe) {
									aiTurnTemp[0] = row+(dy*count);
									aiTurnTemp[1] = col+(dx*count);
									highestCountTemp = seedCount;
								}
							}
						} else { // Out of array bounds
							SENTINEL = false;
							break;
						}
					}
					if(SENTINEL) {
						if(connect4) {
							if(ColumnOptions[aiTurnTemp[0]] == aiTurnTemp[1]) {
								aiTurn[0] = aiTurnTemp[0];
								aiTurn[1] = aiTurnTemp[1];
								highestCount = highestCountTemp;
							}
						} else if(ticTacToe) {
							aiTurn[0] = aiTurnTemp[0];
							aiTurn[1] = aiTurnTemp[1];
							highestCount = highestCountTemp;
						}
					}
				}
			}
		}
		if(board[aiTurn[0]][aiTurn[1]] != Connect4.Seed.EMPTY) { // If all else fails
			for(int row = 0; row < ROWS; ++row) {
				for(int col = 0; col < COLS; ++col) {
					if(board[row][col] == Connect4.Seed.EMPTY) {
						if(connect4) {
							if(ColumnOptions[col] == row) {
								aiTurn[0] = row;
								aiTurn[1] = col;
							}
						} else if(ticTacToe) {
							aiTurn[0] = row;
							aiTurn[1] = col;
						}
					}
				}
			}
		}
	}
}
