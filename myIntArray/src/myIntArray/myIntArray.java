public class myIntArray {
 int[] arr;
 int cellNum;
 
 myIntArray(){
  arr=new int[10];
  cellNum=0;
 }
 
 void add(int[] arr) {
  int curLength=this.arr.length;
  if(arr.length<=(curLength-cellNum)) {
   //1.将新数组元素增加至成员数组中
  }else {
   //2.现有的空间不足以满足新数组元素，则需要进行数组扩充后再实行增加数据操作
  }
 }
 
 int find(int num) {
  int iRet=0;
  /*如何查找？
   * [0,cellNum]
   * 累计数，iRet=0;iRet++
   */
  for (int i=0, i<=arr.length,i++) {
      if (num ==arr[i]) {
          iRet ++;
      }
  }
  
  return iRet;
 }
 void print() {
  /*[0,cellNum]
   * [0,cellnum-1]需要输出,
   * cellNum这个数据的时候就不能再输出,
   */
 }
 
 void sort() {
     for(i=1,i<arr.length,i++) {
         for(j=i,j<arr.length,j++) {
             if (arr(j)==arr(j+1){
                 int tmp = arr(j);
                 arr(j)=arr(j+1);
                 arr(j+1)=tmp;
             }
         }
     }
  
 }
}