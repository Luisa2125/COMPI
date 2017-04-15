// Generated from GramaticaC.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GramaticaCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GramaticaCParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(GramaticaCParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(GramaticaCParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(GramaticaCParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(GramaticaCParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(GramaticaCParser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(GramaticaCParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(GramaticaCParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GramaticaCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GramaticaCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#assignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignation(GramaticaCParser.AssignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#whileBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileBlock(GramaticaCParser.WhileBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#returnBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnBlock(GramaticaCParser.ReturnBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GramaticaCParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#scan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScan(GramaticaCParser.ScanContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#myIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyIf(GramaticaCParser.MyIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(GramaticaCParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(GramaticaCParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#dotLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotLocation(GramaticaCParser.DotLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#declaredVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaredVariable(GramaticaCParser.DeclaredVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(GramaticaCParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#arrayVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVariable(GramaticaCParser.ArrayVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#expressionInP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInP(GramaticaCParser.ExpressionInPContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#nExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNExpression(GramaticaCParser.NExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GramaticaCParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(GramaticaCParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#equalsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsExpression(GramaticaCParser.EqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#relationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpression(GramaticaCParser.RelationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#addSubsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubsExpression(GramaticaCParser.AddSubsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#mulDivExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpression(GramaticaCParser.MulDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#prExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrExpression(GramaticaCParser.PrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpression(GramaticaCParser.BasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic(GramaticaCParser.BasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(GramaticaCParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(GramaticaCParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#as_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_op(GramaticaCParser.As_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#md_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMd_op(GramaticaCParser.Md_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#pr_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_op(GramaticaCParser.Pr_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(GramaticaCParser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_op(GramaticaCParser.Eq_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#cond_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op(GramaticaCParser.Cond_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(GramaticaCParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(GramaticaCParser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(GramaticaCParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaCParser#bool_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_literal(GramaticaCParser.Bool_literalContext ctx);
}