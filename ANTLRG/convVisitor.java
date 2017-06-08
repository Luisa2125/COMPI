import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.RuleNode;


public class convVisitor extends GramaticaCBaseVisitor<String>{
	private  Map<String, String[]> SimbolTab = new HashMap<String,String[]>();
	public ArrayList<quadruple> quadruple1 = new ArrayList<quadruple>();
	public ArrayList<String> quadruple2 = new ArrayList<String>();
	//public Map<String, String[]> quadruple = new HashMap<String, String[]>();
	public Map<String, String> icgTable = new HashMap<String, String>();
	public Map<String, String[]> quadrupleA = new HashMap<String, String[]>();
	
	
	public int lineCounter ;
	public int tempCounter;
	public int whileCounter;
	public int condCounter;
	public int ifCounter;
	public int num;
	public int regNum;
	
	
	
	
	public convVisitor(){
		
		lineCounter = 0;
		tempCounter = 0;
		whileCounter = 0;
		num = 1;
		regNum = 0;
		
		
		
		
	}
	@Override public String visitProgram(GramaticaCParser.ProgramContext ctx) { 
		visitChildren(ctx);
		quadruple2Icg();
		return "done x 2";
	}
	
	@Override public String visitDeclaration(GramaticaCParser.DeclarationContext ctx) {
		return visitChildren(ctx); 
	}
	
	@Override public String visitVarDeclaration(GramaticaCParser.VarDeclarationContext ctx) { 
		quadruple qq = new quadruple();
		int l = doOfset(ctx.getChild(2).getText());
		String of = "["+l+"]";
		String[] quadLine = {ctx.getChild(1).getText()+of};
		qq.setLinea(lineCounter);
		qq.setCuadrupla(quadLine);
		
		quadruple1.add(qq);
		lineCounter++;
		
		return visitChildren(ctx); 
	}
	
	@Override public String visitStructDeclaration(GramaticaCParser.StructDeclarationContext ctx) { 
		quadruple qq = new quadruple();
		quadruple qq1 = new quadruple();
		String[] quadLine = {"STRUCT ", ctx.getChild(1).getText() + ":"};
		qq.setLinea(lineCounter);
		qq.setCuadrupla(quadLine);
		
		quadruple1.add(qq);
		System.out.println("PRUEBA"+quadLine.toString());
		lineCounter ++;
		
		visit(ctx.getChild(ctx.getChildCount() - 1));
		String[] quadLine2 = {"END STRUCT ", ctx.getChild(1).getText()};
		qq1.setLinea(lineCounter);
		qq1.setCuadrupla(quadLine2);
		
		quadruple1.add(qq1);
		System.out.println("PRUEBA"+quadLine2.toString());
		lineCounter ++;
		
		return "";
	}
	
	@Override public String visitVarType(GramaticaCParser.VarTypeContext ctx) { 
		return visitChildren(ctx);
	}
	
	@Override public String visitMethodDeclaration(GramaticaCParser.MethodDeclarationContext ctx) { 
		quadruple qq = new quadruple();
		quadruple qq1 = new quadruple();
		String[] quadLine = {"FUNCTION ", ctx.getChild(1).getText() + ":"};
		qq.setLinea(lineCounter);
		qq.setCuadrupla(quadLine);
		
		quadruple1.add(qq);
		System.out.println("PRUEBA"+quadLine.toString());
		lineCounter ++;
		
		visit(ctx.getChild(ctx.getChildCount() - 1));
		String[] quadLine2 = {"END FUNCTION ", ctx.getChild(1).getText()};
		qq1.setLinea(lineCounter);
		qq1.setCuadrupla(quadLine2);
		
		quadruple1.add(qq1);
		System.out.println("PRUEBA"+quadLine2.toString());
		lineCounter ++;
		
		return "";
	}
	
	@Override public String visitMethodType(GramaticaCParser.MethodTypeContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitParameter(GramaticaCParser.ParameterContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitParameterType(GramaticaCParser.ParameterTypeContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitBlock(GramaticaCParser.BlockContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitStatement(GramaticaCParser.StatementContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitAssignation(GramaticaCParser.AssignationContext ctx) { 
		System.out.println("I visited Assignation");
		quadruple qq = new quadruple();
		String temp = visit(ctx.getChild(2));
		int l = doOfset(ctx.getChild(2).getText());
		String of = "["+l+"]";
		//String[] quadLine = {ctx.getChild(1).getText(),of};
		if(temp.equals("method")){
			visitChildren((RuleNode) ctx.getChild(2));
			/*String[] quadLine = {ctx.getChild(1), "t" + (tempCounter - 1) ,
					"=", ctx.getChild(0).getText()};
			qq.setLinea(lineCounter);
			qq.setCuadrupla(quadLine);
			System.out.println("PRUEBA"+quadLine.toString());
			
			quadruple1.add(qq);*/
		}
		else{
			
			String[] quadLine = {"fp"+num,of,"=",ctx.getChild(2).getText()};
			qq.setLinea(lineCounter);
			qq.setCuadrupla(quadLine);
			
			quadruple1.add(qq);
			num++;
			System.out.println("PRUEBA"+quadLine.toString());
		}
		
		lineCounter ++;
		
	return null;
	}
	
	
	@Override public String visitWhileBlock(GramaticaCParser.WhileBlockContext ctx) { 
		quadruple qq = new quadruple();
		quadruple qq2 = new quadruple();
		quadruple qq3 = new quadruple();
		quadruple qq4 = new quadruple();
		quadruple qq5 = new quadruple();
		quadruple qq6 = new quadruple();
		int localWhile = whileCounter;
		String[] quadLine = {"STARTWHILE_" + localWhile +":"};
		qq.setLinea(lineCounter);
		qq.setCuadrupla(quadLine);
		
		quadruple1.add(qq);
		System.out.println("PRUEBA"+quadLine.toString());
		whileCounter ++;
		lineCounter ++;
		
		String temp = visit(ctx.getChild(2));
		String[] quadLine2 = {"IF " + temp + " > 0 ", "GOTO LABEL_TRUE_" + condCounter};
		String[] quadLine3 = {"GOTO " + "ENDWHILE_" + localWhile };
		String[] quadLine4 = {"LABEL_TRUE_" + condCounter + ":"};
		
		qq2.setLinea(lineCounter);
		qq2.setCuadrupla(quadLine2);
		
		quadruple1.add(qq2);
		System.out.println("PRUEBA"+quadLine2.toString());
		lineCounter ++;
		qq3.setLinea(lineCounter);
		qq3.setCuadrupla(quadLine3);
		
		quadruple1.add(qq3);
		System.out.println("PRUEBA"+quadLine3.toString());
		lineCounter ++;
		qq4.setLinea(lineCounter);
		qq4.setCuadrupla(quadLine4);
		
		quadruple1.add(qq4);
		System.out.println("PRUEBA"+quadLine4.toString());
		lineCounter ++;	
		condCounter ++;
		
		visit(ctx.getChild(ctx.getChildCount() - 1));
		String[] quadLine5 = {"GOTO " + "STARTWHILE_" + localWhile};
		qq5.setLinea(lineCounter);
		qq5.setCuadrupla(quadLine5);
		
		quadruple1.add(qq5);
		System.out.println("PRUEBA"+quadLine5.toString());
		lineCounter ++;
		
		String[] quadLine6 = {"ENDWHILE_" + localWhile};
		qq6.setLinea(lineCounter);
		qq6.setCuadrupla(quadLine6);
		
		quadruple1.add(qq6);
		System.out.println("PRUEBA"+quadLine6.toString());
		lineCounter ++;
		
		return "";
	}
	
	@Override 
	public String visitReturnBlock(GramaticaCParser.ReturnBlockContext ctx) {
		quadruple qq = new quadruple();
		String[] quadLine = {"RETURN ",ctx.getChild(1).getText()};
		qq.setLinea(lineCounter);
		qq.setCuadrupla(quadLine);
		
		quadruple1.add(qq);
		lineCounter ++;
		System.out.println("PRUEBA"+quadLine.toString());
		return visit(ctx.getChild(1)); 
	}
	
	@Override public String visitPrint(GramaticaCParser.PrintContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitScan(GramaticaCParser.ScanContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitMyIf(GramaticaCParser.MyIfContext ctx) { 
		quadruple qq = new quadruple();
		quadruple qq2 = new quadruple();
		quadruple qq3 = new quadruple();
		quadruple qq4 = new quadruple();
		quadruple qq5 = new quadruple();
		quadruple qq6 = new quadruple();
		String temp = visit(ctx.getChild(2));
		
		String[] quadLine = {"IF " + temp + " > 0 ", "GOTO LABEL_TRUE_" + condCounter};
		String[] quadLine2 = {"GOTO " + "LABEL_FALSE_" + condCounter };
		String[] quadLine3 = {"LABEL_TRUE_" + condCounter + ":"};
		
		qq.setLinea(lineCounter);
		qq.setCuadrupla(quadLine);
		
		quadruple1.add(qq);
		System.out.println("PRUEBA"+quadLine.toString());
		lineCounter ++;
		qq2.setLinea(lineCounter);
		qq2.setCuadrupla(quadLine2);
		
		quadruple1.add(qq2);
		System.out.println("PRUEBA"+quadLine2.toString());
		lineCounter ++;
		qq3.setLinea(lineCounter);
		qq3.setCuadrupla(quadLine3);
		
		quadruple1.add(qq3);
		System.out.println("PRUEBA"+quadLine3.toString());
		lineCounter ++;	
		
		
		temp = visit(ctx.getChild(4));
		int localIf = ifCounter;
		String[] quadLine4 = {"GOTO " + "ENDIF_" + localIf};
		qq4.setLinea(lineCounter);
		qq4.setCuadrupla(quadLine4);
		
		quadruple1.add(qq4);
		System.out.println("PRUEBA"+quadLine4.toString());
		lineCounter ++;
		ifCounter++;
		
		String[] quadLine5 = {"LABEL_FALSE_" + condCounter + ":"};
		qq5.setLinea(lineCounter);
		qq5.setCuadrupla(quadLine5);
		
		quadruple1.add(qq5);
		System.out.println("PRUEBA"+quadLine5.toString());
		lineCounter ++;
		condCounter ++;
		if(ctx.getChildCount() >= 6){
			visit(ctx.getChild(5));
		}
		String[] quadLine6 = {"ENDIF_ " + localIf};
		qq6.setLinea(lineCounter);
		qq6.setCuadrupla(quadLine6);
		
		quadruple1.add(qq6);
		System.out.println("PRUEBA"+quadLine6.toString());
		lineCounter ++;
		
		
		//visitChildren(ctx);
		return "";
	}
	
	@Override public String visitElseBlock(GramaticaCParser.ElseBlockContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitLocation(GramaticaCParser.LocationContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitDotLocation(GramaticaCParser.DotLocationContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitDeclaredVariable(GramaticaCParser.DeclaredVariableContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitVariable(GramaticaCParser.VariableContext ctx) { 
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitArrayVariable(GramaticaCParser.ArrayVariableContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitExpressionInP(GramaticaCParser.ExpressionInPContext ctx) { 
		return visitChildren(ctx);
	}
	
	@Override public String visitNExpression(GramaticaCParser.NExpressionContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitExpression(GramaticaCParser.ExpressionContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitAndExpression(GramaticaCParser.AndExpressionContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitEqualsExpression(GramaticaCParser.EqualsExpressionContext ctx) { 
		quadruple qq = new quadruple();
		if(ctx.children.size() >= 2){
			String temp1 = visit(ctx.getChild(1));
			String temp2 = visit(ctx.getChild(0));
			String temp3 = visit(ctx.getChild(2));
			
			if(temp2.equals("method") && temp3.equals("method")){
				temp2 = "t" + (tempCounter - 1);
				temp3 = "t" + (tempCounter - 2);
			}
			else if(temp2.equals("method"))
				temp2 = "t" + (tempCounter - 1);
			else if(temp3.equals("method"))
				temp3 = "t" + (tempCounter - 1);
			String[] quadLine = { "t" + tempCounter,temp2,temp3};
			//String[] quadLine = {temp1, temp2,temp3, "t" + tempCounter};
			qq.setLinea(lineCounter);
			qq.setCuadrupla(quadLine);
			
			quadruple1.add(qq);
			System.out.println("PRUEBA"+quadLine.toString());
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);
		}
				return visit(ctx.getChild(0));
	}
	
	@Override public String visitRelationExpression(GramaticaCParser.RelationExpressionContext ctx) { 
		quadruple qq = new quadruple();
		if(ctx.children.size() >= 2){
			String t;
			if(visit(ctx.getChild(1)).equals("=")){
				t = null;
			}else{
				t = visit(ctx.getChild(1));
			}
			String[] quadLine = { "t" + tempCounter,"=",  visit(ctx.getChild(0)),t,visit(ctx.getChild(2))};
			//String[] quadLine = {visit(ctx.getChild(1)), visit(ctx.getChild(0)),visit(ctx.getChild(2)), "t" + tempCounter};
			qq.setLinea(lineCounter);
			qq.setCuadrupla(quadLine);
			
			quadruple1.add(qq);
			System.out.println("PRUEBA"+quadLine.toString());
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);
		}
		
			return visit(ctx.getChild(0));
	}
	
	@Override public String visitAddSubsExpression(GramaticaCParser.AddSubsExpressionContext ctx) { 
		/*quadruple rr = new quadruple();
		if(ctx.children.size() >= 2){
			String temp1 = visit(ctx.getChild(1));
			String temp2 = visit(ctx.getChild(0));
			String temp3 = visit(ctx.getChild(2));
			
			if(temp2.equals("method") && temp3.equals("method")){
				temp2 = "t" + (tempCounter - 1);
				temp3 = "t" + (tempCounter - 2);
			}
			else if(temp2.equals("method"))
				temp2 = "t" + (tempCounter - 1);
			else if(temp3.equals("method"))
				temp3 = "t" + (tempCounter - 1);
			
			String[] quadLine = { "t" + tempCounter,"=",temp2,temp1,temp3};
			//String[] quadLine = {temp1, temp2,temp3, "t" + tempCounter};
			qq.setLinea(lineCounter);
			qq.setCuadrupla(quadLine);
			
			quadruple1.add(qq);
			System.out.println("PRUEBA"+quadLine.toString());
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);*/
		
		
		
		
		quadruple qq = new quadruple();
		if(ctx.children.size() >= 2){
			String temp1 = visit(ctx.getChild(1));
			String temp2 = visit(ctx.getChild(0));
			String temp3 = visit(ctx.getChild(2));
			
			if(temp2.equals("method") && temp3.equals("method")){
				temp2 = "t" + (tempCounter - 1);
				temp3 = "t" + (tempCounter - 2);
			}
			else if(temp2.equals("method"))
				temp2 = "t" + (tempCounter - 1);
			else if(temp3.equals("method"))
				temp3 = "t" + (tempCounter - 1);
			
			String[] quadLine = { "t" + tempCounter,"=",temp2,temp1,temp3};
			//String[] quadLine = {temp1, temp2,temp3, "t" + tempCounter};
			qq.setLinea(lineCounter);
			qq.setCuadrupla(quadLine);
			
			quadruple1.add(qq);
			System.out.println("PRUEBA"+quadLine.toString());
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);
		}
		
		return visit(ctx.getChild(0));
	}
	
	@Override public String visitMulDivExpression(GramaticaCParser.MulDivExpressionContext ctx) { 
		quadruple qq = new quadruple();
		if(ctx.children.size() >= 2){
			String temp1 = visit(ctx.getChild(1));
			String temp2 = visit(ctx.getChild(0));
			String temp3 = visit(ctx.getChild(2));
			
			if(temp2.equals("method") && temp3.equals("method")){
				temp2 = "t" + (tempCounter - 1);
				temp3 = "t" + (tempCounter - 2);
			}
			else if(temp2.equals("method"))
				temp2 = "t" + (tempCounter - 1);
			else if(temp3.equals("method"))
				temp3 = "t" + (tempCounter - 1);
			String[] quadLine = { "t" + tempCounter,temp2,temp1,temp3};
			//String[] quadLine = {temp1, temp2,temp3, "t" + tempCounter};
			qq.setLinea(lineCounter);
			qq.setCuadrupla(quadLine);
			
			quadruple1.add(qq);
			System.out.println("PRUEBA"+quadLine.toString());
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);
		}
				return visit(ctx.getChild(0));	
	}
	
	@Override public String visitPrExpression(GramaticaCParser.PrExpressionContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitBasicExpression(GramaticaCParser.BasicExpressionContext ctx) { 
		return visitChildren(ctx); 
		
	}
	
	@Override public String visitBasic(GramaticaCParser.BasicContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitArg(GramaticaCParser.ArgContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitMethodCall(GramaticaCParser.MethodCallContext ctx) { 
		quadruple qq = new quadruple();
		quadruple qq2 = new quadruple();
		quadruple qq3 = new quadruple();
		System.out.println("I visited visit MethodCall");
		if(ctx.getChildCount() - 3 > 0){
			String param = "";
			for(int i = 2; i < ctx.getChildCount() - 1; i++ ){
				param = param + ", " + ctx.getChild(i).getText();
			}
			String[] quadLine2 = {"PARAM ", param};
			qq2.setLinea(lineCounter);
			qq2.setCuadrupla(quadLine2);
			
			quadruple1.add(qq2);
			System.out.println("PRUEBA"+quadLine2.toString());
			lineCounter ++;
		}
		String[] quadLine = {"CALL ", ctx.getChild(0).getText() + ",",
				(ctx.getChildCount() - 3) + ""};
		qq.setLinea(lineCounter);
		qq.setCuadrupla(quadLine);
		
		quadruple1.add(qq);
		System.out.println("PRUEBA"+quadLine.toString());
		lineCounter ++;
		
		//check ST to see if return != void || null
		String[] quadLine3 = {"t" + tempCounter,"=", "R"};
		qq3.setLinea(lineCounter);
		qq3.setCuadrupla(quadLine3);
		
		quadruple1.add(qq3);
		System.out.println("PRUEBA"+quadLine3.toString());
		tempCounter ++;
		lineCounter ++;
		
		
		
		
		return "method"; }
	
	@Override public String visitAs_op(GramaticaCParser.As_opContext ctx) { 
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitMd_op(GramaticaCParser.Md_opContext ctx) { 
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitPr_op(GramaticaCParser.Pr_opContext ctx) { 
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitRel_op(GramaticaCParser.Rel_opContext ctx) { 
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitEq_op(GramaticaCParser.Eq_opContext ctx) { 
		return ctx.getChild(0).getText();
	}
	
	@Override public String visitCond_op(GramaticaCParser.Cond_opContext ctx) { 
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitLiteral(GramaticaCParser.LiteralContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public String visitInt_literal(GramaticaCParser.Int_literalContext ctx) { 
		System.out.println(ctx.getChild(0).getText());
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitChar_literal(GramaticaCParser.Char_literalContext ctx) { 
		return ctx.getChild(0).getText(); 
	}
	
	@Override public String visitBool_literal(GramaticaCParser.Bool_literalContext ctx) {
		
		return ctx.getChild(0).getText(); 
	}
	
	public void quadruple2Icg(){
		for (quadruple entry : quadruple1) {
			String[] value = entry.getCuadrupla();
			String icg;
			if(value[0].matches("[-+*/]")){
				icg =	value[3] +
						":=" +
						value[1] +
						value[0] +
						value[2]; 
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].equals("==") || value[0].equals("!=")){
				icg =	value[3] +
						":=" +
						value[1] +
						value[0] +
						value[2]; 
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
				
			else if(value[0].equals("<") || value[0].equals(">") ||
					value[0].equals("<=") || value[0].equals("=>")){
				icg =	value[3] +
						":=" +
						value[1] +
						value[0] +
						value[2]; 
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].matches("[=]")){
				icg = 	value[3] +
						":=" +
						value[1];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].equals("FUNCTION ")){
				icg = 	value[0] +
						value[1];
				icgTable.put(String.valueOf(entry.getLinea()), icg);		
			}
			else if(value[0].startsWith("END ")){
				icg = 	value[0] +
						value[1];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].equals("RETURN ")){
				icg = 	value[0] +
						value[1];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].equals("CALL ")){
				icg = 	value[0] +
						value[1] +
						value[2];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].equals("PARAM ")){
				icg = 	value[0] +
						value[1];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].startsWith("STARTWHILE_")){
				icg = 	value[0];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].startsWith("ENDWHILE_")){
				icg = 	value[0];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].startsWith("IF ")){
				icg = 	value[0]+
						value[1];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].startsWith("GOTO ")){
				icg = 	value[0];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}
			else if(value[0].startsWith("LABEL_TRUE_")){
				icg = 	value[0];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}		
			else if(value[0].startsWith("LABEL_FALSE_")){
				icg = 	value[0];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}		
			else if(value[0].startsWith("ENDIF_")){
				icg = 	value[0];
				icgTable.put(String.valueOf(entry.getLinea()), icg);
			}		
			
		}
	}
	public String data(){
		
		String data = ".data";
		quadruple2.add(data);
		for(int i =0;i<quadruple1.size();i++){
			if(quadruple1.get(i).cuadrupla.length ==1){

				int j = quadruple1.get(i).cuadrupla[0].indexOf("[");
				if(quadruple1.get(i).cuadrupla[0].substring(j+1, j+2).equals("8")){
					String data1 = quadruple1.get(i).cuadrupla[0].substring(0, j)+":"+"	.word\n";
					quadruple2.add(data1);
				}if(quadruple1.get(i).cuadrupla[0].substring(j+1, j+2).equals("4")){
					String data2 = quadruple1.get(i).cuadrupla[0].substring(0, j)+":"+"	.word\n";
					quadruple2.add(data2);
				}if(quadruple1.get(i).cuadrupla[0].substring(j+1, j+2).equals("1")){
					String data3 = quadruple1.get(i).cuadrupla[0].substring(0, j)+":"+"	.word\n";
					quadruple2.add(data3);
				}
				if(i == regNum){
					break;
				}
			}
			String data4 = ".text";
			
		}
		return data;
		
	}
	public String getReg(){
		String Regis= "";
		for(int i =0;i<quadruple1.size();i++){
			if(quadruple1.get(i).cuadrupla.length >=3 && !quadruple1.get(i).cuadrupla[0].equals("PARAM")){
				if(quadruple1.get(i).cuadrupla.length == 3){
					if(!SimbolTab.containsKey(quadruple1.get(i).cuadrupla[0])){
						String[] reg = {"LDR","R"+regNum,"["+quadruple1.get(i).cuadrupla[2]+"]"};
						Regis = Arrays.toString(reg);
						SimbolTab.put(quadruple1.get(i).cuadrupla[0], reg);
						quadruple2.add(Regis);
						System.out.println("muestraaaaaa"+Arrays.toString(reg));
						regNum ++;
					}
				}if(quadruple1.get(i).cuadrupla.length >3 ){
					System.out.println("entra al sumas");
					if(quadruple1.get(i).cuadrupla[3].equals("+")){
						System.out.println("pasa el equals");
						if(!SimbolTab.containsKey(quadruple1.get(i).cuadrupla[4])){
							System.out.println("pasa el equals2");
							System.out.println("llll"+SimbolTab);
							System.out.println("llll"+quadruple1.get(i).cuadrupla[2]);
							String[] reg = {"ADD",SimbolTab.get(quadruple1.get(i).cuadrupla[2])[1],"["+quadruple1.get(i).cuadrupla[4]+"]"};
							
							Regis = Arrays.toString(reg);
							SimbolTab.put(quadruple1.get(i).cuadrupla[0], reg);
							quadruple2.add(Regis);
							System.out.println("sumass"+Arrays.toString(reg));
						}else{
							System.out.println("pasa el equals22");
							String[] reg = {"ADD",SimbolTab.get(quadruple1.get(i).cuadrupla[2])[1],SimbolTab.get(quadruple1.get(i).cuadrupla[4])[2]};
							Regis = Arrays.toString(reg);
							SimbolTab.put(quadruple1.get(i).cuadrupla[0], reg);
							quadruple2.add(Regis);
							System.out.println("sumass"+Arrays.toString(reg));
						}
					}if(quadruple1.get(i).cuadrupla[3].equals("-")){
						System.out.println("pasa el equals");
						if(!SimbolTab.containsKey(quadruple1.get(i).cuadrupla[4])){
							System.out.println("pasa el equals2");
							System.out.println("llll"+SimbolTab);
							System.out.println("llll"+quadruple1.get(i).cuadrupla[2]);
							String[] reg = {"SUB",SimbolTab.get(quadruple1.get(i).cuadrupla[2])[1],"["+quadruple1.get(i).cuadrupla[4]+"]"};
							
							Regis = Arrays.toString(reg);
							SimbolTab.put(quadruple1.get(i).cuadrupla[0], reg);
							quadruple2.add(Regis);
							System.out.println("ress"+Arrays.toString(reg));
						}else{
							System.out.println("pasa el equals22");
							String[] reg = {"SUB",SimbolTab.get(quadruple1.get(i).cuadrupla[2])[1],SimbolTab.get(quadruple1.get(i).cuadrupla[4])[2]};
							Regis = Arrays.toString(reg);
							SimbolTab.put(quadruple1.get(i).cuadrupla[0], reg);
							quadruple2.add(Regis);
							System.out.println("res"+Arrays.toString(reg));
						}
					}if(quadruple1.get(i).cuadrupla[3].equals("*")){
						System.out.println("pasa el equals");
						if(!SimbolTab.containsKey(quadruple1.get(i).cuadrupla[4])){
							System.out.println("pasa el equals2");
							System.out.println("llll"+SimbolTab);
							System.out.println("llll"+quadruple1.get(i).cuadrupla[2]);
							String[] reg = {"MUL",SimbolTab.get(quadruple1.get(i).cuadrupla[2])[1],"["+quadruple1.get(i).cuadrupla[4]+"]"};
							
							Regis = Arrays.toString(reg);
							SimbolTab.put(quadruple1.get(i).cuadrupla[0], reg);
							quadruple2.add(Regis);
							System.out.println("mulss"+Arrays.toString(reg));
						}else{
							System.out.println("pasa el equals22");
							String[] reg = {"MUL",SimbolTab.get(quadruple1.get(i).cuadrupla[2])[1],SimbolTab.get(quadruple1.get(i).cuadrupla[4])[2]};
							Regis = Arrays.toString(reg);
							SimbolTab.put(quadruple1.get(i).cuadrupla[0], reg);
							quadruple2.add(Regis);
							System.out.println("muls"+Arrays.toString(reg));
						}
					}
				}
			}if(quadruple1.get(i).cuadrupla.length == 1 && !quadruple1.get(i).cuadrupla[0].contains("WHILE") && !quadruple1.get(i).cuadrupla[0].contains("LABEL") && !quadruple1.get(i).cuadrupla[0].contains("IF")){
				if(!SimbolTab.containsKey(quadruple1.get(i).cuadrupla[0])){
					String[] reg = {"LDR","R"+regNum,"["+quadruple1.get(i).cuadrupla[0]+"]"};
					Regis = Arrays.toString(reg);
					String lui = quadruple1.get(i).cuadrupla[0].substring(0,1);
					System.out.println(lui);
					SimbolTab.put(lui, reg);
					quadruple2.add(Regis);
					System.out.println("msumas"+Arrays.toString(reg));
					regNum ++;
				}
			}
		}
		return Regis;
	}
	
	public ArrayList<quadruple> getQuadruple(){
		return quadruple1;
	}
	
	public Map<String, String> getIcgTable(){
		return icgTable;
	}
	public String toString (){
		String cod = "";
		for(int i = 0;i<quadruple1.size();i++){
			cod += "\n"+quadruple1.get(i);
		}
		System.out.println(cod);
		System.out.println("TAB:\n"+quadruple1);
		
		return cod;
	}
	
	public int doOfset(String var){
		
		try{
			int u = Integer.valueOf(var);
			return 8;
		}catch(Exception e){
			if(var.equals("true")||var.equals("false")){
				return 1;
			}else{
				return 4;
			}
		}
		
	}
}
