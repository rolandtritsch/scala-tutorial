sealed abstract class Tree
case class Sum(l: Tree, r: Tree) extends Tree
case class Min(l: Tree, r: Tree) extends Tree
case class Mul(l: Tree, r: Tree) extends Tree
case class Div(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree

object Calc {
  type Environment = String => Int

  def eval(t: Tree, e: Environment): Int = t match {
    case Sum(l, r) => eval(l, e) + eval(r, e)
    case Min(l, r) => eval(l, e) - eval(r, e)
    case Mul(l, r) => eval(l, e) * eval(r, e)
    case Div(l, r) => eval(l, e) / eval(r, e)
    case Var(n) => e(n)
    case Const(v) => v
  }

  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if (v == n) => Const(1)
    case _ => Const(0)
  }

  def main(args: Array[String]) = {
    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val exp2: Tree = Mul(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val exp3: Tree = Mul(Min(Var("z"), Var("x")), Div(Const(7), Var("y")))

    val env: Environment = {
      case "x" => 5
      case "y" => 7
      case "z" => 10
    }

    println(s"${exp} = ${eval(exp, env)}")
    println(s"${exp2} = ${eval(exp2, env)}")
    println(s"${exp3} = ${eval(exp3, env)}")

    println(s"Derive(x): ${derive(exp, 'x'.toString)}")
    println(s"Derive(y): ${derive(exp, 'y'.toString)}")
  }
}
