import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Connect4: Two-player Graphics version with Simple-OO */
@SuppressWarnings("serial")
public class Connect4 extends JFrame {
	private int[] opTurn = new int[2];
	//Ai
	private AiConnect4 ai;
	// Shows player options for game
	public static JPanel startingScreen;
	// Initializes game
	public static JFrame optionScreen;
	// Named-constants for the game board
	private static int ROWS = 5; // ROWS cells
	private static int COLS = 5; // COLS cells
	private static int WIN_VALUE = 4;
	private JComboBox rowColSizeOptions;
	private JComboBox winSizeOptions;
	private JRadioButton aiPlayerOneB;
	private JRadioButton aiPlayerTwoB;
	private JRadioButton xPlayerOne;
	private JRadioButton xPlayerTwo;
	private JRadioButton oPlayerOne;
	private JRadioButton oPlayerTwo;
	// Named-constants of the various dimensions used for graphics drawing
	public static int CELL_SIZE = 100; // cell width and height (square)
	public static int CANVAS_WIDTH = CELL_SIZE * COLS; // the drawing canvas
	public static int CANVAS_HEIGHT = CELL_SIZE * ROWS; // the drawing canvas
	public static int GRID_WIDTH = 8; // Grid-line's width
	public static int GRID_WIDHT_HALF = GRID_WIDTH / 2; // Grid-line's
																// half-width
	// Symbols (cross/nought) are displayed inside a cell, with padding from
	// border
	public static final int CELL_PADDING = CELL_SIZE / 6;
	public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2; // width/height
	public static final int SYMBOL_STROKE_WIDTH = 8; // pen's stroke width
	// Use an enumeration (inner class) to represent the various states of the
	// game
	public static int[] ColumnOptions; // [index] = Starts at value of (ROWS-1)

	private enum GameState {
		PLAYING, DRAW, CROSS_WON, NOUGHT_WON
	}
	private GameState currentState; // the current game state
	// Use an enumeration (inner class) to represent the seeds and cell contents
	enum Seed {
		EMPTY, CROSS, NOUGHT
	}
	private Seed opPlayer = Seed.NOUGHT;
	private Seed firstPlayer = Seed.CROSS, secondPlayer = Seed.NOUGHT;
	private Seed currentPlayer = firstPlayer; // The current player
	private Seed humanPlayer, humanPlayerOne = firstPlayer, humanPlayerTwo;
	private Seed aiPlayerOne, aiPlayerTwo = secondPlayer;
	private Seed[][] board; // Game board of ROWS-by-COLS cells

	private DrawCanvas canvas; // Drawing canvas (JPanel) for the game board
	private JLabel statusBar; // Status Bar
	private int aiDelay= 1000;
	private boolean ticTacToe = false, connect4 = true;

	/** Constructor to setup the game and the GUI components */
	public Connect4() {
		firstPlayer = Seed.CROSS;
		opPlayer = Seed.NOUGHT;
		aiPlayerTwo = secondPlayer;
		secondPlayer = Seed.NOUGHT;
		connect4 = true;
		ticTacToe = false;
		optionScreenInit();
	}

	public void aiTurn() {
		Timer aiTimer;
		aiTimer = new Timer(1000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if((currentPlayer == aiPlayerOne || currentPlayer == aiPlayerTwo) && currentState == GameState.PLAYING) {
		    		int[] aiTurn = ai.aiPlayer(); System.out.println("aiPlayer returned ROW: '" + aiTurn[0] + "' and COL: '" + aiTurn[1] + "'");
		    		board[aiTurn[0]][aiTurn[1]] = currentPlayer; System.out.println("Board updated to ROW: '" + aiTurn[0] + "' and ROW: '" + aiTurn[1] + "'"); // Make a move
		    		updateGame(currentPlayer, aiTurn[0], aiTurn[1]); // update game state
		    		currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS; // Switch player
		    		repaint();
		    	}
		    }
		});
		aiTimer.start(); //Starts aiTurn
	}

	/** is the board empty? */
	public boolean emptyBoard() {
		boolean empty = true;
			for (int row = 0; row < ROWS; ++row) {
				for (int col = 0; col < COLS; ++col) {
					if (board[row][col] != Seed.EMPTY) {
						empty = false;
						break;
					}
				}
			}
		return empty;
	}

	/** Initialize the game-board contents and the status */
	public void initGame() {		
		for (int row = 0; row <= (ROWS-1); ++row) {
			for (int col = 0; col <= (COLS-1); ++col) {
				board[row][col] = Seed.EMPTY; // make all cells empty
			}
		}
		currentState = GameState.PLAYING; // ready to play
	}

	public void optionScreenInit() {
		optionScreen = new JFrame();
		getContentPane().setBackground(Color.YELLOW);

		JPanel gameInit = new JPanel(new GridLayout(2,2));
		JPanel allPanels = new JPanel();
		JPanel fptp = new JPanel(new GridLayout(7,1));
		JPanel sptp = new JPanel(new GridLayout(7,1));

		JLabel rowColSizeText = new JLabel("Row and Column size?");
		JLabel winSizeText = new JLabel("What Connect size wins?");
		JLabel firstPlayerText = new JLabel("FIRST PLAYER");
		JLabel secondPlayerText = new JLabel("SECOND PLAYER");
		JLabel firstPlayerType = new JLabel("Choose player type");
		JLabel secondPlayerType = new JLabel("Choose player type");
		JLabel firstPeiceType = new JLabel("Choose X or O");
		JLabel secondPeiceType = new JLabel("Choose X or O");

		String[] rowColSizes = new String[] {"5x5", "6x6","7x7","8x8","9x9"};
		String[] winSize = new String[] {"Connect 4", "Connect 5", "TicTacToe 4", "TicTacToe 5"};

		rowColSizeOptions = new JComboBox(rowColSizes);
		rowColSizeOptions.addActionListener(new RadioButtonListener());
		winSizeOptions = new JComboBox(winSize);
		winSizeOptions.addActionListener(new RadioButtonListener());

		JButton playConnect = new JButton("Play!");
		playConnect.addActionListener(new RadioButtonListener());
		JRadioButton humanPlayerOne =  new JRadioButton("Human 1", true);
		humanPlayerOne.addActionListener(new RadioButtonListener());
		aiPlayerOneB =  new JRadioButton("Computer 1");
		aiPlayerOneB.addActionListener(new RadioButtonListener());
		xPlayerOne = new JRadioButton("X (player 1)", true);
		xPlayerOne.addActionListener(new RadioButtonListener());
		oPlayerOne = new JRadioButton("O (player 1)");
		oPlayerOne.addActionListener(new RadioButtonListener());
		JRadioButton humanPlayerTwo =  new JRadioButton("Human 2");
		humanPlayerTwo.addActionListener(new RadioButtonListener());
		aiPlayerTwoB =  new JRadioButton("Computer 2", true);
		aiPlayerTwoB.addActionListener(new RadioButtonListener());
		xPlayerTwo = new JRadioButton("X (player 2)");
		xPlayerTwo.addActionListener(new RadioButtonListener());
		oPlayerTwo = new JRadioButton("O (player 2)", true);
		oPlayerTwo.addActionListener(new RadioButtonListener());

		ButtonGroup FPTButtonGroup = new ButtonGroup();
		FPTButtonGroup.add(humanPlayerOne);
		FPTButtonGroup.add(aiPlayerOneB);
		ButtonGroup SPTButtonGroup = new ButtonGroup();
		SPTButtonGroup.add(humanPlayerTwo);
		SPTButtonGroup.add(aiPlayerTwoB);
		ButtonGroup FPMButtonGroup = new ButtonGroup();
		FPMButtonGroup.add(xPlayerOne);
		FPMButtonGroup.add(oPlayerOne);
		ButtonGroup SPMButtonGroup = new ButtonGroup();
		SPMButtonGroup.add(xPlayerTwo);
		SPMButtonGroup.add(oPlayerTwo);
		ButtonGroup FPButtonGroup = new ButtonGroup();
		FPButtonGroup.add(aiPlayerOneB);
		FPButtonGroup.add(humanPlayerOne);
		ButtonGroup SPButtonGroup = new ButtonGroup();
		SPButtonGroup.add(aiPlayerTwoB);
		SPButtonGroup.add(humanPlayerTwo);

		gameInit.add(rowColSizeText);
		gameInit.add(winSizeText);
		gameInit.add(rowColSizeOptions);
		gameInit.add(winSizeOptions);

		fptp.add(firstPlayerText);
		fptp.add(firstPeiceType);
		fptp.add(xPlayerOne);
		fptp.add(oPlayerOne);
		fptp.add(firstPlayerType);
		fptp.add(humanPlayerOne);
		fptp.add(aiPlayerOneB);

		sptp.add(secondPlayerText);
		sptp.add(secondPeiceType);
		sptp.add(xPlayerTwo);
		sptp.add(oPlayerTwo);
		sptp.add(secondPlayerType);
		sptp.add(humanPlayerTwo);
		sptp.add(aiPlayerTwoB);

		allPanels.setLayout(new GridLayout(1,2));
		allPanels.add(fptp);
		allPanels.add(sptp);

		optionScreen.add(allPanels);
		optionScreen.add(gameInit, BorderLayout.NORTH);
		optionScreen.add(playConnect, BorderLayout.SOUTH);
		optionScreen.setTitle("CHOOSE PLAYERS!");
		optionScreen.setSize(500,300);
		optionScreen.setVisible(true);
	}

	/**
	 * Update the currentState after the player with "theSeed" has placed on
	 * (rowSelected, colSelected).
	 */
	public void updateGame(Seed theSeed, int rowSelected, int colSelected) {
		opPlayer = currentPlayer;
		//Sets column options for AI and user input
		if((rowSelected-1) != (-1)) {
			ColumnOptions[colSelected] = (rowSelected-1);
		}
		if (hasWon(theSeed)) { // check for win
			if(currentPlayer == Seed.CROSS) {
				currentState = GameState.CROSS_WON;
				optionScreenInit();
			} else if(currentPlayer == Seed.NOUGHT) {
				currentState = GameState.NOUGHT_WON;
				optionScreenInit();
			}
		} else if (isDraw()) { // check for draw
			currentState = GameState.DRAW;
			setVisible(false);
			optionScreenInit();
		} else { } // Otherwise, no change to current state (still GameState.PLAYING).
	}

	/** Return true if it is a draw (i.e., no more empty cell) */
	public boolean isDraw() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (board[row][col] == Seed.EMPTY) {
					return false; // an empty cell found, not draw, exit
				}
			}
		}
		return true; // no more empty cell, it's a draw
	}

	/**
	 * Return true if the player with "theSeed" has won after placing at
	 * (rowSelected, colSelected)
	 */
	public boolean hasWon(Seed theSeed) {
		//{l{-1,0},tl{-1,-1},t{0,-1},tr{1,-1},r{1,0},dr{1,1},d{0,1},dl{-1,1}};
		final int[][] DIRECTIONS = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
		final String [] DIR_TEXT = new String[] {"LEFT", "TOP LEFT", "TOP", "TOP RIGHT", "RIGHT", "DOWN RIGHT", "DOWN", "DOWN LEFT"};

		for(int row = 0; row < ROWS; ++row) {
			for(int col = 0; col < COLS; ++col) {
				if(board[row][col] == theSeed) {
					for(int index = 0; index < DIRECTIONS.length; ++index) {
						int[] direction = DIRECTIONS[index];
						int dx = direction[0];
						int dy = direction[1];
			
						for(int count = 1; count <= WIN_VALUE; ++count) {
							if(	(row+(dy*count) >= 0 && col+(dx*count) >= 0) &&
								(row+(dy*count) < ROWS && col+(dx*count) < COLS) ) {
								if(board[row+(dy*count)][col+(dx*count)] == theSeed) {
									if((count+1) == WIN_VALUE) {
										return true;
									}
								} else if(board[row+(dy*count)][col+(dx*count)] != theSeed) { // Failed due to opposite move or empty space
									break;
								}
							} else { // Out of array bounds
								break;
							}
						}
					}
				}
			}
		}

		return false;
	}

	/** Inner class DrawCanvas (extends JPanel) used for custom graphics drawing. */
	class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) { // invoke via repaint()
			super.paintComponent(g); // fill background
			setBackground(Color.BLACK); // set its background color

			// Draw the grid-lines
			g.setColor(Color.WHITE);
			for (int row = 1; row < ROWS; ++row) {
				g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF, CANVAS_WIDTH - 1, GRID_WIDTH, GRID_WIDTH,
						GRID_WIDTH);
			}
			for (int col = 1; col < COLS; ++col) {
				g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0, GRID_WIDTH, CANVAS_HEIGHT - 1, GRID_WIDTH,
						GRID_WIDTH);
			}

			// Draw the Seeds of all the cells if they are not empty
			// Use Graphics2D which allows us to set the pen's stroke
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Graphics2D only
			for (int row = 0; row < ROWS; ++row) {
				for (int col = 0; col < COLS; ++col) {
					int x1 = col * CELL_SIZE + CELL_PADDING;
					int y1 = row * CELL_SIZE + CELL_PADDING;
					if (board[row][col] == Seed.CROSS) {
						g2d.setColor(Color.RED);
						int x2 = (col + 1) * CELL_SIZE - CELL_PADDING;
						int y2 = (row + 1) * CELL_SIZE - CELL_PADDING;
						g2d.drawLine(x1, y1, x2, y2);
						g2d.drawLine(x2, y1, x1, y2);
					} else if (board[row][col] == Seed.NOUGHT) {
						g2d.setColor(Color.BLUE);
						g2d.drawOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
					}
				}
			}

			// Print status-bar message
			if (currentState == GameState.PLAYING) {
				statusBar.setForeground(Color.BLACK);
				if (currentPlayer == Seed.CROSS) {
					statusBar.setText("X's Turn");
				} else {
					statusBar.setText("O's Turn");
				}
			} else if (currentState == GameState.DRAW) {
				statusBar.setForeground(Color.RED);
				statusBar.setText("It's a Draw! Click to play again.");
			} else if (currentState == GameState.CROSS_WON) {
				statusBar.setForeground(Color.RED);
				statusBar.setText("'X' Won! Click to play again.");
			} else if (currentState == GameState.NOUGHT_WON) {
				statusBar.setForeground(Color.RED);
				statusBar.setText("'O' Won! Click to play again.");
			}
		}
	}

	private class RadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "X (player 1)") {
				firstPlayer = Seed.CROSS;
				secondPlayer = Seed.NOUGHT;
				currentPlayer = firstPlayer;
			}
			if (e.getActionCommand() == "O (player 1)") {
				firstPlayer = Seed.NOUGHT;
				secondPlayer = Seed.CROSS;
				currentPlayer = firstPlayer;
			}
			if (e.getActionCommand() == "X (player 2)") {
				secondPlayer = Seed.CROSS;
				firstPlayer = Seed.NOUGHT;
			}
			if (e.getActionCommand() == "O (player 2)") {
				secondPlayer = Seed.NOUGHT;
				firstPlayer = Seed.CROSS;
			}
			if (e.getActionCommand() == "Human 1") {
				currentPlayer = firstPlayer;
				humanPlayerOne = firstPlayer;
				aiPlayerOne = null;
			}
			if (e.getActionCommand() == "Computer 1") {
				currentPlayer = firstPlayer;
				aiPlayerOne = firstPlayer;
				humanPlayerOne = null;
			}
			if (e.getActionCommand() == "Human 2") {
				humanPlayerTwo = secondPlayer;
				aiPlayerTwo = null;
			}
			if (e.getActionCommand() == "Computer 2") {
				aiPlayerTwo = secondPlayer;
				humanPlayerTwo = null;
			}
			if (rowColSizeOptions.getSelectedItem() == "5x5") {
				ROWS = 5;
				COLS = 5;
			}
			if (rowColSizeOptions.getSelectedItem() == "6x6") {
				ROWS = 6;
				COLS = 6;
			}
			if (rowColSizeOptions.getSelectedItem() == "7x7") {
				ROWS = 7;
				COLS = 7;
			}
			if (rowColSizeOptions.getSelectedItem() == "8x8") {
				ROWS = 8;
				COLS = 8;
			}
			if (rowColSizeOptions.getSelectedItem() == "9x9") {
				ROWS = 9;
				COLS = 9;
			}
			if (winSizeOptions.getSelectedItem() == "Connect 4") {
				WIN_VALUE = 4;
				connect4 = true;
				ticTacToe = false;
			}
			if (winSizeOptions.getSelectedItem() == "Connect 5") {
				WIN_VALUE = 5;
				connect4 = true;
				ticTacToe = false;
			}
			if (winSizeOptions.getSelectedItem() == "TicTacToe 4") {
				WIN_VALUE = 4;
				ticTacToe = true;
				connect4 = false;
			}
			if (winSizeOptions.getSelectedItem() == "TicTacToe 5") {
				WIN_VALUE = 5;
				ticTacToe = true;
				connect4 = false;
			}
			if (e.getActionCommand() == ("Play!")) {
				CANVAS_WIDTH = CELL_SIZE * COLS; // the drawing canvas
				CANVAS_HEIGHT = CELL_SIZE * ROWS; // the drawing canvas
				// Assigns players
				canvas = new DrawCanvas(); // Construct a drawing canvas (a JPanel)
				canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
				// The canvas (JPanel) fires a MouseEvent upon mouse-click
				canvas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) { // mouse-clicked handler
						int mouseX = e.getX(); System.out.println("Mouse X: " + e.getX());
						int mouseY = e.getY(); System.out.println("Mouse Y: " + e.getX());
						// Get the row and column clicked
						int rowSelected = mouseY / CELL_SIZE; System.out.println("Row Selected: " + rowSelected);
						int colSelected = mouseX / CELL_SIZE; System.out.println("Column Selected: " + colSelected);

						//NEEDS FIX
						if( (currentState == GameState.PLAYING) && (currentPlayer == aiPlayerOne || currentPlayer == aiPlayerTwo) ) { //Only used if AI is enabled and it has the first move
							if(emptyBoard()) {
								aiTurn();
							}
						} else if( (currentState == GameState.PLAYING) && (currentPlayer != aiPlayerOne || currentPlayer != aiPlayerTwo) ) {
							if( (rowSelected < ROWS) && (colSelected >= 0) && (colSelected < COLS) && (board[rowSelected][colSelected] == Seed.EMPTY) ) {
								if(ticTacToe == true) {
									opTurn[0] = rowSelected;
									opTurn[1] = colSelected;
									board[rowSelected][colSelected] = currentPlayer; System.out.println("Human input updated board to ROW: '" + rowSelected + "' and COL: '" + colSelected + "'"); // Make a move
									updateGame(currentPlayer, rowSelected, colSelected); // update game state
								} else if(connect4 == true) {
									opTurn[0] = ColumnOptions[colSelected];
									opTurn[1] = colSelected;
									board[ColumnOptions[colSelected]][colSelected] = currentPlayer; System.out.println("Human input updated board to ROW: '" + ColumnOptions[colSelected] + "' and COL: '" + colSelected + "'"); // Make a move
									updateGame(currentPlayer, ColumnOptions[colSelected], colSelected); // update game state
								}
								repaint(); // Call-back paintComponent().
								currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS; // Switch player
								if(currentPlayer == aiPlayerOne || currentPlayer == aiPlayerTwo) {
									aiTurn();
								}
							}
						}
					}
				});

				// Setup the status bar (JLabel) to display status message
				statusBar = new JLabel("  ");
				statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
				statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));

				Container cp = getContentPane();
				cp.setLayout(new BorderLayout());
				cp.add(canvas, BorderLayout.CENTER);
				cp.add(statusBar, BorderLayout.PAGE_END); // same as SOUTH

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pack(); // pack all the components in this JFrame
				setTitle("Connect 4!");
				setVisible(true); // show this JFrame

				board = new Seed[ROWS][COLS]; // allocate array
				//sets column limit
				ColumnOptions = new int[COLS];
				for(int colIndex = 0; colIndex < COLS ; ++colIndex) { //Sets the move options to max row index value on each column
					ColumnOptions[colIndex] = (ROWS-1);
				}
				ai = new AiConnect4(WIN_VALUE, ROWS, COLS, ColumnOptions, aiPlayerOne, aiPlayerTwo, humanPlayerOne, humanPlayerTwo, board, connect4, ticTacToe);
				initGame(); // initialize the game board contents and game variables
				optionScreen.setVisible(false);
				optionScreen.dispose();
			}
		}
	}

}
