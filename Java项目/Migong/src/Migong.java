public class Migong
{
    public static void main(String[] args)
    {

		/*思路：
			1.用数组创建迷宫。
			2.0表示空、可走；1表示有障碍物，不可走。
			*/
        int[][] map=new int[8][7];
        map[3][1]=1;
        map[3][2]=1;
        map[1][2]=1;
        map[2][4]=1;
        map[4][3]=1;
        map[4][4]=1;
        map[6][4]=1;

        for(int i=0;i<7;i++)
        {
            map[0][i]=1;
            map[7][i]=1;
        }
        for(int i=0;i<8;i++)
        {
            map[i][0]=1;
            map[i][6]=1;
        }
        //输出迷宫
        A a1=new A();
        a1.findway(map,1,1);
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<7;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
