public class A
{
    /*1·定义方法寻路
	  2·可走则返回true，不可走则返回false
	  3.[i][j]表示位置
	  4.0表示无障碍；1表示障碍物；2表示经测试，可以由此前行；3表示已探出不可走
	  5.当map[6][5]==2时，表明寻到完整通路，走出迷宫。
	  6.确定寻路策略，下->右->上->左
	  */
    public boolean findway(int[][] map,int i,int j)
    {
        if(map[6][3]==2)//说明寻到通路
            return true;
        if(map[i][j]==0)
        {
            //假定可以走通，并进行测试
            map[i][j]=2;
            if(findway(map,i+1,j))//下
                return true;
            else if(findway(map,i,j+1))//右
                return true;
            else if(findway(map,i-1,j))//上
                return true;
            else if(findway(map,i,j-1))//左
                return true;
            else //无路可走
            {
                map[i][j]=3;
                return false;
            }
        }
        else //map[i][j]==1/3 不可走
            return false;

    }
}
