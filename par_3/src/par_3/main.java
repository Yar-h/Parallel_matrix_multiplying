package par_3;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ScrollPaneConstants;

public class main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox chckbxDisplay;
	private JComboBox combo_fox_threads;
	private JTextField txt_tape_rows;
	private JTextField txt_tape_cols;
	private JTextField txt_fox_cols;
	private JTextField txt_fox_rows;
	private JTextField txt_tape_threads;
	private JTextField tape_time;
	private JTextField fox_time;
	private int tape_rows=0;
	private int tape_cols=0;
	private int tape_threads=0;
	private int fox_rows=0;
	private int fox_cols=0;
	private int fox_threads=0;
	private Matrix arr1;
	private Matrix arr2;
	private Matrix Result;
	private JTable table_1;
	private JTable table_2;
	private JTable table_res;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setBackground(Color.WHITE);
		setUndecorated(true);
		Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setOpacity(0.95f);
		setTitle("Lab 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)(ScreenSize.getWidth()/2)-263, (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-265, 527, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(50, 50, 200), 4, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(485, 3, 39, 27);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 8));
		btnNewButton.setBackground(Color.RED);
				
				JPanel panel_6 = new JPanel();
				panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tape algorithm", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panel_6.setBounds(7, 29, 250, 90);
				contentPane.add(panel_6);
				panel_6.setLayout(null);
				
				JLabel lblMatrixRows = new JLabel("Matrix rows:");
				lblMatrixRows.setBounds(10, 20, 71, 14);
				panel_6.add(lblMatrixRows);
				
				txt_tape_rows = new JTextField();
				txt_tape_rows.setBorder(new LineBorder(Color.BLACK, 1, true));
				txt_tape_rows.setHorizontalAlignment(SwingConstants.CENTER);
				txt_tape_rows.setText("0");
				txt_tape_rows.setBounds(91, 17, 48, 20);
				panel_6.add(txt_tape_rows);
				txt_tape_rows.setColumns(5);
				
				txt_tape_cols = new JTextField();
				txt_tape_cols.setBorder(new LineBorder(Color.BLACK, 1, true));
				txt_tape_cols.setText("0");
				txt_tape_cols.setHorizontalAlignment(SwingConstants.CENTER);
				txt_tape_cols.setColumns(5);
				txt_tape_cols.setBounds(91, 39, 48, 20);
				panel_6.add(txt_tape_cols);
				
				JLabel lblMatrixCols = new JLabel("Matrix cols:");
				lblMatrixCols.setBounds(10, 42, 71, 14);
				panel_6.add(lblMatrixCols);
				
				JLabel lblThreads = new JLabel("Threads:");
				lblThreads.setBounds(10, 64, 71, 14);
				panel_6.add(lblThreads);
				
				txt_tape_threads = new JTextField();
				txt_tape_threads.setBorder(new LineBorder(Color.BLACK, 1, true));
				txt_tape_threads.setText("1");
				txt_tape_threads.setHorizontalAlignment(SwingConstants.CENTER);
				txt_tape_threads.setColumns(5);
				txt_tape_threads.setBounds(91, 61, 48, 20);
				panel_6.add(txt_tape_threads);
				
				JButton btn_tape = new JButton("Execute");
				btn_tape.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if ( (Integer.valueOf(txt_tape_rows.getText())<1)||(Integer.valueOf(txt_tape_cols.getText())<1)||(Integer.valueOf(txt_tape_threads.getText())<1)) return;
						tape_time.setText("");
						tape_rows=Integer.valueOf(txt_tape_rows.getText());
						tape_cols=Integer.valueOf(txt_tape_cols.getText());
						tape_threads=Integer.valueOf(txt_tape_threads.getText());
						arr1=new Matrix(tape_rows, tape_cols, true);
						arr2=new Matrix(tape_cols, tape_rows, true);
						Result = new Matrix(arr1.getRows(), arr2.getCols(), false);

						if (chckbxDisplay.isSelected()){	//display
							((DefaultTableModel)table_res.getModel()).setRowCount(arr1.getRows());
							((DefaultTableModel)table_res.getModel()).setColumnCount(arr2.getCols());
							((DefaultTableModel)table_1.getModel()).setRowCount(tape_rows);
							((DefaultTableModel)table_1.getModel()).setColumnCount(tape_cols);
							for (int i = 0; i < tape_rows; i++) {
								for (int j = 0; j < tape_cols; j++) {
									((DefaultTableModel)table_1.getModel()).setValueAt(arr1.get(i, j), i,j);
								}
							}
							((DefaultTableModel)table_2.getModel()).setRowCount(tape_cols);
							((DefaultTableModel)table_2.getModel()).setColumnCount(tape_rows);
							for (int i = 0; i < tape_cols; i++) {
								for (int j = 0; j < tape_rows; j++) {
									((DefaultTableModel)table_2.getModel()).setValueAt(arr2.get(i, j), i,j);
								}
							}
						}	//display*/
						if ((tape_cols==0)||(tape_cols==0)||(tape_threads==0)) return;
						long timeStart=0;
						long timeEnd=0;
						long time = 0;
						//Tables are created, filled and Displayed
						/* Start sequential multiply */
					       int m = arr1.getRows();
					        int n = arr2.getCols();
					        int o = arr2.getRows();
						timeStart=System.nanoTime();					        
					        for (int i = 0; i < m; i++) {
					            for (int j = 0; j < n; j++) {
					                for (int k = 0; k < o; k++) {
					                	Result.set(i, j, Result.get(i, j)+ arr1.get(i, k) * arr2.get(k, j)); 
					                }
					            }
					        }
						timeEnd=System.nanoTime();	
						time = timeEnd-timeStart;
						tape_time.setText(""+String.format("%.2f",time/1e6)+"/");
						System.out.println("Sequental multiply time = "+String.format("%.2f",time/1e6)+" ms");
						/* End sequential multiply */
						/* Start tape multiply */
						timeStart=System.nanoTime();
						/*----------------------------------------------------------*/
						Multiplier.numberOfThreads=tape_threads;
						Multiplier.row_count=tape_rows;
						Multiplier.col_count=tape_cols;
						Multiplier.Result=Result;
						Multiplier.arr1=arr1;
						Multiplier.arr2=arr2;
						Multiplier.multiply();
						try {Multiplier.lock.await();} catch (InterruptedException e) {e.printStackTrace();}
						timeEnd=System.nanoTime();
						/*----------------------------------------------------------*/
						
						
						time = timeEnd-timeStart;
						tape_time.setText(tape_time.getText()+String.format("%.2f",time/1e6));
						System.out.println("Tape multiply time = "+String.format("%.2f",time/1e6)+" ms");
						/* End tape multiply */
						
					}
				});
				btn_tape.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				btn_tape.setBackground(Color.WHITE);
				btn_tape.setBounds(149, 16, 89, 23);
				panel_6.add(btn_tape);
				
				tape_time = new JTextField();
				tape_time.setToolTipText("Sequential/Parallel");
				tape_time.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Time", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				tape_time.setBounds(149, 42, 89, 39);
				panel_6.add(tape_time);
				tape_time.setColumns(10);
				
				JPanel panel_7 = new JPanel();
				panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Fox's algorithm", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panel_7.setBounds(267, 29, 250, 90);
				contentPane.add(panel_7);
				panel_7.setLayout(null);
				
				txt_fox_cols = new JTextField();
				txt_fox_cols.setEditable(false);
				txt_fox_cols.setBorder(new LineBorder(Color.BLACK, 1, true));
				txt_fox_cols.setText("0");
				txt_fox_cols.setHorizontalAlignment(SwingConstants.CENTER);
				txt_fox_cols.setColumns(5);
				txt_fox_cols.setBounds(91, 39, 48, 20);
				panel_7.add(txt_fox_cols);
				
				txt_fox_rows = new JTextField();
				txt_fox_rows.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						combo_fox_threads.removeAllItems();
						txt_fox_cols.setText(txt_fox_rows.getText());
						int q=Integer.parseInt(txt_fox_cols.getText());
						for (int i=1;(i<50)&&(i<=q*q);i++){
							if (i%(Math.sqrt(Double.parseDouble(i+"")))==0){
								if (q%Math.sqrt(i)==0) combo_fox_threads.addItem(i);
							}
						}
					}
				});
				txt_fox_rows.setBorder(new LineBorder(Color.BLACK, 1, true));
				txt_fox_rows.setText("0");
				txt_fox_rows.setHorizontalAlignment(SwingConstants.CENTER);
				txt_fox_rows.setColumns(5);
				txt_fox_rows.setBounds(91, 17, 48, 20);
				panel_7.add(txt_fox_rows);
				
				JLabel label = new JLabel("Matrix rows:");
				label.setBounds(10, 20, 71, 14);
				panel_7.add(label);
				
				JLabel label_1 = new JLabel("Matrix cols:");
				label_1.setBounds(10, 42, 71, 14);
				panel_7.add(label_1);
				
				JLabel label_2 = new JLabel("Threads:");
				label_2.setBounds(10, 65, 71, 14);
				panel_7.add(label_2);
				
				JButton btn_fox = new JButton("Execute");
				btn_fox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if ( (Integer.valueOf(txt_fox_rows.getText())<1)||(Integer.valueOf(txt_fox_cols.getText())<1)||(Integer.valueOf(combo_fox_threads.getSelectedItem().toString())<1)) return;
						fox_time.setText("");
						fox_rows=Integer.valueOf(txt_fox_rows.getText());
						fox_cols=Integer.valueOf(txt_fox_cols.getText());
						fox_threads=Integer.valueOf(combo_fox_threads.getSelectedItem().toString());
						arr1=new Matrix(fox_rows, fox_cols, true);
						arr2=new Matrix(fox_cols, fox_rows, true);
						Result = new Matrix(arr1.getRows(), arr2.getCols(), false);

						if (chckbxDisplay.isSelected()){	//display
							((DefaultTableModel)table_res.getModel()).setRowCount(arr1.getRows());
							((DefaultTableModel)table_res.getModel()).setColumnCount(arr2.getCols());
							((DefaultTableModel)table_1.getModel()).setRowCount(fox_rows);
							((DefaultTableModel)table_1.getModel()).setColumnCount(fox_cols);
							for (int i = 0; i < fox_rows; i++) {
								for (int j = 0; j < fox_cols; j++) {
									((DefaultTableModel)table_1.getModel()).setValueAt(arr1.get(i, j), i,j);
								}
							}
							((DefaultTableModel)table_2.getModel()).setRowCount(fox_cols);
							((DefaultTableModel)table_2.getModel()).setColumnCount(fox_rows);
							for (int i = 0; i < fox_cols; i++) {
								for (int j = 0; j < fox_rows; j++) {
									((DefaultTableModel)table_2.getModel()).setValueAt(arr2.get(i, j), i,j);
								}
							}
						}	//display*/
						if ((fox_cols==0)||(fox_cols==0)||(fox_threads==0)) return;
						long timeStart=0;
						long timeEnd=0;
						long time = 0;
						//Tables are created, filled and Displayed
						/* Start sequential multiply */
					       int m = arr1.getRows();
					        int n = arr2.getCols();
					        int o = arr2.getRows();
						timeStart=System.nanoTime();	
						System.out.println("Start seq = "+timeStart);
					        for (int i = 0; i < m; i++) {
					            for (int j = 0; j < n; j++) {
					                for (int k = 0; k < o; k++) {
					                	Result.set(i, j, Result.get(i, j)+ arr1.get(i, k) * arr2.get(k, j)); 
					                }
					            }
					        }
						timeEnd=System.nanoTime();	
						System.out.println("End seq = "+timeEnd);
						time = timeEnd-timeStart;
						fox_time.setText(""+String.format("%.2f",time/1e6)+"/");
						System.out.println("Sequental multiply time = "+String.format("%.2f",time/1e6)+" ms");
						/* End sequential multiply */
						/* Start fox multiply */
						/*----------------------------------------------------------*/
						Result.reset();
						timeStart=System.nanoTime();	
						System.out.println("Start = "+timeStart);
						MultiplierFox.numberOfThreads=fox_threads;
						MultiplierFox.row_count=fox_rows;
						MultiplierFox.col_count=fox_cols;
						MultiplierFox.Result=Result;
						MultiplierFox.arr1=arr1;
						MultiplierFox.arr2=arr2;
						MultiplierFox.multiply();
						MultiplierFox.table=table_res;
						
						try {MultiplierFox.lock.await();} catch (InterruptedException e) {e.printStackTrace();}
						timeEnd=System.nanoTime();
						System.out.println("End = "+timeEnd);
						/*----------------------------------------------------------*/
						if (chckbxDisplay.isSelected()){	//display
						for (int i = 0; i < arr1.getRows(); i++) {
							for (int j = 0; j < arr2.getCols(); j++) {
								((DefaultTableModel)table_res.getModel()).setValueAt(Result.get(i, j), i,j);
							}
						}
						}	//display*/
						
						time = timeEnd-timeStart;
						fox_time.setText(fox_time.getText()+String.format("%.2f",time/1e6));
						System.out.println("fox multiply time = "+String.format("%.2f",time/1e6)+" ms");
						/* End fox multiply */
					}
				});
				btn_fox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				btn_fox.setBackground(Color.WHITE);
				btn_fox.setBounds(149, 16, 89, 23);
				panel_7.add(btn_fox);
				
				fox_time = new JTextField();
				fox_time.setToolTipText("Sequential/Parallel");
				fox_time.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Time", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				fox_time.setBounds(149, 42, 89, 39);
				panel_7.add(fox_time);
				fox_time.setColumns(10);
				
				combo_fox_threads = new JComboBox();
				combo_fox_threads.setBounds(91, 62, 48, 20);
				panel_7.add(combo_fox_threads);
				
				JPanel panel_8 = new JPanel();
				panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_8.setBackground(Color.WHITE);
				panel_8.setBounds(7, 129, 517, 140);
				contentPane.add(panel_8);
				panel_8.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBackground(Color.WHITE);
				scrollPane.setBounds(10, 11, 248, 118);
				panel_8.add(scrollPane);
				
				table_1 = new JTable();
				table_1.setBackground(Color.WHITE);
				scrollPane.setViewportView(table_1);
				table_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(259, 11, 248, 118);
				panel_8.add(scrollPane_1);
				
				table_2 = new JTable();
				scrollPane_1.setViewportView(table_2);
				table_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
				JPanel panel_9 = new JPanel();
				panel_9.setBackground(Color.WHITE);
				panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_9.setBounds(7, 279, 517, 178);
				contentPane.add(panel_9);
				panel_9.setLayout(null);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane_2.setBounds(10, 11, 497, 156);
				panel_9.add(scrollPane_2);
				
				table_res = new JTable();
				scrollPane_2.setViewportView(table_res);
				table_res.setBackground(Color.WHITE);
				table_res.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
				chckbxDisplay = new JCheckBox("Display matrices");
				chckbxDisplay.setBounds(7, 3, 127, 22);
				contentPane.add(chckbxDisplay);
				chckbxDisplay.setOpaque(false);
				chckbxDisplay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}

}
