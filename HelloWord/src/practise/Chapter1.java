package practise;

public class Chapter1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
//国际象棋类层次结构（王，后，象，马，车，兵）
class ChessPiece {
    String color;
    int startingPosition;
}//每种棋子都要颜色和初始位置，所以定义一个超类
class King extends ChessPiece {
    int forwardMovement = 1;
    int sideMovement = 1;
}//王只能走一步，有步数限制，所以变量定义1
class Queen extends ChessPiece {
    int forwardMovement;
    int sideMovement;
}
class Bishop extends ChessPiece {
    int forwardMovement;
    int sideMovement;
}
class Knight extends ChessPiece {
    int forwardMovement;
    int sideMovement;
}
class Rook extends ChessPiece {
    int forwardMovement;
    int sideMovement;
}
class Pawn extends ChessPiece {
    int forwardMovement = 1;
    int sideMovement = 0;
}//兵只能向前走，所以sideMovment=0