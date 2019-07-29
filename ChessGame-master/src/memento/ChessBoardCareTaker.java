package memento;

import java.util.EmptyStackException;
import java.util.Stack;

public class ChessBoardCareTaker {
	  private Stack<ChessBoardMemento> chessBoardStatesUndo = new Stack<ChessBoardMemento>();
	  private Stack<ChessBoardMemento> chessBoardStatesRedo = new Stack<ChessBoardMemento>();	  
	  boolean flagUndo=false;
	  boolean flagRedo=false;

	  public void addChessBoardState(ChessBoardMemento chessBoardMemento){
	      chessBoardStatesUndo.push(chessBoardMemento);
	   }


	  public ChessBoardMemento getUndoState(){
		  try{
			  
		     chessBoardStatesRedo.push(chessBoardStatesUndo.pop());
		     flagUndo=false;
	         return chessBoardStatesUndo.peek();
		  }
		  catch(EmptyStackException e) {
			  if (chessBoardStatesUndo.size() == 0&&!flagUndo)
				  {
				  flagUndo=true;
				  return chessBoardStatesRedo.peek();
				  }
			   
			  
			  return null;
		  }
	   }
	  
	  public ChessBoardMemento getRedoState(){
		  try{
			  chessBoardStatesUndo.push(chessBoardStatesRedo.peek());
			  flagRedo=false;
		         return chessBoardStatesRedo.pop();
			  }
			  catch(EmptyStackException e) {
				  if (chessBoardStatesRedo.size() == 0&&!flagRedo)
					  {
					  flagRedo=true;
					  return chessBoardStatesUndo.peek();
					  }
				  return null;
			  }
	  }

	  
	  public void deleteRedoChessBoardStates()
	  {
		  chessBoardStatesRedo.clear();
	  }

}
