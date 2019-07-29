package memento;


public class ChessBoardMemento {
     private ChessBoardState chessBoardState;
     
     public ChessBoardMemento(ChessBoardState chessBoardState){
	      this.chessBoardState = new ChessBoardState( chessBoardState.getChessPieces(),chessBoardState.getCapturedPieces(),chessBoardState.getSquares(),chessBoardState.getPlayTurn());
	   }
     public ChessBoardMemento(){
	   }

	 public ChessBoardState getState(){
	      return chessBoardState;
	   }	
}
