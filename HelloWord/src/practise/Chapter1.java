package practise;

public class Chapter1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
//�����������νṹ��������������������
class ChessPiece {
    String color;
    int startingPosition;
}//ÿ�����Ӷ�Ҫ��ɫ�ͳ�ʼλ�ã����Զ���һ������
class King extends ChessPiece {
    int forwardMovement = 1;
    int sideMovement = 1;
}//��ֻ����һ�����в������ƣ����Ա�������1
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
}//��ֻ����ǰ�ߣ�����sideMovment=0