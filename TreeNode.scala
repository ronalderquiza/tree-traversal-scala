/**
  * Created by Ronald Erquiza on 4/12/2016.
  */
class TreeNode (cValue: Char, tLeft: TreeNode, tRight: TreeNode){
  var value = cValue
  var left = tLeft
  var right = tRight

  def this(cValue: Char) = this(cValue, null, null)
  def postfix(): Unit ={
    if(left!=null){
      left.postfix()
    }
    if(right!=null){
      right.postfix()
    }
    println(value)
  }

  def prefix(): Unit ={

    println(value)
    if(left!=null){
      left.prefix()
    }
    if(right!=null){
      right.prefix()
    }
  }

  def infix(): Unit ={
    if(left!=null){
      left.infix()
    }

    println(value)
    if(right!=null){
      right.infix()
    }
  }



}


object Main{
  def main(args: Array[String]): Unit ={
    /*val root = new TreeNode('A',
      new TreeNode('B'),
      new TreeNode('C',
        new TreeNode('D',
          new TreeNode('E'),
          new TreeNode('F')
        ),
        new TreeNode('G')
      )
    );*/
    //val root = new TreeNode('A', new TreeNode('B'), new TreeNode('C'))
    //root.postfix()
    var root = new TreeNode(' ')
    parse("A(B,C(D(E,F),G))", root);
    println("PREFIX:")
    root.prefix()
    println("POSTFIX:")
    root.postfix()
    println("INFIX:")
    root.infix()


  }

  def parse(string: String, node: TreeNode): Int ={
    parse(string, node, 0)
  }

  def parse(string: String, node: TreeNode, index: Int): Int ={
    if(string.charAt(index).isLetter)
      node.value = string.charAt(index)
    var newIndex:Int = index
    newIndex += 1
    if(string.charAt(newIndex)=='(') {
      newIndex += 1
      node.left = new TreeNode(string.charAt(newIndex))
      newIndex = parse(string, node.left, newIndex)
      //newIndex += 1
      if(string.charAt(newIndex)==')'){
        newIndex += 2
        node.right = new TreeNode(string.charAt(newIndex))
        newIndex = parse(string, node.right, newIndex)
        //newIndex+= 1
      }
      else if(string.charAt(newIndex)==','){
        newIndex += 1
        node.right = new TreeNode(string.charAt(newIndex))
        newIndex = parse(string, node.right, newIndex)
        //newIndex+= 1
      }

    }
    return newIndex
  }
}
