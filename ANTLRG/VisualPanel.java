import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Point;

import javax.management.StringValueExp;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;

import java.awt.TextArea;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.Caret;
import javax.swing.text.DefaultEditorKit;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import sun.security.action.OpenFileInputStreamAction;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.Font;


public class VisualPanel {

	private JFrame frame;
	private Path file = Paths.get("ErrorLog_Syntax.log");
	private List<String> Errors;
	Visitor type;
	convVisitor conv;
	int regNum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualPanel window = new VisualPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisualPanel() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("FreeSans", Font.PLAIN, 35));
		frame.setBounds(100, 100, 2600, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane1.setBounds(50, 90, 1800, 1000);
		frame.getContentPane().add(tabbedPane1);
		
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane2.setBounds(1899, 90, 664, 1000);
		frame.getContentPane().add(tabbedPane2);
		
		TextArea textArea3 = new TextArea();
		textArea3.setFont(new Font("FreeSans", Font.PLAIN, 25));
		tabbedPane2.addTab("Error", null, textArea3, null);
		
		TextArea textArea1 = new TextArea();
		textArea1.setFont(new Font("FreeSans", Font.PLAIN, 33));
		tabbedPane1.addTab("Gramatica", null, textArea1, null);
		
		TextArea textArea2 = new TextArea();
		textArea2.setFont(new Font("FreeSans", Font.PLAIN, 33));
		
		TextArea textArea4 = new TextArea();
		textArea4.setFont(new Font("FreeSans", Font.PLAIN, 33));
		tabbedPane1.addTab("Codigo Intermedio", null, textArea4, null);
		
		TextArea textArea5 = new TextArea();
		textArea5.setFont(new Font("FreeSans", Font.PLAIN, 33));
		tabbedPane1.addTab("ARM", null, textArea5, null);
		
		/***textArea2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				Caret c;
				Point p = caret.getMagicCaretPosition();
				
				

				aFrameYourePositioning.setLocation(p);
				// TODO Auto-generated method stub
				int c = e.getKeyCode ();
		        if (c==KeyEvent.VK_UP) {                
		        	p.y -= textArea2.getLocationOnScreen().y;  
		        } else if(c==KeyEvent.VK_DOWN) {                
		        	p.y += textArea2.getLocationOnScreen().y;  
		        } else if(c==KeyEvent.VK_LEFT) {                
		        	p.x -= textArea2.getLocationOnScreen().x;   
		        } else if(c==KeyEvent.VK_RIGHT) {                
		        	p.x += textArea2.getLocationOnScreen().x;  
		        }
		        
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				Caret caret = textArea2.getCaretPosition();
				Point p = caret.getMagicCaretPosition();
				
				

				aFrameYourePositioning.setLocation(p);
				// TODO Auto-generated method stub
				int c = e.getKeyCode ();
		        if (c==KeyEvent.VK_UP) {                
		        	p.y -= textArea2.getLocationOnScreen().y;  
		        } else if(c==KeyEvent.VK_DOWN) {                
		        	p.y += textArea2.getLocationOnScreen().y;  
		        } else if(c==KeyEvent.VK_LEFT) {                
		        	p.x -= textArea2.getLocationOnScreen().x;   
		        } else if(c==KeyEvent.VK_RIGHT) {                
		        	p.x += textArea2.getLocationOnScreen().x;  
		        }
				
			}
		};)***/
		tabbedPane1.addTab("Test", null, textArea2, null); 
		
		JPanel treePanel = new JPanel();
		//tabbedPane1.addTab("Arbol", null, treePanel, null);
		
		JMenuBar Menu = new JMenuBar();
		Menu.setBounds(46, 30, 140, 30);
		
		JMenu File = new JMenu("File");
		File.setFont(new Font("FreeSans",Font.PLAIN, 25));
		
		JMenu Edit = new JMenu("Edit");
		Edit.setFont(new Font("FreeSans", Font.PLAIN, 25));
		Menu.add(File);
		
		JMenuItem open = new JMenuItem("Open",KeyEvent.VK_A);
		open.setFont(new Font("FreeSans", Font.PLAIN, 23));
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				openFile(textArea1,textArea2,textArea3);
			}	
		});
		JMenuItem save = new JMenuItem("Save",KeyEvent.VK_A);
		save.setFont(new Font("FreeSans", Font.PLAIN, 23));
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ProbandoAction button
				saveFile(textArea1,textArea2,textArea3);
			}	
		});
		JMenuItem quit = new JMenuItem("Quit",KeyEvent.VK_A);
		quit.setFont(new Font("FreeSans", Font.PLAIN, 23));
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
			}
	    });
		File.add(open);
		File.add(save);
		File.add(quit);
		
		Menu.add(Edit);
		
		JMenuItem cut = new JMenuItem("Cut",KeyEvent.VK_A);
		cut.setFont(new Font("FreeSans", Font.PLAIN, 23));
		JMenuItem copy = new JMenuItem("Copy",KeyEvent.VK_A);
		copy.setFont(new Font("FreeSans", Font.PLAIN, 23));
		JMenuItem paste = new JMenuItem("Paste",KeyEvent.VK_A);
		paste.setFont(new Font("FreeSans", Font.PLAIN, 23));
		cut.setAction(new DefaultEditorKit.CutAction());
		copy.setAction(new DefaultEditorKit.CopyAction());
		paste.setAction(new DefaultEditorKit.PasteAction());
		Edit.add(cut);
		Edit.add(copy);
		Edit.add(paste);
		frame.getContentPane().add(Menu);
		
		
		
		
		Action compilar = new AbstractAction("COMPILAR"){
			public void actionPerformed(ActionEvent e){
				readToTree(textArea2, textArea3, treePanel,textArea4, textArea5);
				
			}
		}; 
		JButton btnCompilar = new JButton("COMPILAR");
		btnCompilar.setFont(new Font("FreeSans", Font.PLAIN, 25));
		btnCompilar.setBounds(61, 1146, 180, 25);
		btnCompilar.setAction(compilar);
		frame.getContentPane().add(btnCompilar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane1.addTab("Arbol", null, scrollPane, null);
		
		scrollPane.setViewportView(treePanel);
		
		
	
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/luisa/workspace/COMPILADORES/ANTLRG/GramaticaC.g4"));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		   String everything = sb.toString();
		   textArea1.setText(everything);
		  
		   
		   
		   
		   
		    br.close();
		} catch(Exception e) {	}
		
		
	}
	private void openFile(TextArea textArea1,TextArea textArea2, TextArea textArea3){
		JFileChooser open = new JFileChooser("./");
		int ret = open.showOpenDialog(frame);
		File file = open.getSelectedFile();
		System.out.println();
		BufferedReader reader = null;
		if(ret == JFileChooser.APPROVE_OPTION){
			System.out.println(">>>"+file.getName());
			try{
				reader = new BufferedReader(new FileReader(file.getName()));
				
				String current; 
				while((current = reader.readLine())!= null){
					System.out.println(file.getName().contains(".java"));
					if(file.getName().contains(".java")){
						System.out.print("si");
						textArea2.setText(current);
					}
					else if(file.getName().contains(".g4")){
						System.out.print("no");
						textArea2.setText(current);
					}
					else{
						System.out.print("que raro");
						textArea3.setText("Su archivo no es gramatica o una clase de java");
					}
				}
				reader.close();
				
			}catch(IOException e){
				System.out.println("Error"+e);
				JOptionPane.showMessageDialog(frame,"The Text could not be Opened!","Error",JOptionPane.INFORMATION_MESSAGE);
				textArea3.setText(String.valueOf(e));
			}
		}
	}
	private void saveFile(TextArea textArea1,TextArea textArea2, TextArea textArea3){
		JFileChooser saver = new JFileChooser("./");
		//saver.setFileFilter(new Text_Filter());
		int ret = saver.showSaveDialog(frame);
		File file = saver.getSelectedFile();
		BufferedWriter writer = null;
		if(ret == JFileChooser.APPROVE_OPTION){
			try{
				if(file.getName().contains(".java")){
				writer = new BufferedWriter(new FileWriter(file.getName()));
				writer.write(textArea2.getText());
				writer.close();
				JOptionPane.showMessageDialog(frame,"JavaFile was Saved Successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
				}else if(file.getName().contains(".g4")){
					writer = new BufferedWriter(new FileWriter(file.getName()));
					writer.write(textArea1.getText());
					writer.close();
					JOptionPane.showMessageDialog(frame,"Grammar was Saved Successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
				}else{
					textArea3.setText("Solo se guardan grammaticas o javafiles");
					JOptionPane.showMessageDialog(frame,"The Text could not be Saved!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}catch(IOException e){
				JOptionPane.showMessageDialog(frame,"The Text could not be Saved!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
	
		
		
		}
	}
	private void readToTree(TextArea textArea2, TextArea textArea3, JPanel treePanel, TextArea textArea4,TextArea textArea5){
		//ANTLR Tree
	  ANTLRInputStream input = new ANTLRInputStream(textArea2.getText());

	  GramaticaCLexer lexer  = new GramaticaCLexer(input);
	  // Add custom error handdlers.
      lexer.removeErrorListeners();
      lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

	  TokenStream tokenStream = new CommonTokenStream(lexer);

	  GramaticaCParser parser = new GramaticaCParser(tokenStream);
	  // Add custom error handdlers.
      parser.removeErrorListeners();
      parser.addErrorListener(ThrowingErrorListener.INSTANCE);

	  ParseTree tree = parser.program();
	  
	  TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
	  viewr.setFontSize(13);
	  
	  viewr.setSize(700, 700);
	  treePanel.removeAll();
	  treePanel.add(viewr);
	  //type = new Visitor();
	  conv = new convVisitor();
	  
	  //type.visit(tree);
	  conv.visit(tree);
	  conv.toString();
	  //textArea4.setText(conv.toString());
	  //type.aString();
	  //conv.aString();
	  String inter = "";
	  String lineas = "";
	  String ARM = "";
	  
	  try {
	  	Errors = Files.readAllLines(file, Charset.forName("UTF-8"));
	  	Files.deleteIfExists(file);
	  	for (int i = 0; i < Errors.size(); i++) {
	  		textArea3.setText("(" + (i + 1) + "): " + Errors.get(i) + "\n");
	  		//textArea3.setText(type.errores);
	  	}
	  }
	  catch ( IOException e ) {
		 // if(!(type.errores).equals("")){
			 // textArea3.setText(type.errores);
		  //}else{
			  textArea3.setText("Succes");
			  
		  //}
	  }
	  for(quadruple linea:conv.quadruple1){
		  for(int i = 0;i<(linea.cuadrupla).length;i++){
			  inter+=(linea.cuadrupla[i]);
			  lineas += (linea.cuadrupla[i]);
			  
		  }

		  lineas = "";
		  inter += ("\n");
	  }
	  textArea4.setText(inter);
	  conv.data();
	  conv.getReg();
	  for(String linea:conv.quadruple2){
		  
		ARM+=(linea);
		ARM += ("\n");
	  }
	  textArea5.setText(ARM);
	  
	}

	
}
