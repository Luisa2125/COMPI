
public class Visitor extends GramaticaCBaseVisitor<String> {
	@Override public String visitProgram(GramaticaCParser.ProgramContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitDeclaration(GramaticaCParser.DeclarationContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitVarDeclaration(GramaticaCParser.VarDeclarationContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitStructDeclaration(GramaticaCParser.StructDeclarationContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitVarType(GramaticaCParser.VarTypeContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitMethodDeclaration(GramaticaCParser.MethodDeclarationContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitMethodType(GramaticaCParser.MethodTypeContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitParameterType(GramaticaCParser.ParameterTypeContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitBlock(GramaticaCParser.BlockContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitStatement(GramaticaCParser.StatementContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitAssignation(GramaticaCParser.AssignationContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitWhileBlock(GramaticaCParser.WhileBlockContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitReturnBlock(GramaticaCParser.ReturnBlockContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitPrint(GramaticaCParser.PrintContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitScan(GramaticaCParser.ScanContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitMyIf(GramaticaCParser.MyIfContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitElseBlock(GramaticaCParser.ElseBlockContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitLocation(GramaticaCParser.LocationContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitDotLocation(GramaticaCParser.DotLocationContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitDeclaredVariable(GramaticaCParser.DeclaredVariableContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitVariable(GramaticaCParser.VariableContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitArrayVariable(GramaticaCParser.ArrayVariableContext ctx) { return visitChildren(ctx); }

	@Override public String visitExpressionInP(GramaticaCParser.ExpressionInPContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitNExpression(GramaticaCParser.NExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitExpression(GramaticaCParser.ExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitAndExpression(GramaticaCParser.AndExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitEqualsExpression(GramaticaCParser.EqualsExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitRelationExpression(GramaticaCParser.RelationExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitAddSubsExpression(GramaticaCParser.AddSubsExpressionContext ctx) { return visitChildren(ctx); }

	@Override public String visitMulDivExpression(GramaticaCParser.MulDivExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitPrExpression(GramaticaCParser.PrExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitBasicExpression(GramaticaCParser.BasicExpressionContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitBasic(GramaticaCParser.BasicContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitArg(GramaticaCParser.ArgContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitMethodCall(GramaticaCParser.MethodCallContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitAs_op(GramaticaCParser.As_opContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitMd_op(GramaticaCParser.Md_opContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitPr_op(GramaticaCParser.Pr_opContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitRel_op(GramaticaCParser.Rel_opContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitEq_op(GramaticaCParser.Eq_opContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitCond_op(GramaticaCParser.Cond_opContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitLiteral(GramaticaCParser.LiteralContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitInt_literal(GramaticaCParser.Int_literalContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitChar_literal(GramaticaCParser.Char_literalContext ctx) { return visitChildren(ctx); }
	
	@Override public String visitBool_literal(GramaticaCParser.Bool_literalContext ctx) { return visitChildren(ctx); }

}
