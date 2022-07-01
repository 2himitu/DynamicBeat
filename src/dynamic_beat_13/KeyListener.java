package dynamic_beat_13;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {	
	@Override
	public void keyPressed(KeyEvent e) {
		if (DynamicBeat.game==null) 
		{
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) 
		{
			DynamicBeat.game.pressS();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) 
		{
			DynamicBeat.game.pressD();
		}
		else if (e.getKeyCode() == KeyEvent.VK_F) 
		{
			DynamicBeat.game.pressF();
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) 
		{
			DynamicBeat.game.pressSapce();
		}
		else if (e.getKeyCode() == KeyEvent.VK_J) 
		{
			DynamicBeat.game.pressJ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_K) 
		{
			DynamicBeat.game.pressK();
		}
		else if (e.getKeyCode() == KeyEvent.VK_L) 
		{	
			DynamicBeat.game.pressL();
		}

	}
	
	@Override
	public void keyReleased (KeyEvent e) {
		if (DynamicBeat.game==null) {
			return;
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.releeaseS();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.releeaseD();
		}
		else if (e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.releeaseF();
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.releeaseSpace();
		}
		else if (e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.releeaseJ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.releeaseK();
		}
		else if (e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.releeaseL();
		}

	}
}
	
	
