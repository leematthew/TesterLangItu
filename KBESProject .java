import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @(#)KBESProject.java
 *
 *
 * @author Jestel Diona C. Buenaventura
 * @author Matthew Kenneth L. Lee
 * @author Mark Jason F. Palaruan
 * @version 1.00 2016/11/16
 */

public class KBESProject extends JPanel implements MouseListener, MouseMotionListener{
	TimeTable s425 = new TimeTable("S425");
    final int WIDTH = 100;
    final int HEIGHT = 50;

    public KBESProject() {
    	this.setPreferredSize(new Dimension(WIDTH * 6, HEIGHT * 9));
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
    }

    // MouseListener methods
    public void mouseEntered(MouseEvent me) { /* not implemented */ }
    public void mouseExited(MouseEvent me) { /* not implemented */ }
    public void mousePressed(MouseEvent me) { /* not implemented */ }
    public void mouseReleased(MouseEvent me) { /* not implemented */ }

    int selectedRow = -1;
    int selectedCol = -1;
    int code = 9301;
    public void mouseClicked(MouseEvent me) {

    	if (s425.schedule[selectedRow][selectedCol] == null) {
    		s425.schedule[selectedRow][selectedCol] = code + "";

    	} else {
    		// conflict detected --- fix the problem

			// solution 1: move to a later time
		   	//selectedRow ++;

			// solution 2: move to an earlier time
    		//selectedRow --;
    		
    		//solution 3: move to a later day
    		//selectedCol++;
    		
    		//solution 4: move to an earlier day
    		//selectedCol--;
    		
    		//solution 5: move to a later time
    		//selectedRow = selectedRow + 2;
    		
    		//solution 6: move to a later time
    		//selectedRow = selectedRow + 3;
    		
    		//solution 7: move to a later time
    		//selectedRow = selectedRow + 4;
    		
    		//solution 8: move to a later time
    		//selectedRow = selectedRow + 5;
    		
    		//solution 9: move to a later time
    		//selectedRow = selectedRow + 6;
    		
    		//solution 10: move to a later time
    		//selectedRow = selectedRow + 7;
    		
    		//solution 11: move to the last time 
    		//selectedRow = selectedRow + 8;
    		
    		//solution 12: move to an earlier time
    		//selectedRow = selectedRow - 2;
    		
    		//solution 13: 
    		//selectedCol = selectedCol + 2;
    		
    		//solution 14: move to an earlier day
    		//selectedCol = selectedCol - 2;
    		
    		//solution 15: move two days earlier / move to Wednesday column
    		//selectedCol = selectedCol - 3;
    		
    		//solution 16: move three days earlier / move to Tuesday column
    		//selectedCol = selectedCol - 4;
    		
    		//solution 17: move four days earlier / move to Monday column
    		//selectedCol = selectedCol - 5;
    		
    		//solution 18: Diagonal going to the right downwards
    		//selectedRow ++;
    		//selectedCol++;
    		
    		//solution 19: Diagonal going to the left downwards
    		//selectedRow ++;
    		//selectedCol--;
    		
    		//solution 20: Diagonal going to the right upwards
    		//selectedRow --;
    		//selectedCol++;
    		
    		//solution 21: Diagonal going to the left upwards
    		//selectedRow --;
    		//selectedCol--;
    		
    		//solution 22: Left to right per row
/*    		for(int row = 8; row > -1; row--){
				for (int column = 0; column <6; column++){
					if(s425.schedule[row][column]==null){
						selectedRow = row;
						selectedCol = column;
						break;
					}
				}
			}
*/
    		
    		//solution 23: top to bottom per column
/*    		for(int column = 5; column > -1; column--){
				for (int row = 0; row < 9; row++){
					if(s425.schedule[row][column]==null){
						selectedRow = row;
						selectedCol = column;
						break;
					}
				}
			}
*/
			
			//solution 24: bottom to top column
/*			for(int column = 5; column > -1; column--){
				for (int row = 0; row < 9; row++){
					if(s425.schedule[row][column]==null){
						selectedRow = row;
						selectedCol = column;			
					}
				}
			}
*/
			//solution 25: right to left row 
/*			for(int row = 8; row > -1; row--){
				for (int column = 0; column <6; column++){
					if(s425.schedule[row][column]==null){
						selectedRow = row;
						selectedCol = column;
					}
				}
			}		
 */  
			
    		
    		s425.schedule[selectedRow][selectedCol] = code + "";
    	}

		code ++;
    	repaint();
    }

    // MouseMotionListener methods
    public void mouseDragged(MouseEvent me) { /* not implemented */ }
    public void mouseMoved(MouseEvent me) {
    	selectedRow = me.getY() / HEIGHT;
    	selectedCol = me.getX() / WIDTH;

    	repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);

    	Graphics2D canvas = (Graphics2D)g;
    	String[][] s = s425.schedule;

    	canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    	// draw the marker
    	canvas.setColor(Color.GREEN);
    	canvas.fill(new Rectangle2D.Double(selectedCol * WIDTH, selectedRow * HEIGHT, WIDTH - 3, HEIGHT - 3));

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 6; col++) {
				if (s[row][col] == null) {
			    	canvas.setColor(Color.LIGHT_GRAY);
			    	canvas.draw(new Rectangle2D.Double(col * WIDTH, row * HEIGHT, WIDTH - 3, HEIGHT - 3));

				} else {
			    	canvas.setColor(Color.BLACK);
			    	canvas.draw(new Rectangle2D.Double(col * WIDTH, row * HEIGHT, WIDTH - 3, HEIGHT - 3));

			    	canvas.setFont(new Font("Consolas", Font.PLAIN, 24));
			    	canvas.drawString(s[row][col], col * WIDTH + 5, row * HEIGHT + 25);
				}
			}
		}


    }

    public static void main(String[] args) {
        JFrame frame;

        frame = new JFrame("KBES Finals");
        frame.setContentPane(new KBESProject());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TimeTable {
	String label;
	String[][] schedule;

	public TimeTable(String label) {
		this.label = label;
		this.schedule = new String[9][6];
	}
}