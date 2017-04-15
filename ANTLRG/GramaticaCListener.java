// Generated from GramaticaC.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaCParser}.
 */
public interface GramaticaCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GramaticaCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GramaticaCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GramaticaCParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GramaticaCParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(GramaticaCParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(GramaticaCParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(GramaticaCParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(GramaticaCParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(GramaticaCParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(GramaticaCParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(GramaticaCParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(GramaticaCParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(GramaticaCParser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(GramaticaCParser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(GramaticaCParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(GramaticaCParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(GramaticaCParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(GramaticaCParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GramaticaCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GramaticaCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GramaticaCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GramaticaCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(GramaticaCParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(GramaticaCParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(GramaticaCParser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(GramaticaCParser.WhileBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#returnBlock}.
	 * @param ctx the parse tree
	 */
	void enterReturnBlock(GramaticaCParser.ReturnBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#returnBlock}.
	 * @param ctx the parse tree
	 */
	void exitReturnBlock(GramaticaCParser.ReturnBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GramaticaCParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GramaticaCParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#scan}.
	 * @param ctx the parse tree
	 */
	void enterScan(GramaticaCParser.ScanContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#scan}.
	 * @param ctx the parse tree
	 */
	void exitScan(GramaticaCParser.ScanContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#myIf}.
	 * @param ctx the parse tree
	 */
	void enterMyIf(GramaticaCParser.MyIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#myIf}.
	 * @param ctx the parse tree
	 */
	void exitMyIf(GramaticaCParser.MyIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(GramaticaCParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(GramaticaCParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(GramaticaCParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(GramaticaCParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#dotLocation}.
	 * @param ctx the parse tree
	 */
	void enterDotLocation(GramaticaCParser.DotLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#dotLocation}.
	 * @param ctx the parse tree
	 */
	void exitDotLocation(GramaticaCParser.DotLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#declaredVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaredVariable(GramaticaCParser.DeclaredVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#declaredVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaredVariable(GramaticaCParser.DeclaredVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(GramaticaCParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(GramaticaCParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#arrayVariable}.
	 * @param ctx the parse tree
	 */
	void enterArrayVariable(GramaticaCParser.ArrayVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#arrayVariable}.
	 * @param ctx the parse tree
	 */
	void exitArrayVariable(GramaticaCParser.ArrayVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#expressionInP}.
	 * @param ctx the parse tree
	 */
	void enterExpressionInP(GramaticaCParser.ExpressionInPContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#expressionInP}.
	 * @param ctx the parse tree
	 */
	void exitExpressionInP(GramaticaCParser.ExpressionInPContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#nExpression}.
	 * @param ctx the parse tree
	 */
	void enterNExpression(GramaticaCParser.NExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#nExpression}.
	 * @param ctx the parse tree
	 */
	void exitNExpression(GramaticaCParser.NExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GramaticaCParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GramaticaCParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(GramaticaCParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(GramaticaCParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#equalsExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualsExpression(GramaticaCParser.EqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#equalsExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualsExpression(GramaticaCParser.EqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#relationExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpression(GramaticaCParser.RelationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#relationExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpression(GramaticaCParser.RelationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#addSubsExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubsExpression(GramaticaCParser.AddSubsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#addSubsExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubsExpression(GramaticaCParser.AddSubsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#mulDivExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpression(GramaticaCParser.MulDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#mulDivExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpression(GramaticaCParser.MulDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#prExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrExpression(GramaticaCParser.PrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#prExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrExpression(GramaticaCParser.PrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpression(GramaticaCParser.BasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpression(GramaticaCParser.BasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#basic}.
	 * @param ctx the parse tree
	 */
	void enterBasic(GramaticaCParser.BasicContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#basic}.
	 * @param ctx the parse tree
	 */
	void exitBasic(GramaticaCParser.BasicContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GramaticaCParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GramaticaCParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(GramaticaCParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(GramaticaCParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#as_op}.
	 * @param ctx the parse tree
	 */
	void enterAs_op(GramaticaCParser.As_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#as_op}.
	 * @param ctx the parse tree
	 */
	void exitAs_op(GramaticaCParser.As_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#md_op}.
	 * @param ctx the parse tree
	 */
	void enterMd_op(GramaticaCParser.Md_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#md_op}.
	 * @param ctx the parse tree
	 */
	void exitMd_op(GramaticaCParser.Md_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#pr_op}.
	 * @param ctx the parse tree
	 */
	void enterPr_op(GramaticaCParser.Pr_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#pr_op}.
	 * @param ctx the parse tree
	 */
	void exitPr_op(GramaticaCParser.Pr_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(GramaticaCParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(GramaticaCParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(GramaticaCParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(GramaticaCParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(GramaticaCParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(GramaticaCParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(GramaticaCParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(GramaticaCParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(GramaticaCParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(GramaticaCParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(GramaticaCParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(GramaticaCParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaCParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(GramaticaCParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaCParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(GramaticaCParser.Bool_literalContext ctx);
}