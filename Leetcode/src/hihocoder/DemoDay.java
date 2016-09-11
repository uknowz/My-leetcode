package hihocoder;

import java.util.Scanner;
//����⻹�����Ż��ռ䣬����������ά���鴢�棬������һά����
public class DemoDay{
	public int minChange(char[][] grids) {    //����ͼ��bΪ�ϰ��.Ϊ���ϰ�������յ�Ĭ��Ϊ.
		int m = grids.length;             //����
		int n = grids[0].length;          //����
        int[][] a = new int[m][n];        //��¼����㵽��õ�Ԫ�����޸ĵĵ�Ԫ��Ŀ��Сֵ
        int[][] right = new int[m][n];    
        /*��¼����㡢�յ㡢���һ�С����һ������ĵ�Ԫ�ĵ�ǰ�˶�����0Ϊ���ң�1Ϊ���£�2Ϊ���ⷽ��
         * ��������Ϸ����󷽵���õ�Ԫ����ı�ĵ�Ԫ��Ŀ��ͬ����ɴ����ⷽ�򵽴�õ�Ԫ��*/
        
        //ֻ��һ�У����������ϰ�����Ŀ
        if(m==1){
        	int count = 0;
        	for(int i=1;i<n;i++){
        		if(grids[0][i]=='b'){
        			count++;
        		}
        	}
        	return count;
        }
        //ֻ��һ�У����������ϰ�����Ŀ
        if(n==1){
        	int count = 0;
        	for(int i=1;i<m;i++){
        		if(grids[i][0]=='b'){
        			count++;
        		}
        	}
        	return count;
        }
        //��������1����������1
        /*
         * ��̬�滮��һ��һ�������ͼ��ÿ����Ԫ����һ�Σ�ʱ�临�Ӷ�Ϊm*n
         * ÿ������һ����Ԫ�����㵽�õ�Ԫ����ı�ĵ�Ԫ��Ŀ��Сֵ
         */
        for(int i=0;i<m;i++){//һ��һ�м�¼ÿһ״̬�����Ž⣬֪��������״̬a[m][n]
            for(int j=0;j<n;j++){
            	//��ʼ�����
            	if(i==0 && j==0){//�б�Ҫ��if���������ѵ�����ѭ���Ŀ�ʼ�Ϳ��Գ�ʼ������������ѭ�����ڣ�����if���ƵĻ���ÿ��ѭ�����ᱻ����
            		a[i][j] = 0;
            	}else
                //��ʼ����һ�ţ���һ�ŵķ�������ң���ÿһ��״ֻ̬��ǰһ״̬�����״̬Ӱ��͵�ǰ״̬��Ӱ��
            	if(i==0){
            		a[i][j] = a[i][j-1] + (grids[i][j]=='b'?1:0);
            		right[i][j] = 0;
            	}else
            	//��ʼ����һ�У���һ�еķ�������£�
            	if(j==0){
            		//��������һ����Ԫ��ֻ�е�����ұߵĵ�ԪΪ1�ϰ���ʱ������Ż����£�
            		if(i==1 && grids[i-1][j+1] != 'b'){
            			a[i][j] = 1;//������Ҳ�һ����Ԫ��empty��λblocked����Ϊchange grids��˫��ģ���ĿֻҪ����Сת������������ֻ���blocked��empty��
            		}else{
            		//�����������������£����ܵڶ��е�ԪӰ�죩
            			a[i][j] = a[i-1][j] + (grids[i][j]=='b'?1:0);
            		}
            		right[i][j] = 1;//��һ�еķ����Ϊ��
            	}else
            	//�յ㣨ȡ�Ϸ����󷽵�Ԫ����С���Ǹ�ֵ��
            	if(i==m-1 && j==n-1){
            		a[i][j] = Math.min(a[i-1][j], a[i][j-1]);
            	}else
            	//�������һ�У����һ�е����е�Ԫ������ߵĵ�Ԫ���۷������һ������£�����ı�Ϊ���ң�,��ʱ���һ�в�������һ�У���Ϊǰ���Ѿ����۹��˵�һ�У���else��ѵ�һ�е��Ѿ��ų�������
            	if(i==m-1){
            		int top = a[i-1][j];
            		int left = a[i][j-1];
            		//�Ϸ��ĵ�Ԫ�������ң������Ϸ���Ԫ��Ϊ�ϰ����ʱ��Ҫ�ı��Ϸ���Ԫ���˶�����Ϊ���£�����Ҫ�޸����Ͻǵ�ԪΪ�ϰ��
            		if(right[i-1][j]==0 && grids[i-1][j+1] != 'b'){
            			top++;
            		}
            		a[i][j] = Math.min(top, left) + (grids[i][j]=='b'?1:0);
            		right[i][j] = 0;
            	}else
            	//�������һ�У����һ�е����е�Ԫ�����ϱߵĵ�Ԫ���۷������һ������£�����ı�Ϊ���£�
            	if(j==n-1){
            		int top = a[i-1][j];
            		int left = a[i][j-1];
            		//�󷽵ĵ�Ԫ�������£������·���Ԫ��Ϊ�ϰ����ʱ��Ҫ�ı��Ϸ���Ԫ���˶�����Ϊ���ң�����Ҫ�޸����½ǵ�ԪΪ�ϰ��
            		if(right[i][j-1]==1 && grids[i+1][j-1] != 'b'){
            			left++;
            		}
            		a[i][j] = Math.min(top, left) + (grids[i][j]=='b'?1:0);
            		right[i][j] = 1;
            	}else{
            	//��ͼ�����Ĳ���ʱ
            		int top = a[i-1][j];
            		int left = a[i][j-1];
            		//�Ϸ��ĵ�Ԫ�������ң������Ϸ���Ԫ��Ϊ�ϰ����ʱ��Ҫ�ı��Ϸ���Ԫ���˶�����Ϊ���£�����Ҫ�޸����Ͻǵ�ԪΪ�ϰ��
            		if(right[i-1][j]==0 && grids[i-1][j+1] != 'b'){
            			top++;
            		}
            		//�󷽵ĵ�Ԫ�������£������·���Ԫ��Ϊ�ϰ����ʱ��Ҫ�ı��Ϸ���Ԫ���˶�����Ϊ���ң�����Ҫ�޸����½ǵ�ԪΪ�ϰ��
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
            		}else{//�������һ����left<top��ͳһ����������Ϊ����0��������,��������wr
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
        while(in.hasNext()) {//�ж�һ��ʼ��û�����룬����ȥ��
        	int N = in.nextInt();
        	int M = in.nextInt();
        	String delet = in.nextLine();//��������
        	char[][] grid = new char[N][M];
        	for(int i=0;i<N;i++){//��ά�������grids��һ��һ�ж���ÿһ�ж���string��charΪ��Ԫ��
        		String line = in.nextLine();
        		for(int j=0;j<M;j++){
        			grid[i][j] = line.charAt(j);
        		}
        	}
        	System.out.println(demo.minChange(grid));
        }
	}
}
