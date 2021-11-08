import java.util.*;

public class TicTacToe {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
		System.out.print("HI WELCOME TO THE GAME, Enter your name: ");

		String name = sc.nextLine();

		printGameBoard(gameBoard);
		while (true) {

			System.out.print("Hi " + name + " enter your placement (1-9) for the upper Tic Tac Toe Board: ");

			int playerPos = sc.nextInt();
			while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
				System.out.println("Position taken! Enter another position");
				playerPos = sc.nextInt();
			}

			placePiece(gameBoard, playerPos, "player");
			String result = checkWinner();
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPositions)) {
				System.out.println("Position taken! Enter another position");
				cpuPos = rand.nextInt(9) + 1;
			}
			placePiece(gameBoard, cpuPos, "cpu");

			printGameBoard(gameBoard);

			result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			System.out.println(result);
		}
		sc.close();
	}

	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static void placePiece(char[][] gameBoard, int pos, String user) {

		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}

		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;

		}

	}

	public static String checkWinner() {

		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftColumn = Arrays.asList(1, 4, 7);
		List middleColumn = Arrays.asList(2, 5, 8);
		List rightColumn = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);

		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(middleRow);
		winningConditions.add(bottomRow);
		winningConditions.add(leftColumn);
		winningConditions.add(middleColumn);
		winningConditions.add(rightColumn);
		winningConditions.add(cross1);
		winningConditions.add(cross2);

		for (List l : winningConditions) {
			if (playerPositions.containsAll(l)) {
				return "Congratualtions you won!";
			} else if (cpuPositions.containsAll(l)) {
				return "You Lost, CPU wins!";
			} else if (playerPositions.size() + cpuPositions.size() == 9) {
				return "Draw";
			}
		}

		return "";
	}

}
