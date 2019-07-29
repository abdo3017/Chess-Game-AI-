package memento;


public class ChessBoardOriginator {
	   
	private ChessBoardState chessBoardState;

	public void setState(ChessBoardState chessBoardState){
	      this.chessBoardState = new ChessBoardState( chessBoardState.getChessPieces(),chessBoardState.getCapturedPieces(),chessBoardState.getSquares(),chessBoardState.getPlayTurn());
	   }

    public ChessBoardState getState(){
	      return chessBoardState; 
	   }

	public ChessBoardMemento saveStateToMemento(){
	      return new ChessBoardMemento(chessBoardState);
	   }

	public void getStateFromMemento(ChessBoardMemento chessBoardMemento){
	      chessBoardState = chessBoardMemento.getState();
	   }

}
