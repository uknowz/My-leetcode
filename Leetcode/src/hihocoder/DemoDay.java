package hihocoder;

import java.util.Scanner;
//这道题还可以优化空间，不用两个二维数组储存，用两个一维数组
public class DemoDay{
	public int minChange(char[][] grids) {    //传入图，b为障碍物，.为无障碍物，起点和终点默认为.
		int m = grids.length;             //行数
		int n = grids[0].length;          //列数
        int[][] a = new int[m][n];        //记录从起点到达该单元所需修改的单元数目最小值
        int[][] right = new int[m][n];    
        /*记录除起点、终点、最后一行、最后一列以外的单元的当前运动方向，0为向右，1为向下，2为任意方向
         * （如果从上方和左方到达该单元所需改变的单元数目相同，则可从任意方向到达该单元）*/
        
        //只有一行，返回所有障碍物数目
        if(m==1){
        	int count = 0;
        	for(int i=1;i<n;i++){
        		if(grids[0][i]=='b'){
        			count++;
        		}
        	}
        	return count;
        }
        //只有一列，返回所有障碍物数目
        if(n==1){
        	int count = 0;
        	for(int i=1;i<m;i++){
        		if(grids[i][0]=='b'){
        			count++;
        		}
        	}
        	return count;
        }
        //列数大于1且行数大于1
        /*
         * 动态规划，一层一层遍历该图，每个单元遍历一次，时间复杂度为m*n
         * 每遍历到一个单元，计算到该单元所需改变的单元数目最小值
         */
        for(int i=0;i<m;i++){//一行一行记录每一状态的最优解，知道求到最终状态a[m][n]
            for(int j=0;j<n;j++){
            	//初始化起点
            	if(i==0 && j==0){//有必要加if来控制吗，难道不是循环的开始就可以初始化？不过放在循环体内，不加if控制的话，每次循环都会被运行
            		a[i][j] = 0;
            	}else
                //初始化第一排（第一排的方向必向右），每一个状态只受前一状态的左侧状态影响和当前状态的影响
            	if(i==0){
            		a[i][j] = a[i][j-1] + (grids[i][j]=='b'?1:0);
            		right[i][j] = 0;
            	}else
            	//初始化第一列（第一列的方向必向下）
            	if(j==0){
            		//起点下面的一个单元（只有当起点右边的单元为1障碍物时，方向才会向下）
            		if(i==1 && grids[i-1][j+1] != 'b'){
            			a[i][j] = 1;//将起点右侧一个单元从empty换位blocked，因为change grids是双向的，题目只要求最小转换数，并不是只算从blocked到empty的
            		}else{
            		//其他情况（方向必向下，不受第二列单元影响）
            			a[i][j] = a[i-1][j] + (grids[i][j]=='b'?1:0);
            		}
            		right[i][j] = 1;//第一列的方向必为下
            	}else
            	//终点（取上方和左方单元中最小的那个值）
            	if(i==m-1 && j==n-1){
            		a[i][j] = Math.min(a[i-1][j], a[i][j-1]);
            	}else
            	//到达最后一行（最后一行的所有单元，其左边的单元无论方向向右还是向下，都会改变为向右）,此时最后一行不包括第一列，因为前面已经讨论过了第一列，用else则把第一列的已经排除在外了
            	if(i==m-1){
            		int top = a[i-1][j];
            		int left = a[i][j-1];
            		//上方的单元方向向右，且右上方单元不为障碍物（此时需要改变上方单元的运动方向为向下，即需要修改右上角单元为障碍物）
            		if(right[i-1][j]==0 && grids[i-1][j+1] != 'b'){
            			top++;
            		}
            		a[i][j] = Math.min(top, left) + (grids[i][j]=='b'?1:0);
            		right[i][j] = 0;
            	}else
            	//到达最后一列（最后一列的所有单元，其上边的单元无论方向向右还是向下，都会改变为向下）
            	if(j==n-1){
            		int top = a[i-1][j];
            		int left = a[i][j-1];
            		//左方的单元方向向下，且左下方单元不为障碍物（此时需要改变上方单元的运动方向为向右，即需要修改左下角单元为障碍物）
            		if(right[i][j-1]==1 && grids[i+1][j-1] != 'b'){
            			left++;
            		}
            		a[i][j] = Math.min(top, left) + (grids[i][j]=='b'?1:0);
            		right[i][j] = 1;
            	}else{
            	//在图的中心部分时
            		int top = a[i-1][j];
            		int left = a[i][j-1];
            		//上方的单元方向向右，且右上方单元不为障碍物（此时需要改变上方单元的运动方向为向下，即需要修改右上角单元为障碍物）
            		if(right[i-1][j]==0 && grids[i-1][j+1] != 'b'){
            			top++;
            		}
            		//左方的单元方向向下，且左下方单元不为障碍物（此时需要改变上方单元的运动方向为向右，即需要修改左下角单元为障碍物）
            		if(right[i][j-1]==1 && grids[i+1][j-1] != 'b'){
            			left++;
            		}
            		if(top<left){
            			a[i][j] = top + (grids[i][j]=='b'?1:0);
            			right[i][j] = 1;
            		}
            		else
            		if(left<top){
            			a[i][j] = left + (grids[i][j]=='b'?1:0);
            			right[i][j] = 0;
            		}else{//如果两边一样活left<top，统一将方向设置为向右0，不可以,这样运行wr
            			a[i][j] = left + (grids[i][j]=='b'?1:0);
            			right[i][j] = 2;
            		}
            	}
            }
        }
        return a[m-1][n-1];
    }
	
	public static void main(String []args){
		DemoDay demo = new DemoDay();
		Scanner in = new Scanner(System.in);
        while(in.hasNext()) {//判断一开始有没有输入，可以去掉
        	int N = in.nextInt();
        	int M = in.nextInt();
        	String delet = in.nextLine();//废弃的流
        	char[][] grid = new char[N][M];
        	for(int i=0;i<N;i++){//二维数组读入grids，一行一行读，每一行读的string的char为列元素
        		String line = in.nextLine();
        		for(int j=0;j<M;j++){
        			grid[i][j] = line.charAt(j);
        		}
        	}
        	System.out.println(demo.minChange(grid));
        }
	}
}
