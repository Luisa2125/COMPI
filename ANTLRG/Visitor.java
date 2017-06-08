import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;


public class Visitor extends GramaticaCBaseVisitor<String> {
	private  Map<String, ArrayList<String>> SimbolTab = new HashMap<String,ArrayList<String>>();
	private int envCount = 1;
	String errores = "";
	boolean bandera = true;
	boolean main = false;
	@Override 
	public String visitProgram(GramaticaCParser.ProgramContext ctx) { 
		for (int i=0;i<ctx.getChildCount()-1;i++){
			if((ctx.getChild(i).getText().contains("main"))){
				main = true;
				if(!(ctx.getChild(i).getText().contains("void"))){
					System.out.println("main "+main);
					String errorMes = "NO EXISTE void en MAIN";
					errores+="\n"+errorMes;
					JOptionPane.showMessageDialog(null, errorMes, "BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
		if(main==false){
			System.out.println("main "+main);
			String errorMes = "NO EXISTE MAIN";
			errores+="\n"+errorMes;
			JOptionPane.showMessageDialog(null, errorMes, "BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
			
		}
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitDeclaration(GramaticaCParser.DeclarationContext ctx) { 
		return visitChildren(ctx);
		}
	
	@Override 
	public String visitVarDeclaration(GramaticaCParser.VarDeclarationContext ctx) { 
		//System.out.println("I visted visitVarDeclaration");
		ArrayList<String> var = new ArrayList<String>(Arrays.asList(ctx.getChild(1).getText(),ctx.getChild(0).getText(),String.valueOf(envCount)));
		String name = String.valueOf(envCount)+"-"+ctx.getChild(1).getText();
		System.out.println(">"+SimbolTab.containsKey(ctx.getChild(1).getText()+String.valueOf(envCount)));
		if (SimbolTab.containsKey(envCount+"-"+ctx.getChild(1).getText())){
			
			String errorMes = "ERROR! no se puede crear la variable\n "+var.get(1)+" "+ctx.getChild(1)+" YA EXISTE!!\nEn la linea = " + ctx.getStart().getLine();
			errores+="\n"+errorMes;
			JOptionPane.showMessageDialog(null, errorMes, "TIENES UN BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			if(ctx.getChildCount()>3){
				System.out.println("ARRAY "+ctx.getChild(3).getText());
				try{
					int valor = Integer.valueOf(ctx.getChild(3).getText());
					if(! (	valor >0)){
						String errorMes = "ERROR! no existe arreglos de\n "+ctx.getChild(3).getText()+"\nVarieble "+ctx.getChild(1)+" \nEn la linea = " + ctx.getStart().getLine();
						errores+="\n"+errorMes;
						JOptionPane.showMessageDialog(null, errorMes, "TIENES UN BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch( Exception e){
					String errorMes = "ERROR! tipo no int --> "+ctx.getChild(3).getText()+"\nVarieble "+ctx.getChild(1)+" \nEn la linea = " + ctx.getStart().getLine();
					errores+="\n"+errorMes;
					JOptionPane.showMessageDialog(null, errorMes, "TIENES UN BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				
				System.out.println("array tipo "+visit(ctx.getChild(3)));
			}
			bandera = !bandera;
			SimbolTab.put(name, var);
		}
		//System.out.println(SimbolTab);
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitStructDeclaration(GramaticaCParser.StructDeclarationContext ctx) { 
		//System.out.println("I visited visitStructDeclaration");
		envCount+=1;
		ArrayList<String> var = new ArrayList<String>(Arrays.asList(ctx.getChild(1).getText(),ctx.getChild(0).getText(),String.valueOf(envCount)));
		String name = String.valueOf(envCount)+"-"+ctx.getChild(1).getText();
		SimbolTab.put(name, var);
		
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitVarType(GramaticaCParser.VarTypeContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitMethodDeclaration(GramaticaCParser.MethodDeclarationContext ctx) { 
		//System.out.println("I visited visitMethodDeclaration");
		envCount+=1;
		String Parametros="";
		for(int i=3; i<ctx.children.size()-2;i++){
			try{
				if(Parametros.equals("")){
					Parametros = ctx.getChild(i).getChild(1).getText();
				}else{
					Parametros += "," + ctx.getChild(i).getChild(1).getText();
				}
			}
			catch(Exception e){}
		}
		System.out.println("ver "+Parametros);
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList(ctx.getChild(1).getText(),ctx.getChild(0).getText(),String.valueOf(envCount),Parametros));
		String name = String.valueOf(envCount)+"-"+ctx.getChild(1).getText();
		SimbolTab.put(name, var);




		if(ctx.getChild(0).getText().equals("void")){
			if((ctx.getChild(ctx.getChildCount()-1).getText()).contains("return")){
				String errorMes = "El metodo "+ ctx.getChild(1).getText()+" es tipo void\nCONTIENNE return";
				errores+="\n"+errorMes;
				JOptionPane.showMessageDialog(null, errorMes, "BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitMethodType(GramaticaCParser.MethodTypeContext ctx) { 
		

		return visitChildren(ctx); 
	}
	@Override
	public String visitParameter(GramaticaCParser.ParameterContext ctx){
		//System.out.println("I visted visitVarDeclaration");
		ArrayList<String> var = new ArrayList<String>(Arrays.asList(ctx.getChild(1).getText(),ctx.getChild(0).getChild(0).getText(),String.valueOf(envCount)));
		String name = String.valueOf(envCount)+"-"+ctx.getChild(1).getText();
		if (SimbolTab.containsKey(String.valueOf(envCount)+"-"+ctx.getChild(1).getText())){
			String errorMes = "ERROR! no se puede crecibir dos parametros iguales\n "+var.get(1)+" "+ctx.getChild(1)+" YA EXISTE!!\nEn la linea = " + ctx.getStart().getLine();
			errores+="\n"+errorMes;
			JOptionPane.showMessageDialog(null, errorMes, "TIENES UN BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			SimbolTab.put(name, var);
		}
		//System.out.println(SimbolTab);
		return visitChildren(ctx);
		
		
	}
	
	@Override 
	public String visitParameterType(GramaticaCParser.ParameterTypeContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitBlock(GramaticaCParser.BlockContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitStatement(GramaticaCParser.StatementContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitAssignation(GramaticaCParser.AssignationContext ctx) { 
		//System.out.println("ctx"+ctx.getText());
		int n=ctx.getChildCount();
		bandera = !bandera;
		
		//String key1 = "";
		String tipo1 = "";
		String tipo2 = "";
		for (int i=0;i<SimbolTab.size();i++){
			//System.out.println("CTX CHILD "+i+" "+ctx.getChild(i).getText());
			//System.out.println("CTX VISIT "+i+" "+visit(ctx.getChild(i)));
			
		}
		
		for(int i=1;i<=envCount;i++){
			if(SimbolTab.containsKey(i+"-"+ctx.getChild(0).getText())/* && SimbolTab.containsKey(i+"-"+ctx.getChild(2).getText())*/){
				
				String key = i+"-"+ctx.getChild(0).getText(); 
				tipo1 = SimbolTab.get(key).get(1);
				if(visit(ctx.getChild(2))==null){
					String str = ctx.getChild(2).getText();
					int index = str.indexOf("(");
					////System.out.println(str+",,"+index);
					//System.out.println("STR"+str);
					if(index > 0){
						String met = str.substring(0, index);
						int index1 = str.indexOf(")");
						String par = str.substring(index+1,index1);
						int p1 = par.length() - par.replace(",", "").length();
						System.out.println("PARAMETROS--"+par);
						for(int j=1;j<=envCount;j++){
							if(SimbolTab.containsKey(j+"-"+met)){
								System.out.println("sumasola "+j+"-"+met);
								String str1 = SimbolTab.get(j+"-"+met).get(3);
								//System.out.prinln("PARAMETROS2--"+str1)
								int p2 = str1.length() - str1.replace(",", "").length();
								if(p1!=p2){
									System.out.println("p1= "+p1+" p2= "+p2);
									String errorMes = "los parametros de "+met+" no coinciden";
									JOptionPane.showMessageDialog(null, errorMes, "ERROR", JOptionPane.INFORMATION_MESSAGE);
									errores += "\n"+errorMes;
								}
								
								tipo2 = SimbolTab.get(j+"-"+met).get(1);
							}
						}
						
					}else{
						if(str.contains("-")||str.contains("+")||str.contains("/")||str.contains("*")){
							
							tipo2 = "int";
						}
					}
				}else{
					tipo2 = visit(ctx.getChild(2));
				}
				
			}
			/**if(bandera == false){
				
				
				String errorMes = "Error en la asignacion de variable "+ctx.getChild(0).getText()+" en linea " + ctx.getStart().getLine();
				JOptionPane.showMessageDialog(null, errorMes, "BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
				errores += "\n"+errorMes;		
			}**/
			
		}
		
		//String str = ctx.getChild(2).getText();
		///int index = str.indexOf("(");
		//System.out.println(index+","+str.length()+","+str);
		//String i = str.substring(0, index);
		//System.out.println("---"+i);
		//System.out.println("int"+SimbolTab.get(key).get(1));
		System.out.println("--"+ctx.getChild(2).getText());
		//System.out.println(ctx.getChild(2).getText()+" = "+visit(ctx.getChild(2)));
		System.out.println("I visited visitAssignation");
		//System.out.println("????"+visitChildren(ctx));
		if(!tipo1.equals(tipo2)){
			System.out.println("entra al if");
			System.out.println(tipo1+"-"+tipo2);
			//System.out.println((visit(ctx.getChild(0))) + ctx.getChild(0).getText());
			//System.out.println((visit(ctx.getChild(2))) + ctx.getChild(2).getText());
			//System.out.println(ctx.children.size());
			String errorMes = "Error on Assignation because of type at line: " + ctx.getStart().getLine();
			JOptionPane.showMessageDialog(null, errorMes, "ERROR", JOptionPane.INFORMATION_MESSAGE);
			errores += "\n"+errorMes;
		}
		else {
			//System.out.println("The type for " + ctx.getChild(0).getText() + " right " + tipo1);
			//System.out.println("The type for " +ctx.getChild(2).getText() + " left " + tipo2);
		}
	
		return visitChildren(ctx); 
	}	
	@Override 
	public String visitWhileBlock(GramaticaCParser.WhileBlockContext ctx) { 
				//System.out.println("while "+ctx.getChild(2).getText());
				//System.out.println("cuantos "+ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText());
				try{
					if(!(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("==") || !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals(">=") || !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("<=") || !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("!=") || !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals(">") || !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("<")){
						String errorMes = "Error while no boolean \nEn la linea  " + ctx.getStart().getLine();
						JOptionPane.showMessageDialog(null, errorMes, " BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
						errores += "\n"+errorMes;
					}
				}catch(Exception e){
					String errorMes = "Error while no boolean \nEn la linea  " + ctx.getStart().getLine();
					JOptionPane.showMessageDialog(null, errorMes, " BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
					errores += "\n"+errorMes;
				}
				envCount += 1;
				//System.out.println("I visited visitWhileBlock");
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitReturnBlock(GramaticaCParser.ReturnBlockContext ctx) { 
				//System.out.println("I visited visitReturnBlock");
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitPrint(GramaticaCParser.PrintContext ctx) { 
				//System.out.println("I visited visitPrint");
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitScan(GramaticaCParser.ScanContext ctx) { 
				//System.out.println("I visited visitScan");
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitMyIf(GramaticaCParser.MyIfContext ctx) { 
				//System.out.println("I visited visitMyIf");
				try{
					if(!(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("==") && !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals(">=") && !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("<=") && !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("!=") && !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals(">") && !(ctx.getChild(2).getChild(0).getChild(0).getChild(1).getText()).equals("<")){
						String errorMes = "Error if no boolean \nEn la linea  " + ctx.getStart().getLine();
						JOptionPane.showMessageDialog(null, errorMes, " BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
						errores += "\n"+errorMes;
					}
				}catch(Exception e){
					String errorMes = "Error if no boolean \nEn la linea  " + ctx.getStart().getLine();
					JOptionPane.showMessageDialog(null, errorMes, " BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
					errores += "\n"+errorMes;
				}
				envCount = envCount + 1;
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitElseBlock(GramaticaCParser.ElseBlockContext ctx) { 
				//System.out.println("I visited visitElseBlock");
				envCount = envCount + 1;
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitLocation(GramaticaCParser.LocationContext ctx) { 
				//System.out.println("I visited visitLocation");
				return visitChildren(ctx); 
	}
	
	
	@Override 
	public String visitDotLocation(GramaticaCParser.DotLocationContext ctx) { 
		
		return visitChildren(ctx); }
	
	@Override 
	public String visitDeclaredVariable(GramaticaCParser.DeclaredVariableContext ctx) { return visitChildren(ctx); }
	
	@Override 
	public String visitVariable(GramaticaCParser.VariableContext ctx) { 
		ArrayList<String> SimInfo = new ArrayList<String>();
		String ret = "";
		for(int i = 1;i<=envCount;i++){
			String Key = i+"-"+ctx.getText();
		
			if(SimbolTab.containsKey(Key)){
				try{
					SimInfo = SimbolTab.get(Key);
					ret = SimInfo.get(1);
				}
				catch(Exception e){ 
					String errorMessage = "Symbol NOT found on Symbol Table Error " + ctx.getStart().getLine();
					JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.INFORMATION_MESSAGE);
					errores += "\n"+errorMessage;
					ret =  null;
				}
			}
		}
	
		return visitChildren(ctx); }
	@Override 
	public String visitArrayVariable(GramaticaCParser.ArrayVariableContext ctx) { 
				
				//System.out.println("I visited visitArrayVariable");
				//System.out.println(""+ctx.getText());
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitExpressionInP(GramaticaCParser.ExpressionInPContext ctx) { 
				//System.out.println("I visited visitExpressionInP");
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitNExpression(GramaticaCParser.NExpressionContext ctx) { 
				//System.out.println("I visited visitNExpression");
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitExpression(GramaticaCParser.ExpressionContext ctx) { 
				//System.out.println("I visited visitOrExpression");
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitAndExpression(GramaticaCParser.AndExpressionContext ctx) { 
		//System.out.println("I visited visitAndExpression");
		return visitChildren(ctx); }
	
	@Override 
	public String visitEqualsExpression(GramaticaCParser.EqualsExpressionContext ctx) { 
		//System.out.println("I visited visitEqualsExpression");
		String tipo1 = "";
		String tipo2 = "";

		//System.out.println("EQUALS "+ctx.getText());
			
		//System.out.println("SOY NORMAL");
			/*if(ctx.children.size()>2){
				System.out.println("Entre al IF1");
				if(visit(ctx.getChild(0)).equals(visit(ctx.getChild(2))) && visit(ctx.getChild(0))!=null && visit(ctx.getChild(2))!=null){
					System.out.println("Entre al IF");
					
					//return visit(ctx.getChild(0));
				}
			}*/
		
		
			//return null; 
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitRelationExpression(GramaticaCParser.RelationExpressionContext ctx) { 
		/*if(ctx.children.size()>2){
			if(visit(ctx.getChild(0)).equals(visit(ctx.getChild(2)))){
				return visit(ctx.getChild(0));
		}}else{
			String errorMessage = "Types Error " + ctx.getStart().getLine();
			JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}*/
		return visitChildren(ctx); 
	}

		
	
	@Override 
	public String visitAddSubsExpression(GramaticaCParser.AddSubsExpressionContext ctx) { 
		//System.out.println("I visited visitAddSubsExpression");
		System.out.println("Imprimiendo" + ctx.getChildCount());
		String type1 = "";
		String type2 = "";
		if(ctx.getChildCount()>2){
			for(int i=1;i<=envCount;i++){
					if(SimbolTab.containsKey(i+"-"+ctx.getChild(0).getText())){
						type1 = SimbolTab.get(i+"-"+ctx.getChild(0).getText()).get(1);
						
					}
					if(SimbolTab.containsKey(i+"-"+ctx.getChild(2).getText())){
						type2 = SimbolTab.get(i+"-"+ctx.getChild(2).getText()).get(1);
						
					
					 
				}
			}
			System.out.println("tipo1 "+type1+", tipo2 "+type2);
			
			
			if(!type1.equals("int") || !type2.equals("int")){
				String errorMes = "Error tipo no int en suma\nLinea:  " + ctx.getStart().getLine();
				JOptionPane.showMessageDialog(null, errorMes, " BELLO ERROR", JOptionPane.INFORMATION_MESSAGE);
				errores += "\n"+errorMes;
				
			}

		}
		
		return visitChildren(ctx); }

	@Override 
	public String visitMulDivExpression(GramaticaCParser.MulDivExpressionContext ctx) { 

		//System.out.println("I visited visitMulDivExpression");
		String type = null;

		if(ctx.children.size()>1){
			for(int i =0;i<ctx.children.size();i++){
				if(i % 2 == 0){
					if(type==null){
						type = visit(ctx.getChild(i));
					}
					else if(type.equals(visit(ctx.getChild(i)))&&(!ctx.getChild(i).equals("boolean")));
					else{
						String errorMessage = "Error de asignacion en la linea " + ctx.getStart().getLine();
						JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.INFORMATION_MESSAGE);
						}
							  }
													}
						return type;
								 }
		else{
			return visit(ctx.getChild(0));
		}
}
		//return visitChildren(ctx); }
	
	@Override 
	public String visitPrExpression(GramaticaCParser.PrExpressionContext ctx) { 
				//System.out.println("I visited visitPrExpression");
				if(ctx.children.size()>2){
					System.out.println("PrExpression with: " + ctx.getText() );
					if(visit(ctx.getChild(0)).equals(visit(ctx.getChild(2)))){
						return visit(ctx.getChild(0));
					}
					else{
						String errorMessage = "Types Error " + ctx.getStart().getLine();
						JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				return visitChildren(ctx); 
	}
	
	@Override 
	public String visitBasicExpression(GramaticaCParser.BasicExpressionContext ctx) {
		//System.out.println("I visited visitBasicExpression");
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitBasic(GramaticaCParser.BasicContext ctx) { 
		//System.out.println("I visited visitBasic");
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitArg(GramaticaCParser.ArgContext ctx) { 
		//System.out.println("I visited visitArg");
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitMethodCall(GramaticaCParser.MethodCallContext ctx) { 
		//System.out.println("I visited visitMethodCall");
		String ctxString = ctx.getText();
		////System.out.println("******************************************");
		for (Map.Entry<String,ArrayList<String>> e : SimbolTab.entrySet()){
			if (e.getKey().startsWith("suma")) {
				ArrayList<String> SymbolInformation = new ArrayList<String>();
				try{
					SymbolInformation = SimbolTab.get(e.getKey());
				}
				catch(Exception ex){ 
					String errorMes = "Symbol NOT found on Symbol Table Error " + ctx.getStart().getLine();
					JOptionPane.showMessageDialog(null, errorMes, "ERROR", JOptionPane.INFORMATION_MESSAGE);
					errores += "\n"+errorMes;
				}
				
				String answer = ctxString.substring(ctxString.indexOf("(")+1,ctxString.indexOf(")"));
				if(SymbolInformation.get(3).equals(answer)){
					//System.out.println("I visited visitDeclaredMethodCall" + SymbolInformation[1]);
					return SymbolInformation.get(1);
				}
				else{
					String errorMes = "Types are diferent on line " + ctx.getStart().getLine();
					JOptionPane.showMessageDialog(null, errorMes, "ERROR", JOptionPane.INFORMATION_MESSAGE);
					errores += "\n"+errorMes;
				}
			  }
		}
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitAs_op(GramaticaCParser.As_opContext ctx) { 
		///System.out.println("I visited visitAs_op");
		//System.out.println("> > > >"+visitChildren(ctx));
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitMd_op(GramaticaCParser.Md_opContext ctx) {
		////System.out.println("I visited visitMd_op");
		//System.out.println("> > >"+visitChildren(ctx));
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitPr_op(GramaticaCParser.Pr_opContext ctx) { 
		//System.out.println("I visited visitPr_op");
		//System.out.println("> >"+visitChildren(ctx));
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitRel_op(GramaticaCParser.Rel_opContext ctx) { 
		//System.out.println("I visited visitRel_op");
		//System.out.println(">>>>>"+visitChildren(ctx));
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitEq_op(GramaticaCParser.Eq_opContext ctx) { 
		//System.out.println("I visited visitEq_op");
		//System.out.println(">>>>"+visitChildren(ctx));
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitCond_op(GramaticaCParser.Cond_opContext ctx) { 
		////System.out.println("I visited visitCon_op");
		//System.out.println(">>>"+visitChildren(ctx));
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitLiteral(GramaticaCParser.LiteralContext ctx) { 
		//System.out.println("I visited visitLiteral");
		//System.out.println(">>"+visitChildren(ctx));
		return visitChildren(ctx); 
	}
	
	@Override 
	public String visitInt_literal(GramaticaCParser.Int_literalContext ctx) { 
		//System.out.println("I visited visitInt");
		
		return "int"; 
	}
	
	@Override 
	public String visitChar_literal(GramaticaCParser.Char_literalContext ctx) { 
		System.out.println("I visited visitChar");
		return "char"; 
	}
	
	@Override 
	public String visitBool_literal(GramaticaCParser.Bool_literalContext ctx) { 
		System.out.println("I visited visitBool");
		return "boolean";
	}
	public void aString(){
		System.out.print(SimbolTab);
		System.out.println("errores"+errores);
		
	}

}
