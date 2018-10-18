import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** TicTacToe: Two-player Graphics version with Simple-OO */
@SuppressWarnings("serial")
public class TicTacToe extends JFrame {
	//Ai
	private AiTicTacToe ai;
	// Shows player options for game
	public static JPanel startingScreen;
	// Initializes game
	public static JFrame optionScreen;
	// Named-constants for the game board
	protected static int ROWS = 3; // ROWS cells
	protected static int COLS = 3; // COLS cells
	// Named-constants of the various dimensions used for graphics drawing
	public static int CELL_SIZE = 100; // cell width and height (square)
	public static int CANVAS_WIDTH = CELL_SIZE * COLS; // the drawing
																// canvas
	public static int CANVAS_HEIGHT = CELL_SIZE * ROWS;
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

	protected enum GameState {
		PLAYING, DRAW, CROSS_WON, NOUGHT_WON
	}

	protected GameState currentState; // the current game state
	// Use an enumeration (inner class) to represent the seeds and cell contents
	protected enum Seed {
		EMPTY, CROSS, NOUGHT
	}
	protected Seed firstPlayer, secondPlayer;
	protected Seed currentPlayer; // The current player
	protected Seed humanPlayer;
	protected Seed aiPlayer;
	protected Seed[][] board; // Game board of ROWS-by-COLS cells
	private DrawCanvas canvas; // Drawing canvas (JPanel) for the game board
	private JLabel statusBar; // Status Bar
	protected int aiDelay= 1000;
	
	/** Constructor to setup the game and the GUI components */
	public TicTacToe() {
		optionScreenInit();
	}

	public void aiTurn() {
		Timer aiTimer;
		aiTimer = new Timer(1000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(currentPlayer == aiPlayer) {
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
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				board[row][col] = Seed.EMPTY; // make all cells empty
			}
		}
		currentState = GameState.PLAYING; // ready to play
	}

	public void optionScreenInit() {
		optionScreen = new JFrame();
		JPanel allPanels = new JPanel();
		JPanel fptp = new JPanel(new GridLayout(7,1));
		JPanel sptp = new JPanel(new GridLayout(7,1));

		JLabel firstPlayerText = new JLabel("FIRST PLAYER");
		JLabel secondPlayerText = new JLabel("SECOND PLAYER");
		JLabel firstPlayerType = new JLabel("Choose player type");
		JLabel secondPlayerType = new JLabel("Choose player type");
		JLabel firstPeiceType = new JLabel("Choose X or O");
		JLabel secondPeiceType = new JLabel("Choose X or O");

		JButton playTicTacToe = new JButton("Play TicTacToe!");
		playTicTacToe.addActionListener(new RadioButtonListener());
		JRadioButton humanPlayerOne =  new JRadioButton("Human 1");
		humanPlayerOne.addActionListener(new RadioButtonListener());
		JRadioButton aiPlayerOne =  new JRadioButton("Computer 1");
		aiPlayerOne.addActionListener(new RadioButtonListener());
		JRadioButton xPlayerOne = new JRadioButton("X (player 1)");
		xPlayerOne.addActionListener(new RadioButtonListener());
		JRadioButton oPlayerOne = new JRadioButton("O (player 1)");
		oPlayerOne.addActionListener(new RadioButtonListener());
		JRadioButton humanPlayerTwo =  new JRadioButton("Human 2");
		humanPlayerTwo.addActionListener(new RadioButtonListener());
		JRadioButton aiPlayerTwo =  new JRadioButton("Computer 2");
		aiPlayerTwo.addActionListener(new RadioButtonListener());
		JRadioButton xPlayerTwo = new JRadioButton("X (player 2)");
		xPlayerTwo.addActionListener(new RadioButtonListener());
		JRadioButton oPlayerTwo = new JRadioButton("O (player 2)");
		oPlayerTwo.addActionListener(new RadioButtonListener());

		ButtonGroup FPTButtonGroup = new ButtonGroup();
		FPTButtonGroup.add(humanPlayerOne);
		FPTButtonGroup.add(aiPlayerOne);
		ButtonGroup SPTButtonGroup = new ButtonGroup();
		SPTButtonGroup.add(humanPlayerTwo);
		SPTButtonGroup.add(aiPlayerTwo);
		ButtonGroup FPMButtonGroup = new ButtonGroup();
		FPMButtonGroup.add(xPlayerOne);
		FPMButtonGroup.add(xPlayerTwo);
		ButtonGroup SPMButtonGroup = new ButtonGroup();
		SPMButtonGroup.add(oPlayerOne);
		SPMButtonGroup.add(oPlayerTwo);

		fptp.add(firstPlayerText);
		fptp.add(firstPeiceType);
		fptp.add(xPlayerOne);
		fptp.add(oPlayerOne);
		fptp.add(firstPlayerType);
		fptp.add(humanPlayerOne);
		fptp.add(aiPlayerOne);

		sptp.add(secondPlayerText);
		sptp.add(secondPeiceType);
		sptp.add(xPlayerTwo);
		sptp.add(oPlayerTwo);
		sptp.add(secondPlayerType);
		sptp.add(humanPlayerTwo);
		sptp.add(aiPlayerTwo);

		allPanels.setLayout(new GridLayout(1,2));
		allPanels.add(fptp);
		allPanels.add(sptp);

		optionScreen.add(allPanels);
		optionScreen.add(playTicTacToe, BorderLayout.SOUTH);
		optionScreen.setTitle("CHOOSE PLAYERS!");
		optionScreen.setSize(400,200);
		optionScreen.setVisible(true);
	}
	
	/**
	 * Update the currentState after the player with "theSeed" has placed on
	 * (rowSelected, colSelected).
	 */
	public void updateGame(Seed theSeed, int rowSelected, int colSelected) {
		if (hasWon(theSeed, rowSelected, colSelected)) { // check for win
			currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
		} else if (isDraw()) { // check for draw
			currentState = GameState.DRAW;
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
	public boolean hasWon(Seed theSeed, int rowSelected, int colSelected) {
		return ( ((board[rowSelected][0] == theSeed) && (board[rowSelected][1] == theSeed && board[rowSelected][2] == theSeed)) || // 3-in-the-row
				 ((board[0][colSelected] == theSeed) && (board[1][colSelected] == theSeed && board[2][colSelected] == theSeed)) || // 3-in-the-column
				 ((rowSelected == colSelected) && (board[0][0] == theSeed && board[1][1] == theSeed && board[2][2] == theSeed)) || // 3-in-the-diagonal
				 ((rowSelected + colSelected == 2) && (board[0][2] == theSeed && board[1][1] == theSeed && board[2][0] == theSeed)) ); // 3-in-the-opposite-diagonal
	}

	/** Inner class DrawCanvas (extends JPanel) used for custom graphics drawing. */
	class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) { // invoke via repaint()
			super.paintComponent(g); // fill background
			setBackground(Color.WHITE); // set its background color

			// Draw the grid-lines
			g.setColor(Color.LIGHT_GRAY);
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
			g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Graphics2D
																												// only
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
				currentPlayer = firstPlayer;
			}
			if (e.getActionCommand() == "O (player 1)") {
				firstPlayer = Seed.NOUGHT;
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
				humanPlayer = firstPlayer;
				if(aiPlayer == Seed.CROSS) {
				}
				if(aiPlayer == Seed.NOUGHT) {
				}
			}
			if (e.getActionCommand() == "Computer 1") {
				currentPlayer = firstPlayer;
				aiPlayer = firstPlayer;
				if(aiPlayer == Seed.CROSS) {
				}
				if(aiPlayer == Seed.NOUGHT) {
				}
			}
			if (e.getActionCommand() == "Human 2") {
				humanPlayer = secondPlayer;
			}
			if (e.getActionCommand() == "Computer 2") {
				aiPlayer = secondPlayer;
			}
			if (e.getActionCommand() == "Play TicTacToe!") {
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
						if( (currentState == GameState.PLAYING) && (currentPlayer == aiPlayer) ) { //Only used if AI is enabled and it has the first move
							if(ai.emptyBoard()) {
								aiTurn();
							}
						} else if( (currentState == GameState.PLAYING) && (currentPlayer != aiPlayer) ) {
							if( (rowSelected >= 0) && (rowSelected < ROWS) && (colSelected >= 0) && (colSelected < COLS) && (board[rowSelected][colSelected] == Seed.EMPTY) ) {
								board[rowSelected][colSelected] = currentPlayer; System.out.println("Human input updated board to ROW: '" + rowSelected + "' and COL: '" + colSelected + "'"); // Make a move
								updateGame(currentPlayer, rowSelected, colSelected); // update game state
								repaint(); // Call-back paintComponent().
								currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS; // Switch player
								if(currentPlayer == aiPlayer) {
									aiTurn();
								}
							}
						} else if(currentState == GameState.DRAW || currentState == GameState.CROSS_WON || currentState == GameState.NOUGHT_WON){ // game over
							optionScreenInit();
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
				setTitle("Tic Tac Toe");
				setVisible(true); // show this JFrame

				board = new Seed[ROWS][COLS]; // allocate array
				ai = new AiTicTacToe(ROWS, COLS, aiPlayer, humanPlayer, currentPlayer, board);
				initGame(); // initialize the game board contents and game variables
				optionScreen.setVisible(false);
				optionScreen.dispose();
			}
		}
	}

}
