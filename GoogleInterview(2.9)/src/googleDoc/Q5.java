package googleDoc;

public class Q5 {
	int[] a;
	public Q5(int N){
		a=new int[1+N/32];
	}
	//给统计数组的相应位置置1
	//n>>5等于n/32，1<<(n&0x1f)表示n%32
	void setBit(int n){
		int row=n>>5;
		a[row]=a[row]|(1<<(n&0x1f));
		
	}
	int getBit(int n){
		int row=n/32;
		return a[row]&(1<<(n&0x1f));
	}
	public void main(String[] args){
		int[] num={1,3,4};
		int n=num.length;
		Q5 ex= new Q5(n);
		for(int i=0;i<n;i++){
			if(ex.getBit(num[i])!=0){
				ex.setBit(num[i]);
			}
		}
		
	}
}
